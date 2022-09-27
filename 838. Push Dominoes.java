class Solution {
    // 题目等价于： 「一个推倒了的牌只能对另一个站着的牌起作用」
    // 含义1. 两个相邻的被推倒的牌互不影响。
    // 含义2. 一张站立的牌（"."）的最终状态与离其两侧最近的 "L" 或 "R" 有关。
    // 思路：
    //      首先，边界条件不好判断，直接左边加'L',右边加上'R',不会对结果造成影响，最后记得去掉
    //      然后，总共四种情况  L.....L => LLLLLLL
    //                        L.....R => L.....R
    //                        R.....L => RRR.LLL
    //                        R.....R => RRRRRRR
    // 举例：.L.R...LR..L..
    //              首尾添加LR=> L.L.R...LR..L..R
    //                一番操作=> LLL.RR.LLRRLL..R
    //              首尾减去LR=>  LL.RR.LLRRLL..
    public String pushDominoes(String dominoes) {
        dominoes = 'L' + dominoes + 'R';
        char[] chars = dominoes.toCharArray();
        // 最小长度为3，不用担心越界
        int left = 0, right = 1;
        while (right < chars.length) {
            while (chars[right] == '.') {
                right++;
            }
            if (chars[left] == chars[right]) {
                // 这两种情况
                //        L.....L => LLLLLLL
                //        R.....R => RRRRRRR
                update(chars, left, right);
            } else {
                // 这种情况 R.....L => RRR.LLL
                if (chars[left] == 'R') {
                    update(chars, left, right);
                    // 区间长度为奇数
                    if ((right - left + 1) % 2 == 1){
                        // 中间可能要置为 '.'
                        // >> 1,位移操作符，右移1位除以2
                        chars[left + right >> 1] = '.';
                    }
                }
                // 这种情况 L.....R => L.....R
                // 什么都不做就行
            }
            // 操作完，进入下一个
            left = right;
            right = right + 1;
        }
        //参数： bytes：要解码为字符的 byte , offset： 要解码的第一个 byte 的索引, length： 要解码的 byte 数 的长度

        return new String(chars, 1, chars.length - 2);
    }
    // 这个函数极其简单，就是模拟推倒， 一边倒
    private void update(char[] chars, int L, int R) {
        // 记录下区间初始状态
        int left = L, right = R;
        // 判断条件必须为 <= ，首尾相遇才行，先执行运算，再++ --
        while (left <= right) {
            chars[left] = chars[L];
            chars[right] = chars[R];
            left++;
            right--;
        }
    }
}