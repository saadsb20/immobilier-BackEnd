package com.example.backend.controller;

import com.example.backend.dtos.*;
import com.example.backend.entities.Immobillier;
import com.example.backend.services.ImmobillierContractService;
import org.aspectj.runtime.internal.Conversions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@RestController
public class ImmobillierController {

    @Autowired
    ImmobillierContractService immobillierContractService;

    @PostMapping("/addUser")
    public String addUser( @RequestBody() UserInput userInput) throws Exception {
        System.out.println("hhhhhhhhhhhh");
       return immobillierContractService.addNewUser(userInput.getUser());
    }
    @PostMapping("/approveUser")
    public String  approveUser(@RequestBody() UserInput userInput) throws Exception {
        return immobillierContractService.approveUsers(userInput.getUser());
    }
    @PostMapping("/addImmobillier")
    public Immobillier addImmobillier(@RequestBody() ImmobilierInput immobilierInput) throws Exception {
       return immobillierContractService.createProperty(immobilierInput);
    }

    @PostMapping("/approveImmobillier")
    public StatusImmobilier approveImmobillier(@RequestBody() ApproveImmoInput approveImmoInput) throws Exception {
       return immobillierContractService.approveProperty(approveImmoInput.getPropId());
    }
    @PostMapping("/changeOwnerShip")
    public String  changeOwnerShip( @RequestBody() ChangeOwnershipInput changeOwnershipInput) throws Exception {
       return immobillierContractService.changeOwnership(changeOwnershipInput);
    }
    @PostMapping("/approveChangeOwnerShip")
    public Immobillier approveChangeOwnerShip(  @RequestBody() ApproveImmoInput approveImmoInput) throws Exception {
        return immobillierContractService.approveChangeOwnership(approveImmoInput.getPropId());
    }

    @GetMapping("/immobillierDetails/{id}")
    public Immobillier immobillierDetails( @PathVariable String id) throws Exception {
        System.out.println("BigInteger id : " + id);
        return   immobillierContractService.getPropertyDetails(id);
    }

    @GetMapping("/immobiliers")
    public List<Immobillier> immobilliers() throws Exception {
        return   immobillierContractService.allImmobiliers();
    }
    @GetMapping("/myImmobiliers")
    public List<Immobillier> myImmobiliers() throws Exception {
        return   immobillierContractService.myImmobiliers();
    }
    @GetMapping("/sell_immobiliers")
    public List<Immobillier> forSellImmobilliers() throws Exception {
        return   immobillierContractService.forSellImmobiliers();
    }
    @GetMapping("/approvedImmobiliers")
    public List<Immobillier> approvedImmobiliers() throws Exception {
        return   immobillierContractService.approvedImmobiliers();
    }
    @GetMapping("/waitingImmobiliers")
    public List<Immobillier> waitingImmobiliers() throws Exception {
        return   immobillierContractService.waitingImmobiliers();
    }
    @GetMapping("/waitingChangeImmobiliers")
    public List<Immobillier> waitingChangeImmobiliers() throws Exception {
        return   immobillierContractService.waitingChangeImmobiliers();
    }
}
