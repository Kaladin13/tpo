package org.example.logging;

import org.example.functions.common.BaseFunction;

public class ModuleLogger {
    private final FunctionLogger functionLogger;

    public ModuleLogger(FunctionLogger functionLogger) {
        this.functionLogger = functionLogger;
    }

    public void logModule(BaseFunction module, double start, double end, double step) {
        for (double i = start; i <= end; i += step) {
            this.functionLogger.logFunction(module.getFunctionName(), i, module.compute(i));
        }
        this.functionLogger.endLogging(module.getFunctionName());
    }
}
