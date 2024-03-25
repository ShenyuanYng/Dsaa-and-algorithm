import java.util.Scanner;

public class q5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number=input.nextInt();
        String str= input.next();
        int count=0;
        String str3= "";
        for (int i = 0; i <number ; i++) {
            String newstr=str.substring(0,i)+str.substring(i+1);

            String str1;
            String str2;

            str1=newstr.substring(0,(number-1)/2);
            str2=newstr.substring((number-1)/2);
            if (str1.equals(str2)){
                count++;
                str3=str1;
            }
        }
        if (count>=2){
            System.out.print("NOT UNIQUE");
        }
        if (count==1) {
            System.out.print(str3);
        }
        if (count==0){
            System.out.print("NOT POSSIBLE");
        }
    }
}
