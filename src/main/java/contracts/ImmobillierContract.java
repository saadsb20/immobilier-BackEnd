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
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;
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
public class ImmobillierContract extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50600080546001600160a01b0319163390811782558152600360208190526040909120805460ff19166001830217905550600080546001600160a01b03168152600460205260409020805460ff19166001179055610bd9806100736000396000f3fe608060405234801561001057600080fd5b50600436106101005760003560e01c806389b3887e11610097578063e35fe36611610066578063e35fe36614610284578063e9b66f8c146102a7578063eeb294e2146102ba578063f7b10808146102cd57600080fd5b806389b3887e146102225780639448f03d146102355780639c4ea46a14610248578063c1d5e84f1461027157600080fd5b80634c82d0e4116100d35780634c82d0e4146101a157806374d5e100146101b45780637b855bf0146101e45780638709b2e71461020f57600080fd5b80630a1b10e114610105578063126dbe431461012d57806327983fcf1461017b57806332282f8e1461018e575b600080fd5b610118610113366004610a71565b61030a565b60405190151581526020015b60405180910390f35b61016c61013b366004610a93565b600090815260016020819052604090912080549181015460029091015460ff9092169290916001600160a01b031690565b60405161012493929190610ae3565b610118610189366004610a93565b6103e7565b61011861019c366004610a71565b61047b565b6101186101af366004610a71565b610527565b6101d76101c2366004610a71565b60036020526000908152604090205460ff1681565b6040516101249190610b0d565b6000546101f7906001600160a01b031681565b6040516001600160a01b039091168152602001610124565b61011861021d366004610b20565b6105f8565b610118610230366004610b42565b61065b565b610118610243366004610b6e565b61072b565b6101f7610256366004610a93565b6002602052600090815260409020546001600160a01b031681565b61011861027f366004610a71565b61083b565b610118610292366004610a71565b60046020526000908152604090205460ff1681565b6101186102b5366004610a93565b610912565b6101186102c8366004610a93565b6109a6565b61016c6102db366004610a93565b600160208190526000918252604090912080549181015460029091015460ff909216916001600160a01b031683565b33600090815260036020819052604082205460ff168181111561032f5761032f610aac565b14801561034b57503360009081526004602052604090205460ff165b61035457600080fd5b6001600160a01b038216600090815260036020819052604082205460ff169081111561038257610382610aac565b1461038c57600080fd5b6001600160a01b03821660009081526004602052604090205460ff16156103b257600080fd5b6001600160a01b038216600090815260036020526040902080546002919060ff19166001835b0217905550600190505b919050565b33600090815260036020819052604082205460ff168181111561040c5761040c610aac565b14801561042857503360009081526004602052604090205460ff165b61043157600080fd5b6000828152600160205260409020600201546001600160a01b031633141561045857600080fd5b6000828152600160208190526040909120805460039260ff1990911690836103d8565b33600090815260036020819052604082205460ff16818111156104a0576104a0610aac565b1480156104bc57503360009081526004602052604090205460ff165b6104c557600080fd5b6001600160a01b038216600090815260036020819052604082205460ff16908111156104f3576104f3610aac565b14156104fe57600080fd5b506001600160a01b03166000908152600460205260409020805460ff1916600190811790915590565b33600090815260036020819052604082205460ff168181111561054c5761054c610aac565b14801561056857503360009081526004602052604090205460ff165b61057157600080fd5b6001600160a01b038216600090815260036020819052604082205460ff169081111561059f5761059f610aac565b146105a957600080fd5b6001600160a01b03821660009081526004602052604090205460ff16156105cf57600080fd5b6001600160a01b0382166000908152600360208190526040909120805460ff19166001836103d8565b60008281526001602052604081206002015483906001600160a01b0316331461062057600080fd5b6000848152600260205260409020546001600160a01b03161561064257600080fd5b5050600091825260016020819052604090922082015590565b60008281526001602052604081206002015483906001600160a01b0316331461068357600080fd5b6001600160a01b038316600090815260046020526040902054839060ff166106aa57600080fd5b6000858152600160205260409020600201546001600160a01b03858116911614156106d457600080fd5b6000858152600260205260409020546001600160a01b0316156106f657600080fd5b600085815260026020526040902080546001600160a01b0386166001600160a01b031990911617905560019250505092915050565b600060023360009081526003602081905260409091205460ff169081111561075557610755610aac565b1015801561077257503360009081526004602052604090205460ff165b61077b57600080fd5b6001600160a01b038216600090815260046020526040902054829060ff166107a257600080fd5b60408051606081018252600180825260208083018890526001600160a01b038716838501526000898152908290529290922081518154929391929091839160ff1916908360038111156107f7576107f7610aac565b02179055506020820151600182810191909155604090920151600290910180546001600160a01b0319166001600160a01b0390921691909117905595945050505050565b600060023360009081526003602081905260409091205460ff169081111561086557610865610aac565b1015801561088257503360009081526004602052604090205460ff165b61088b57600080fd5b6001600160a01b038216600090815260036020819052604082205460ff16908111156108b9576108b9610aac565b146108c357600080fd5b6001600160a01b03821660009081526004602052604090205460ff16156108e957600080fd5b6001600160a01b038216600090815260036020526040902080546001919060ff191682806103d8565b33600090815260036020819052604082205460ff168181111561093757610937610aac565b14801561095357503360009081526004602052604090205460ff165b61095c57600080fd5b6000828152600160205260409020600201546001600160a01b031633141561098357600080fd5b6000828152600160208190526040909120805460029260ff1990911690836103d8565b33600090815260036020819052604082205460ff16818111156109cb576109cb610aac565b1480156109e757503360009081526004602052604090205460ff165b6109f057600080fd5b6000828152600260205260409020546001600160a01b0316610a1157600080fd5b5060009081526002602081815260408084208054600180855292909520840180546001600160a01b039096166001600160a01b0319968716179055929091528154909216905590565b80356001600160a01b03811681146103e257600080fd5b600060208284031215610a8357600080fd5b610a8c82610a5a565b9392505050565b600060208284031215610aa557600080fd5b5035919050565b634e487b7160e01b600052602160045260246000fd5b60048110610ae057634e487b7160e01b600052602160045260246000fd5b50565b60608101610af085610ac2565b93815260208101929092526001600160a01b031660409091015290565b60208101610b1a83610ac2565b91905290565b60008060408385031215610b3357600080fd5b50508035926020909101359150565b60008060408385031215610b5557600080fd5b82359150610b6560208401610a5a565b90509250929050565b600080600060608486031215610b8357600080fd5b8335925060208401359150610b9a60408501610a5a565b9050925092509256fea2646970667358221220b73fe225bc02ed6d195e8c0df8bef237d42ba27da82020b3f586d0a6ffb0fcb664736f6c634300080b0033";

    public static final String FUNC_ADDNEWADMIN = "addNewAdmin";

    public static final String FUNC_ADDNEWSUPERADMIN = "addNewSuperAdmin";

    public static final String FUNC_ADDNEWUSER = "addNewUser";

    public static final String FUNC_APPROVECHANGEOWNERSHIP = "approveChangeOwnership";

    public static final String FUNC_APPROVEPROPERTY = "approveProperty";

    public static final String FUNC_APPROVEUSERS = "approveUsers";

    public static final String FUNC_CHANGEOWNERSHIP = "changeOwnership";

    public static final String FUNC_CHANGEVALUE = "changeValue";

    public static final String FUNC_CREATEPROPERTY = "createProperty";

    public static final String FUNC_CREATORADMIN = "creatorAdmin";

    public static final String FUNC_GETPROPERTYDETAILS = "getPropertyDetails";

    public static final String FUNC_PROPOWNERCHANGE = "propOwnerChange";

    public static final String FUNC_PROPERTIES = "properties";

    public static final String FUNC_REJECTPROPERTY = "rejectProperty";

    public static final String FUNC_USERROLES = "userRoles";

    public static final String FUNC_VERIFIEDUSERS = "verifiedUsers";

    @Deprecated
    protected ImmobillierContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ImmobillierContract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ImmobillierContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ImmobillierContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> addNewAdmin(String _newAdmin) {
        final Function function = new Function(
                FUNC_ADDNEWADMIN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _newAdmin)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> addNewSuperAdmin(String _newSuperAdmin) {
        final Function function = new Function(
                FUNC_ADDNEWSUPERADMIN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _newSuperAdmin)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> addNewUser(String _newUser) {
        final Function function = new Function(
                FUNC_ADDNEWUSER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _newUser)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> approveChangeOwnership(BigInteger _propId) {
        final Function function = new Function(
                FUNC_APPROVECHANGEOWNERSHIP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_propId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> approveProperty(BigInteger _propId) {
        final Function function = new Function(
                FUNC_APPROVEPROPERTY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_propId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> approveUsers(String _newUser) {
        final Function function = new Function(
                FUNC_APPROVEUSERS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _newUser)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> changeOwnership(BigInteger _propId, String _newOwner) {
        final Function function = new Function(
                FUNC_CHANGEOWNERSHIP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_propId), 
                new org.web3j.abi.datatypes.Address(160, _newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> changeValue(BigInteger _propId, BigInteger _newValue) {
        final Function function = new Function(
                FUNC_CHANGEVALUE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_propId), 
                new org.web3j.abi.datatypes.generated.Uint256(_newValue)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> createProperty(BigInteger _propId, BigInteger _value, String _owner) {
        final Function function = new Function(
                FUNC_CREATEPROPERTY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_propId), 
                new org.web3j.abi.datatypes.generated.Uint256(_value), 
                new org.web3j.abi.datatypes.Address(160, _owner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> creatorAdmin() {
        final Function function = new Function(FUNC_CREATORADMIN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<Tuple3<BigInteger, BigInteger, String>> getPropertyDetails(BigInteger _propId) {
        final Function function = new Function(FUNC_GETPROPERTYDETAILS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_propId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}));
        return new RemoteFunctionCall<Tuple3<BigInteger, BigInteger, String>>(function,
                new Callable<Tuple3<BigInteger, BigInteger, String>>() {
                    @Override
                    public Tuple3<BigInteger, BigInteger, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<BigInteger, BigInteger, String>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (String) results.get(2).getValue());
                    }
                });
    }

    public RemoteFunctionCall<String> propOwnerChange(BigInteger param0) {
        final Function function = new Function(FUNC_PROPOWNERCHANGE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<Tuple3<BigInteger, BigInteger, String>> properties(BigInteger param0) {
        final Function function = new Function(FUNC_PROPERTIES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}));
        return new RemoteFunctionCall<Tuple3<BigInteger, BigInteger, String>>(function,
                new Callable<Tuple3<BigInteger, BigInteger, String>>() {
                    @Override
                    public Tuple3<BigInteger, BigInteger, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<BigInteger, BigInteger, String>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (String) results.get(2).getValue());
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> rejectProperty(BigInteger _propId) {
        final Function function = new Function(
                FUNC_REJECTPROPERTY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_propId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> userRoles(String param0) {
        final Function function = new Function(FUNC_USERROLES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Boolean> verifiedUsers(String param0) {
        final Function function = new Function(FUNC_VERIFIEDUSERS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    @Deprecated
    public static ImmobillierContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ImmobillierContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ImmobillierContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ImmobillierContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ImmobillierContract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ImmobillierContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ImmobillierContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ImmobillierContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ImmobillierContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ImmobillierContract.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<ImmobillierContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ImmobillierContract.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ImmobillierContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ImmobillierContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ImmobillierContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ImmobillierContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
