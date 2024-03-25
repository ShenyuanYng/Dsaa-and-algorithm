import java.util.Scanner;

public class q3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number=input.nextInt();
        String str=input.next();
        for (int i = 1; i <=number ; i++) {
          String sub=str.substring(0,i);
          StringBuilder newstr = new StringBuilder(sub);

          while (newstr.length()<=number){
              newstr.append(sub);
          }

          String subnewstr=newstr.substring(0,number);

          if (subnewstr.equals(str)){
              System.out.print(sub.length());
              break;
          }
        }
    }

}
