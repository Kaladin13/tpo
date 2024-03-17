package org.example.functions.logarithms;

import com.opencsv.CSVReader;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LogarithmsMocksFactory {
    private static List<List<Double>> readCsvArgs(String fileName) {
        Path filePath = Path.of(Objects.requireNonNull(LogarithmsMocksFactory.class.getResource(fileName)).getPath());

        try {
            Reader reader = Files.newBufferedReader(filePath);
            try (CSVReader csvReader = new CSVReader(reader)) {
                var res = csvReader.readAll();
                res.remove(0);
                return res.stream()
                        .map(v -> Arrays.stream(v).map(Double::parseDouble)
                                .collect(Collectors.toList()))
                        .collect(Collectors.toList());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Ln getLnMock() {
        Ln ln = mock(Ln.class);
        var argsList = readCsvArgs("lnTest.csv");

        when(ln.getAccuracy()).thenReturn(0.000000001);

        for (var args : argsList) {
            when(ln.compute(args.get(0))).thenReturn(args.get(1));
        }

        return ln;
    }
}
