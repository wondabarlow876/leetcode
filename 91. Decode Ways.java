// 动态规划
// 时间复杂度 O（n）
// 时间复杂度 O（n）or O（1）
class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        // 定义 一个数组
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; ++i) {
            // s[i] != '0',  
            if (s.charAt(i - 1) != '0') {
                f[i] += f[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                f[i] += f[i - 2];
            }
        }
        return f[n];
    }
}
