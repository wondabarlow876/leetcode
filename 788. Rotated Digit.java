class Solution {
    public int rotatedDigits(int n) {
        int ans = 0;
        for (int i =0; i <n; i++) {
            //正则匹配条件:可能有018,必须有2569,肯定没有347
            String index = String.valueOf(i);
            if(index.matches("[2,5,6,9]+[0,1,8]*[3,4,7]{0}")){
                ans++;
            }
        }
        return ans;
    }
}