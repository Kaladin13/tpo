package org.example.functions.logarithms;

import org.example.functions.BaseFunction;

public class LogFromArg extends BaseFunction {
    public double getBase() {
        return base;
    }

    private final double base;
    private final double lnBase;
    private final Ln ln;

    public LogFromArg(double accuracy, double base, Ln ln) {
        super(accuracy, "log_from_arg");
        this.base = base;
        this.ln = ln;

        if (this.base == 1) {
            this.lnBase = Double.NaN;
        } else {
            this.lnBase = this.ln.compute(this.base);
        }
    }

    @Override
    public double compute(double arg) {
        return this.ln.compute(arg) / this.lnBase;
    }
}
