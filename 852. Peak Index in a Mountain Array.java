// 找到山峰的索引下标，山峰的意思是数组先递增再递减
// Time complexity: O(logn)
// Space complexity: O(1)
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        // 细节，right = n-2, 为啥我也没想明白
        int left = 1, right = n - 2, ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > arr[mid + 1]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}

// 作者：LeetCode-Solution
// 链接：https://leetcode.cn/problems/peak-index-in-a-mountain-array/solution/shan-mai-shu-zu-de-feng-ding-suo-yin-by-dtqvv/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
