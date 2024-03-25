import java.util.*;

public class ProjectMaxProfit {
    private static int maxProfit = Integer.MIN_VALUE;
    private static Map<Integer, List<Integer>> graph = new HashMap<>();
    private static int[] projectRevenues;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  // Number of projects
        int m = scanner.nextInt();  // Number of prerequisites
        projectRevenues = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            projectRevenues[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        scanner.close();

        // Start DFS from each project
        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            dfs(i, visited, 0);
        }
        System.out.println(maxProfit);
    }

    private static void dfs(int current, boolean[] visited, int currentProfit) {
        visited[current] = true;
        currentProfit += projectRevenues[current];

        // Update the maxProfit if it's the end of the path or no more prerequisites
        if (!graph.containsKey(current) || graph.get(current).isEmpty()) {
            maxProfit = Math.max(maxProfit, currentProfit);
        } else {
            for (int next : graph.get(current)) {
                if (!visited[next]) {
                    dfs(next, visited, currentProfit);
                }
            }
        }

        // Backtrack
        visited[current] = false;
        currentProfit -= projectRevenues[current];
    }
}