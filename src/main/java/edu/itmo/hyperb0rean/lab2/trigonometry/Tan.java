package edu.itmo.hyperb0rean.lab2.trigonometry;

import edu.itmo.hyperb0rean.lab2.function.LimitedSeries;

import static java.lang.String.format;
import static java.math.BigDecimal.ZERO;
import static java.math.MathContext.DECIMAL128;
import static java.math.RoundingMode.HALF_EVEN;

import java.math.BigDecimal;

public class Tan extends LimitedSeries {

    private final Sin sin;
    private final Cos cos;

    public Tan(final Sin sin, final Cos cos) {
        super();
        this.sin = sin;
        this.cos = cos;
    }

    public Tan() {
        super();
        this.sin = new Sin();
        this.cos = new Cos();
    }

    @Override
    public BigDecimal calculate(final BigDecimal x, final BigDecimal precision)
            throws ArithmeticException {
        checkValidity(x, precision);

        final BigDecimal sinValue = sin.calculate(x, precision);
        final BigDecimal cosValue = cos.calculate(x, precision);

        if (cosValue.compareTo(ZERO) == 0) {
            throw new ArithmeticException(format("Function value for argument %s doesn't exist", x));
        }

        final BigDecimal result = sinValue.divide(cosValue, DECIMAL128.getPrecision(), HALF_EVEN);
        return result.setScale(precision.scale(), HALF_EVEN);
    }
}