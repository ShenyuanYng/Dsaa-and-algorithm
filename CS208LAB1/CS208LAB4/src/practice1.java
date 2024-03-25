import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class practice1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] iValues = new int[N];
        int[] aValues = new int[N];

        for (int i = 0; i < N; i++) {
            iValues[i] = scanner.nextInt();
        }

        for (int i = 0; i < N; i++) {
            aValues[i] = scanner.nextInt();
        }

        int[] shortestTimes = new int[N];
        boolean[] visited = new boolean[N];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            shortestTimes[i] = Integer.MAX_VALUE;
        }
        shortestTimes[0] = 0;

        queue.add(0);

        while (!queue.isEmpty()) {
            int currentCheckpoint = queue.poll();
            visited[currentCheckpoint] = true;


            if (currentCheckpoint + 1 < N && !visited[currentCheckpoint + 1]) {
                int newTime = shortestTimes[currentCheckpoint] + 1;
                if (newTime < shortestTimes[currentCheckpoint + 1]) {
                    shortestTimes[currentCheckpoint + 1] = newTime;
                    queue.add(currentCheckpoint + 1);
                }
            }


            if (aValues[currentCheckpoint] > currentCheckpoint && aValues[currentCheckpoint] < N && !visited[aValues[currentCheckpoint]]) {
                int newTime = shortestTimes[currentCheckpoint] + 1;
                if (newTime < shortestTimes[aValues[currentCheckpoint]]) {
                    shortestTimes[aValues[currentCheckpoint]] = newTime;
                    queue.add(aValues[currentCheckpoint]);
                }
            }

        }


        for (int i = 0; i < N; i++) {
            System.out.print(shortestTimes[i]+" ");
        }
    }
}
