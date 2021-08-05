import java.math.BigInteger;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger number = scanner.nextBigInteger();

        int result = 1;
        BigInteger tempNumber = BigInteger.ONE;

        while (tempNumber.compareTo(number) < 0) {
            tempNumber = tempNumber.multiply(BigInteger.valueOf(++result));
        }
        System.out.println(result);
    }
}