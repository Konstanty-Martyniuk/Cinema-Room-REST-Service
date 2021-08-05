import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        long result = 1;
        for (int i = num1; i < num2; i++) {
            result *= i;
        }
        System.out.println(result);
    }
}