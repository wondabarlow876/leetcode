// 1680. Concatenation of Consecutive Binary Numbers
// Math/ Bit Manipulation/Simulation

public class Solution {
    private static final int MOD = 1000000007;

    public int concatenatedBinary(int n) {
        int res = 0, shift = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                // 说明是2的幂，则进位
                shift++;
            }
            res = (int) ((((long) res << shift) + i) % MOD);
        }
        return res;
    }
}
