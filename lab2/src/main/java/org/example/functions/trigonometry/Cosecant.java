package org.example.functions.trigonometry;

import org.example.functions.common.BaseFunction;

public class Cosecant extends BaseFunction {
    private final Sin sin;

    public Cosecant(double accuracy, Sin sin) {
        super(accuracy, "cosecant");
        this.sin = sin;
    }

    @Override
    public double compute(double arg) {
        double res = this.sin.compute(arg);

        if (Double.isNaN(res) || res == 0.0) {
            return Double.NaN;
        }

        return 1 / res;
    }
}
