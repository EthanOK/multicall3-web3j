package org.multicall;

import org.handle.EncodeMulticall;
import org.handle.EncodedFunction;
import org.web3j.abi.FunctionReturnDecoder;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.model.Multicall3;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthCall;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.ReadonlyTransactionManager;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.utils.Convert;
import org.web3j.utils.Numeric;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
        public static void main(String[] args) throws Exception {

                String RPC = "https://0xrpc.io/sep";
                String multicall3Address = "0xcA11bde05977b3631167028862bE2a173976CA11";
                List<String> accounts = Arrays.asList(
                                "0x742d35Cc6634C0532925a3b844Bc454e4438f44e",
                                "0x00000000219ab540356cBB839Cbe05303d7705Fa");

                Web3j web3j = Web3j.build(new HttpService(RPC));
                ContractGasProvider contractGasProvider = new DefaultGasProvider();

                // Only Read Contract
                Multicall3 multicall3 = Multicall3.load(multicall3Address, web3j,
                                new ReadonlyTransactionManager(web3j, null), contractGasProvider);

                BigInteger blockNumber = multicall3.getBlockNumber().send();
                System.out.println("blockNumber: " + blockNumber);

                List<Multicall3.Call3> calls = new ArrayList<Multicall3.Call3>(accounts.size());
                for (String account : accounts) {
                        calls.add(new Multicall3.Call3(multicall3Address, true,
                                        Numeric.hexStringToByteArray(
                                                        EncodeMulticall.encodeGetEthBalance(account).encoded)));
                }

                EncodedFunction getEthBalanceFunction = EncodeMulticall.encodeGetEthBalance(accounts.get(0));

                EncodedFunction aggregate3Function = EncodeMulticall.encodeAggregate3(calls);

                EthCall ethCall = web3j.ethCall(
                                Transaction.createEthCallTransaction(
                                                null,
                                                multicall3Address,
                                                aggregate3Function.encoded),
                                DefaultBlockParameterName.LATEST)
                                .send();

                // 解析返回数据
                List<Type> responseDatas = FunctionReturnDecoder.decode(ethCall.getValue(),
                                aggregate3Function.outputParameters);

                DynamicArray<Multicall3.Result> results = (DynamicArray<Multicall3.Result>) responseDatas.getFirst();

                List<Multicall3.Result> resultsList = results.getValue();
                for (int i = 0; i < resultsList.size(); i++) {
                        Multicall3.Result result = resultsList.get(i);

                        BigInteger ethBalance_ = ((Uint256) FunctionReturnDecoder
                                        .decode(Numeric.toHexString(result.returnData),
                                                        getEthBalanceFunction.outputParameters)
                                        .getFirst()).getValue();

                        String ethBalance = Convert.fromWei(ethBalance_.toString(), Convert.Unit.ETHER).toString();
                        System.out.println(accounts.get(i) + ": " + ethBalance + " ETH");

                }

        }

}