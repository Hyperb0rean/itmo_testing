package edu.itmo.hyperb0rean.lab2.function;

import static java.math.BigDecimal.ZERO;
import static java.math.MathContext.DECIMAL128;
import static java.math.RoundingMode.HALF_EVEN;
import static java.math.RoundingMode.HALF_UP;

import ch.obermuhlner.math.big.BigDecimalMath;
import  edu.itmo.hyperb0rean.lab2.logarithm.Ln;
import edu.itmo.hyperb0rean.lab2.logarithm.Log;
import edu.itmo.hyperb0rean.lab2.trigonometry.Tan;

import java.math.BigDecimal;
import java.math.MathContext;

public class FunctionsSystem implements Series{

    private final Tan tan;
    private final Ln ln;
    private final Log log2;
    private final Log log3;
    private final Log log10;

    public FunctionsSystem() {
        this.tan = new Tan();
        this.ln = new Ln();
        this.log2 = new Log(2);
        this.log3 = new Log(3);
        this.log10 = new Log(10);
    }

    public BigDecimal calculate(final BigDecimal x, final BigDecimal precision) {
        final MathContext mc = new MathContext(DECIMAL128.getPrecision(), HALF_EVEN);
        final BigDecimal correctedX = x.remainder(BigDecimalMath.pi(mc).multiply(new BigDecimal(2)));
        if (x.compareTo(ZERO) <= 0) {
            return tan.calculate(correctedX, precision)
                    .setScale(precision.scale(), HALF_EVEN);
        } else {
            if (log3.calculate(correctedX, precision).equals(ZERO) || log2.calculate(correctedX, precision).equals(ZERO)) return null;
            return ln.calculate(correctedX,precision)
                    .divide(log2.calculate(correctedX,precision),HALF_UP)
                    .multiply(log2.calculate(correctedX,precision))
                    .pow(2)
                    .divide(log3.calculate(correctedX,precision),HALF_UP)
                    .add(log10.calculate(correctedX,precision));
        }
    }
}