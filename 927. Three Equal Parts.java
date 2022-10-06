// 条件1: 1的个数能被3整除
// 条件2: 对于二进制来说，影响最终结果的其实是“1”后面的“0”的个数，所以每个分组中的最后那个“1”后面就必须有相同数量的“0”，由此可以从最后一个1的索引到最后一个0为一个区间

class Solution {
    public int[] threeEqualParts(int[] arr) {
        // 用于记录每个“1”所在arr中的位置（index）
        int[] record = new int[arr.length + 1];
        int oneCount = 0;
        for (int i = 0; i < arr.length; i++) if (arr[i] == 1) record[++oneCount] = i;
        // 如果数组全是0的情况，固定返回[0, arr.length - 1]
        if (oneCount == 0) return new int[]{0, arr.length - 1}; 
        // 如果1的个数不能被平分，则表示无法平均分配
        if (oneCount % 3 != 0) return new int[]{-1, -1}; 
        // gn：每组1的个数   lzn：最后一组末尾0的个数
        int gn = oneCount / 3, lzn = arr.length - 1 - record[oneCount]; 
        // 如果每组末尾0的个数不足，则返回[-1,-1]
        if (record[gn * 2] - record[gn] - 1 < lzn || record[gn * 3] - record[gn * 2] - 1 < lzn) return new int[]{-1, -1}; 
        int tail1 = record[gn] + lzn, tail2 = record[gn * 2] + lzn, tail3 = record[gn * 3] + lzn,
                nums = Math.min(Math.min(tail1 + 1, tail2 - tail1), tail3 - tail2);
        int[] result = new int[]{tail1, tail2 + 1};
        while(nums-- > 0) {
            if (arr[tail1] != arr[tail2] || arr[tail1]!= arr[tail3] || arr[tail2] != arr[tail3]) return new int[]{-1, -1};
            tail1--; tail2--; tail3--;
        }
        return result;
    }
}


// https://leetcode.cn/problems/three-equal-parts/solution/-by-muse-77-dper/