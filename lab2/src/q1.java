
import java.util.Scanner;

public class q1 {
    public static double c = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0;i < n;i++){
            c = in.nextDouble();
            System.out.printf("%.4f\n",binary(0,100000000));
        }
    }
    public static double returnF(double i){
        return (i+1)*Math.log(i+1)-i-c;
    }
    public static double binary(double down,double up){
        if(returnF(down) == 0) return down;
        if(returnF(up) == 0) return up;
        if(Math.abs(up-down) < 0.0000001) return (down+up)/2;
        if(returnF((down+up)/2) == 0) return (down+up)/2;
        if(returnF((down+up)/2) < 0) return binary((down+up)/2,up);
        if(returnF((down+up)/2) > 0) return binary(down,(down+up)/2);
        return (down+up)/2;
    }
}


