package com.example.backend;



import contracts.test.ImmobillierContract;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import java.math.BigInteger;
import java.util.logging.Logger;


@SpringBootApplication
@EnableFeignClients
public class BackendApplication {

//    private final static String PRIVATE_KEY = "dc56417ae7de55a9f33e15394f0515f8b128d5d619c76256f6e51fe1fa7c5279";
//    private final static BigInteger GAS_LIMIT = BigInteger.valueOf(6721975L);
//    private final static BigInteger GAS_PRICE = BigInteger.valueOf(20000000000L);
//    //private final static String CONTRACT_ADDRESS = "0x90edae36c31698a7d2160c31eef2ebdf920171b7";


    public static void main(String[] args) {

        SpringApplication.run(BackendApplication.class, args);
    }

    public BackendApplication() throws Exception {
//        String node = "HTTP://0.0.0.0:7545";
//        System.out.println("Connecting to Ethereum …");
//        Web3j web3 = Web3j.build(new HttpService(node));
//        System.out.println("Ethereum connected ");
//        // String privatekey = "";
//        BigInteger privkey = new BigInteger(PRIVATE_KEY, 16);
//        ECKeyPair ecKeyPair = ECKeyPair.create(privkey);
//        Credentials credentials = Credentials.create(ecKeyPair);
//
//        ImmobillierContract contract = ImmobillierContract.deploy(web3, credentials, GAS_PRICE, GAS_LIMIT).send();
//
////        ImmobillierContract contract = loadContract(CONTRACT_ADDRESS,web3,credentials);
////        LoadedContarct.setLoadedContarct(contract);
////       String  address2_ = LoadedContarct.getLoadedContarct().getContractAddress();
//
//         System.out.println("Smart contract deployed to address "+ contract.getContractAddress());


    }


//        private String deployContract(Web3j web3j, Credentials credentials) throws Exception {
//        return ImmobillierContract.deploy(web3j, credentials, GAS_PRICE, GAS_LIMIT)
//                .send()
//                .getContractAddress();
//    }
//
//    private ImmobillierContract loadContract(String contractAddress, Web3j web3j, Credentials credentials) {
//        return ImmobillierContract.load(contractAddress, web3j, credentials, GAS_PRICE, GAS_LIMIT);
//    }
@Bean
BCryptPasswordEncoder getBCPE(){
    return new BCryptPasswordEncoder();
}

    }




