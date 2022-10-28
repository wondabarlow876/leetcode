class Solution {
    public int arraySign(int[] nums) {
        int sign = 1;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            }
            if (num < 0) {
                sign = -sign;
            }
        }
        return sign;
    }
}


// 作者：LeetCode-Solution
// 链接：https://leetcode.cn/problems/sign-of-the-product-of-an-array/solution/shu-zu-yuan-su-ji-de-fu-hao-by-leetcode-f4uuj/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。