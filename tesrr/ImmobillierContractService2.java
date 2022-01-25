package com.example.backend.services;

import com.example.backend.dtos.ChangeOwnershipInput;
import com.example.backend.dtos.ImmobilierInput;

import java.math.BigInteger;

public interface ImmobillierContractService2 {
   public void addNewAdmin(String _newAdmin);
   public  void addNewSuperAdmin(String _newSuperAdmin);
   public void addNewUser(String _newUser) throws Exception;
   public  void approveChangeOwnership(BigInteger immoId);
   public  void approveImmobilier(BigInteger immoId) throws Exception;
   public  void approveUsers(String _newUser) throws Exception;
   public  void changeOwnership(ChangeOwnershipInput changeOwnershipInput) throws Exception;
   public  void changePrice(BigInteger immoId, BigInteger _newPrice);
   //public  void changeCategory(BigInteger _immoId, String _newCategory);
   public  void createImmobilier(ImmobilierInput immobilierInput ) throws Exception;
   public void creatorAdmin();
   public void getImmobilierDetails(BigInteger immoId) throws Exception;
   public void immoOwnerChange(BigInteger param0);
}
