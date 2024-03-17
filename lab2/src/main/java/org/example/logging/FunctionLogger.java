package org.example.logging;

public interface FunctionLogger {

    void logFunction(String functionName, double arg, double res);
    void endLogging(String functionName);
}
