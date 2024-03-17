package org.example.functions.logarithms;

import org.example.functions.common.BaseFunction;

public class LogFromArg extends BaseFunction {
    private final double base;
    private final double lnBase;
    private final Ln ln;

    public LogFromArg(double accuracy, double base, Ln ln) {
        super(accuracy, String.format("log_%f", base));
        this.base = base;
        this.ln = ln;

        if (this.base == 1) {
            this.lnBase = Double.NaN;
        } else {
            this.lnBase = this.ln.compute(this.base);
        }
    }

    public double getBase() {
        return base;
    }

    @Override
    public double compute(double arg) {
        return this.ln.compute(arg) / this.lnBase;
    }
}
