package org.example.functions.common;

import org.example.functions.logarithms.Ln;
import org.example.functions.logarithms.LogFromArg;
import org.example.functions.trigonometry.Cosecant;
import org.example.functions.trigonometry.Sin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class MainFunctionTest {
    private Sin sin;

    private Cosecant cosecant;
    private Ln ln;

    private LogFromArg log2;
    private LogFromArg log3;
    private LogFromArg log10;

    private MainFunction mainFunction;

    @BeforeEach
    void setUp() {
        double ACCURACY = 0.00001;
        sin = new Sin(ACCURACY);
        cosecant = new Cosecant(ACCURACY, sin);

        ln = new Ln(ACCURACY);
        log2 = new LogFromArg(ACCURACY, 2, ln);
        log3 = new LogFromArg(ACCURACY, 3, ln);
        log10 = new LogFromArg(ACCURACY, 10, ln);

        mainFunction = new MainFunction(ACCURACY, cosecant, log3, log10, log2);
    }

    @ParameterizedTest()
    @CsvFileSource(resources = "mainTest.csv")
    void testBasic(double arg, double res) {
        assertEquals(res, mainFunction.compute(arg), mainFunction.getAccuracy());
    }
}