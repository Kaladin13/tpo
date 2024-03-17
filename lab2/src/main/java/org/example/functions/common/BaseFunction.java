package org.example.functions.common;

abstract public class BaseFunction {
    protected final double accuracy;
    protected final String functionName;

    public BaseFunction(double accuracy, String functionName) {
        this.accuracy = accuracy;
        this.functionName = functionName;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public String getFunctionName() {
        return functionName;
    }

    public abstract double compute(double arg);
}
