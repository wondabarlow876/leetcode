
// 根据题意，ss 的分数与 11 分的 ()有关。对于每个()，它的最终分数与它所处的深度有关，如果深度为bal
//  。我们统计所有 ()() 的最终分数和即可。

// 作者：LeetCode-Solution
// 链接：https://leetcode.cn/problems/score-of-parentheses/solution/gua-hao-de-fen-shu-by-leetcode-solution-we6b/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

class Solution {
    public int scoreOfParentheses(String s) {
        int bal = 0, n = s.length(), res = 0;
        for (int i = 0; i < n; i++) {
            bal += (s.charAt(i) == '(' ? 1 : -1);
            if (s.charAt(i) == ')' && s.charAt(i - 1) == '(') {
                res += 1 << bal;
            }
        }
        return res;
    }


}
