import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class q1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
    int n=input.nextInt();
    int m=input.nextInt();
    char[][]matrix=new char[n][m];
        for (int i = 0; i <n ; i++) {
            String STR=input.next();
            for (int j = 0; j <m ; j++) {
                matrix[i][j]=STR.charAt(j);
            }

        }

        PondCounter pondCounter = new PondCounter();
        int pondCount = pondCounter.countPonds(matrix);

        System.out.println(pondCount);
    }
}
 class PondCounter {
    public int countPonds(char[][] matrix) {
        int count = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 'W') {
                    count++;
                    dfs(matrix, i, j);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] matrix, int row, int col) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if (row < 0 || row >= rows || col < 0 || col >= cols || matrix[row][col] != 'W') {
            return;
        }

        matrix[row][col] = 'l';  // 将已访问的水域标记为'.'，避免重复计数

        // 遍历周围的8个位置
        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < 8; i++) {
            int newRow = row + dr[i];
            int newCol = col + dc[i];
            dfs(matrix, newRow, newCol);
        }
    }
}

/* Scanner input = new Scanner(System.in);
        int N = input.nextInt();  // 序列 P 的元素个数
        int M = input.nextInt();  // 条件的个数

        // 条件列表，每个条件是由两个数 A 和 B 组成
        int[][] conditions = new int[M][2];
        for (int i = 0; i <M ; i++) {
            conditions[i][0]=input.nextInt();
            conditions[i][1]=input.nextInt();
        }*/




