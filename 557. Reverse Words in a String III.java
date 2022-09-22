// 557. Reverse Words in a String III
// 方法一：使用额外空间
// 思路与算法

// 开辟一个新字符串。然后从头到尾遍历原字符串，直到找到空格为止，此时找到了一个单词，并能得到单词的起止位置。随后，根据单词的起止位置，可以将该单词逆序放到新字符串当中。如此循环多次，直到遍历完原字符串，就能得到翻转后的结果。
// 复杂度分析

// 时间复杂度：O(N)O(N)，其中 NN 为字符串的长度。原字符串中的每个字符都会在 O(1)O(1) 的时间内放入新字符串中。
// 空间复杂度：O(N)O(N)。我们开辟了与原字符串等大的空间。


class Solution {
    public String reverseWords(String s) {
        // 申明一个可变的StringBuffer变量（String 类型不可变
        StringBuffer ret = new StringBuffer();
        int length = s.length();
        int i = 0;
        while (i < length) {
            // start是单词的的起始索引
            int start = i;
            // 遍历单词，遇到空格就停止，i是第一个空格的索引
            while (i < length && s.charAt(i) != ' ') {
                i++;
            }
            // 给StringBuffer变量赋值反转的单词
            for (int p = start; p < i; p++) {
                ret.append(s.charAt(start + i - 1 - p));
            }
            // 遍历单词，当遇到空格的时候，索引+1，给StringBuffer变量赋值空格
            while (i < length && s.charAt(i) == ' ') {
                i++;
                ret.append(' ');
            }
        }
        return ret.toString();
    }
}
