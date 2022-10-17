// to be reviewed
class Solution {
    public int minDifficulty(int[] jd, int d) {
        int n = jd.length;
        //总天数小于计划天数直接返回-1
        if(n < d) return -1;
        int[][] f = new int[n][d + 1];
        for(int i = 0; i < n; i++){
            Arrays.fill(f[i], Integer.MAX_VALUE / 2);
        }
        //初始化
        f[0][1] = jd[0];
        for(int i = 1; i < n; i++){
            int[] max = new int[i + 1];
            max[i] = jd[i];
            //倒序从i到0的最大值
            for(int k = i - 1; k >= 0; k--){
                max[k] = Math.max(max[k + 1], jd[k]);
            }
            //当前可以组成的最大天数为min(i + 1, d)
            for(int j = Math.min(i + 1, d); j > 1 ; j--){
                //求出当前计划天数难度和的最小值
                //因为后面的各个难度和需要用到前面的各个难度和的最小值，所以需要正序遍历
                for(int k = 0; k < i; k++){
                    f[i][j] = Math.min(f[i][j], f[k][j - 1] + max[k + 1]);    
                }    
            }
            //max[0]表示[0, i]难度的最大值
            f[i][1] = max[0];
        }
        return f[n - 1][d];
    }
}
