/**
 * Created by Larry Liu on 11/22/2017.
 * 471. Encode String with Shortest Length
 */
public class p471 {
    public String encode(String s) {
        String[][] dp = new String[s.length()][s.length()];

        for (int l = 0; l < s.length(); l++) {
            for (int i = 0; i < s.length() - l; i++) {
                int j = i + l;
                String subStr = s.substring(i, j+1);
                if (subStr.length() < 5) {
                    dp[i][j] = subStr;
                } else {
                    // Loop through all possible combinations
                    dp[i][j] = subStr;
                    for (int k = i; k < j; k++) {
                        if (dp[i][k].length() + dp[k + 1][j].length() < dp[i][j].length()) {
                            dp[i][j] = dp[i][k] + dp[k + 1][j];
                        }
                    }
                    // Loop for checking if subStr contains pattern
                    String temp = (subStr + subStr).substring(1, subStr.length() * 2 - 1);
                    if (temp.contains(subStr)) {
                        int end = temp.indexOf(subStr) + 1;
                        String pattern = dp[i][i+end-1];
                        String res = String.format("%d[%s]", subStr.length() / end, pattern);
                        if (res.length() < dp[i][j].length())
                            dp[i][j] = res;
                    }
                }
            }
        }

        return dp[0][s.length()-1];
    }

    public static void main(String[] args) {
        p471 sol = new p471();
        System.out.println(sol.encode("abbbabbbcabbbabbbc"));
    }
}
