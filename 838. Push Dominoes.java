class Solution {
    // 题目等价于： 「一个推倒了的牌只能对另一个站着的牌起作用」
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
                    if ((right - left + 1) % 2 == 1){
                        // 中间可能要置为 '.'
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
        return new String(chars, 1, chars.length - 2);
    }
    // 这个函数极其简单，就是模拟推倒
    private void update(char[] chars, int L, int R) {
        int left = L, right = R;
        while (left <= right) {
            chars[left] = chars[L];
            chars[right] = chars[R];
            left++;
            right--;
        }
    }
}