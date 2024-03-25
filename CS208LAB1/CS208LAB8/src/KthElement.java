import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;

class QReader {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public QReader() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        tokenizer = new StringTokenizer("");
    }

    public String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public void close() {
    }
}

class QWriter {
    private PrintWriter writer;

    public QWriter() {
        writer = new PrintWriter(System.out);
    }

    public void print(Object obj) {
        writer.print(obj);
    }

    public void println(Object obj) {
        writer.println(obj);
    }

    public void close() {
        writer.close();
    }
}

public class KthElement {
    public static void main(String[] args) throws IOException {
        QReader reader = new QReader();
        QWriter writer = new QWriter();

        int T = reader.nextInt(); // Number of queries
        int n = reader.nextInt(); // Length of arrays A and B

        int[] A = new int[n];
        int[] B = new int[n];

        // Input array A
        for (int i = 0; i < n; i++) {
            A[i] = reader.nextInt();
        }

        // Input array B
        for (int i = 0; i < n; i++) {
            B[i] = reader.nextInt();
        }



        for (int t = 0; t < T; t++) {
            int l = reader.nextInt(); // Query interval start
            int r = reader.nextInt(); // Query interval end
            int k = reader.nextInt(); // Kth element

            int st1 = l-1, st2 = l-1;

            int result = findKthElement(A, B, k,r,st1,st2);

            // Output the kth element
            writer.println(result);
        }

        // Close the reader and writer
        reader.close();
        writer.close();
    }

    private static int findKthElement(int[] A, int[] B, int k,int r, int st1, int st2) {
        if (st1 == r)
        {
            return B[st2 + k - 1];
        }

        // In case we have reached end of array 2
        if (st2 == r)
        {
            return A[st1 + k - 1];
        }


        // Compare first elements of arrays and return
        if (k == 1)
        {
            return (A[st1] < B[st2])
                    ? A[st1] : B[st2];
        }


        int curr = k / 2;

        // Size of array 1 is less than k / 2
        if (curr - 1 >= r - st1) {
            if (A[r - 1] < B[st2 + curr - 1])
            {
                return B[st2 + (k - (r - st1) - 1)];
            }
            else
            {
                return findKthElement(A, B,  k - curr,r,
                        st1, st2 + curr);
            }
        }

        // Size of array 2 is less than k / 2
        if (curr - 1 >= r - st2) {
            if (B[r - 1] < A[st1 + curr - 1])
            {
                return A[st1 + (k - (r - st2) - 1)];
            }
            else
            {
                return findKthElement(A, B,  k - curr,r,
                        st1 + curr, st2);
            }
        }
        else
            if (A[curr + st1-1 ] < B[curr + st2 -1])
            {
                return findKthElement(A, B,  k - curr,r,
                        st1 + curr, st2);
            }
            else
            {
                return findKthElement(A, B,   k - curr,r,
                        st1, st2 + curr);
            }
    }
}
