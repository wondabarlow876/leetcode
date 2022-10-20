// 方法三：找规律 + 位运算
class Solution {
    public int kthGrammar(int n, int k) {
        // return Integer.bitCount(k - 1) & 1;
        k--;
        int res = 0;
        while (k > 0) {
            k &= k - 1;
            res ^= 1;
        }
        return res;
    }
}

// 作者：LeetCode-Solution
// 链接：https://leetcode.cn/problems/k-th-symbol-in-grammar/solution/di-kge-yu-fa-fu-hao-by-leetcode-solution-zgwd/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。