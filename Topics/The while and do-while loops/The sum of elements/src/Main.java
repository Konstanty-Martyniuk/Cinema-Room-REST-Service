import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        boolean doLoop = true;

        while (doLoop) {
            int temp = scanner.nextInt();
            if (temp != 0) {
                sum += temp;
            } else {
                doLoop = false;
            }
        }
        System.out.println(sum);
    }
}