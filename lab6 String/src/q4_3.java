import java.util.Scanner;

public class q4_3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str1 = input.next();
        String str2 = input.next();
        //删除字符串,while里面的true是下面compare方法返回的
        while (compare(str1, str2)) {
            String str3=new String();
            String[] str=str1.split(str2);
            for (int i = 0; i <str.length ; i++) {
                str3=str3+str[i];
            }
            str1=str3;
        }
        System.out.print(str1);
    }

    public static boolean compare(String str1, String str2) {
        int i = 0;
        int j = 0;
        int count = -1;
        while (i < str1.length() && j < str2.length()) {
            if (str1.charAt(i) == str2.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j >= str2.length()) {
            count = i - j;//xia biao
            return true;
        } else {
            return false;
        }
    }
}
