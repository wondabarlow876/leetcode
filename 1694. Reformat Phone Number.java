// Solution1
class Solution {
    public String reformatNumber(String number) {
        // 申明一个 StringBuilder 类型的变量，StringBuilder的特点：快，线程不安全
        StringBuilder result = new StringBuilder();
        int count = 0;
        for (int i = 0; i < number.length(); i ++) {
            // 去掉 空格和破折号
            // continue 结束本层的本次循环
            // 当遇到非数字直接结束本次循环，遇到数字就append到result里
            if (number.charAt(i) < '0' || number.charAt(i) > '9') continue;
            // count累计到3的倍数，就append一个char类型‘-’
            if (count != 0 && count % 3 == 0) result.append('-');
            result.append(number.charAt(i));
            count++;
        }
        // 最后剩下4个数字
        if (count % 3 == 1) {
            // 删掉倒数第二个‘-’
            result.deleteCharAt(result.length() - 2);
            // 在倒数第二个字符的位置插入 char字符 ‘c’
            result.insert(result.length() - 2, '-');
        }
        // stringbuilder 转换成 string
        return result.toString();
    }
}

// Solution2
class Solution {
    public String reformatNumber(String number) {
        StringBuilder digits = new StringBuilder();
        for (int i = 0; i < number.length(); ++i) {
            char ch = number.charAt(i);
            if (Character.isDigit(ch)) {
                digits.append(ch);
            }
        }

        int n = digits.length();
        int pt = 0;
        StringBuilder ans = new StringBuilder();
        while (n > 0) {
            if (n > 4) {
                ans.append(digits.substring(pt, pt + 3) + "-");
                pt += 3;
                n -= 3;
            } else {
                if (n == 4) {
                    ans.append(digits.substring(pt, pt + 2) + "-" + digits.substring(pt + 2, pt + 4));
                } else {
                    ans.append(digits.substring(pt, pt + n));
                }
                break;
            }
        }
        return ans.toString();
    }
}
