import java.util.*;
import java.util.Scanner;

public class q4 {
    static int n;
    static ArrayList<Integer>[] adjList;
    static int[] depths;
    static int[] parents;
    static int farthest;
    static int maxDepth;
    static int result;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<Integer>();
        }

        for (int i=0; i<n-1; i++){
            adjList[input.nextInt()-1].add(input.nextInt()-1);
        }
        for (int i=0; i<n; i++) {
            for (int node: adjList[i]) {
                adjList[node].add(i);
            }
        }

        depths = new int[n];
        parents = new int[n];
        farthest = 0;
        maxDepth = 0;
        result = findLongestPath();
        System.out.println(result);
    }


    public static void dfs(int root, int parent, int depth) {
        depths[root] = depth;
        parents[root] = parent;
        for (int neighbor : adjList[root]) {
            if (neighbor != parent) {
                dfs(neighbor, root, depth + 1);
            }
        }
    }


    public static void findFarthest(int start) {
        dfs(start, -1, 0);
        for (int node = 0; node < n; node++) {
            if (depths[node] > maxDepth) {
                farthest = node;
                maxDepth = depths[node];
            }
        }
    }

    public static int findLongestPath() {
        findFarthest(0);
        int v1 = farthest;
        maxDepth = 0;
        findFarthest(v1);
        int v2 = farthest;
        return maxDepth;
    }
}
