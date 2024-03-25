import java.util.Scanner;
public class q2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] counts = new int[1001];
      int num;
        do {
             num =input.nextInt();
            if (num >= 1 && num <= 1000) {
                counts[num - 1]++;
            }
        } while (num != 0);
        for (int i=0;i<1001;i++){
            if (counts[i]!=0){
                int x=i+1;
                System.out.println( x+ " " + counts[i]);
            }
        }
    }
}
