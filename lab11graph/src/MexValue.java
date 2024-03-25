import java.util.Scanner;

public class MexValue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int mexValue = calculateMex(a, b);
            System.out.println(mexValue);
        }
    }

    private static int calculateMex(int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);

        if (min == 0) {
            if (max % 2 == 0) {
                return max + 1;
            } else {
                return max;
            }
        } else {
            if ((min - 1) % 2 == 0) {
                if (max % 2 == 0) {
                    return max;
                } else {
                    return max - 1;
                }
            } else {
                if (max % 2 == 0) {
                    return max - 1;
                } else {
                    return max;
                }
            }
        }
    }
}
