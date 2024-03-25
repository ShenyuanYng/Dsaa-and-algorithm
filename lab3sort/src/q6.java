import java.io.*;
import java.util.*;

public class q6 {
    public static void main(String[] args) {
      Scanner input=new Scanner(System.in);
        //   QWriter out=new QWriter();
        int number = input.nextInt();
       // int k=input.nextInt();
        long[] arr =new long[number];
        for (int i = 0; i <number ; i++) {
            arr[i]=input.nextInt();
        }
        sort(arr,0,number-1);
        for (int i = 0; i <number ; i++) {
            System.out.print(arr[i]+" ");
        }
        //System.out.println(arr[number-k]);
    }

    public static void sort(long[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = (right+left)/2;
        sort(arr, left, mid);
        sort(arr, mid +1, right);
        merge(arr, left, mid+1, right);
    }

    public static void merge(long[] arr, int leftPtr, int rightPtr, int rightBound) {
        int mid = rightPtr - 1;
        long[] temp = new long[rightBound - leftPtr + 1];
        int i = leftPtr;
        int j = rightPtr;
        int k = 0;
        while (i <= mid && j <= rightBound) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= rightBound) {
            temp[k++] = arr[j++];
        }
        System.arraycopy(temp, 0, arr, leftPtr, temp.length);
    }
}
