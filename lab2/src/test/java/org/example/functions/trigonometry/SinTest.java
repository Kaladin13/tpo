package org.example.functions.trigonometry;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class SinTest {
    private Sin sin;

    @BeforeEach
    void setUp() {
        this.sin = new Sin(0.000001);
    }

    @ParameterizedTest()
    @CsvFileSource(resources = "sinTest.csv")
    void testTableValues(double piArg, double piDivision, double res) {
        assertEquals(res, sin.compute(piArg * Math.PI / piDivision), sin.getAccuracy());
    }
}