package org.web3j.model;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicBytes;
import org.web3j.abi.datatypes.DynamicStruct;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/LFDT-web3j/web3j/tree/main/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.14.0.
 */
@SuppressWarnings("rawtypes")
public class Multicall3 extends Contract {
    public static final String BINARY = "6080604052348015600e575f5ffd5b50610c6a8061001c5f395ff3fe6080604052600436106100ef575f3560e01c80634d2301cc11610087578063a8b0574e11610057578063a8b0574e14610221578063bce38bd71461023b578063c3077fa91461024e578063ee82ac5e14610261575f5ffd5b80634d2301cc146101c357806372425d9d146101ea57806382ad56cb146101fc57806386d516e81461020f575f5ffd5b80633408e470116100c25780633408e4701461016b578063399542e91461017d5780633e64a6961461019f57806342cbb15c146101b1575f5ffd5b80630f28c97d146100f3578063174dea7114610114578063252dba421461013457806327e86d6e14610155575b5f5ffd5b3480156100fe575f5ffd5b50425b6040519081526020015b60405180910390f35b610127610122366004610958565b61027f565b60405161010b9190610a38565b610147610142366004610958565b610464565b60405161010b929190610a51565b348015610160575f5ffd5b50435f190140610101565b348015610176575f5ffd5b5046610101565b61019061018b366004610abb565b6105d2565b60405161010b93929190610b10565b3480156101aa575f5ffd5b5048610101565b3480156101bc575f5ffd5b5043610101565b3480156101ce575f5ffd5b506101016101dd366004610b37565b6001600160a01b03163190565b3480156101f5575f5ffd5b5044610101565b61012761020a366004610958565b6105ed565b34801561021a575f5ffd5b5045610101565b34801561022c575f5ffd5b5060405141815260200161010b565b610127610249366004610abb565b610766565b61019061025c366004610958565b6108f2565b34801561026c575f5ffd5b5061010161027b366004610b5d565b4090565b60605f828067ffffffffffffffff81111561029c5761029c610b74565b6040519080825280602002602001820160405280156102e157816020015b604080518082019091525f8152606060208201528152602001906001900390816102ba5790505b509250365f5b82811015610406575f85828151811061030257610302610b88565b6020026020010151905087878381811061031e5761031e610b88565b90506020028101906103309190610b9c565b6040810135958601959093506103496020850185610b37565b6001600160a01b0316816103606060870187610bba565b60405161036e929190610bfd565b5f6040518083038185875af1925050503d805f81146103a8576040519150601f19603f3d011682016040523d82523d5f602084013e6103ad565b606091505b5060208085019190915290151580845290850135176103fc5762461bcd60e51b5f526020600452601760245276135d5b1d1a58d85b1b0cce8818d85b1b0819985a5b1959604a1b60445260845ffd5b50506001016102e7565b5082341461045b5760405162461bcd60e51b815260206004820152601a60248201527f4d756c746963616c6c333a2076616c7565206d69736d6174636800000000000060448201526064015b60405180910390fd5b50505092915050565b436060828067ffffffffffffffff81111561048157610481610b74565b6040519080825280602002602001820160405280156104b457816020015b606081526020019060019003908161049f5790505b509150365f5b828110156105c8575f8787838181106104d5576104d5610b88565b90506020028101906104e79190610c0c565b92506104f66020840184610b37565b6001600160a01b031661050c6020850185610bba565b60405161051a929190610bfd565b5f604051808303815f865af19150503d805f8114610553576040519150601f19603f3d011682016040523d82523d5f602084013e610558565b606091505b5086848151811061056b5761056b610b88565b60209081029190910101529050806105bf5760405162461bcd60e51b8152602060048201526017602482015276135d5b1d1a58d85b1b0cce8818d85b1b0819985a5b1959604a1b6044820152606401610452565b506001016104ba565b5050509250929050565b43804060606105e2868686610766565b905093509350939050565b6060818067ffffffffffffffff81111561060957610609610b74565b60405190808252806020026020018201604052801561064e57816020015b604080518082019091525f8152606060208201528152602001906001900390816106275790505b509150365f5b8281101561045b575f84828151811061066f5761066f610b88565b6020026020010151905086868381811061068b5761068b610b88565b905060200281019061069d9190610c20565b92506106ac6020840184610b37565b6001600160a01b03166106c26040850185610bba565b6040516106d0929190610bfd565b5f604051808303815f865af19150503d805f8114610709576040519150601f19603f3d011682016040523d82523d5f602084013e61070e565b606091505b50602080840191909152901515808352908401351761075d5762461bcd60e51b5f526020600452601760245276135d5b1d1a58d85b1b0cce8818d85b1b0819985a5b1959604a1b60445260645ffd5b50600101610654565b6060818067ffffffffffffffff81111561078257610782610b74565b6040519080825280602002602001820160405280156107c757816020015b604080518082019091525f8152606060208201528152602001906001900390816107a05790505b509150365f5b828110156108e8575f8482815181106107e8576107e8610b88565b6020026020010151905086868381811061080457610804610b88565b90506020028101906108169190610c0c565b92506108256020840184610b37565b6001600160a01b031661083b6020850185610bba565b604051610849929190610bfd565b5f604051808303815f865af19150503d805f8114610882576040519150601f19603f3d011682016040523d82523d5f602084013e610887565b606091505b5060208301521515815287156108df5780516108df5760405162461bcd60e51b8152602060048201526017602482015276135d5b1d1a58d85b1b0cce8818d85b1b0819985a5b1959604a1b6044820152606401610452565b506001016107cd565b5050509392505050565b5f5f6060610902600186866105d2565b919790965090945092505050565b5f5f83601f840112610920575f5ffd5b50813567ffffffffffffffff811115610937575f5ffd5b6020830191508360208260051b8501011115610951575f5ffd5b9250929050565b5f5f60208385031215610969575f5ffd5b823567ffffffffffffffff81111561097f575f5ffd5b61098b85828601610910565b90969095509350505050565b5f81518084528060208401602086015e5f602082860101526020601f19601f83011685010191505092915050565b5f82825180855260208501945060208160051b830101602085015f5b83811015610a2c57601f1985840301885281518051151584526020810151905060406020850152610a156040850182610997565b6020998a01999094509290920191506001016109e1565b50909695505050505050565b602081525f610a4a60208301846109c5565b9392505050565b5f604082018483526040602084015280845180835260608501915060608160051b8601019250602086015f5b82811015610aae57605f19878603018452610a99858351610997565b94506020938401939190910190600101610a7d565b5092979650505050505050565b5f5f5f60408486031215610acd575f5ffd5b83358015158114610adc575f5ffd5b9250602084013567ffffffffffffffff811115610af7575f5ffd5b610b0386828701610910565b9497909650939450505050565b838152826020820152606060408201525f610b2e60608301846109c5565b95945050505050565b5f60208284031215610b47575f5ffd5b81356001600160a01b0381168114610a4a575f5ffd5b5f60208284031215610b6d575f5ffd5b5035919050565b634e487b7160e01b5f52604160045260245ffd5b634e487b7160e01b5f52603260045260245ffd5b5f8235607e19833603018112610bb0575f5ffd5b9190910192915050565b5f5f8335601e19843603018112610bcf575f5ffd5b83018035915067ffffffffffffffff821115610be9575f5ffd5b602001915036819003821315610951575f5ffd5b818382375f9101908152919050565b5f8235603e19833603018112610bb0575f5ffd5b5f8235605e19833603018112610bb0575f5ffdfea264697066735822122022035aee9e7ad0465526f30250b6c251b2498b43507ffd6f86ae2a1b26a0b15f64736f6c634300081d0033";

    private static String librariesLinkedBinary;

    public static final String FUNC_AGGREGATE = "aggregate";

    public static final String FUNC_AGGREGATE3 = "aggregate3";

    public static final String FUNC_AGGREGATE3VALUE = "aggregate3Value";

    public static final String FUNC_BLOCKANDAGGREGATE = "blockAndAggregate";

    public static final String FUNC_GETBASEFEE = "getBasefee";

    public static final String FUNC_GETBLOCKHASH = "getBlockHash";

    public static final String FUNC_GETBLOCKNUMBER = "getBlockNumber";

    public static final String FUNC_GETCHAINID = "getChainId";

    public static final String FUNC_GETCURRENTBLOCKCOINBASE = "getCurrentBlockCoinbase";

    public static final String FUNC_GETCURRENTBLOCKDIFFICULTY = "getCurrentBlockDifficulty";

    public static final String FUNC_GETCURRENTBLOCKGASLIMIT = "getCurrentBlockGasLimit";

    public static final String FUNC_GETCURRENTBLOCKTIMESTAMP = "getCurrentBlockTimestamp";

    public static final String FUNC_GETETHBALANCE = "getEthBalance";

    public static final String FUNC_GETLASTBLOCKHASH = "getLastBlockHash";

    public static final String FUNC_TRYAGGREGATE = "tryAggregate";

    public static final String FUNC_TRYBLOCKANDAGGREGATE = "tryBlockAndAggregate";

    @Deprecated
    protected Multicall3(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Multicall3(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Multicall3(String contractAddress, Web3j web3j, TransactionManager transactionManager,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Multicall3(String contractAddress, Web3j web3j, TransactionManager transactionManager,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> aggregate(List<Call> calls, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_AGGREGATE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<Call>(Call.class, calls)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<TransactionReceipt> aggregate3(List<Call3> calls,
            BigInteger weiValue) {
        final Function function = new Function(
                FUNC_AGGREGATE3, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<Call3>(Call3.class, calls)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<TransactionReceipt> aggregate3Value(List<Call3Value> calls,
            BigInteger weiValue) {
        final Function function = new Function(
                FUNC_AGGREGATE3VALUE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<Call3Value>(Call3Value.class, calls)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<TransactionReceipt> blockAndAggregate(List<Call> calls,
            BigInteger weiValue) {
        final Function function = new Function(
                FUNC_BLOCKANDAGGREGATE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<Call>(Call.class, calls)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<BigInteger> getBasefee() {
        final Function function = new Function(FUNC_GETBASEFEE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<byte[]> getBlockHash(BigInteger blockNumber) {
        final Function function = new Function(FUNC_GETBLOCKHASH, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(blockNumber)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<BigInteger> getBlockNumber() {
        final Function function = new Function(FUNC_GETBLOCKNUMBER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getChainId() {
        final Function function = new Function(FUNC_GETCHAINID, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> getCurrentBlockCoinbase() {
        final Function function = new Function(FUNC_GETCURRENTBLOCKCOINBASE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> getCurrentBlockDifficulty() {
        final Function function = new Function(FUNC_GETCURRENTBLOCKDIFFICULTY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getCurrentBlockGasLimit() {
        final Function function = new Function(FUNC_GETCURRENTBLOCKGASLIMIT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getCurrentBlockTimestamp() {
        final Function function = new Function(FUNC_GETCURRENTBLOCKTIMESTAMP, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getEthBalance(String addr) {
        final Function function = new Function(FUNC_GETETHBALANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, addr)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<byte[]> getLastBlockHash() {
        final Function function = new Function(FUNC_GETLASTBLOCKHASH, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<TransactionReceipt> tryAggregate(Boolean requireSuccess,
            List<Call> calls, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_TRYAGGREGATE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Bool(requireSuccess), 
                new org.web3j.abi.datatypes.DynamicArray<Call>(Call.class, calls)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<TransactionReceipt> tryBlockAndAggregate(Boolean requireSuccess,
            List<Call> calls, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_TRYBLOCKANDAGGREGATE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Bool(requireSuccess), 
                new org.web3j.abi.datatypes.DynamicArray<Call>(Call.class, calls)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    @Deprecated
    public static Multicall3 load(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return new Multicall3(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Multicall3 load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Multicall3(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Multicall3 load(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return new Multicall3(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Multicall3 load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Multicall3(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Multicall3> deploy(Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Multicall3.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<Multicall3> deploy(Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Multicall3.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    public static RemoteCall<Multicall3> deploy(Web3j web3j, TransactionManager transactionManager,
            ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Multicall3.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<Multicall3> deploy(Web3j web3j, TransactionManager transactionManager,
            BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Multicall3.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    public static void linkLibraries(List<Contract.LinkReference> references) {
        librariesLinkedBinary = linkBinaryWithReferences(BINARY, references);
    }

    private static String getDeploymentBinary() {
        if (librariesLinkedBinary != null) {
            return librariesLinkedBinary;
        } else {
            return BINARY;
        }
    }

    public static class Call extends DynamicStruct {
        public String target;

        public byte[] callData;

        public Call(String target, byte[] callData) {
            super(new org.web3j.abi.datatypes.Address(160, target), 
                    new org.web3j.abi.datatypes.DynamicBytes(callData));
            this.target = target;
            this.callData = callData;
        }

        public Call(Address target, DynamicBytes callData) {
            super(target, callData);
            this.target = target.getValue();
            this.callData = callData.getValue();
        }
    }

    public static class Call3 extends DynamicStruct {
        public String target;

        public Boolean allowFailure;

        public byte[] callData;

        public Call3(String target, Boolean allowFailure, byte[] callData) {
            super(new org.web3j.abi.datatypes.Address(160, target), 
                    new org.web3j.abi.datatypes.Bool(allowFailure), 
                    new org.web3j.abi.datatypes.DynamicBytes(callData));
            this.target = target;
            this.allowFailure = allowFailure;
            this.callData = callData;
        }

        public Call3(Address target, Bool allowFailure, DynamicBytes callData) {
            super(target, allowFailure, callData);
            this.target = target.getValue();
            this.allowFailure = allowFailure.getValue();
            this.callData = callData.getValue();
        }
    }

    public static class Result extends DynamicStruct {
        public Boolean success;

        public byte[] returnData;

        public Result(Boolean success, byte[] returnData) {
            super(new org.web3j.abi.datatypes.Bool(success), 
                    new org.web3j.abi.datatypes.DynamicBytes(returnData));
            this.success = success;
            this.returnData = returnData;
        }

        public Result(Bool success, DynamicBytes returnData) {
            super(success, returnData);
            this.success = success.getValue();
            this.returnData = returnData.getValue();
        }
    }

    public static class Call3Value extends DynamicStruct {
        public String target;

        public Boolean allowFailure;

        public BigInteger value;

        public byte[] callData;

        public Call3Value(String target, Boolean allowFailure, BigInteger value, byte[] callData) {
            super(new org.web3j.abi.datatypes.Address(160, target), 
                    new org.web3j.abi.datatypes.Bool(allowFailure), 
                    new org.web3j.abi.datatypes.generated.Uint256(value), 
                    new org.web3j.abi.datatypes.DynamicBytes(callData));
            this.target = target;
            this.allowFailure = allowFailure;
            this.value = value;
            this.callData = callData;
        }

        public Call3Value(Address target, Bool allowFailure, Uint256 value, DynamicBytes callData) {
            super(target, allowFailure, value, callData);
            this.target = target.getValue();
            this.allowFailure = allowFailure.getValue();
            this.value = value.getValue();
            this.callData = callData.getValue();
        }
    }
}
