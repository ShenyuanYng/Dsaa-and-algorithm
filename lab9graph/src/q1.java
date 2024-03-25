import java.util.Scanner;

public class q1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        int m=input.nextInt();
        int array[][]=new int[n][n];
        for (int i = 0; i <m ; i++) {
           int x=input.nextInt();
           int y=input.nextInt();
           array[x-1][y-1]=1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n ; j++) {
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }
}
