public class EditDistance {

    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }
        int w1 = word1.length();
        int w2 = word2.length();
        int[][] dp = new int[w1 + 1][w2 + 1];
        for (int i = 0; i <= w1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= w2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= w1; i++) {
            for (int j = 1; j <= w2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }
            }
        }
        return dp[w1][w2];
    }
}
