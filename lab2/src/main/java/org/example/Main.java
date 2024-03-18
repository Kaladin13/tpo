package org.example;

import org.example.functions.common.MainFunction;
import org.example.functions.logarithms.Ln;
import org.example.functions.logarithms.LogFromArg;
import org.example.functions.trigonometry.Cosecant;
import org.example.functions.trigonometry.Sin;
import org.example.logging.ConsoleFunctionLogger;
import org.example.logging.CsvFunctionLogger;
import org.example.logging.FunctionLogger;
import org.example.logging.ModuleLogger;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        final double ACCURACY = 0.00001;
        Sin sin = new Sin(ACCURACY);

        Cosecant cosecant = new Cosecant(ACCURACY, sin);

        Ln ln = new Ln(ACCURACY);

        LogFromArg log2 = new LogFromArg(ACCURACY, 2, ln);
        LogFromArg log3 = new LogFromArg(ACCURACY, 3, ln);
        LogFromArg log10 = new LogFromArg(ACCURACY, 10, ln);

        MainFunction mainFunction = new MainFunction(ACCURACY, cosecant, log3, log10, log2);

        FunctionLogger logger;

        if (Objects.equals(args[0], "console")) {
            logger = new ConsoleFunctionLogger();
        } else {
            logger = new CsvFunctionLogger();
        }

        ModuleLogger moduleLogger = new ModuleLogger(logger);

        moduleLogger.logModule(mainFunction, -Math.PI, Math.PI, Math.PI / 4);
        moduleLogger.logModule(cosecant, -Math.PI, Math.PI, Math.PI / 4);
        moduleLogger.logModule(ln, 1, 32, 1);

    }
}