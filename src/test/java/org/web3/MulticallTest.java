package org.web3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.web3j.model.Multicall3;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.ReadonlyTransactionManager;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.utils.Numeric;

public class MulticallTest {

    String RPC = "https://0xrpc.io/sep";
    String multicall3Address = "0xcA11bde05977b3631167028862bE2a173976CA11";
    ContractGasProvider contractGasProvider = new DefaultGasProvider();
    Multicall3 multicall3;

    @BeforeEach
    public void setUp() {

        Web3j web3j = Web3j.build(new HttpService(RPC));
        multicall3 = Multicall3.load(multicall3Address, web3j, new ReadonlyTransactionManager(web3j, null),
                contractGasProvider);
    }

    @Test
    @DisplayName("test getBlockHash")
    public void testGetBlockHash() throws Exception {
        BigInteger blockNumber = multicall3.getBlockNumber().send();
        System.out.println("blockNumber: " + blockNumber);
        byte[] lastBlockHash = multicall3.getLastBlockHash().send();
        String lastBlockHashString = Numeric.toHexString(lastBlockHash);
        System.out.println("lastBlockHash: " + lastBlockHashString);
        byte[] blockHash = multicall3.getBlockHash(blockNumber.subtract(BigInteger.ONE)).send();
        String blockHashString = Numeric.toHexString(blockHash);

        assertEquals(lastBlockHashString, blockHashString);
    }
}
