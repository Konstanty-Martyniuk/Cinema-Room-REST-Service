import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();

        if (num1 % num3 == 0) {
            System.out.println(num2 / num3 - num1 / num3 + 1);
        } else {
            System.out.println(num2 / num3 - num1 / num3);
        }
    }
}