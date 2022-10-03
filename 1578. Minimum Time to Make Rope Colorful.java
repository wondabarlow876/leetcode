// 贪心算法
// 根据题意可以知道，如果字符串 colors 中有若干相邻的重复颜色，则这些颜色中最多只能保留一个。因此，我们可以采取贪心的策略：在这一系列重复颜色中，我们保留删除成本最高的颜色，并删除其他颜色。这样得到的删除成本一定是最低的。

class Solution {
    public int minCost(String colors, int[] neededTime) {
        int i = 0, len = colors.length();
        int ret = 0;
        while (i < len) {
            char ch = colors.charAt(i);
            int maxValue = 0;
            int sum = 0;

            while (i < len && colors.charAt(i) == ch) {
                maxValue = Math.max(maxValue, neededTime[i]);
                sum += neededTime[i];
                i++;
            }
            ret += sum - maxValue;
        }
        return ret;
    }
}
