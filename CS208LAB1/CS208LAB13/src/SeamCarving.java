import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SeamCarving {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        // 读取输入
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int m = Integer.parseInt(tokenizer.nextToken());
        int n = Integer.parseInt(tokenizer.nextToken());

        // disruption measures数组
        long[][] d = new long[m][n];

        // 读取每个像素的disruption measure
        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < n; j++) {
                d[i][j] = Long.parseLong(tokenizer.nextToken());
            }
        }

        // 动态规划找到最小disruption measure的seam
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 当前位置的disruption measure
                long currentDisruption = d[i][j];

                // 在上一行找到最小的disruption measure
                long minPrev = d[i - 1][j];
                if (j > 0) {
                    minPrev = Math.min(minPrev, d[i - 1][j - 1]);
                }
                if (j < n - 1) {
                    minPrev = Math.min(minPrev, d[i - 1][j + 1]);
                }

                // 更新当前位置的disruption measure
                d[i][j] += minPrev;
            }
        }

        // 找到最后一行的最小值
        long minDisruption = d[m - 1][0];
        for (int j = 1; j < n; j++) {
            minDisruption = Math.min(minDisruption, d[m - 1][j]);
        }

        // 输出最小disruption measure
        writer.write(Long.toString(minDisruption));


        reader.close();
        writer.close();
    }
}
