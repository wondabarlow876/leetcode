// 这题非常简单，题目等价于判断是否存在“01”字符串

class Solution {
    public boolean checkOnesSegment(String s) {
        return !s.contains("01");
    }
}
