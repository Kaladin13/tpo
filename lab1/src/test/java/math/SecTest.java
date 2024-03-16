package math;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SecTest {
    @ParameterizedTest(name = "Basic test")
    @CsvFileSource(resources = "secTest.csv")
    void secBasicFunctionality(double input, double expectedValue) {
        assertEquals(expectedValue, SecCalculation.sec(input), Math.pow(input, SecCalculation.getErrorMargin()));
    }

    @ParameterizedTest(name = "Sec nan test")
    @ValueSource(doubles = {Double.NaN})
    void exceptionTest(double value) {
        assertEquals(value, SecCalculation.sec(value));
    }
}
