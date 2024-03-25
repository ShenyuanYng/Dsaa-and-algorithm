import java.util.ArrayList;
import java.util.Scanner;
public class q5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        int[] array1 = new int[number];
        int[] array2=new  int[number];
        for (int i = 0; i <number ; i++) {
            array1[i]=input.nextInt();
        }
        for (int i = 0; i <number ; i++) {
            array2[i]=input.nextInt();
        }
        sort(array1,0,number-1);
        sort(array2,0,number-1);
        ArrayList<Integer> list=new ArrayList<Integer>();
        for (int i = 0; i <number ; i++) {
            for (int j = 0; j <Math.ceil(number/(i+1)) ; j++) {
                list.add(array1[i]+array2[j]);
            }
        }
        int array[]=new int[list.size()];
        for (int i = 0; i <list.size() ; i++) {
                array[i]=list.get(i);
        }
        sort(array,0,list.size()-1);
        for (int i = 0; i <number ; i++) {
            System.out.print(array[i]+" ");
        }

    }
    public static void sort(int[] array, int left, int right) {
        if (left == right) {
            return;
        }

        int mid = (right+left)/2;

        sort(array, left, mid);

        sort(array, mid +1, right);
        merge(array, left, mid+1, right);
    }

    public static void merge(int[] array, int leftPtr, int rightPtr, int rightBound) {
        int mid = rightPtr - 1;
        int[] temp = new int[rightBound - leftPtr + 1];
        int i = leftPtr;
        int j = rightPtr;
        int k = 0;

        while (i <= mid && j <= rightBound) {
            if (array[i] <= array[j]) {
                temp[k] = array[i];
                i++;
            } else {
                temp[k] = array[j];
                j++;
            }
            k++;
        }


        while (i <= mid) {
            temp[k++] = array[i++];
        }

        while (j <= rightBound) {
            temp[k++] = array[j++];

        }
        System.arraycopy(temp, 0, array, leftPtr, temp.length);
    }
}
