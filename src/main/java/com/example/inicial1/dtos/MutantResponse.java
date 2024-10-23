package com.example.inicial1.dtos;

import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
public class MutantResponse {
    private boolean isMutant;
    public boolean isMutant() {
        return isMutant;
    }
}
