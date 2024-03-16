package org.example.functions.logarithms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class LogFromArgTest {
    private Ln ln;

    @BeforeEach
    void setUp() {
        this.ln = LogarithmsMocksFactory.getLnMock();
    }

    @ParameterizedTest()
    @CsvFileSource(resources = "logArgTest.csv")
    void testBase(double base, double arg, double res) {
        LogFromArg log = new LogFromArg(0.00001, base, this.ln);

        assertEquals(res, log.compute(arg), log.getAccuracy());
    }
}