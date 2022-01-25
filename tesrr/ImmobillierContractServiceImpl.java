//package com.example.backend.services;
//
//import com.example.backend.Repositories.ImmobillierRepository;
//import com.example.backend.constant.LoadedContarct;
//import com.example.backend.dtos.ChangeOwnershipInput;
//import com.example.backend.dtos.ImmobilierInput;
//import com.example.backend.entities.Immobillier;
//import contracts.ImmobilierContract;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.math.BigInteger;
//
//@Service
//public class ImmobillierContractServiceImpl implements ImmobillierContractService2 {
//
//    @Autowired
//    ImmobillierRepository immobillierRepository;
//    ImmobilierContract immobilierContract = LoadedContarct.getLoadedContarct();
//
//    @Override
//    public void addNewAdmin(String _newAdmin) {
//        immobilierContract.addNewAdmin(_newAdmin);
//    }
//
//    @Override
//    public void addNewSuperAdmin(String _newSuperAdmin) {
//        immobilierContract.addNewSuperAdmin(_newSuperAdmin);
//    }
//
//    @Override
//    public void addNewUser(String _newUser) throws Exception {
//        System.out.println("hhhhhhhhhhhh"+ immobilierContract.getContractAddress());
//        System.out.println("hhhhhhhhhhhh"+_newUser);
//        System.out.println("------- add User "+ immobilierContract.addNewUser(_newUser).send());
//
//    }
//
//    @Override
//    public void approveChangeOwnership(BigInteger _immoId) {
//        immobilierContract.approveChangeOwnership(_immoId);
//    }
//
//    @Override
//    public void approveImmobilier(BigInteger _immoId) throws Exception {
//        immobilierContract.approveImmobilier(_immoId);
//    }
//
//    @Override
//    public void approveUsers(String _newUser) throws Exception {
//        System.out.println("approve User "+ immobilierContract.approveUsers(_newUser));
//
//    }
//
//    @Override
//    public void changeOwnership(ChangeOwnershipInput changeOwnershipInput) throws Exception {
//        System.out.println("********************************"+changeOwnershipInput.get_newOwner()+"********"+changeOwnershipInput.get_propId());
//        System.out.println("change OwnerShip "+ immobilierContract.changeOwnership(BigInteger.valueOf(changeOwnershipInput.get_propId()),changeOwnershipInput.get_newOwner()).send());
//
//    }
//
//    @Override
//    public void changePrice(BigInteger _immoId, BigInteger _newPrice) {
//        immobilierContract.changePrice(_immoId,_newPrice);
//    }
//
////    @Override
////    public void changeCategory(BigInteger _immoId, String _newCategory) {
////        immobilierContract.changeCategory(_immoId,_newCategory);
////    }
//
//    @Override
//    public void createImmobilier(ImmobilierInput immobilierInput) throws Exception {
//        System.out.println("hhhhhhhhhhhh");
//        Immobillier immobillier = new Immobillier(null,
//                immobilierInput.get_price(),
//                immobilierInput.getLocalisation(),
//                immobilierInput.getCategory(),
//                immobilierInput.getOwner());
//
//        Immobillier savedImmobillier= immobillierRepository.save(immobillier);
//        System.out.println("------- add immobilier "+ immobilierContract.createImmobilier(
//                BigInteger.valueOf(1),
//                BigInteger.valueOf(10000),
//                "fes",
//                "apprt",
//                "0x0f6fccc87a1B2cf3A934F5b49a975d941EE5f60F"
//        ).send());
//
//
//    }
//
//    @Override
//    public void creatorAdmin() {
//        immobilierContract.creatorAdmin();
//    }
//
//    @Override
//    public void getImmobilierDetails(BigInteger _immoId) throws Exception {
//        System.out.println("------- details immobilier "+ immobilierContract.getImmobilierDetails(_immoId).send());
//    }
//
//    @Override
//    public void immoOwnerChange(BigInteger param0) {
//
//    }
//}
