
import java.util.Scanner;

public class q2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        for (int i = 0; i < number; i++) {
            int  n = input.nextInt();//节点数
            int  k = input.nextInt();//子节点数
            int h= (int) Math.ceil(Math.log(n+1)/Math.log(k)); //树的高度
            //根节点的下标为1，最后一层之前的节点数
            int num = (int) (Math.pow(k, h) - 1) / (k - 1);
            //最后两层之前的节点数
            int num2 = (int) (Math.pow(k, h-1) - 1) / (k - 1);
            //用用节点数求最后一层的节点数
            int last = n - num;
            int count = (int) (n-num2-Math.ceil((double) last /(double) k));
            System.out.println(count);
        }
        }
}
