/* 
我的思路
1.只要 nums[i] > nums[i-1],就必须要交换
2.交换完了再判断 另一个数组的前后关系
3.写了代码但是总超时
3.看了很多分析，说这种叫 dp


*/ 

class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        int ans1=0,ans2=1,inf=(int)2e5;//表示上一位交换和不交换的时候的最小次数
        for(int i=1;i<nums1.length;i++){
            boolean a=nums1[i]>nums1[i-1]&&nums2[i]>nums2[i-1],b=nums1[i]>nums2[i-1]&&nums2[i]>nums1[i-1];
            int ans3=Math.min(a?ans1:inf,b?ans2:inf),ans4=Math.min(b?ans1:inf,a?ans2:inf)+1;
            ans1=ans3;
            ans2=ans4;
        }
        return Math.min(ans1,ans2);
    }
}