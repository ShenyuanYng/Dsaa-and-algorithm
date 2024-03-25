import java.util.Scanner;

public class q2_2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int j = 0;
            while ((1 - Math.pow(K, j)) / (1 - K) > N || (1 - Math.pow(K, j + 1)) / (1 - K) <= N) {
                j++;
            }

            int count = (int) (N - (1 - Math.pow(K, j)) / (1 - K));
            int k = 0;
            while (k * K >= count || (k + 1) * K < count) {
                k++;
            }

            count = (int) (count + Math.pow(K, j - 1) - k - 1);


            System.out.println(count);
        }

    }
}

