import java.util.Scanner;

public class q2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int length=input.nextInt();
        String str=input.next();
        int []array=new int[length];
       array[0]=0;
       int count=0;
        for (int j = 1; j <length ; j++) {
            while (count>0&&str.charAt(count)!=str.charAt(j)){
                count=array[count-1];
            }
            if (str.charAt(count)==str.charAt(j)){
                count++;
            }
            array[j]=count;
        }
        for (int i = 0; i <length ; i++) {
            System.out.print(array[i]+" ");
        }
    }
}
