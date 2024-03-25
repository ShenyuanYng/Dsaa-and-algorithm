import java.util.Scanner;

public class q3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String count = input.next();
        int n = count.length();
        int x = n / 3;
        int n1 = 0;
        int n2=0;
        if (n % 3 == 0) {
            n1 = x;
            n2 = x;
        }
        if (n % 3 == 1) {
            n1 = x;
            n2 = x + 1;
        }
         if (n % 3 == 2) {
            n1 = x + 1;
            n2 = x;
        }

        for (int i = 0; i <n1-1 ; i++) {
            System.out.print(count.charAt(i));
            for(int j=0;j<n2;j++) {
                System.out.print(" ");
            }
            System.out.println(count.charAt(n-i-1));
        }
        for (int i = n1-1; i <n1+1+n2 ; i++) {
            System.out.print(count.charAt(i));
        }
    }
}
