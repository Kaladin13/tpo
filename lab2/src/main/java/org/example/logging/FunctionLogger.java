package org.example.logging;

@FunctionalInterface
public interface FunctionLogger {

    void logFunction(String functionName, double arg, double res);
}
