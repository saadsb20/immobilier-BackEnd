package com.example.backend.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResp {
    private Long id;
    private String username;
    private int actived;
    private String address;
}
