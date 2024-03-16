package org.example.functions.trigonometry;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class CosecantTest {
    private Cosecant cosecant;

    @BeforeEach
    void setUp() {
        this.cosecant = new Cosecant(0.0001, TrigonomentryMocksFactory.getSinMock());
    }

    @ParameterizedTest()
    @CsvFileSource(resources = "cosecantTest.csv")
    void testBasicMath(double piArg, double piDivision, double res) {
        assertEquals(res, this.cosecant.compute(piArg * Math.PI / piDivision), this.cosecant.getAccuracy());
    }
}