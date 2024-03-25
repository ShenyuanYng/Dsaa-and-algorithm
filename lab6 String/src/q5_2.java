import java.util.Scanner;

public class q5_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        String str = input.next();
        int count=1;
        int j=number/2+1;
        for (int i = 0; i <number/2+1 ; i++) {

            if (str.charAt(i)==str.charAt(j)){
                    j++;
            }
            else if (str.charAt(i)!=str.charAt(j)){
                count--;
            }
        }
        if (count==0){
            String str1=str.substring(number/2+1);
            System.out.print(str1);
        }
        else {
            int count1 = 1;
            int k = number / 2;
            for (int i = 0; i < number / 2; i++) {
                if (str.charAt(i) == str.charAt(k)) {
                    k++;
                } else if (str.charAt(i) != str.charAt(k)) {
                    k++;
                    i--;
                    count1--;
                }
            }
            if (count1 == 0) {
                String str2 = str.substring(0, number / 2);
                System.out.print(str2);
            }
        }

    }
}
