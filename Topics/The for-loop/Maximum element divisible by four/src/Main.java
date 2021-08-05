import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int result = Integer.MIN_VALUE;
        while(scanner.hasNext()) {
            int temp = scanner.nextInt();
            if (temp % 4 == 0 && temp > result) result = temp;
        }
        System.out.println(result);
    }
}
