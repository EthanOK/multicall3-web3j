package org.handle;

import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Type;

import java.util.List;

public class EncodedFunction {
    public final String encoded;
    public final List<TypeReference<Type>> outputParameters;

    public EncodedFunction(String encoded, List<TypeReference<Type>> outputParameters) {
        this.encoded = encoded;
        this.outputParameters = outputParameters;
    }
}
