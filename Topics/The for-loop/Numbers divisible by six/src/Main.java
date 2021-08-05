import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] numbers = new int[length];
        int result = 0;
        for (int i = 0; i < length; i++) {
            numbers[i] = scanner.nextInt();
            if (numbers[i] % 6 == 0) {
                result += numbers[i];
            }
        }
        System.out.println(result);
    }
}