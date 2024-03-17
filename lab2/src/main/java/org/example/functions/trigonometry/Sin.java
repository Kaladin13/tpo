package org.example.functions.trigonometry;

import org.example.functions.common.BaseFunction;

public class Sin extends BaseFunction {
    public Sin(double accuracy) {
        super(accuracy, "sin");
    }

    @Override
    public double compute(double arg) {
        int step = 1;
        int factorial = 1;
        int sign = -1;
        double argPow = arg;
        double sum = arg;

        while (getAccuracy() < (Math.abs(argPow) / factorial)) {
            step += 2;
            factorial *= step * (step - 1);
            argPow *= arg * arg;

            sum = sum + (sign * argPow / factorial);
            sign *= -1;
        }

        return sum;
    }
}
