// Solution1
// Sort 排序
// 时间复杂度：O(nlog n)，因为排序复杂度为O(nlogn)
// 空间复杂度：O(log n)。在某些语言（比如 Java & JavaScript）中字符串是不可变的，因此需要额外的 O(n) 的空间来拷贝字符串。但是忽略这一复杂度分析，因为这依赖于具体实现方式和细节


class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        // 如果长度不同，返回false
        if (s1.length() != s2.length()) {
            return false;
        }
        // string转为array，将array排序
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        // 判断arrary是否相同
        return Arrays.equals(str1, str2);
    }
}
// Solution1 问题? 那如果s2中的频次小于s1中的频次怎么办呢？？？

// Solution2
// 哈希表
// 从另一个角度考虑，字符串s1 和 s2 互为字符重排等价于「两个字符串中字符出现的种类和次数均相等」。
// 由于字符串只包含 128128 种不同的字符，因此我们可以维护一个长度为 128128 的频次数组 table。先遍历记录字符串 s1 中字符出现的频次，然后遍历字符串
// s2, 减去 table 中对应的频次，如果出现 table[i]<0, 返回false
class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        // 一个长度为128的 table
        int[] table = new int[128];
        // 遍历 s1, 给 table 加上 s1 里出现的字符
        for (int i = 0; i < s1.length(); i++) {
            table[s1.charAt(i)]++;
        }
        // 遍历 s2, 在table 里减去 s2 里的字符
        for (int i = 0; i < s2.length(); i++) {
            table[s2.charAt(i)]--;
            // 如果存在字符在 s2 中 的频次超过了 s1 中出现的频次， 返回false
            if (table[s2.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }
}


// Solution3
// Solution2的简化写法
// 注意语法，
class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] table = new int[128];
        // 遍历 s1, 给 table 加上 s1 里出现的字符
        for (char c : s1.toCharArray()) {
            ++table[c - 'a']; // 这里 ++a 和 a++ 没有区别
        }
        for (char c : s2.toCharArray()) {
            // 这里必须 --a，因为是先减去已经有的一个频次，再判断大小
            if (--table[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
