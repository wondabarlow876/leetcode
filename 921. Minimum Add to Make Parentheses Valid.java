// 贪心， 栈
class Solution {
    public int minAddToMakeValid(String s) {
        int ans = 0;
        int leftCount = 0;
        int length = s.length();
        // 遍历字符串
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            // 如果为左括号，则leftCount++
            if (c == '(') {
                leftCount++;
            } else {
                // 如果为右括号，抵消掉一个左边括号，如果没有左括号，则ans+1
                if (leftCount > 0) {
                    leftCount--;
                } else {
                    ans++;
                }
            }
        }
        // 经过前面的匹配，可能还有剩下的左括号，需要匹配相同相同数量的右括号
        ans += leftCount;
        return ans;
    }
}
