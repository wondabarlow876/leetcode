class Solution:
    def countAndSay(self, n: int) -> str:
        prev = "1"
        for i in range(n-1):
            curr = ""
            pos = 0
            start = 0

            while pos < len(prev):
                while pos < len(prev) and prev[pos] == prev[start]:
                    pos += 1
                curr += str(pos - start) + prev[start]
                start = pos
            prev = curr
        
        return prev

# 作者：LeetCode-Solution
# 链接：https://leetcode.cn/problems/count-and-say/solution/wai-guan-shu-lie-by-leetcode-solution-9rt8/
# 来源：力扣（LeetCode）
# 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。