import java.math.BigInteger;

class DoubleFactorial {
    public static BigInteger calcDoubleFactorial(int n) {
        if (n == 0 || n == 1) {
            return BigInteger.ONE;
        }
        int number = n;
        BigInteger result = BigInteger.valueOf(1);
        while (number > 1) {
            result = result.multiply(BigInteger.valueOf(number));
            number -= 2;
        }
        return result;
    }
}