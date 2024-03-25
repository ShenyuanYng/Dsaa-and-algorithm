import java.util.PriorityQueue;
import java.util.Scanner;

public class q1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        PriorityQueue<Integer> P=new PriorityQueue<>();
        for (int i = 0; i <number ; i++) {
            int n=input.nextInt();
            if (n==1){
                P.add(input.nextInt());
            }
            else if (n==2){
                System.out.println(P.peek());
            }
            else {
                P.poll();
            }
        }
    }
}




