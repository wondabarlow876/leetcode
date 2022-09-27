// 面试题 17.09. 第 k 个数
// https://leetcode.cn/problems/get-kth-magic-number-lcci/

// 定义数组 dp，其中 dp[i] 表示第 i 个数，第 k 个数即为 dp[k]。
// 如何得到其余的数呢？定义三个指针 p3,p5,p7, 表示下一个数是当前指针指向的数乘以对应的质因数。初始时，三个指针的值都是 11。
// 当 2<= i <= k 时，令dp[i] = min(dp[p3]*3, dp[p5]*5, dp[p7]*7),然后分别比较 dp[i]和dp[p3]*3, dp[p5]*5, dp[p7]*7是否相等，如果相等，对应指数+1
// 时间复杂度：O(k)。需要计算数组 dp 中的 k 个元素，每个元素的计算都可以在 O(1)的时间内完成。
// 空间复杂度：O(k)。空间复杂度主要取决于数组 dp 的大小。

class Solution {
    public int getKthMagicNumber(int k) {
        // 申明一个长度为k+1的数组（因为题目中k从1开始）
        int[] dp = new int[k + 1];
        // 赋值,注意从1开始
        dp[1] = 1;
        // 定义三个指针
        int p3 = 1, p5 = 1, p7 = 1;
        for (int i = 2; i <= k; i++) {
            int num3 = dp[p3] * 3, num5 = dp[p5] * 5, num7 = dp[p7] * 7;
            // 求三个数的min，套两层 Math.min()
            dp[i] = Math.min(Math.min(num3, num5), num7);
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
            if (dp[i] == num7) {
                p7++;
            }
        }
        return dp[k];
    }
}