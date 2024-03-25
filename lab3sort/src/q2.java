import java.util.Scanner;

public class q2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        int[] array = new int[number];
        for (int i = 0; i < number; i++) {
            array[i] = input.nextInt();
        }
        int[] arr=new int[1];
       // int count =method.quickSort(array,0,array.length-1);
        method.quickSort(array, 0, array.length - 1 ,arr);
         System.out.println(arr[0]);
    }
}
class method{
    public static void quickSort(int []array, int low, int high, int []arr) {
        int i,j,temp,t;

        if(low>high){
            return;
        }
        i=low;
        j=high;
        //temp就是基准位
        temp = array[low];
        while (i<j) {
            //先看右边，依次往左递减
            while (temp<=array[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp>=array[i]&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                t = array[j];
                array[j] = array[i];
                array[i] = t;
                arr[0]++;
            }
        }
        //最后将基准为与i和j相等位置的数字交换
        array[low] = array[i];
        array[i] = temp;
        arr[0]++;
        //递归调用左半数组
        quickSort(array, low, j-1,arr);
        //递归调用右半数组
        quickSort(array, j+1, high,arr);
    }
}


