import java.util.Scanner;

public class q2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int x = input.nextInt();
        int array[] = new int[n];
        int low = 0;
        int up = 0;
        for (int i = 0; i < n; i++) {
            array[i] = input.nextInt();
        }
        if (n == 1) {
            if (array[0] > x) {
                System.out.print(0 + " " + 0);
            }
            if (array[0] < x) {
                System.out.print(1+ " " + 1);
            }
            if (array[0]==x){
                System.out.print(0+" "+1);
            }
        }
        if (n >= 2) {
            if (array[n - 1] > x && x > array[0]) {
                for (int i = 0; i < n; i++) {
                    if (array[i] >= x) {
                        low = i;
                        break;
                    }
                }
                for (int i = 0; i < n; i++) {
                    if (array[i] > x) {
                        up = i;
                        break;
                    }
                }
                System.out.print(low + " " + up);
            }

            if (array[0] > x) {
                System.out.print(0 + " " + 0);
            }

            if (array[0] == x) {
                for (int i = 0; i < n; i++) {
                    if (array[i] > x) {
                        up = i;
                        break;
                    }
                    if (array[n-1]==x){
                        up=n;
                    }
                }
                System.out.print(0 + " " + up);
            }
            if (array[n - 1] == x) {
                if (array[0] != x) {
                    for (int i = 0; i < n; i++) {
                        if (array[i] >= x) {
                            low = i;
                            break;
                        }
                    }
                    System.out.print(low + " " + n);
                }
            }
            if (array[n - 1] < x) {
                System.out.print(n + " " + n);
            }
        }
    }
}
