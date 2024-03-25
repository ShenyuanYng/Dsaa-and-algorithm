import java.util.PriorityQueue;
import java.util.Scanner;

public class q5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        PriorityQueue<Integer> P=new PriorityQueue<>();
        for (int i = 0; i <number ; i++) {
            P.add(input.nextInt());
        }
        int array[]=new int[number];
        int i=0;
        //创建一个优先队列，然后把输入的值放进去，然后先亮亮合并，合并后的值放进去，然后再亮亮合并，直到只剩下一个值
        while (P.size()>1){
            int a=P.poll();
            int b=P.poll();
            int c=a+b;
            array[i]=c;
            P.add(c);
            i++;
        }
        int count=0;
        for (int j = 0; j <number ; j++) {
            count=count+array[j];
        }
        System.out.println(count);
    }
}

