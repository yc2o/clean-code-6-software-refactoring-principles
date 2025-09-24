public class MathCalculator {

    public double squareRoot(double number) {
        if (number < 0) {
            throw new IllegalArgumentException("Input for square root must be non-negative.");
        }
        double result = Math.sqrt(number);
        // Postcondition: result >= 0
        return result;
    }

    public double divide(double dividend, double divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Divisor must not be zero.");
        }
        double result = dividend / divisor;
        // Postcondition: result * divisor == dividend (kecuali pembulatan floating point)
        return result;
    }
}