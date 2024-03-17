package org.example.logging;

public class ConsoleFunctionLogger implements FunctionLogger {
    @Override
    public void logFunction(String functionName, double arg, double res) {
        System.out.printf("x = %f, %s(x) = %f%n", arg, functionName, res);
    }

    @Override
    public void endLogging(String functionName) {
    }
}
