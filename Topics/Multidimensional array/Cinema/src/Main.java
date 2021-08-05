import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int rows = input.nextInt();
        int seats = input.nextInt();

        int[][] cinema = new int[rows][seats];

        for (int a = 0; a < rows; a++) {
            for (int b = 0; b < seats; b++) {
                cinema[a][b] = input.nextInt();
            }
        }

        int order = input.nextInt();
        int counter = 0;
        int row = 0;

        for (int c = 0; c < rows; c++) {
            for (int d = 0; d < seats; d++) {
                if (cinema[c][d] == 0) {
                    counter++;
                    if (counter == order) {
                        row = c + 1;
                        break;
                    }
                }

                if (cinema[c][d] == 1) {
                    counter = 0;
                }
            }

            if (counter == order) {
                break;
            }
            counter = 0;
        }

        System.out.println(row);
    }
}