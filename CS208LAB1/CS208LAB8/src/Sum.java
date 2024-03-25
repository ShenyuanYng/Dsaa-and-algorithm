import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Sum {
    public static void main(String[] args) throws IOException {
        FastReader reader = new FastReader();
        PrintWriter writer = new PrintWriter(System.out);

        int N = reader.nextInt();
        long L = reader.nextLong();
        long R = reader.nextLong();
        long[] A = new long[N];
        for (int i = 0; i < N; i++) {
            A[i] = reader.nextLong();
        }

        long result = countRangeSum(A, L, R);
        writer.println(result);

        writer.close();
    }

    public static long countRangeSum(long[] nums, long lower, long upper) {
        int n = nums.length;
        long[] presum = new long[n + 1];
        for (int i = 1; i <= n; i++)
            presum[i] = presum[i - 1] + nums[i - 1];
        long[] tmp = new long[n + 1];
        return merge(presum, 0, presum.length - 1, lower, upper, tmp);
    }

    private static long merge(long[] presum, int l, int r, long lower, long upper, long[] tmp) {
        if (l >= r)
            return 0;
        long count = 0;
        int mid = l + r >>> 1;
        count += merge(presum, l, mid, lower, upper, tmp);
        count += merge(presum, mid + 1, r, lower, upper, tmp);
        int i = l, up = mid + 1, low = mid + 1;
        while (i <= mid) {
            while (low <= r && presum[low] - presum[i] < lower)
                low++;
            while (up <= r && presum[up] - presum[i] <= upper)
                up++;
            count += up - low;
            i++;
        }
        i = l;
        int j = mid + 1;
        int k = l;
        while (i <= mid || j <= r) {
            if (i > mid) {
                tmp[k++] = presum[j++];
            } else if (j > r) {
                tmp[k++] = presum[i++];
            } else if (presum[i] < presum[j]) {
                tmp[k++] = presum[i++];
            } else {
                tmp[k++] = presum[j++];
            }
        }
        for (i = l; i <= r; i++)
            presum[i] = tmp[i];
        return count;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer("");
        }

        String next() {
            while (!st.hasMoreElements()) {
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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
