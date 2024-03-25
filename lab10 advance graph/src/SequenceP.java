import java.util.*;

public class SequenceP {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();  // 序列 P 的元素个数
        int M = input.nextInt();  // 条件的个数

        // 条件列表，每个条件是由两个数 A 和 B 组成
        int[][] conditions = new int[M][2];
        for (int i = 0; i <M ; i++) {
            conditions[i][0]=input.nextInt();
            conditions[i][1]=input.nextInt();
        }
        List<Integer> sequenceP = findValidSequence(N, M, conditions);

        if (sequenceP == null) {
            System.out.println(-1);
        } else {
            for (int num : sequenceP) {
                System.out.print(num + " ");
            }
        }
    }

    private static List<Integer> findValidSequence(int N, int M, int[][] conditions) {
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        int[] inDegree = new int[N + 1];

        for (int[] condition : conditions) {
            int A = condition[0];
            int B = condition[1];

            adjacencyList.computeIfAbsent(A, k -> new ArrayList<>()).add(B);
            inDegree[B]++;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> sequenceP = new ArrayList<>();
        while (!queue.isEmpty()) {
            int num = queue.poll();
            sequenceP.add(num);

            List<Integer> neighbors = adjacencyList.getOrDefault(num, new ArrayList<>());
            for (int neighbor : neighbors) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        if (sequenceP.size() == N) {
            return sequenceP;
        } else {
            return null;
        }
    }
}
