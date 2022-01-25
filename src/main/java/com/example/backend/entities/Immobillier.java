package com.example.backend.entities;

import com.example.backend.dtos.StatusImmobilier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.util.Date;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Immobillier {
    @Id
    private String id ;
    private int price;
    private  String localisation;
    private  String category;
    private  String ownerName;
    private String ownerAddress;
    private boolean forSell;
    private  String description;
    private Date creation_date;
    private StatusImmobilier status;
}
