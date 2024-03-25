import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TV_breaker {
    public static void main(String[] args) throws IOException {
        FastScanner scanner = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        // 读取Bob的电视字符串
        String tvString = scanner.next();

        // 读取惊人特征的数量
        int n = scanner.nextInt();

        // 读取惊人特征字符串并存储在一个数组中
        String[] amazingFeatures = new String[n];
        for (int i = 0; i < n; i++) {
            amazingFeatures[i] = scanner.next();
        }

        // 计算最小次数的打击
        int minHits = calculateMinHits(tvString, amazingFeatures);

        // 输出结果
        out.println(minHits);
        out.flush();
    }

    // 构建KMP的最长前缀后缀数组
    public static int[] buildKMPTable(String pattern) {
        int[] table = new int[pattern.length()];
        int j = 0;

        for (int i = 1; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = table[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            table[i] = j;
        }

        return table;
    }

    // 使用KMP算法查找惊人特征在电视字符串中的位置
    public static int kmpSearch(String text, String pattern) {
        int[] kmpTable = buildKMPTable(pattern);
        int textIndex = 0;
        int patternIndex = 0;

        while (textIndex < text.length()) {
            if (text.charAt(textIndex) == pattern.charAt(patternIndex)) {
                textIndex++;
                patternIndex++;
                if (patternIndex == pattern.length()) {
                    return textIndex - patternIndex;
                }
            } else {
                if (patternIndex != 0) {
                    patternIndex = kmpTable[patternIndex - 1];
                } else {
                    textIndex++;
                }
            }
        }
        return -1;
    }

    // 计算最小次数的打击函数
    public static int calculateMinHits(String tvString, String[] amazingFeatures) {
        int minHits = 0;

        while (containsAmazingFeature(tvString, amazingFeatures)) {
            int bestHitIndex = tvString.length();
            int bestHitCount = Integer.MAX_VALUE;

            for (String feature : amazingFeatures) {
                int hitIndex = kmpSearch(tvString, feature);
                if (hitIndex >= 0) {
                    int hitCount = feature.length();
                    if (hitCount < bestHitCount) {
                        bestHitCount = hitCount;
                        bestHitIndex = hitIndex;
                    }
                }
            }

            char[] tvCharArray = tvString.toCharArray();
            for (int i = bestHitIndex; i < bestHitIndex + bestHitCount; i++) {
                tvCharArray[i] = ' ';
            }

            tvString = new String(tvCharArray);
            minHits++;
        }

        return minHits;
    }

    // 检查字符串是否包含任何惊人特征
    public static boolean containsAmazingFeature(String tvString, String[] amazingFeatures) {
        for (String feature : amazingFeatures) {
            if (tvString.contains(feature)) {
                return true;
            }
        }
        return false;
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
