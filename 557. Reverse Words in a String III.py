# 557. Reverse Words in a String III
# Idea: String, two pointers
# One line code

# ' '.join 字符串->数组
# i[::-1] 单个单词反转
# for i in s 遍历字符串
# s.split(' ') 字符串按照空格分割成（可遍历的）数组
# 连起来就是 把字符串按照空格分割成（可遍历的）数组，把数组里的每个单词字符串反序（改变字符串，不开辟新空间，然后再把数组转变成字符串）
class Solution:
    def reverseWords(self, s: str) -> str:
        return ' '.join([i[::-1] for i in s.split(' ')])

