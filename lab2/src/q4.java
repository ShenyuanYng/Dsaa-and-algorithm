import java.util.Arrays;
import java.util.Scanner;

public class q4{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0;i < n;i++){
            //Main Function Here
            bIdx = 0;
            aIdx = 0;
            aCount = 0;
            b_seq = new int[200000];
            a_seq = new int[200000];
            originalString = trimA(in.next().toCharArray());//input
            countBlock(originalString);
            //TODO: if originalString.length == 0, should return a 0 and continue the loop
            if(aCount == 0 || b_seq[0] == 0){
                System.out.println(0);
                continue;
            }
            int min = 1000000;
            int[] minRecord = new int[1000001];
            for(int j = 0;j <= a_seq.length;j++){
                min = Math.min(min,findBestOnce(j));
                if(++minRecord[min] > 5) break;
            }
            System.out.println(min);
        }
    }
    public static char[] originalString;
    public static int[] b_seq = new int[200000];
    public static int bIdx = 0;
    public static int[] a_seq = new int[200000];
    public static int aIdx = 0;
    public static int aCount = 0;
    public static void countBlock(char[] c){//Count the blocks of a and b and record the structure of it
        int idx = 1;
        for (int i = 0; i < c.length-1; i++) {
            if(c[i] == c[i+1]){
                if(c[i] == 'a') {
                    a_seq[aIdx]++;
                    aCount++;
                }
                else b_seq[bIdx]++;
            }else{
                if(c[i] == 'a') {
                    a_seq[aIdx++]++;
                    aCount++;
                    bIdx++;
                }
                else b_seq[bIdx]++;
            }
        }
        if(c[c.length-1] == 'a') {
            a_seq[aIdx]++;
            aCount++;
        }
        else b_seq[bIdx]++;
        a_seq = Arrays.copyOf(a_seq,aIdx+1);
        b_seq = Arrays.copyOf(b_seq,bIdx+1);
    }
    public static int findBestOnce(int n){
        int costB = 0;
        int costA = 0;
        int minCost = 100000000;
        for(int i = 1;i <= n;i++){
            costB = 0;
            costA = 0;
            for(int j = 1;j < i;j++){//Delete Left
                costB += b_seq[j-1];
                costA -= a_seq[j-1];
            }
            for(int j = i+1;j <= n;j++){//Delete Right
                costB += b_seq[bIdx+j-n];
                costA -= a_seq[bIdx+j-n-1];
            }
            int max = Math.max(aCount + costA, costB);
            minCost = Math.min(minCost, max);
        }
        //return min
        return minCost;
    }
    public static char[] trimA(char[] c){
        int idx1 = 0;
        int idx2 = 0;
        for(int i = 0;i < c.length;i++){
            if(c[i] == 'b'){
                idx1 = i;
                break;
            }
        }
        for(int i = c.length-1;i >0;i--){
            if(c[i] == 'b'){
                idx2 = i;
                break;
            }
        }
        return Arrays.copyOfRange(c,idx1,idx2+1);
    }
}
