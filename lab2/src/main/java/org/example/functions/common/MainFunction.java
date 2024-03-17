package org.example.functions.common;

import org.example.functions.logarithms.LogFromArg;
import org.example.functions.trigonometry.Cosecant;

public class MainFunction extends BaseFunction {
    private final Cosecant cosecant;
    private final LogFromArg log2;
    private final LogFromArg log3;
    private final LogFromArg log10;

    public MainFunction(double accuracy, Cosecant cosecant,
                        LogFromArg log3, LogFromArg log10, LogFromArg log2) {
        super(accuracy, "main_res");

        this.cosecant = cosecant;
        this.log2 = log2;
        this.log3 = log3;
        this.log10 = log10;
    }

    private double computePositive(double arg) {
        var log3Res = this.log3.compute(arg);
        var log2Res = this.log2.compute(arg);
        var log10Res = this.log10.compute(arg);

        var divResult = log3Res / log10Res + log3Res;

        return divResult / log2Res - log3Res + log3Res;
    }

    private double computeNegative(double arg) {
        return Math.pow(this.cosecant.compute(arg), 2);
    }

    @Override
    public double compute(double arg) {
        return arg <= 0 ? this.computeNegative(arg) : this.computePositive(arg);
    }
}
