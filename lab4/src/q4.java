import java.util.Scanner;
public class q4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        int m=input.nextInt();
        Node[] array =new Node[n];
        for (int i = 0; i < n; i++) {
            array[i] = new Node(i+1);
        }
        for(int i=1;i<n;i++) {

                array[i].pre=array[i-1];
                array[i-1].next=array[i];
        }
        Node head=array[0];//存链表的头
        Node tail=array[n-1];//存链表的尾

        String str1 = "right";
        String str2="left";


        for (int i = 0; i <m ; i++) {
            String str=input.next();
            int x=input.nextInt();
            int y=input.nextInt();
            Node px,py;
            px=array[x-1];//存val为x的节点
            py=array[y-1];//存val为y的节点
            if (str.equals(str1)){              //right
                if(px.next!=null&&py.pre!=null) {
                    tail.next=py;
                    px.next.pre=py.pre;
                    py.pre.next=px.next;
                    py.pre=tail;
                    px.next=null;
                    tail=px;//更新链表的尾
                }
                if(px.next != null) {
                    head=px.next;//更新链表的头
                    px.next.pre=null;
                    px.next=null;
                    tail.next=py;
                    py.pre=tail;
                    tail=px;//更新链表的尾
                }
            }
            if (str.equals(str2)) {              //left
                if (px.pre != null && py.next != null) {
                    py.next.pre = px.pre;
                    px.pre.next = py.next;
                    py.next = head;
                    head.pre = py;
                    px.pre = null;
                    head = px;//更新链表的头
                }
                if (px.pre != null) {
                    tail = px.pre;//更新链表的尾
                    px.pre.next = null;
                    head.pre = py;
                    px.pre = null;
                    py.next = head;
                    head = px;//更新链表的头
                }
            }
        }
        //打印结果
        Node p=head;
        while(p.next!=null) {
            System.out.print(p.val+" ");
            p=p.next;
        }
        //防止输出格式错误，最后一个数后面没空格
        System.out.print(p.val);
    }
}
class Node {
    public int val;
    public Node next = null;
    public Node pre = null;

    //构造函数
    public Node(int a) {
        val = a;
    }
}
