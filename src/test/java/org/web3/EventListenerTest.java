package org.web3;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.web3j.crypto.Keys;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.websocket.WebSocketService;

class EventListenerTest {
    String wssUrl = "wss://mainnet.gateway.tenderly.co";
    String USDT_ADDRESS =Keys.toChecksumAddress("0xdAC17F958D2ee523a2206206994597C13D831ec7");
    String USDC_ADDRESS =Keys.toChecksumAddress("0xA0b86991c6218b36c1d19D4a2e9Eb0cE3606eB48");
    List<String> contractList = new ArrayList<>();

    Web3j web3j;

    @BeforeEach
    public void setUp() throws ConnectException {

        WebSocketService webSocketService = new WebSocketService(wssUrl, true);
        webSocketService.connect();
        web3j = Web3j.build(webSocketService);
        // USDT
        contractList.add(USDT_ADDRESS);
        // USDC
        contractList.add(USDC_ADDRESS);
    }

    @Test
    @DisplayName("test block event listener")
    public void testBlockEventListener() throws Exception {
        EthFilter filter = new EthFilter(DefaultBlockParameterName.LATEST,
                DefaultBlockParameterName.LATEST, contractList)
                .addOptionalTopics("0xddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef",
                        "0x8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925");

        web3j.ethLogFlowable(filter).subscribe(event -> {

            String contractAddress =Keys.toChecksumAddress(event.getAddress());
            if (contractAddress.equals(USDT_ADDRESS)) {
                System.out.print("USDT ");
            } else if (contractAddress.equals(USDC_ADDRESS)) {
                System.out.print("USDC ");
            }
            String topic = event.getTopics().get(0);
            if (topic.equals("0xddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef")) {
                System.out.print("Transfer => ");
            } else if (topic.equals("0x8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925")) {
                System.out.print("Approval => ");
            }

            System.out.println("blockNumber: " + event.getBlockNumber() + ", transactionHash: "
                    + event.getTransactionHash() + ", logIndex: " + event.getLogIndex());

        });

    }
}