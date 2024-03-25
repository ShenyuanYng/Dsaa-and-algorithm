import java.util.Scanner;
public class q3_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int d=input.nextInt();
        int n=input.nextInt();
        int m=input.nextInt();
        int[] array =new int[n+2];
        array[0]=0;
        array[n+1]=d;
        for (int i = 1; i <n+1 ; i++) {
            array[i]=input.nextInt();
        }
        if (n==m){
            System.out.println(d);
        }
        else {
        int down = 0;
        int up = d;
        while (up-down>=1) {
            int number=0;
            int mid = (down + up) / 2+1;
            int[] array2=new int[1];
            for (int i = 1; i < n+2; i++) {
                int distance = 0;
                if (array2[0] == 0) {
                    distance = array[i];
                } else {
                    distance = array[i] - array2[0];
                }
                if (distance >= mid) {
                    array2[0] = array[i];
                } else {
                    number++;
                }
            }
            if (number<=m){
                down = mid;
            }
            else {
              up=mid-1;
            }
            }
        System.out.println(down);
        }
    }
    }

