package org.example.functions.logarithms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class LnTest {
    private Ln ln;

    @BeforeEach
    void setUp() {
        this.ln = new Ln(0.000001);
    }

    @ParameterizedTest()
    @CsvFileSource(resources = "lnTest.csv")
    void testBasic(double arg, double res) {
        assertEquals(res, this.ln.compute(arg), this.ln.getAccuracy());
    }
}