import java.util.Scanner;

public class q1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        ListNode first = new ListNode();
        for (int i = 1; i <= n; i++) {
            ListNode node = new ListNode(i);
            if (i == 1) {
                first = node;
                first.next = first;
            } else {
                ListNode temp = first;
                while (temp.next != first) {
                    temp = temp.next;
                }
                temp.next = node;
                node.next = first;
            }
        }


        do {
            for (int i = 1; i < m; i++) {
                if ((i + 1) == m) {
                    System.out.print(first.next.val+" ");
                    first.next = first.next.next;
                }
                first = first.next;
            }
        } while (first != first.next);
        System.out.print(first.val+" ");
    }

        static class ListNode {
            public int val;
            public ListNode next;

            //构造函数
            public ListNode(int a) {
                this.val = a;
            }
            public ListNode(){}
        }

}
