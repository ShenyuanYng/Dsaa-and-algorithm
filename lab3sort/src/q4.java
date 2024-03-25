import java.util.Scanner;

public class q4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        int[] array =new int[number];
        for (int i = 0; i <number ; i++) {
            array[i]=input.nextInt();
        }
        int m;
        int k;
        for (int i = 0; i <number-1 ; i++) {
            m=i;
            for (int j =i+ 1; j <number ; j++) {
                if (judge(array[j], array[m]) > 0) {
                    m = j;
                }
            }
            //循环遍历找到两两组合最大的，放到前面的位置
                k=array[i];
                array[i]=array[m];
                array[m]=k;

        }
        StringBuilder str= new StringBuilder(new String());
        for (int i:array) {
            str.append(String.valueOf(i));
        }
        System.out.println(str);

    }

    public static int judge(int num1, int num2){
        String a=Integer.toString(num1)+Integer.toString(num2);
        String b=Integer.toString(num2)+Integer.toString(num1);
        return (a.compareTo(b));
    }
}