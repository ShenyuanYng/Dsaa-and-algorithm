import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Job {
    int start;
    int finish;
    int weight;

    public Job(int start, int finish, int weight) {
        this.start = start;
        this.finish = finish;
        this.weight = weight;
    }
}

public class WeightedIntervalScheduling {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = scanner.nextInt();
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int finish = scanner.nextInt();
            int weight = scanner.nextInt();
            jobs[i] = new Job(start, finish, weight);
        }


        Arrays.sort(jobs, Comparator.comparingInt(job -> job.finish));

        // 计算最大权重
        int[] dp = new int[n];
        dp[0] = jobs[0].weight;
        for (int i = 1; i < n; i++) {
            int currentWeight = jobs[i].weight;
            int latestCompatible = findLatestCompatibleJob(jobs, i);
            if (latestCompatible != -1) {
                currentWeight += dp[latestCompatible];
            }
            dp[i] = Math.max(currentWeight, dp[i - 1]);
        }


        System.out.println(dp[n - 1]);
    }

    private static int findLatestCompatibleJob(Job[] jobs, int currentIndex) {
        int low = 0, high = currentIndex - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (jobs[mid].finish <= jobs[currentIndex].start) {
                if (jobs[mid + 1].finish <= jobs[currentIndex].start) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
