package edu.itmo.hyperb0rean.lab2.function;

import static java.math.BigDecimal.ONE;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.util.stream.Stream;

import edu.itmo.hyperb0rean.lab2.trigonometry.*;
import edu.itmo.hyperb0rean.lab2.logarithm.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SeriesTest {

    private static final BigDecimal DEFAULT_PRECISION = new BigDecimal("0.000001");

    @ParameterizedTest
    @MethodSource("functions")
    void shouldNotAcceptNullArgument(final Series function) {
        assertThrows(NullPointerException.class, () -> function.calculate(null, DEFAULT_PRECISION));
    }

    @ParameterizedTest
    @MethodSource("functions")
    void shouldNotAcceptNullPrecision(final Series function) {
        assertThrows(NullPointerException.class, () -> function.calculate(ONE, null));
    }

    private static Stream<Arguments> functions() {
        return Stream.of(
                Arguments.of(new Sin()),
                Arguments.of(new Cos()),
                Arguments.of(new Tan()),
                Arguments.of(new Ln()),
                Arguments.of(new Log(2)),
                Arguments.of(new Log(3)),
                Arguments.of(new Log(10)));
    }
}