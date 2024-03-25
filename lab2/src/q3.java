import java.util.ArrayList;
import java.util.Scanner;

public class q3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int D = sc.nextInt();
        int N = sc.nextInt();
        int M = sc.nextInt();

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < N; i++) arrayList.add(sc.nextInt());

        int start = 0;
        int end = D;
        int m;
        if (N == 0) {
            m = D;
        } else {
            while (true) {
                m = (start + end)/2;
                if (end - start <= 1) break;
                if (check(arrayList, m, N-M, D)) {
                    start = m;
                } else {
                    end = m;
                }
            }
        }
        System.out.println(m);
    }

    public static boolean check(ArrayList<Integer> arrayList, int middle, int points, int D) {
        int count = 0;
        int initial = 0;
        for (Integer integer : arrayList) {
            if (count == points) {
                return true;
            } else {
                if (integer - initial >= middle) {
                    initial = integer;
                    if (D-initial < middle) return false;
                    count++;
                }
            }
        }
        return count == points;
    }
}