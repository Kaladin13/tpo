package org.example.functions.trigonometry;

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

public class TrigonomentryMocksFactory {

    private static List<List<Double>> readCsvArgs(String fileName) {
        Path filePath = Path.of(Objects.requireNonNull(TrigonomentryMocksFactory.class.getResource(fileName)).getPath());

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

    public static Sin getSinMock() {
        Sin sin = mock(Sin.class);
        var argsList = readCsvArgs("sinTest.csv");

        when(sin.getAccuracy()).thenReturn(0.000000001);

        for (var args : argsList) {
            when(sin.compute(args.get(0) * Math.PI / args.get(1))).thenReturn(args.get(2));
        }

        return sin;
    }

    public static Cosecant getCosecantMock() {
        Cosecant cosecant = mock(Cosecant.class);
        var argsList = readCsvArgs("cosecantTest.csv");

        when(cosecant.getAccuracy()).thenReturn(0.000000001);

        for (var args : argsList) {
            when(cosecant.compute(args.get(0) * Math.PI / args.get(1))).thenReturn(args.get(2));
        }

        return cosecant;
    }
}
