import java.util.Scanner;

public class q4_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringBuilder str1 = new StringBuilder(input.next());
        String str2 = input.next();
        while (KMP.KMP(str1,str2)) {
            str1.delete(KMP.KMP1(str1, str2), KMP.KMP1(str1, str2) + str2.length());
        }
        System.out.print(str1);

        }
    }

 class KMP {
    public static boolean KMP(StringBuilder Str, String Sub){
        if (Str == null || Sub == null){
            return false;
        }


        int i = 0;
        int j = 0;
        int[] next = new int[Sub.length()];

        getNext(next,Sub);

        while(i < Str.length() && j < Sub.length()){
            if (j == -1 || Str.charAt(i) == Sub.charAt(j)){
                i++;
                j++;
            }else {
                j = next[j];
            }
        }

        if (j >= Sub.length()){
            return true;
        }else {
            return false;
        }
    }
     public static int KMP1(StringBuilder Str,String Sub){
         if (Str == null || Sub == null){
             return -1;
         }

         int i = 0;
         int j = 0;
         int[] next = new int[Sub.length()];

         getNext(next,Sub);

         while(i < Str.length() && j < Sub.length()){
             if (j == -1 || Str.charAt(i) == Sub.charAt(j)){
                 i++;
                 j++;
             }else {
                 j = next[j];
             }
         }

         if (j >= Sub.length()){
             return i-j;
         }else {
             return -1;
         }
     }


    public static void getNext(int[] next,String sub){
        next[0] = -1;
        next[1] = 0;

        int i = 2;
        int k = 0;

        //由于我们设定好了next数组前两位的值
        //所以我们使用我们上面所讲到的逻辑就可以很好的完成我们的填充
        while(i < next.length){
            if (k ==- 1 || sub.charAt(k) == sub.charAt(i-1)){
                next[i] = k+1;
                i++;
                k++;
            }else {
                k = next[k];
            }
        }
    }

}
