import java.util.Arrays;
import java.util.Scanner;
public class q4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        int count=1;
        queue queue1=new queue();
        for (int i = 0; i <number ; i++) {
            int n=input.nextInt();
            if (n==1){
                count++;//数组的赋值
                queue1.addFirst(count);
            }
            else if (n==2){
                queue1.popFirst();
            }
            else if (n==3){
                count++;
                queue1.addLast(count);
            }
            else if (n==4){
                queue1.popLast();
            }
            else {
                System.out.println(queue1.getMiddle());
            }
            //System.out.println(Arrays.toString(queue1.arr)+" "+queue1.left+" "+queue1.right);
        }

    }
}
class queue{
    public int right=100001;
    public int left=99999;
    private final int Maxsize=200000;
    public int[] arr = new int[200000];
    public queue(){
        arr[100000] = 1;
    }
    public void addFirst(int n) {
        arr[right]=n;
        right++;
    }
    public void addLast(int n) {
        arr[left]=n;
        left--;
    }
    public void popFirst(){
        arr[right-1] = 0;
        right--;
    }
    public void popLast(){
        arr[left+1] = 0;
        left++;
    }
    public int getMiddle() {
        return arr[(right+left)/2];
    }
}
