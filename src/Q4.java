import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number=input.nextInt();
        for (int k=0;k<number;k++) {
            int n = input.nextInt();
            if (n == 1) {
                int n1 = input.nextInt();
                System.out.println(0);
            }
            else {
                int array0[][] = new int[n][n];
                //duru

                for (int i = 0; i < n; i++) {
                    String str = input.next();
                    for (int j = 0; j < n; j++) {
                        array0[i][j] = str.charAt(j)-48;
                    }
                }
                //xuanzhuan90
                int array1[][] = new int[n][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        array1[i][j] = array0[j][n - i - 1];
                    }
                }

                //xuanzhuan180
                int array2[][] = new int[n][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        array2[i][j] = array1[j][n - i - 1];
                    }
                }

                //xuanzhuan270
                int array3[][] = new int[n][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        array3[i][j] = array2[j][n - i - 1];
                    }
                }
                int array4[][] = new int[n][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        array4[i][j] = array0[i][j]+array2[i][j]+array3[i][j]+array1[i][j];
                    }
                }

                int count=0;
                for (int i = 0; i <n ; i++) {
                    for (int j = 0; j < n; j++) {
                        if (array4[i][j]==1||array4[i][j]==3){
                            count++;
                        }
                        if (array4[i][j]==2){
                            count=count+2;
                        }
                    }
                }
                int y=count/4;
                System.out.println(y);
            }
        }
    }
}