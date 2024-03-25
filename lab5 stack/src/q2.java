import java.util.Scanner;
import java.util.Stack;

public class q2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Stack<Character> stack1=new Stack<Character>();//存yunsuanfu
        Stack<Character> stack2=new Stack<>();//cunshuzi

        String str=input.next();
        String zimu;
        for (int i = 0; i <str.length() ; i++) {
            if (str.charAt(i)=='+'||str.charAt(i)=='-'||str.charAt(i)=='*'||str.charAt(i)=='/'||str.charAt(i)=='('||str.charAt(i)==')'){
                if (str.charAt(i) == '(' || stack1.empty()) {
                    stack1.push(str.charAt(i));
                } else if ((str.charAt(i) == '/' || str.charAt(i) == '*') &&(stack1.peek()=='+'||stack1.peek()=='-'|| stack1.peek() == '(')) {
                    stack1.push(str.charAt(i));
                } else if ((str.charAt(i) == '/' || str.charAt(i) == '*')&&(stack1.peek()=='*'||stack1.peek()=='/')) {
                    while(!stack1.empty()){
                        if (stack1.peek()=='*'||stack1.peek()=='/'){
                       stack2.push(stack1.pop());
                        }
                        else {
                            break;
                        }
                   }
                   stack1.push(str.charAt(i));
                }else if (str.charAt(i) == ')') {
                    while (stack1.peek() != '(') {
                        stack2.push(stack1.pop());
                    }
                    if (stack1.peek() == '(') {
                        stack1.pop();
                    }
                } else if (str.charAt(i) == '+' || str.charAt(i) == '-')  {
                    while (!stack1.empty()) {
                        if (stack1.peek() != '(') {
                            stack2.push(stack1.pop());
                        }
                        else {
                            break;
                        }
                    }
                    stack1.push(str.charAt(i));
                }
        } else {
                stack2.push(str.charAt(i));
            }

        }
        //将剩余的操作符压入s2
        while (!stack1.empty()){
            stack2.push(stack1.pop());
        }
        int count=stack2.size();
        Character ayyay []=new Character[stack2.size()];
        for (int i = 0;i<count ; i++) {
            ayyay[i]=stack2.pop();
        }
        for (int i =count ; i >0 ; i--) {
            System.out.print(ayyay[i-1]);
        }

    }


}


