package org.example.functions.logarithms;

import org.example.functions.BaseFunction;

public class Ln extends BaseFunction {

    public Ln(double accuracy) {
        super(accuracy, "ln");
    }

    @Override
    public double compute(double arg) {
        if (Double.isNaN(arg) || arg <= 0.0) {
            return Double.NaN;
        }

        double currentValue = 0;
        double previousValue;
        int iteration = 1;

        if (Math.abs(arg - 1) <= 1) {
            do {
                previousValue = currentValue;
                currentValue += ((Math.pow(-1, iteration - 1) * Math.pow(arg - 1, iteration)) / iteration);
                iteration++;
            } while (getAccuracy() <= Math.abs(currentValue - previousValue));
        } else {
            do {
                previousValue = currentValue;
                currentValue += ((Math.pow(-1, iteration - 1) * Math.pow(arg - 1, -iteration)) / iteration);
                iteration++;
            } while (getAccuracy() <= Math.abs(currentValue - previousValue));

            currentValue += compute(arg - 1);
        }

        return currentValue;
    }
}
