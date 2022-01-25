package com.example.backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImmobilierInput {
    private String privateKey;
    private  String localisation;
    private  String category;
    private  String owner;
    private int _price;
    private String _ownerAddress;
    private boolean forSell;
    private  String description;
}
