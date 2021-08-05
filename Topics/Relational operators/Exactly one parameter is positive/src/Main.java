import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = new int[3];
        numbers[0] = scanner.nextInt();
        numbers[1] = scanner.nextInt();
        numbers[2] = scanner.nextInt();
        int sum = 0;
        for (int number: numbers) {
            if (number > 0) {
                sum++;
            }
        }

        System.out.println(sum == 1);
    }
}