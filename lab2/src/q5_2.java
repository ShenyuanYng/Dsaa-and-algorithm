import java.util.Scanner;
//二分法
public class q5_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        int[] arr = new int[test];
        for (int i = 0; i < test; i++) {
            int m = sc.nextInt();
            int start = 0;
            int end = m;
            int middle;
            while (true) {
                middle = (start+end)/2;
                if (end - start <= 1) break;
                if (check(m, middle)) {
                    start = middle;
                } else {
                    end = middle;
                }
            }
            arr[i] = middle;
        }

        for (int e : arr) {
            System.out.println(e);
        }
    }

    public static boolean check(int m, int middle) {
        while (true) {
            if (middle == 0) return true;
            for (int i = 1; i < m; i++) {
                if (m >= (3 * i * i + i) / 2 && m < (3*(i+1)*(i+1)+i+1)/2) {
                    m -= (3 * i * i + i) / 2;
                    middle--;
                    break;
                }
            }
            if (middle == 0) return true;
            if (m <= 1) return false;
        }
    }
}
