import java.util.Arrays;
import java.util.Scanner;

public class Viterbi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int s = sc.nextInt();
        int t = sc.nextInt();
        int [][]a = new int[n][m];
        int [][]dp = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                a[j][i] = sc.nextInt();
            }
        }
        int q = n;
        n = m;
        m = q;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (i == 0){
                    dp[i][j] = -a[i][j]*a[i][j] + s*s + a[i][j] * s;
                }else {
                    dp[i][j] = dp[i-1][0] + -a[i][j]*a[i][j] + a[i-1][0] * a[i-1][0] + a[i][j] * a[i-1][0];
                    for (int k = 1; k < m; k++){
                        dp[i][j] = Math.min(dp[i][j], dp[i-1][k] - a[i][j]*a[i][j] + a[i-1][k] * a[i-1][k] + a[i][j] * a[i-1][k]);
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++){
            dp[n-1][i] = dp[n-1][i] - t * t + a[n-1][i] * a[n-1][i] + a[n-1][i] * t;
            if (i == 0){
                ans = dp[n-1][0];
            }else {
                ans = Math.min(ans, dp[n-1][i]);
            }
        }
        System.out.println(ans);
    }
}