import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;

        int numbers = scanner.nextInt();
        for (int i = 0; i < numbers; i++) {
            int temp = scanner.nextInt();
            if (temp == 5) {
                a++;
            } else if (temp == 4) {
                b++;
            } else if (temp == 3) {
                c++;
            } else {
                d++;
            }
        }

        System.out.println(d + " " + c + " " + b + " " + a);
    }
}