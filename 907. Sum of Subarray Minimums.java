// 会超时
// class Solution {
//     private static final int MOD = 1000000007;
//     public int sumSubarrayMins(int[] arr) {
//         if (arr == null || arr.length == 0) {
//             return 0;
//         }
//         int n = arr.length;
//         long ans = 0;
//         // 起点
//         for (int i = 0; i < n; i++) {
//             int min = arr[i];
//             // 终点
//             for (int j = i; j < n; j++) {
//                 min = Math.min(min, arr[j]);
//                 ans = (ans + min) % MOD;
//             }
//         }
//         return (int)ans;
//     }
// }

// 作者：yimeixiaobai
// 链接：https://leetcode.cn/problems/sum-of-subarray-minimums/solution/xiao-bai-lang-dong-hua-xiang-jie-bao-zhe-489q/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
// Solution2
class Solution {
    private static final int MOD = 1000000007;
    public int sumSubarrayMins(int[] arr) {
        // 处理边界情况
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        // 每个元素辐射范围的左边界
        int[] left = new int[n];
        // 每个元素辐射范围的右边界
        int[] right = new int[n];
        Deque<Integer> stack = new LinkedList<>();

        // 第一次循环先找到所有元素的左边界
        for (int i = 0; i < n; i++) {
            // 向左找第一个小于等于E的元素
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            // 设立一个最左边界-1
            if (stack.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stack.peek();
            }
            // 下标入栈，方便同时得到i和A[i]
            stack.push(i);
        }

        // 第二次循环找到所有元素的右边界
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            // 向右找第一个小于E的元素
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            // 设立一个最右边界n
            if (stack.isEmpty()) {
                right[i] = n;
            } else {
                right[i] = stack.peek();
            }
            // 下标入栈，方便同时得到i和A[i]
            stack.push(i);
        }

        // 按照贡献度计算即可
        // 注意此处left[i]和right[i]实际上记录的是左边界-1和右边界+1，和上面思路中有些区别，便于计算
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = (ans + (long)(i - left[i]) * (right[i] - i) * arr[i]) % MOD; 
        }
        return (int)ans;
    }
}
