package com.example.backend.dtos;

import lombok.Data;

import java.math.BigInteger;

@Data
public class ChangeOwnershipInput {
    private String privateKey;
    private String _propId;
    private String _newOwner;
}
