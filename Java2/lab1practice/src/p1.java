import java.util.Scanner;

public class p1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long num = in.nextLong();
        System.out.println(countzero(num));
    }

    public static int countzero(long num) {
        int count = 0;
        for (int i = 0; i < 64; i++) {
            //与二进制的1进行按位与
            if ((num & 1) == 0) {
                count++;
            }

            num >>>= 1;//右移
        }
        return count;
    }
}
