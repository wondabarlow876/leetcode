/* 
我的思路
1.回文串一定是对称的
2.只要从头遍历第一个不是a的字符换成a就可以
3.寻找上一条的漏洞并堵死
4.可能的漏洞，4.1变成a以后又变成了回文串
4.1.1 变成a以后还是回文串，不可能
emmm这题不会这么简单吧一定有坑
看了分析，果然有坑，
如果全文是a，最后一个字符变成b就行
*/ 

class Solution {
    public String breakPalindrome(String palindrome) {
        char[] s = palindrome.toCharArray();
        int n = s.length;

        for (int i = 0; i < n / 2; i++) {
            if (s[i] != 'a') {
                s[i] = 'a';
                return String.valueOf(s);
            }
        }
        s[n - 1] = 'b'; //if all 'a'
        return n < 2 ? "" : String.valueOf(s);
    }

}
