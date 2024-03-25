import java.util.Scanner;

public class q1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for (int i = 0; i <n ; i++) {
            String str = input.next();
            char[] stack = new char[str.length()+1];
            int top = 1;
            if (str.charAt(0)==')'){
                System.out.println("NO");
                continue;
            }
            for (int j = 1; j <str.length(); j++) {
                char nextChar = str.charAt(j);
                if (top>0&& nextChar!='(') {
                    top--;
                }
                else if (top<0){
                    break;
                }
                else {
                    top++;
                    stack[top] = nextChar;
                }
            }
            if (top != 0) {
                    System.out.println("NO");
                } else {
                    System.out.println("YES");
                }

            }

    }
}
