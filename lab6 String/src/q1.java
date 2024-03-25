import java.util.Scanner;

public class q1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str1=input.next();
        String str2=input.next();
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
            count=i-j;
            System.out.print(count);
        }
        else {
            System.out.print(-1);
        }
    }
}
