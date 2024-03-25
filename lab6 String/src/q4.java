import java.util.Scanner;

public class q4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringBuilder str1= new StringBuilder(input.next());
        String str2=input.next();
        //删除字符串,while里面的true是下面compare方法返回的
        while (compare(str1,str2)){
            str1.delete(xiabiao(str1, str2), xiabiao(str1, str2) + str2.length());//count 是compare里面的count
        }
        System.out.print(str1);
    }
    public static boolean compare(StringBuilder str1, String str2){
        int i=0;
        int j=0;
        int count=-1;
        while (i<str1.length()&&j<str2.length()){
            if (str1.charAt(i)==str2.charAt(j)){
                i++;
                j++;
            }else {
                i=i-j+1;
                j=0;
            }
        }
        if (j>=str2.length()){
            count=i-j;//xia biao
            return true;
        }
        else {
            return false;
        }
    }
    public static int xiabiao(StringBuilder str1, String str2){
        int i=0;
        int j=0;
        int count=-1;
        while (i<str1.length()&&j<str2.length()){ //这里的i和j是局部变量，不是全局变量
            if (str1.charAt(i)==str2.charAt(j)){ //这里的i和j是局部变量，不是全局变量
                i++;
                j++;
            }else {
                i=i-j+1;    //
                j=0;
            }
        }
        if (j>=str2.length()){
            count=i-j;//xia biao  //
            return count;
        }
        else {
        }
        return i;
    }
    //冒泡排序
    public static void bubbleSort(int[] arr){
        for (int i = 0; i <arr.length-1 ; i++) {
            for (int j = 0; j <arr.length-1-i ; j++) {
                if (arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }


}
