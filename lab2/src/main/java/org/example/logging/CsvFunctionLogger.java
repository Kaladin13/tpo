package org.example.logging;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CsvFunctionLogger implements FunctionLogger {
    private final Map<String, CSVWriter> csvWriterMap;

    public CsvFunctionLogger() {
        this.csvWriterMap = new HashMap<>();
    }

    private CSVWriter getCsvWriter(String filename) {
        if (csvWriterMap.containsKey(filename)) {
            return csvWriterMap.get(filename);
        }

        URL resourseUrl = getClass().getResource(filename);

        if (resourseUrl == null) {
            try {
                File file = new File(Objects
                        .requireNonNull(getClass()
                                .getResource("/")).getPath().concat(filename));

                file.createNewFile();
            } catch (Exception e) {
                System.out.println("Error with creating file");
                return null;
            }
        }

        try {
            FileWriter output = new FileWriter(filename, false);
            CSVWriter writer = new CSVWriter(output, ',',
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);

            this.csvWriterMap.put(filename, writer);
            return writer;
        } catch (Exception e) {
            System.out.println("Error with writing to file");
            return null;
        }
    }

    @Override
    public void logFunction(String functionName, double arg, double res) {
        var writer = this.getCsvWriter(functionName.concat(".csv"));

        if (writer == null) {
            return;
        }

        writer.writeNext(new String[]{Double.toString(arg), Double.toString(res)});
    }

    @Override
    public void endLogging(String functionName) {
        var writer = this.getCsvWriter(functionName.concat(".csv"));

        if (writer == null) {
            return;
        }

        try {
            writer.close();
        } catch (IOException e) {
            System.out.println("Could not close stream");
        }
    }
}
