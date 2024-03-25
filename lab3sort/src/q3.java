import java.io.*;
import java.util.*;

public class q3 {
    public static void main(String[] args) {
        QReader input = new QReader();
     //   QWriter out=new QWriter();
        int number = input.nextInt();
        int k=input.nextInt();
        long[] arr =new long[number];
        for (int i = 0; i <number ; i++) {
            arr[i]=input.nextInt();
        }
        sort(arr,0,number-1);
        System.out.println(arr[number-k]);
    }

    public static void sort(long[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = (right+left)/2;
        sort(arr, left, mid);
        sort(arr, mid +1, right);
        merge(arr, left, mid+1, right);
    }

    public static void merge(long[] arr, int leftPtr, int rightPtr, int rightBound) {
        int mid = rightPtr - 1;
        long[] temp = new long[rightBound - leftPtr + 1];
        int i = leftPtr;
        int j = rightPtr;
        int k = 0;
        while (i <= mid && j <= rightBound) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= rightBound) {
            temp[k++] = arr[j++];
        }
        System.arraycopy(temp, 0, arr, leftPtr, temp.length);
    }
}
/*class QReader {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer tokenizer = new StringTokenizer("");

    private String innerNextLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    public void hasNext() {
        while (!tokenizer.hasMoreTokens()) {
            String nextLine = innerNextLine();
            if (nextLine == null) {
                return;
            }
            tokenizer = new StringTokenizer(nextLine);
        }
    }

    public String nextLine() {
        tokenizer = new StringTokenizer("");
        return innerNextLine();
    }

    public String next() {
        hasNext();
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }
}

class QWriter implements Closeable {
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public void print(Object object) {
        try {
            writer.write(object.toString());
        } catch (IOException e) {
            return;
        }
    }

    public void println(Object object) {
        try {
            writer.write(object.toString());
            writer.write("\n");
        } catch (IOException e) {
            return;
        }
    }

    @Override
    public void close() {
        try {
            writer.close();
        } catch (IOException e) {
            return;
        }
    }
}*/
