import java.util.Scanner;
import java.io.*;
import java.util.*;
public class q3_2 {
    public static void main(String[] args) {
        QReader input = new QReader();
        QWriter out = new QWriter();
        int number = input.nextInt();
        int k = input.nextInt();
        int[] array = new int[number];
        for (int i = 0; i < number; i++) {
            array[i] = input.nextInt();
        }
        quickSelect (array,number-k+1);
       out.print(array[number-k]);
       out.close();

    }

    public static int quickSelect(int[] nums, int k) {
        int i = 0;
        int j = nums.length - 1;
        while(i <= j) {
            int partitionIdx = partition(nums, i, j);

            if((k - 1) == partitionIdx) {
                return nums[partitionIdx];
            }
            else if((k - 1) < partitionIdx) {
                j = partitionIdx - 1;
            }
            else {
                i = partitionIdx + 1;
            }
        }

        return 0;
    }
    public static int partition(int[] nums, int start, int end) {
        if(start == end) {
            return start;
        }
        Random random = new Random();
        int ran = random.nextInt(end-start)+start;

        int pivot = nums[ran];
        swap(nums,ran,start);
        while(start < end) {
            while(start < end && nums[end] >= pivot) {
                end--;
            }
            nums[start] = nums[end];
            while(start < end && nums[start] <= pivot) {
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = pivot;
        return start;
    }
    public static void swap(int[] array,int ran,int low) {
        int temp = array[ran];
        array[ran] = array[low];
        array[low] = temp;
    }

}


class Untitled {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        while (in.hasNext()) {
            int x = in.nextInt();
            out.println(x);
        }
        out.close();
    }
}

class QReader {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer tokenizer = new StringTokenizer("");

    private String innerNextLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    public boolean hasNext() {
        while (!tokenizer.hasMoreTokens()) {
            String nextLine = innerNextLine();
            if (nextLine == null) {
                return false;
            }
            tokenizer = new StringTokenizer(nextLine);
        }
        return true;
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
    private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

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
}





