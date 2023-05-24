package org.example;

/**
 * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "aa" p = "a"
 * <p>
 * 输出: false
 * <p>
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * <p>
 * 示例 2:
 * <p>
 * 输入: s = "aa" p = "a*"
 * <p>
 * 输出: true
 * <p>
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * <p>
 * 示例 3:
 * <p>
 * 输入: s = "ab" p = ".*"
 * <p>
 * 输出: true
 * <p>
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * <p>
 * 示例 4:
 * <p>
 * 输入: s = "aab" p = "c*a*b"
 * <p>
 * 输出: true
 * <p>
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * <p>
 * 示例 5:
 * <p>
 * 输入: s = "mississippi" p = "mis*is*p*."
 * <p>
 * 输出: false
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母以及字符 . 和 *，无连续的 '*'。
 */
public class Solution19 {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        int m = s.length(), n = p.length();
        // p 为空时检查 s 是否为空
        if (n == 0) return m == 0;
        /*
         * 状态转移方程：
         * 如果 p[j-1] 是普通字符(!='*') 则 s[i-1] == p[j-1] => dp[i][j] = dp[i - 1][j - 1] 否则 dp[i][j] = false
         * 如果 p[j-1] 是'*' 表示 p[j-2] 可以出现任意次
         *     若 s[i-1] 和 p[j-2] 匹配
         *         则可以选择使用 '*' 或不使用 '*' 即 dp[i][j] = dp[i-1][j] || dp[i][j-2]
         *         否则只能不使用 '*'，即 dp[i][j] = dp[i][j-2]
         */
        // 记录状态
        boolean[][] dp = new boolean[m + 1][n + 1];
        // 初始状态
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            // j 从 1 开始
            for (int j = 1; j <= n; j++) {
                char c1 = p.charAt(j - 1);
                if (c1 != '*') {
                    if (i >= 1 && (c1 == s.charAt(i - 1) || c1 == '.')) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else if (j >= 2) {
                    char c2 = p.charAt(j - 2);
                    if (i >= 1 && (c2 == s.charAt(i - 1) || c2 == '.')) {
                        dp[i][j] = dp[i - 1][j];
                    }
                    dp[i][j] |= dp[i][j - 2];
                }
            }
        }
        return dp[m][n];
    }
}
