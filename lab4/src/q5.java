import java.util.Scanner;

public class q5 {

    static class MyList{
        public int i;
        public int value;
        public MyList next;
        public MyList pre;

        public MyList(int i, int value) {
            this.i = i;
            this.value = value;
        }
    }

    public static MyList findMax(MyList head){
        MyList max = head;
        MyList tmp = head;
        while(tmp != null){
            if(tmp.value  > max.value){
                max = tmp;
            }
            tmp = tmp.next;
        }
        return max;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] result = new int[n];
        MyList head = new MyList(0, scanner.nextInt());
        MyList pre = head;

        for (int i = 1; i < n; i++) {
            MyList next = new MyList(i, scanner.nextInt());
            pre.next = next;
            next.pre = pre;
            pre = next;
        }

        int coach = 1;
        while(head != null){
            MyList max = findMax(head);
            result[max.i] = coach;
            MyList left = max;
            for (int i = 0; i < k; i++) {
                left = left.pre;
                if(left == null){
                    break;
                }
                result[left.i] = coach;
            }
            MyList right = max;
            for (int i = 0; i < k; i++) {
                right = right.next;
                if(right == null){
                    break;
                }
                result[right.i] = coach;
            }
            MyList leftmost;
            MyList rightmost;
            if(right == null || right.next == null){
                rightmost = null;
            }else{
                rightmost = right.next;
            }
            if(left == null || left.pre == null){
                head = rightmost;
                if(head != null){
                    head.pre = null;
                }
            }else{
                leftmost = left.pre;
                leftmost.next = rightmost;
                if(rightmost != null){
                    rightmost.pre = leftmost;
                }
            }

            if(coach == 1){
                coach = 2;
            }else{
                coach = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(result[i]);
        }
        System.out.println();

    }


}
