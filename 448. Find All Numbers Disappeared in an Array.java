// 448. Find All Numbers Disappeared in an Array

// class Solution {
//     public int[] missingTwo(int[] nums) {
//         int length = nums.length();
//         int end = nums[length];

//         // end = length, 缺少两个尾巴
//         if (end == length) {
//             return [end+1, end+2]
//         }
//         // end = length + 1, 缺少一中一尾
//         if (end == length +1) {
            
//         }
//         // end = length + 2, 缺少2个非尾数（头部or中间）
//         for (int i=0;i<n.length();i++) {

//         }
//     }
// }

class Solution {
    public int[] missingTwo(int[] nums) {
        int xorsum = 0;
        int n = nums.length + 2;
        for (int num : nums) {
            xorsum ^= num;
        }
        for (int i = 1; i <= n; i++) {
            xorsum ^= i;
        }
        // 防止溢出
        int lsb = (xorsum == Integer.MIN_VALUE ? xorsum : xorsum & (-xorsum));
        int type1 = 0, type2 = 0;
        for (int num : nums) {
            if ((num & lsb) != 0) {
                type1 ^= num;
            } else {
                type2 ^= num;
            }
        }
        for (int i = 1; i <= n; i++) {
            if ((i & lsb) != 0) {
                type1 ^= i;
            } else {
                type2 ^= i;
            }
        }
        return new int[]{type1, type2};
    }
}

