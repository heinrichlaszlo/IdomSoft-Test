package com.example.demo.dto;

import lombok.Data;

@Data
public class ISmenetlevelRequest {
    private Long sorszam;
    private String honnan;
    private String hova;
    private String gepjarmuVezetoNeve;
    private Integer km;
    private String datumKezdo;

    private Long aid_id;
}
