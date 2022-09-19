// Title:  2.two sum
// Idea:   Two pointers
// Complexity: Sort and search with two points O(n) and O(1) space
// Language:Python
// Author:  Kaili Yang


public class Solution {
    // example in leetcode book
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (map.containsKey(target - x)) {
                return new int[]{map.get(target - x), i};
            }
            map.put(x, i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}


// error log
// 1.;
// 2.HashMap<>()
// 3.new int[]{}   

 

