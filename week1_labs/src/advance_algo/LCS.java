package intermediate.src.week1_labs.advance_algo;

public class LCS {
    // Function to find the length of Longest Common Subsequence(LCS) and return the LCS string
    public static String findLCS(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        
        // Create a 2D array to store lengths of longest common subsequence
        int[][] dp = new int[m + 1][n + 1];
        
        // Fill dp array
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1; // Characters match
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // Characters don't match
                }
            }
        }
        
        // Construct the LCS string from the dp table
        StringBuilder lcs = new StringBuilder();
        int i = m;
        int j = n;
        
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                lcs.append(str1.charAt(i - 1)); // Add to LCS
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--; // Move up in the table
            } else {
                j--; // Move left in the table
            }
        }
        
        // Since we constructed the LCS from the end, we need to reverse it
        lcs.reverse();
        return lcs.toString();
    }
    
    public static void main(String[] args) {
        String str1 = "TAGGABLE";
        String str2 = "GXTXAYB";
        
        // Find and print the LCS
        String lcs = findLCS(str1, str2);
        System.out.println("Longest Common Subsequence: " + lcs);
    }
}
