import java.math.BigInteger;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger a = null;
        BigInteger b = null;
        BigInteger c = null;
        BigInteger d = null;

        try {
            a = scanner.nextBigInteger();
            b = scanner.nextBigInteger();
            c = scanner.nextBigInteger();
            d = scanner.nextBigInteger();
        } catch (Exception e) {
            System.out.println("Wrong data!");
        }

        System.out.println(a.negate().multiply(b).add(c).subtract(d));
    }
}