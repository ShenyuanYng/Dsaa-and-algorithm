public class LongestCommonSubsequence {

    public static String findLCS(String X, String Y) {
        int m = X.length();
        int n = Y.length();


        int[][] lcsTable = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    lcsTable[i][j] = 0;
                } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    lcsTable[i][j] = lcsTable[i - 1][j - 1] + 1;
                } else {
                    lcsTable[i][j] = Math.max(lcsTable[i - 1][j], lcsTable[i][j - 1]);
                }
            }
        }

        int i = m, j = n;
        StringBuilder lcs = new StringBuilder();
        while (i > 0 && j > 0) {
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                lcs.insert(0, X.charAt(i - 1));
                i--;
                j--;
            } else if (lcsTable[i - 1][j] >= lcsTable[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return lcs.toString();
    }

    public static void main(String[] args) {
        String S1 = "ABCBDAB";
        String S2 = "BDCABA";

        String lcs = findLCS(S1, S2);
        System.out.println(lcs);
    }
}
