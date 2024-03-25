import java.util.*;

public class practice2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x1 = sc.nextInt() + n / 2;
        int y1 = sc.nextInt() + n / 2;
        int x2 = sc.nextInt() + n / 2;
        int y2 = sc.nextInt() + n / 2;
        Node startNode = new Node(x1, y1, 0, null);

        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n + 1][n + 1];

        queue.add(startNode);
        visited[x1][y1] = true;

        int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
        int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};

        Node node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node.x == x2 && node.y == y2) {
                break;
            }

            for (int i = 0; i < 8; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx >= 0 && nx <= n && ny >= 0 && ny <= n && !visited[nx][ny]) {
                    queue.add(new Node(nx, ny, node.d + 1, node));
                    visited[nx][ny] = true;
                }
            }
        }

        System.out.println(node.d);
        while (node != null) {
            System.out.println((node.x - n / 2) + " " + (node.y - n / 2));
            node = node.fatherNode;
        }
    }
}

class Node {
    public int x;
    public int y;
    public int d;
    public Node fatherNode;

    public Node(int x, int y, int d, Node node) {
        this.x = x;
        this.y = y;
        this.d = d;
        this.fatherNode = node;
    }
}
