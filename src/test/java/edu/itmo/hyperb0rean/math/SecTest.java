package edu.itmo.hyperb0rean.math;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import edu.itmo.hyperb0rean.math.Sec;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SecTest {

    @ParameterizedTest(name = "sec({0})")
    @DisplayName("Check PI dots")
    @ValueSource(doubles = {-2 * Math.PI, -Math.PI, Math.PI, 2 * Math.PI})
    void checkPiDots(double param) {
        assertAll(
                () -> assertEquals(1.0 / Math.cos(param), Sec.calc(param, 10), 0.01)
        );
    }

    @ParameterizedTest(name = "sec({0}) = {1}")
    @DisplayName("Check between dots [-1; +1]")
    @CsvFileSource(resources = "/table_values_sec.csv", numLinesToSkip = 1, delimiter = ';')
    void checkBetweenDotsMinusOneAndOne(double x, double y) {
        assertAll(
                () -> assertEquals(y, Sec.calc(x, 10), 0.01)
        );
    }

    @ParameterizedTest(name = "sec({0})")
    @DisplayName("Check undefined values")
    @ValueSource(doubles = {-Math.PI / 2, Math.PI / 2, 3 * Math.PI / 2, 5 * Math.PI / 2})
    void checkUndefinedValues(double param) {
        assertThrows(ArithmeticException.class, () -> Sec.calc(param, 10));
    }
}