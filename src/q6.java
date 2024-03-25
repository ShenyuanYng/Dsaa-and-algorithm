import java.util.Scanner;

public class q6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        for (int i = 0; i < number; i++) {
            int n=input.nextInt();
            if (n==1){
                int n1=input.nextInt();
                System.out.println(0);
                continue;
            }
            int array[]=new int [n];

            int array1[]=new int[n];
            int array2[]=new int[n];
            int a[]=new  int[n];
            int b[]=new  int[n];
            int c[]=new  int[n];
            //duru
            for (int j=0;j<n;j++){
                array[j]=input.nextInt();
            }
            //panding
            int count1=0;//daibiao 0
            int count2=0;// daibiao 1

            int x=0;
            int y=0;
            int z=0;
            int count=0;
            int count3=0;
            for (int j = 0; j <n ; j++) {
                if (array[j]==0){
                    count1++;
                }
                if (array[j]==1){
                    count2++;
                }
            }
            if (Math.abs(count1-count2)>=2){
                System.out.println(-1);
            }
            if (count1-count2==1){
                for (int j = 0; j <(n-1)/2 ; j++) {
                    array1[2*j+1]=1;//01010
                }
                for (int j = 0; j < n; j++) {
                    if (array[j] == 0) {
                        x++;
                        array[j] = 2;
                        a[x] = j;
                    }
                    if (array1[j] == 0) {
                        y++;
                        array1[j] = 2;
                        b[y] = j;
                    }
                }
                    for (int k = 0; k <n ; k++) {
                     count=count+Math.abs(a[k]-b[k]);
                    }
                System.out.println(count);
            }


            if (count2-count1==1) {
                for (int j = 0; j <=(n -1)/ 2; j++) {
                    array1[2 * j] = 1;//10101
                }
                for (int j = 0; j < n; j++) {
                    if (array[j]==1){
                        x++;
                        array[j]=2;
                        a[x]=j;
                    }
                    if (array1[j]==1){
                        y++;
                        array1[j]=2;
                        b[y]=j;
                    }
                }
                for (int j = 0; j <n ; j++) {
                    count=count+Math.abs(a[j]-b[j]);
                }
                System.out.println(count);
            }

            if (count2-count1==0){
                for (int j = 0; j <n/2 ; j++) {
                    array1[2*j]=1;//1010
                    array2[2*j+1]=1;//0101
                }
                for (int j = 0; j <n ; j++) {
                    if (array[j]==1){
                        x++;
                        array[j]=2;
                        a[x]=j;
                    }
                    if (array1[j]==1){
                        y++;
                        array1[j]=2;
                        b[y]=j;
                    }
                    if (array2[j]==1){
                        z++;
                        array2[j]=2;
                        c[z]=j;
                    }
                }
                for (int j = 0; j <n ; j++) {
                    count=count+Math.abs(a[j]-b[j]);
                }
                for (int j = 0; j <n ; j++) {
                    count3=count3+Math.abs(a[j]-c[j]);
                }
                if (count>=count3){
                    System.out.println(count3);
                }
                else {
                    System.out.println(count);
                }
                }
            }
            }
        }


