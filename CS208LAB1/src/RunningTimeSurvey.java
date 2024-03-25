import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.math.BigInteger;
import java.util.Arrays;

public class RunningTimeSurvey {
    public static void main(String[] args) {
        String[][] taskList = {
                {"LinearTimeTest", "linearTime", "1000"},
                {"LinearTimeCollectionTest", "linearTimeCollection", "1000"},
                {"NLogNTimeTest", "nLogNTime", "100"},
                {"QuadraticTimeTest", "quadraticTime", "100"},
                {"CubicTimeTest", "cubicTime", "100"},
                {"ExponentialTimeTest", "exponentialTime", "10000"},
                {"FactorialTimeTest", "factorialTime", "10000"}
        };

        for (String[] task : taskList) {
            String taskName = task[0];
            int inputSize = Integer.parseInt(task[2]);

            long elapsedTime = measureTime(taskName, inputSize);
            System.out.println(taskName + " for input size " + inputSize + " took " + elapsedTime + " microseconds.");
        }
    }

    public static long measureTime(String taskName, int inputSize) {
        long[] list = new long[inputSize];
        generateList(inputSize, list);

        long startTime = System.nanoTime();
        if (taskName.equals("LinearTimeTest")) {
            linearTime(inputSize, list);
        } else if (taskName.equals("LinearTimeCollectionTest")) {
            linearTimeCollection(inputSize, list);
        } else if (taskName.equals("NLogNTimeTest")) {
            nLogNTime(inputSize, list);
        } else if (taskName.equals("QuadraticTimeTest")) {
            quadraticTime(inputSize, list);
        } else if (taskName.equals("CubicTimeTest")) {
            cubicTime(inputSize, list);
        } else if (taskName.equals("ExponentialTimeTest")) {
            exponentialTime(inputSize);
        } else if (taskName.equals("FactorialTimeTest")) {
            factorialTime(inputSize);
        }
        long endTime = System.nanoTime();

        // 将纳秒转换为微秒
        long elapsedTimeMicroseconds = (endTime - startTime) / 1000;

        return elapsedTimeMicroseconds;
    }

    public static void generateList(int n, long[] list) {
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            list[i] = rand.nextLong();
        }
    }
//找最大值
    public static void linearTime(int n, long[] list) {
        long max = list[0];
        for (int i = 1; i < n; i++) {
            if (list[i] > max) {
                max = list[i];
            }
        }
    }
//找最大值
    public static void linearTimeCollection(int n, long[] list) {
        ArrayList<Long> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrayList.add(list[i]);
        }
        Long max = Collections.max(arrayList);
    }
//排序
    public static void nLogNTime(int n, long[] list) {
        Arrays.sort(list);
    }

    public static void quadraticTime(int n, long[] list) {
        int x=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
              if(list[i]==list[j]){
                  x=x+1;
              }
            }
        }
    }

    public static void cubicTime(int n, long[] list) {
        int x=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (list[i]==list[j]&&list[j]==list[k]){
                        x=x+1;
                    }
                }
            }
        }
    }

    public static void exponentialTime(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 0; i < n; i++) {
            result = result.multiply(BigInteger.valueOf(2));
        }
    }

    public static void factorialTime(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
    }
}
