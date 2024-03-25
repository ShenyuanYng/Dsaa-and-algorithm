import java.util.Scanner;

public class q2 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        int q=input.nextInt();
        ListNode[] array =new ListNode[n+1];
        for (int i = 1; i <= n; i++) {
            array[i] = new ListNode(i);
        }

        int query,x,y;
        for (int i = 0; i <q ; i++) {
            query=input.nextInt();
            if (query == 1) {
                x=input.nextInt();
                y=input.nextInt();
                array[x].next=array[y];
                array[y].pre=array[x];
            }
            if (query == 2) {
                x=input.nextInt();
                y=input.nextInt();
                array[y].pre=null;
                array[x].next=null;
            }
            if (query == 3) {
                x=input.nextInt();
                int length=array[x].Length(array[x]);
                ListNode head=array[x].Find_head(array[x]);
                System.out.print(length);
                while(head!=null){
                    System.out.print(" "+head.val);
                    head=head.next;
                }
                System.out.print("\n");
            }
        }
    }
}

class ListNode {
    public int val;
    public ListNode next=null;
    public ListNode pre=null;
    //构造函数
    public ListNode(int a) {
        val = a;
    }
    public int Length(ListNode x){
        ListNode p=x;
        int m=0;//节点x之前的节点个数
        int n=0;//节点x之后的节点个数
        int length;
        while(x.pre!=null){
            x=x.pre;
            m++;
        }
        x=p;
        while(x.next!=null){
            x=x.next;
            n++;
        }
        return length=m+n+1;
    }
    public ListNode Find_head(ListNode x){
        int i=0;
        for(i=0;x.pre!=null;i++)
            x=x.pre;
        return x;
    }
}
