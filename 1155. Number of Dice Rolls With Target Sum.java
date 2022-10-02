class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        int[] dp = new int[target];
        int mod = 1000000007;
        for(int i = 0;i<d;i++){
            //反向更新 因为需要保留i-1层结果来计算i层结果
            for(int j = target-1;j>=0;j--){
                if(i == 0 ){
                    dp[j] = j<f?1:0;
                    continue;
                }
                //二维情况下i层初始值为0，不能直接使用i-1层结果做初始值
                dp[j] = 0;
                for(int k = 1;k<=f&&j-k>=0;k++){
                    dp[j] = (dp[j]+ dp[j-k])%mod;
                }

            }
        }
        return dp[target-1];        
    }
}