import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p3 {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    static class FastWriter {
        BufferedWriter bw;

        public FastWriter() {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        void print(String str) {
            try {
                bw.write(str);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        void println(String str) {
            print(str + "\n");
        }

        void close() {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        FastWriter writer = new FastWriter();

        int n = scanner.nextInt(); // 苹果数量
        int m = scanner.nextInt(); // 篮子数量
        int[] basketSizes = new int[m]; // 篮子体积
        int[] applePositions = new int[n]; // 苹果位置
        int count = 0;

        for (int i = 0; i < m; i++) {
            basketSizes[i] = scanner.nextInt();
            count += basketSizes[i];
        }

        for (int i = 0; i < n; i++) {
            applePositions[i] = scanner.nextInt();
        }

        // 计算篮子的总体积和苹果的数量
        int totalBasketVolume = Arrays.stream(basketSizes).sum();
        int totalApples = applePositions.length;

        long totalDistance = 0; // 总距离成本

        if (totalBasketVolume >= totalApples) {
            // 如果篮子的总体积大于等于苹果的数量，使用最大的篮子从最远处开始拿
            Arrays.sort(basketSizes);
            int basketindex0 = m - 1;
            long distance = 0;
            int appleIndex = n - 1;
            for (int i = 0; i < m; i++) {
                if (appleIndex < 0) {
                    break;
                }
                int maxDistance = 2 * Math.abs(applePositions[appleIndex]);
                distance += maxDistance;

                appleIndex -= basketSizes[basketindex0];
                basketindex0--;
            }
            totalDistance = distance;
        } else {
            // 否则，使用最最大的篮子拿和篮子总体积相等的pi的苹果
            Arrays.sort(basketSizes);
            int basketIndex1 = m - 1;
            int appleindex1 = count - 1;

            for (int i = 0; i < m; i++) {
                int maxDistance = 2 * Math.abs(applePositions[appleindex1]);
                totalDistance += maxDistance;

                appleindex1 -= basketSizes[basketIndex1];
                basketIndex1--;
            }
        }

        writer.println(String.valueOf(totalDistance));
        writer.close();
    }
}
