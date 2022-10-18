class Solution {
    public boolean isPerfectSquare(int num) {
        int left = 0, right = num;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            long square = (long) mid * mid;`
            if (square < num) {
                left = mid + 1;
            } else if (square > num) {class Solution {
    public boolean checkIfPangram(String sentence) {
        int res = 0;
        for ( char c : sentence.toCharArray()) {
            res |= 1 << (c - 'a');
            if ((res ^ 0x3ffffff) == 0) {
                return true;
            }
        }
        return false;
    }
}


            } else {
                return true;
            }
        }
        return false;
    }
}

// 作者：LeetCode-Solution
// 链接：https://leetcode.cn/problems/valid-perfect-square/solution/you-xiao-de-wan-quan-ping-fang-shu-by-le-wkee/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

