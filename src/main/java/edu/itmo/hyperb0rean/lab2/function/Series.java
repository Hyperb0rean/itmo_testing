package edu.itmo.hyperb0rean.lab2.function;
import java.math.BigDecimal;

public interface Series {

    BigDecimal calculate(final BigDecimal x, final BigDecimal precision);

}
