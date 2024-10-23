package com.example.inicial1.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MutantServiceTest {

    @Test
    public void testRows(){
        String[] dna = {
                "AAAATG",
                "TGCAGT",
                "GCTTCC",
                "CCCCTG",
                "GTAGTC",
                "AGTCAC"
        };
        assertTrue(MutantService.isMutant(dna));
    }

    @Test
    public void testColums(){
        String[] dna = {
                "AGAATG",
                "TGCAGT",
                "GCTTCC",
                "GTCCTC",
                "GTAGTC",
                "GGTCAC"
        };
        assertTrue(MutantService.isMutant(dna));
    }

    @Test
    public void testMainDiagonals(){
        String[] dna = {
                "AGAATG",
                "TACAGT",
                "GCAGCC",
                "TTGATG",
                "GTAGTC",
                "AGTCAA"
        };
        assertTrue(MutantService.isMutant(dna));
    }

    @Test
    public void testSecondaryLeftDiagonals(){
        String[] dna = {
                "ATAATG",
                "GTTAGT",
                "GGCTCG",
                "TTGATG",
                "GTAGTC",
                "AGTCAA"
        };
        assertTrue(MutantService.isMutant(dna));
    }

    @Test
    public void testSecondaryRightDiagonals(){
        String[] dna = {
                "ATAATG",
                "GTATGA",
                "GCTTAG",
                "TTTAGG",
                "GTAGTC",
                "AGTCAA"
        };
        assertTrue(MutantService.isMutant(dna));
    }

    @Test
    public void testTertiaryLeftDiagonals(){
        String[] dna = {
                "ATGATG",
                "GTAGTA",
                "CCTTGG",
                "TCTAGG",
                "GGCGTC",
                "AGTCAA"
        };
        assertTrue(MutantService.isMutant(dna));
    }

    @Test
    public void testTertiaryRightDiagonals(){
        String[] dna = {
                "ATGATG",
                "GTATTA",
                "AATTGG",
                "ACTAGT",
                "GGAGTC",
                "AGGCAA"
        };
        assertTrue(MutantService.isMutant(dna));
    }

    @Test
    public void testNonMutant(){
        String[] dna = {
                "ATGCGA",
                "CAGTGC",
                "TTATTT",
                "AGACGG",
                "GCGTCA",
                "TCACTG"

        };
        assertFalse(MutantService.isMutant(dna));
    }

    @Test
    public void testNonMutant2(){
        String[] dna = {
                "AAAT",
                "AACC",
                "AAAC",
                "CGGG"
        };
        assertFalse(MutantService.isMutant(dna));
    }

    @Test
    public void testMutant1() {
        String[] dna = {
                "AAAA",
                "CCCC",
                "TCAG",
                "GGTC"
        };
        assertTrue(MutantService.isMutant(dna));
    }

    @Test
    public void testMutant2(){
        String[] dna = {
                "TGAC",
                "AGCC",
                "TGAC",
                "GGTC"
        };
        assertTrue(MutantService.isMutant(dna));
    }



}
