package contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple8;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class PropertyFactory extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b506109aa806100206000396000f3fe60806040526004361061004a5760003560e01c80631ea67fd51461004f578063bda87cb514610072578063cb6784e014610094578063d96a094a146100a9578063f7b10808146100bc575b600080fd5b34801561005b57600080fd5b506000546040519081526020015b60405180910390f35b34801561007e57600080fd5b5061009261008d366004610796565b6100f0565b005b3480156100a057600080fd5b506100926102a2565b6100926100b736600461084b565b6102af565b3480156100c857600080fd5b506100dc6100d736600461084b565b6103fa565b6040516100699897969594939291906108b1565b60006040518061010001604052808b81526020018a815260200189898080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250505090825250604080516020601f8a0181900481028201810190925288815291810191908990899081908401838280828437600092019190915250505090825250604080516020601f88018190048102820181019092528681529181019190879087908190840183828082843760009201829052509385525050506020808301869052600160408085018290523360609095019490945285548082018755958352918190208451600790960201948555838101519185019190915590820151805192939261021192600285019201906105f7565b506060820151805161022d9160038401916020909101906105f7565b50608082015180516102499160048401916020909101906105f7565b5060a0820151600582015560c08201516006909101805460e0909301516001600160a01b031661010002610100600160a81b0319921515929092166001600160a81b031990931692909217179055505050505050505050565b6102ad60008061067b565b565b600081815481106102c2576102c2610923565b90600052602060002090600702016000015434146103145760405162461bcd60e51b815260206004820152600b60248201526a08ae4e4caeae440e0e4d2f60ab1b604482015260640160405180910390fd5b6000818154811061032757610327610923565b600091825260208220600660079092020101546040516001600160a01b0361010090920491909116913480156108fc02929091818181858888f19350505050158015610377573d6000803e3d6000fd5b50336000828154811061038c5761038c610923565b906000526020600020906007020160060160016101000a8154816001600160a01b0302191690836001600160a01b0316021790555060008082815481106103d5576103d5610923565b60009182526020909120600790910201600601805460ff191691151591909117905550565b6000818154811061040a57600080fd5b906000526020600020906007020160009150905080600001549080600101549080600201805461043990610939565b80601f016020809104026020016040519081016040528092919081815260200182805461046590610939565b80156104b25780601f10610487576101008083540402835291602001916104b2565b820191906000526020600020905b81548152906001019060200180831161049557829003601f168201915b5050505050908060030180546104c790610939565b80601f01602080910402602001604051908101604052809291908181526020018280546104f390610939565b80156105405780601f1061051557610100808354040283529160200191610540565b820191906000526020600020905b81548152906001019060200180831161052357829003601f168201915b50505050509080600401805461055590610939565b80601f016020809104026020016040519081016040528092919081815260200182805461058190610939565b80156105ce5780601f106105a3576101008083540402835291602001916105ce565b820191906000526020600020905b8154815290600101906020018083116105b157829003601f168201915b50505050600583015460069093015491929160ff8116915061010090046001600160a01b031688565b82805461060390610939565b90600052602060002090601f016020900481019282610625576000855561066b565b82601f1061063e57805160ff191683800117855561066b565b8280016001018555821561066b579182015b8281111561066b578251825591602001919060010190610650565b5061067792915061069f565b5090565b508054600082556007029060005260206000209081019061069c91906106b4565b50565b5b8082111561067757600081556001016106a0565b80821115610677576000808255600182018190556106d56002830182610713565b6106e3600383016000610713565b6106f1600483016000610713565b50600060058201556006810180546001600160a81b03191690556007016106b4565b50805461071f90610939565b6000825580601f1061072f575050565b601f01602090049060005260206000209081019061069c919061069f565b60008083601f84011261075f57600080fd5b50813567ffffffffffffffff81111561077757600080fd5b60208301915083602082850101111561078f57600080fd5b9250929050565b600080600080600080600080600060c08a8c0312156107b457600080fd5b8935985060208a0135975060408a013567ffffffffffffffff808211156107da57600080fd5b6107e68d838e0161074d565b909950975060608c01359150808211156107ff57600080fd5b61080b8d838e0161074d565b909750955060808c013591508082111561082457600080fd5b506108318c828d0161074d565b9a9d999c50979a9699959894979660a00135949350505050565b60006020828403121561085d57600080fd5b5035919050565b6000815180845260005b8181101561088a5760208185018101518683018201520161086e565b8181111561089c576000602083870101525b50601f01601f19169290920160200192915050565b60006101008a83528960208401528060408401526108d18184018a610864565b905082810360608401526108e58189610864565b905082810360808401526108f98188610864565b60a0840196909652505091151560c08301526001600160a01b031660e09091015295945050505050565b634e487b7160e01b600052603260045260246000fd5b600181811c9082168061094d57607f821691505b6020821081141561096e57634e487b7160e01b600052602260045260246000fd5b5091905056fea26469706673582212205513530ab7500fcb9a9e139e32b8fd1c71a6a57e3d59411f39e3213175c2ac0264736f6c634300080b0033";

    public static final String FUNC_BUY = "buy";

    public static final String FUNC_CLEARALLPROPERTIES = "clearAllProperties";

    public static final String FUNC_GETNBPROPERTIES = "getNbProperties";

    public static final String FUNC_POST = "post";

    public static final String FUNC_PROPERTIES = "properties";

    @Deprecated
    protected PropertyFactory(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected PropertyFactory(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected PropertyFactory(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected PropertyFactory(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> buy(BigInteger _propertyId) {
        final Function function = new Function(
                FUNC_BUY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_propertyId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> clearAllProperties() {
        final Function function = new Function(
                FUNC_CLEARALLPROPERTIES, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> getNbProperties() {
        final Function function = new Function(FUNC_GETNBPROPERTIES, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> post(BigInteger _price, BigInteger _size, String _geoAddress, String _description, String _documents, BigInteger _nbRooms) {
        final Function function = new Function(
                FUNC_POST, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_price), 
                new org.web3j.abi.datatypes.generated.Uint256(_size), 
                new org.web3j.abi.datatypes.Utf8String(_geoAddress), 
                new org.web3j.abi.datatypes.Utf8String(_description), 
                new org.web3j.abi.datatypes.Utf8String(_documents), 
                new org.web3j.abi.datatypes.generated.Uint256(_nbRooms)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple8<BigInteger, BigInteger, String, String, String, BigInteger, Boolean, String>> properties(BigInteger param0) {
        final Function function = new Function(FUNC_PROPERTIES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Bool>() {}, new TypeReference<Address>() {}));
        return new RemoteFunctionCall<Tuple8<BigInteger, BigInteger, String, String, String, BigInteger, Boolean, String>>(function,
                new Callable<Tuple8<BigInteger, BigInteger, String, String, String, BigInteger, Boolean, String>>() {
                    @Override
                    public Tuple8<BigInteger, BigInteger, String, String, String, BigInteger, Boolean, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple8<BigInteger, BigInteger, String, String, String, BigInteger, Boolean, String>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (String) results.get(3).getValue(), 
                                (String) results.get(4).getValue(), 
                                (BigInteger) results.get(5).getValue(), 
                                (Boolean) results.get(6).getValue(), 
                                (String) results.get(7).getValue());
                    }
                });
    }

    @Deprecated
    public static PropertyFactory load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new PropertyFactory(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static PropertyFactory load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new PropertyFactory(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static PropertyFactory load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new PropertyFactory(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static PropertyFactory load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new PropertyFactory(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<PropertyFactory> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(PropertyFactory.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<PropertyFactory> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(PropertyFactory.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<PropertyFactory> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(PropertyFactory.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<PropertyFactory> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(PropertyFactory.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
