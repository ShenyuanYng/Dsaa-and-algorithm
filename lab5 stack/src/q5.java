import java.util.Scanner;
public class q5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        int []array=new int[number];
        for (int i = 0; i <number ; i++) {
           array[i]=input.nextInt();
        }
        int count=0;
        for (int i = 1; i <number ; i++) {
            int x=0;
            int min = array[i - 1];
            if (array[i] < array[i - 1]) {
                count++;
            } else if (array[i]>array[i-1]){
                for (int j = i - 1; j >= 0; j--) {
                    if (array[j]>array[i]){
                        x++;
                    }
                    if (x==1){
                        count++;
                        break;
                    }
                    if (array[j] >= min) {
                        count++;
                        min = array[j];
                    }
                }
            }
            else {
                for (int j = i-1; j >=0 ; j--) {
                    if (array[j]==array[i]){
                        count++;
                    }
                    else if (array[j]>array[i]){
                        count++;
                        break;
                    }
                }
            }
        }
        System.out.print(count);
    }
}
