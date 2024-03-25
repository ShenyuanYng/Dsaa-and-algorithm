import java.util.Scanner;

public class q1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        for (int k = 0; k < number; k++) {
            int[] array1 = new int[1000];
            int[] array2 = new int[1000];
            array1[0] = input.nextInt();
            array2[0] = input.nextInt();
            int i = 1;
            while (array1[i - 1] != 1) {
                array1[i] = array1[i - 1] / 2;
                i++;

            }

            int j = 1;
            while (array2[j - 1] != 1) {
                array2[j] = array2[j - 1] / 2;
                j++;
            }

            int m=0;
            int n=0;
            while (array1[m] != array2[n]) {
                if (array1[m] > array2[n]) {
                    m++;
                } else {
                    n++;
                }
            }
            System.out.println(m+n);




        }
    }

}


