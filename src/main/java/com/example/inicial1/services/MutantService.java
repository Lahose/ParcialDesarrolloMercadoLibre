package com.example.inicial1.services;

import com.example.inicial1.entities.Mutant;
import com.example.inicial1.repositories.MutantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MutantService {

    private static final int SEQUENCE_LENGTH = 4;

    @Autowired
    private MutantRepository mutantRepository;

    public boolean analyzeDna(String[] dna) {
        //Convertimos el ADN a una cadena con comas
        String dnaSequence = String.join(",", dna);

        //Vemos si existe en nuestra Base de Datos
        Optional<Mutant> existingDna = mutantRepository.findByDna(dnaSequence);
        if (existingDna.isPresent()) {
            return existingDna.get().isMutant();
        }

        boolean isMutant = isMutant(dna);

        Mutant dnaEntity = Mutant.builder()
                .dna(dnaSequence)
                .isMutant(isMutant)
                .build();
        mutantRepository.save(dnaEntity);

        return isMutant;
    }

    public static boolean isMutant(String[] dna) {
        int n = dna.length;
        int sequenceCount = 0;

        sequenceCount += checkRows(dna, n);
        if (sequenceCount > 1) return true;

        sequenceCount += checkColumns(dna, n);
        if (sequenceCount > 1) return true;

        sequenceCount += checkDiagonals(dna, n);
        return sequenceCount > 1;

    }

    //Verificación por filas
    public static int checkRows(String[] dna, int n) {
        int sequenceCount = 0;
        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = 1; j < n; j++) {
                if (dna[i].charAt(j) == dna[i].charAt(j - 1)) {
                    count++;
                    if (count == SEQUENCE_LENGTH) {
                        sequenceCount++;
                        if (sequenceCount > 1) return sequenceCount;
                        count = 1;
                    }
                } else {
                    count = 1;
                }
            }
        }
        return sequenceCount;
    }

    //Verificación por Columnas
    public static int checkColumns(String[] dna, int n) {
        int sequenceCount = 0;
        for (int j = 0; j < n; j++) {
            int count = 1;
            for (int i = 1; i < n; i++) {
                if (dna[i].charAt(j) == dna[i - 1].charAt(j)) {
                    count++;
                    if (count == SEQUENCE_LENGTH) {
                        sequenceCount++;
                        if (sequenceCount > 1) return sequenceCount;
                    }
                } else {
                    count = 1;
                }
            }
        }
        return sequenceCount;
    }

    //Verificación por diagonales
    public static int checkDiagonals(String[] dna, int n) {
        int sequenceCount = 0;

        for (int i = 0; i <= n - SEQUENCE_LENGTH; i++) {
            for (int j = 0; j <= n - SEQUENCE_LENGTH; j++) {
                if (checkDiagonal(dna, i, j, 1, 1, n)) {
                    sequenceCount++;
                    if (sequenceCount > 1) return sequenceCount;
                }
            }
        }

        //Diagonal de derecha a izquierda
        for (int i = 0; i <= n - SEQUENCE_LENGTH; i++) {
            for (int j = SEQUENCE_LENGTH - 1; j < n; j++) {
                if (checkDiagonal(dna, i, j, 1, -1, n)) {
                    sequenceCount++;
                    if (sequenceCount > 1) return sequenceCount;
                }
            }
        }

        return sequenceCount;
    }

    public static boolean checkDiagonal(String[] dna, int x, int y, int dx, int dy, int n) {
        char first = dna[x].charAt(y);
        for (int i = 1; i < SEQUENCE_LENGTH; i++) {
            int newX = x + i * dx;
            int newY = y + i * dy;
            if (newX >= n || newY >= n || newY < 0 || dna[newX].charAt(newY) != first) {
                return false;
            }
        }
        return true;
    }
}