class Solution {
    public int largestPerimeter(int[] nums) {
        // any sum of two > the last one
        // 1. sort 2.compare
        Arrays.sort(nums);
        for (int i = nums.length-1; i >= 2; i--) {
            if(nums[i-1] + nums[i-2] > nums[i]){
                return nums[i] + nums[i-1] + nums[i-2];
            }
        }
        return 0;
    }
}