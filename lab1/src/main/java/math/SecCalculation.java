package math;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class SecCalculation {
    private static final ArrayList<AbstractMap.SimpleEntry<Integer, Integer>> arguments = new ArrayList<>() {
        {
            add(new AbstractMap.SimpleEntry<>(1, 2));
            add(new AbstractMap.SimpleEntry<>(5, 24));
            add(new AbstractMap.SimpleEntry<>(61, 720));
            add(new AbstractMap.SimpleEntry<>(1385, 40320));
        }
    };

    public static int getErrorMargin() {
        return arguments.size() * 2 + 1;
    }

    public static double sec(double x) {
        AtomicInteger i = new AtomicInteger(1);

        return 1 + arguments.stream()
                .map(val -> val.getKey() * Math.pow(x, i.getAndIncrement() * 2) / val.getValue())
                .mapToDouble(Double::doubleValue)
                .sum();
    }
}
