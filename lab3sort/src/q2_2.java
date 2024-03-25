import java.util.Scanner;
public class q2_2 {
    public  static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        int[] arr =new int[number];
        for (int i = 0; i <number ; i++) {
            arr[i]=input.nextInt();
        }
        long[] array =new long[1];
        sort(arr,0,number-1,array);
          System.out.println(array[0]);
            }

            public static void sort(int[] arr, int left, int right,long[] array) {
                if (left == right) {
                    return;
                }
                //分成两半
                int mid = (right+left)/2;
                //左边排序
                sort(arr, left, mid,array);
                //右边排序
                sort(arr, mid +1, right,array);
                merge(arr, left, mid+1, right,array);
            }
            //leftPtr 指数组最左边
            //rightPtr 指数组中间
            //rightBound 数组最右边
            public static void merge(int[] arr, int leftPtr, int rightPtr, int rightBound, long[] array) {
                int mid = rightPtr - 1;
                int[] temp = new int[rightBound - leftPtr + 1];

                int i = leftPtr;
                int j = rightPtr;
                int k = 0;

                while (i <= mid && j <= rightBound) {
                    if (arr[i] <= arr[j]) {
                        temp[k] = arr[i];
                        i++;
                    } else {
                        array[0]+=mid-i+1;
                        temp[k] = arr[j];
                        j++;
                    }
                    k++;
                }

                // 将右边剩余的归并
                while (i <= mid) {
                    temp[k++] = arr[i++];
                }
                //将左边剩余的归并
                while (j <= rightBound) {
                    temp[k++] = arr[j++];
                }
                System.arraycopy(temp, 0, arr, leftPtr, temp.length);
            }
        }

