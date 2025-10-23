package org.web3j.model;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.DynamicBytes;
import org.web3j.abi.datatypes.DynamicStruct;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.StaticStruct;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.reflection.Parameterized;
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
public class TestArray extends Contract {
    public static final String BINARY = "6080604052348015600e575f5ffd5b506102668061001c5f395ff3fe608060405260043610610054575f3560e01c806306fdde03146100585780631f8bb20e14610067578063338eb90b14610085578063b7d52a2514610067578063b858183f1461009f578063fecceafa146100c4575b5f5ffd5b348015610063575f5ffd5b505b005b348015610072575f5ffd5b50610065610081366004610129565b5050565b348015610090575f5ffd5b50610065610081366004610168565b6100b26100ad3660046101d9565b505f90565b60405190815260200160405180910390f35b3480156100cf575f5ffd5b506100656100de366004610217565b50565b5f5f83601f8401126100f1575f5ffd5b50813567ffffffffffffffff811115610108575f5ffd5b6020830191508360208260051b8501011115610122575f5ffd5b9250929050565b5f5f6020838503121561013a575f5ffd5b823567ffffffffffffffff811115610150575f5ffd5b61015c858286016100e1565b90969095509350505050565b5f5f60208385031215610179575f5ffd5b823567ffffffffffffffff81111561018f575f5ffd5b8301601f8101851361019f575f5ffd5b803567ffffffffffffffff8111156101b5575f5ffd5b8560208260061b84010111156101c9575f5ffd5b6020919091019590945092505050565b5f602082840312156101e9575f5ffd5b813567ffffffffffffffff8111156101ff575f5ffd5b820160808185031215610210575f5ffd5b9392505050565b5f6040828403128015610228575f5ffd5b50909291505056fea26469706673582212209fd32918ec13dad5aa6d89b6e70ea3be4d9cd7fc599e88cbb71137fd543519c664736f6c634300081d0033";

    private static String librariesLinkedBinary;

    public static final String FUNC_EXACTINPUT = "exactInput";

    public static final String FUNC_GET = "get";

    public static final String FUNC_NAME = "name";

    public static final String FUNC_SETORDER = "setOrder";

    public static final String FUNC_SETORDERS = "setOrders";

    public static final String FUNC_SETORDERSS = "setOrderss";

    @Deprecated
    protected TestArray(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected TestArray(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected TestArray(String contractAddress, Web3j web3j, TransactionManager transactionManager,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected TestArray(String contractAddress, Web3j web3j, TransactionManager transactionManager,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> exactInput(ExactInputParams params,
            BigInteger weiValue) {
        final Function function = new Function(
                FUNC_EXACTINPUT, 
                Arrays.<Type>asList(params), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<TransactionReceipt> get(List<Array> arrays) {
        final Function function = new Function(
                FUNC_GET, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<Array>(Array.class, arrays)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setOrder(Order order) {
        final Function function = new Function(
                FUNC_SETORDER, 
                Arrays.<Type>asList(order), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setOrders(List<Order> orders) {
        final Function function = new Function(
                FUNC_SETORDERS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<Order>(Order.class, orders)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setOrderss(List<Order> orderss) {
        final Function function = new Function(
                FUNC_SETORDERSS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<Order>(Order.class, orderss)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static TestArray load(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return new TestArray(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static TestArray load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new TestArray(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static TestArray load(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return new TestArray(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static TestArray load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new TestArray(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<TestArray> deploy(Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return deployRemoteCall(TestArray.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<TestArray> deploy(Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(TestArray.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    public static RemoteCall<TestArray> deploy(Web3j web3j, TransactionManager transactionManager,
            ContractGasProvider contractGasProvider) {
        return deployRemoteCall(TestArray.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<TestArray> deploy(Web3j web3j, TransactionManager transactionManager,
            BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(TestArray.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), "");
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

    public static class ExactInputParams extends DynamicStruct {
        public byte[] path;

        public String recipient;

        public BigInteger amountIn;

        public BigInteger amountOutMinimum;

        public ExactInputParams(byte[] path, String recipient, BigInteger amountIn,
                BigInteger amountOutMinimum) {
            super(new org.web3j.abi.datatypes.DynamicBytes(path), 
                    new org.web3j.abi.datatypes.Address(160, recipient), 
                    new org.web3j.abi.datatypes.generated.Uint256(amountIn), 
                    new org.web3j.abi.datatypes.generated.Uint256(amountOutMinimum));
            this.path = path;
            this.recipient = recipient;
            this.amountIn = amountIn;
            this.amountOutMinimum = amountOutMinimum;
        }

        public ExactInputParams(DynamicBytes path, Address recipient, Uint256 amountIn,
                Uint256 amountOutMinimum) {
            super(path, recipient, amountIn, amountOutMinimum);
            this.path = path.getValue();
            this.recipient = recipient.getValue();
            this.amountIn = amountIn.getValue();
            this.amountOutMinimum = amountOutMinimum.getValue();
        }
    }

    public static class Array extends DynamicStruct {
        public List<BigInteger> addresss;

        public String account;

        public Array(List<BigInteger> addresss, String account) {
            super(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                            org.web3j.abi.datatypes.generated.Uint256.class,
                            org.web3j.abi.Utils.typeMap(addresss, org.web3j.abi.datatypes.generated.Uint256.class)), 
                    new org.web3j.abi.datatypes.Address(160, account));
            this.addresss = addresss;
            this.account = account;
        }

        public Array(@Parameterized(type = Uint256.class) DynamicArray<Uint256> addresss,
                Address account) {
            super(addresss, account);
            this.addresss = addresss.getValue().stream().map(v -> v.getValue()).collect(Collectors.toList());
            this.account = account.getValue();
        }
    }

    public static class Order extends StaticStruct {
        public String from;

        public String to;

        public Order(String from, String to) {
            super(new org.web3j.abi.datatypes.Address(160, from), 
                    new org.web3j.abi.datatypes.Address(160, to));
            this.from = from;
            this.to = to;
        }

        public Order(Address from, Address to) {
            super(from, to);
            this.from = from.getValue();
            this.to = to.getValue();
        }
    }
}
