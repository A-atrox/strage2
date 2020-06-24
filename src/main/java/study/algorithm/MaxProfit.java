package study.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @创建人 guoyf
 * @创建时间 2020/6/19
 * @描述
 */
public class MaxProfit {
    private int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            maxprofit += Math.max(prices[i + 1] - prices[i], 0);
        }
        return maxprofit;
    }

    private static int minDeletionSize(String[] A) {
        if (A.length == 0) {
            return 0;
        }
        int sum = 0;

        Map<Integer, Character> map = new HashMap<>();
        int j = 0;
        while (j < A[0].toCharArray().length) {
            for (int row = 0; row < A.length - 2; row++) {
                if (A[row + 1].charAt(j) < A[row].charAt(j) && !map.containsKey(j)) {
                    map.put(j, 'c');
                    sum++;
                    break;
                }
                j++;
            }
        }
        return sum;
    }

    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        char[] str = s.toCharArray();
        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[len][len];
        // dp[i][j]表示字串的i到j是否是回文子串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        // 按列去填 一列一列的填
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (str[i] != str[j]) {
                    // 如果不相等那么dp[i][j] 就为false也就是说明子串以i开头j结尾的不是回文串
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }


    public static String changeStr(String s) {
        char[] c = s.toCharArray();
        StringBuffer str = new StringBuffer();
        str.append("#");
        for (char x : c) {
            str.append(x);
            str.append("#");
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String s = "ababbbbaccc";
        System.out.println(longestPalindrome(s));
    }
}
