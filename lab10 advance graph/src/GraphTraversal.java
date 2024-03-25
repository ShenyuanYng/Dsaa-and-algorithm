import java.util.*;

public class GraphTraversal {
    private int n; // 节点数量
    private int k; // 人的数量
    private List<Integer>[] graph; // 图的邻接表表示

    public int countVisitedNodes(int n, int k, int[][] edges, int[] startNodes) {
        this.n = n;
        this.k = k;
        graph = new List[n + 1]; // 节点编号从1开始，所以数组大小为n+1

        // 初始化邻接表
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 构建有向图
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph[from].add(to);
        }

        int[] visitedCount = new int[n + 1]; // 记录每个节点被访问的次数
        for (int i = 0; i < k; i++) {
            int startNode = startNodes[i];
            boolean[] visited = new boolean[n + 1];
            visited[startNode] = true;
            dfs(startNode, visited, visitedCount);
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (visitedCount[i] == k) {
                count++;
            }
        }

        return count;
    }

    private void dfs(int node, boolean[] visited, int[] visitedCount) {
        visitedCount[node]++;

        for (int next : graph[node]) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next, visited, visitedCount);
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int k=input.nextInt();
        int n = input.nextInt(); // 节点数量
        int m = input.nextInt(); // 人的数量
        int[][] edges = new int[m][2];
        int[] startNodes = new int[k];
        for (int i = 0; i <k ; i++) {
            startNodes[i]=input.nextInt();
        }
        for (int i = 0; i <m ; i++) {
            edges[i][0]=input.nextInt();
            edges[i][1]=input.nextInt();
        }

        GraphTraversal graphTraversal = new GraphTraversal();
        int result = graphTraversal.countVisitedNodes(n, k, edges, startNodes);
        System.out.println(result);
    }
}
