class Solution {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] min = new int[n + 10];
        min[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) min[i] = Math.min(min[i + 1], nums[i]);
        for (int i = 0, max = 0; i < n - 1; i++) {
            max = Math.max(max, nums[i]);
            if (max <= min[i + 1]) return i + 1;
        }
        return -1; // never
    }
}

// 作者：AC_OIer
// 链接：https://leetcode.cn/problems/partition-array-into-disjoint-intervals/solution/by-ac_oier-yyen/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。