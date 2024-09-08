package edu.itmo.hyperb0rean.math;

public class Sec {
    public static double calc(double x, int n) {

        while (x > 2 * Math.PI) {
            x -= 2 * Math.PI;
        }
        while (x < 0) {
            x += 2 * Math.PI;
        }

        double cosX = 0.0;
        double factorial = 1;
        for (int k = 0; k < n; k++) {
            cosX += (Math.pow(-1, k) * Math.pow(x, 2 * k)) / factorial;
            factorial *= (2 * k + 1) * (2 * k + 2);
        }

        if (Math.abs(cosX) < Math.exp(-n)) {
            throw new ArithmeticException("sec(x) is undefined for x where cos(x) is zero.");
        }

        return 1.0 / cosX;
    }
}