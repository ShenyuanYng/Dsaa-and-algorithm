import java.util.PriorityQueue;
import java.util.Scanner;


public class q3 {

    private static final PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> b - a); // 左半部分，越大越有限
    private static final PriorityQueue<Integer> right = new PriorityQueue<>(); // 右半部分越小越有优先
    private static long leftSum = 0; // 左边求和。
    private static long rightSum = 0; // 右边求和。

    public static void addNum(int num) {
        if (left.isEmpty() || num <= left.peek()) {
            left.offer(num);
            leftSum += num;
            if (left.size() > right.size() + 1) {
                int val = left.peek();
                right.offer(left.poll());
                leftSum -= val;
                rightSum += val;
            }
        } else {
            right.offer(num);
            rightSum += num;
            if (right.size() > left.size()) {
                int val = right.peek();
                left.offer(right.poll());
                rightSum -= val;
                leftSum += val;
            }
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);//输入总数
        int n = scanner.nextInt();
        long countB = 0;//记录所有b的和，注：1e9 * 1e6会爆int，所以要用long。

        for (int i = 0; i < n; i++) {
            int type = scanner.nextInt();//输入类型
            if (type == 1) {//新函数，要加入新结点
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                countB += b;
                addNum(a);
            } else { //打印
                long x;
                if (right.size() <= left.size()) x = left.peek();
                else x = right.peek();
                long ans = countB;
                ans += (left.size() * x - leftSum) + (rightSum - right.size() * x);
                System.out.println(x + " " + ans);
            }
        }
    }
}
