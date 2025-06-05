package org.handle;

import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.model.Multicall3;

import java.util.Arrays;
import java.util.List;

public class EncodeMulticall {
    public static EncodedFunction encodeGetEthBalance(String addr) {
        Function function = new Function("getEthBalance",
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, addr)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {
                }));
        String encodeData = FunctionEncoder.encode(function);
        return new EncodedFunction(encodeData, function.getOutputParameters());

    }

    public static EncodedFunction encodeAggregate3(List<Multicall3.Call3> calls) {

        Function function = new Function("aggregate3",
                Arrays.<Type>asList(
                        new org.web3j.abi.datatypes.DynamicArray<Multicall3.Call3>(Multicall3.Call3.class, calls)),
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Multicall3.Result>>() {
                }));
        String encodeData = FunctionEncoder.encode(function);

        return new EncodedFunction(encodeData, function.getOutputParameters());

    }

}
