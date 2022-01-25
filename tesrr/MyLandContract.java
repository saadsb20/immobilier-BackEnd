package contracts;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple5;
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
public class MyLandContract extends Contract {
    public static final String BINARY = "608060408190526000805460ff60a01b1916905561001c90610080565b604051809103906000f080158015610038573d6000803e3d6000fd5b50600580546001600160a01b0319166001600160a01b039290921691909117905534801561006557600080fd5b50600080546001600160a01b0319163317815560015561008c565b605980610fcb83390190565b610f308061009b6000396000f3fe6080604052600436106100915760003560e01c806382f557ae1161005957806382f557ae146101585780638da5cb5b1461017c578063b3f40d6a146101b4578063bfbf7e76146101d7578063db9d05511461020457600080fd5b806305b1137b1461009657806305efe9c7146100b857806326f82448146100f25780633ccfd60b146101125780636574255514610127575b600080fd5b3480156100a257600080fd5b506100b66100b1366004610c4c565b61023a565b005b3480156100c457600080fd5b506100d86100d3366004610c4c565b610275565b6040516100e9959493929190610cc5565b60405180910390f35b3480156100fe57600080fd5b506100b661010d366004610d1c565b610357565b34801561011e57600080fd5b506100b6610469565b34801561013357600080fd5b50610147610142366004610c4c565b610498565b6040516100e9959493929190610de9565b34801561016457600080fd5b5061016e60015481565b6040519081526020016100e9565b34801561018857600080fd5b5060005461019c906001600160a01b031681565b6040516001600160a01b0390911681526020016100e9565b6101c76101c2366004610c4c565b610694565b60405190151581526020016100e9565b3480156101e357600080fd5b506101f76101f2366004610c4c565b6109ca565b6040516100e99190610e29565b34801561021057600080fd5b5061016e61021f366004610e43565b6001600160a01b031660009081526003602052604090205490565b6040516001600160a01b0383169082156108fc029083906000818181858888f19350505050158015610270573d6000803e3d6000fd5b505050565b6003602052816000526040600020818154811061029157600080fd5b6000918252602090912060059091020180546001820180546001600160a01b0390921694509192506102c290610e60565b80601f01602080910402602001604051908101604052809291908181526020018280546102ee90610e60565b801561033b5780601f106103105761010080835404028352916020019161033b565b820191906000526020600020905b81548152906001019060200180831161031e57829003601f168201915b5050505050908060020154908060030154908060040154905085565b6000546001600160a01b0316331461036e57600080fd5b6001805461037b91610eb1565b60018181556040805160a0810182526001600160a01b0387811682526020808301888152838501889052606084019690965260808301859052336000908152600382529384208054808701825590855293819020835160059095020180546001600160a01b031916949092169390931781559351805191948594909361040693918501920190610b68565b50604082810151600283015560608301516003830155608090920151600490910155600154815133815260208101919091527f2728c9d3205d667bbc0eefdfeda366261b4d021949630c047f3e5834b30611ab910160405180910390a150505050565b60405133904780156108fc02916000818181858888f19350505050158015610495573d6000803e3d6000fd5b50565b606060008060008060036000886001600160a01b03166001600160a01b0316815260200190815260200160002086815481106104d6576104d6610ec9565b906000526020600020906005020160010160036000896001600160a01b03166001600160a01b03168152602001908152602001600020878154811061051d5761051d610ec9565b906000526020600020906005020160020154600360008a6001600160a01b03166001600160a01b03168152602001908152602001600020888154811061056557610565610ec9565b600091825260208083206005909202909101546001600160a01b038c811684526003909252604090922080549190921691908a9081106105a7576105a7610ec9565b6000918252602080832060036005909302018201546001600160a01b038e168452919052604090912080548b9081106105e2576105e2610ec9565b90600052602060002090600502016004015484805461060090610e60565b80601f016020809104026020016040519081016040528092919081815260200182805461062c90610e60565b80156106795780601f1061064e57610100808354040283529160200191610679565b820191906000526020600020905b81548152906001019060200180831161065c57829003601f168201915b50505050509450945094509450945094509295509295909350565b6000805b336000908152600360205260409020548110156109be573360009081526003602052604090208054849190839081106106d3576106d3610ec9565b90600052602060002090600502016003015414156109ac576040805160a0810182526001600160a01b038616815233600090815260036020908152928120805491938301918590811061072857610728610ec9565b9060005260206000209060050201600101805461074490610e60565b80601f016020809104026020016040519081016040528092919081815260200182805461077090610e60565b80156107bd5780601f10610792576101008083540402835291602001916107bd565b820191906000526020600020905b8154815290600101906020018083116107a057829003601f168201915b5050505050815260200160036000336001600160a01b03166001600160a01b0316815260200190815260200160002084815481106107fd576107fd610ec9565b906000526020600020906005020160020154815260200185815260200160036000336001600160a01b03166001600160a01b03168152602001908152602001600020848154811061085057610850610ec9565b60009182526020808320600592830201600401549093526001600160a01b03898116835260038452604083208054600180820183559185529385902086519490930290920180546001600160a01b03191693909116929092178255838301518051949550859492936108c89392850192910190610b68565b50604082015181600201556060820151816003015560808201518160040155505060036000336001600160a01b03166001600160a01b03168152602001908152602001600020828154811061091f5761091f610ec9565b60009182526020822060059091020180546001600160a01b03191681559061094a6001830182610bec565b50600060028201819055600382018190556004909101556040518481526001600160a01b0386169033907fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef9060200160405180910390a36001925050506109c4565b806109b681610edf565b915050610698565b50600090505b92915050565b606060005b6001600160a01b038416600090815260036020526040902054811015610b3a576001600160a01b0384166000908152600360205260409020805484919083908110610a1c57610a1c610ec9565b9060005260206000209060050201600301541415610b28576001600160a01b0384166000908152600360205260409020805482908110610a5e57610a5e610ec9565b90600052602060002090600502016004015460011415610aed576001600160a01b0384166000908152600360205260408120805483908110610aa257610aa2610ec9565b9060005260206000209060050201600401819055506040518060400160405280601581526020017413d4115490551253d38814d550d0d154d4d1955313605a1b8152509150506109c4565b505060408051808201909152601d81527f50524f504552545920414c5245414459204e4f5420464f522053414c4500000060208201526109c4565b80610b3281610edf565b9150506109cf565b505060408051808201909152600f81526e125395905312510813105391081251608a1b602082015292915050565b828054610b7490610e60565b90600052602060002090601f016020900481019282610b965760008555610bdc565b82601f10610baf57805160ff1916838001178555610bdc565b82800160010185558215610bdc579182015b82811115610bdc578251825591602001919060010190610bc1565b50610be8929150610c22565b5090565b508054610bf890610e60565b6000825580601f10610c08575050565b601f01602090049060005260206000209081019061049591905b5b80821115610be85760008155600101610c23565b6001600160a01b038116811461049557600080fd5b60008060408385031215610c5f57600080fd5b8235610c6a81610c37565b946020939093013593505050565b6000815180845260005b81811015610c9e57602081850181015186830182015201610c82565b81811115610cb0576000602083870101525b50601f01601f19169290920160200192915050565b6001600160a01b038616815260a060208201819052600090610ce990830187610c78565b604083019590955250606081019290925260809091015292915050565b634e487b7160e01b600052604160045260246000fd5b600080600060608486031215610d3157600080fd5b8335610d3c81610c37565b9250602084013567ffffffffffffffff80821115610d5957600080fd5b818601915086601f830112610d6d57600080fd5b813581811115610d7f57610d7f610d06565b604051601f8201601f19908116603f01168101908382118183101715610da757610da7610d06565b81604052828152896020848701011115610dc057600080fd5b826020860160208301376000602084830101528096505050505050604084013590509250925092565b60a081526000610dfc60a0830188610c78565b6020830196909652506001600160a01b039390931660408401526060830191909152608090910152919050565b602081526000610e3c6020830184610c78565b9392505050565b600060208284031215610e5557600080fd5b8135610e3c81610c37565b600181811c90821680610e7457607f821691505b60208210811415610e9557634e487b7160e01b600052602260045260246000fd5b50919050565b634e487b7160e01b600052601160045260246000fd5b60008219821115610ec457610ec4610e9b565b500190565b634e487b7160e01b600052603260045260246000fd5b6000600019821415610ef357610ef3610e9b565b506001019056fea2646970667358221220d359cbcbd6486c05135582d6337b1cda08bd88f06ecbd330b3407182a367669f64736f6c634300080b00336080604052348015600f57600080fd5b50603c80601d6000396000f3fe608060405200fea2646970667358221220dd3a1ddc8451c253ffbd89f736bd35ebbb4e7cbb26be452e87a9cf50cbaebbb764736f6c634300080b0033";

    public static final String FUNC_REMOVEFROMSALE = "RemoveFromSale";

    public static final String FUNC___OWNEDLANDS = "__ownedLands";

    public static final String FUNC_ADDLAND = "addLand";

    public static final String FUNC_GETLAND = "getLand";

    public static final String FUNC_GETNOOFLANDS = "getNoOfLands";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_TOTALLANDSCOUNTER = "totalLandsCounter";

    public static final String FUNC_TRANSFERETHER = "transferEther";

    public static final String FUNC_TRANSFERLAND = "transferLand";

    public static final String FUNC_WITHDRAW = "withdraw";

    public static final Event ADD_EVENT = new Event("Add", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event ETHERTRANSFER_EVENT = new Event("EtherTransfer", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event TRANSFER_EVENT = new Event("Transfer", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event UPDATESTATUS_EVENT = new Event("UpdateStatus", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected MyLandContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected MyLandContract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected MyLandContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected MyLandContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<AddEventResponse> getAddEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ADD_EVENT, transactionReceipt);
        ArrayList<AddEventResponse> responses = new ArrayList<AddEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AddEventResponse typedResponse = new AddEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._owner = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse._landID = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<AddEventResponse> addEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, AddEventResponse>() {
            @Override
            public AddEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ADD_EVENT, log);
                AddEventResponse typedResponse = new AddEventResponse();
                typedResponse.log = log;
                typedResponse._owner = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse._landID = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<AddEventResponse> addEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ADD_EVENT));
        return addEventFlowable(filter);
    }

    public List<EtherTransferEventResponse> getEtherTransferEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ETHERTRANSFER_EVENT, transactionReceipt);
        ArrayList<EtherTransferEventResponse> responses = new ArrayList<EtherTransferEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            EtherTransferEventResponse typedResponse = new EtherTransferEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._to = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse._cost = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<EtherTransferEventResponse> etherTransferEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, EtherTransferEventResponse>() {
            @Override
            public EtherTransferEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ETHERTRANSFER_EVENT, log);
                EtherTransferEventResponse typedResponse = new EtherTransferEventResponse();
                typedResponse.log = log;
                typedResponse._from = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._to = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse._cost = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<EtherTransferEventResponse> etherTransferEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ETHERTRANSFER_EVENT));
        return etherTransferEventFlowable(filter);
    }

    public List<TransferEventResponse> getTransferEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(TRANSFER_EVENT, transactionReceipt);
        ArrayList<TransferEventResponse> responses = new ArrayList<TransferEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            TransferEventResponse typedResponse = new TransferEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._to = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse._landID = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<TransferEventResponse> transferEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, TransferEventResponse>() {
            @Override
            public TransferEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(TRANSFER_EVENT, log);
                TransferEventResponse typedResponse = new TransferEventResponse();
                typedResponse.log = log;
                typedResponse._from = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._to = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse._landID = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<TransferEventResponse> transferEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TRANSFER_EVENT));
        return transferEventFlowable(filter);
    }

    public List<UpdateStatusEventResponse> getUpdateStatusEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(UPDATESTATUS_EVENT, transactionReceipt);
        ArrayList<UpdateStatusEventResponse> responses = new ArrayList<UpdateStatusEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            UpdateStatusEventResponse typedResponse = new UpdateStatusEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._msg = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse._cost = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<UpdateStatusEventResponse> updateStatusEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, UpdateStatusEventResponse>() {
            @Override
            public UpdateStatusEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(UPDATESTATUS_EVENT, log);
                UpdateStatusEventResponse typedResponse = new UpdateStatusEventResponse();
                typedResponse.log = log;
                typedResponse._msg = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse._cost = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<UpdateStatusEventResponse> updateStatusEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(UPDATESTATUS_EVENT));
        return updateStatusEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> RemoveFromSale(String _landHolder, BigInteger land_id) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_REMOVEFROMSALE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _landHolder), 
                new org.web3j.abi.datatypes.generated.Uint256(land_id)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple5<String, String, BigInteger, BigInteger, BigInteger>> __ownedLands(String param0, BigInteger param1) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC___OWNEDLANDS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, param0), 
                new org.web3j.abi.datatypes.generated.Uint256(param1)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple5<String, String, BigInteger, BigInteger, BigInteger>>(function,
                new Callable<Tuple5<String, String, BigInteger, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple5<String, String, BigInteger, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple5<String, String, BigInteger, BigInteger, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue());
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> addLand(String propertyOwner, String _location, BigInteger _cost) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ADDLAND, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, propertyOwner), 
                new org.web3j.abi.datatypes.Utf8String(_location), 
                new org.web3j.abi.datatypes.generated.Uint256(_cost)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> getLand(String _landHolder, BigInteger _index) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_GETLAND, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _landHolder), 
                new org.web3j.abi.datatypes.generated.Uint256(_index)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> getNoOfLands(String _landHolder) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_GETNOOFLANDS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _landHolder)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> owner() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> totalLandsCounter() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_TOTALLANDSCOUNTER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> transferEther(String rec, BigInteger _amount) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TRANSFERETHER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, rec), 
                new org.web3j.abi.datatypes.generated.Uint256(_amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> transferLand(String _landBuyer, BigInteger _landID) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TRANSFERLAND, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _landBuyer), 
                new org.web3j.abi.datatypes.generated.Uint256(_landID)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> withdraw() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_WITHDRAW, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static MyLandContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new MyLandContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static MyLandContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new MyLandContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static MyLandContract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new MyLandContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static MyLandContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new MyLandContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<MyLandContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(MyLandContract.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<MyLandContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(MyLandContract.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<MyLandContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(MyLandContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<MyLandContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(MyLandContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class AddEventResponse extends BaseEventResponse {
        public String _owner;

        public BigInteger _landID;
    }

    public static class EtherTransferEventResponse extends BaseEventResponse {
        public String _from;

        public String _to;

        public BigInteger _cost;
    }

    public static class TransferEventResponse extends BaseEventResponse {
        public String _from;

        public String _to;

        public BigInteger _landID;
    }

    public static class UpdateStatusEventResponse extends BaseEventResponse {
        public String _msg;

        public BigInteger _cost;
    }
}
