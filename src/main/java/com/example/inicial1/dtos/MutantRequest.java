package com.example.inicial1.dtos;


import com.example.inicial1.validators.ValidDna;
import lombok.*;


@Setter
@Getter
public class MutantRequest {
    @ValidDna
    private String[] dna;
}
