import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Interval {
    int left;
    int right;

    public Interval(int left, int right) {
        this.left = left;
        this.right = right;
    }
}

public class practice{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Interval[] intervals = new Interval[n];

        for (int i = 0; i < n; i++) {
            int left = scanner.nextInt();
            int right = scanner.nextInt();
            intervals[i] = new Interval(left, right);
        }

        // 排序区间，按右端点升序排序
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval.right));

        int count = 0;
        int currentPoint = intervals[0].right;
        count++;

        for (int i = 1; i < n; i++) {
            if (intervals[i].left > currentPoint) {
                // 如果下一个区间的左端点大于当前点，则需要另一个点来覆盖它
                currentPoint = intervals[i].right;
                count++;
            }
        }

        System.out.println(count);
    }
}
