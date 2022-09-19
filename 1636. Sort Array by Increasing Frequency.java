// Title:  1636. Sort Array by Increasing Frequency
// Idea:   O(n)/O(n+C)
// Complexity: O(n)/O(n+C)
// Language: Java
// Author:  Kaili Yang

// 按照题意，统计词频，再按词频排序即可。
// 注意在Java中是不支持对基本类型的数组自定义排序的，所以，这里我们需要要用Integer[] 数组。

class Solution {
    public int[] frequencySort(int[] nums) {
        Integer[] arr = new Integer[nums.length];
        int[] freqs = new int[201];
        for (int i = 0; i < nums.length; i++) {
            // 统计频次
            freqs[nums[i] + 100]++;
            //将int数组转换成Integer数组
            arr[i] = nums[i];
        }
        // Java中不支持对基本类型的数组自定义排序
        Arrays.sort(arr, (a, b) -> {
            // 按照频次排序
            return freqs[a + 100] == freqs[b + 100] ? b - a : freqs[a + 100] - freqs[b + 100];
            
            // 如果两个数的频次相同，那么这两个数就按照从大到小排序（后者减去前者）
            // 频次不相同，则按照频次排序
        });
        // 转换为int数组
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }
        return nums;
    }
}

// Soluion2
class Solution {
    public int[] frequencySort(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        List<int[]> list = new ArrayList<>();
        for(int key:map.keySet()){
            list.add(new int[]{key,map.get(key)});
        }
        Collections.sort(list,(a,b)->{
            if(a[1] != b[1]) return a[1] - b[1];
            return b[0] - a[0];
        });
        int[] ans = new int[n];
        int idx = 0;
        for(int[] cur:list){
            int m = cur[1];
            while(m-->0) ans[idx++] = cur[0];
        }
        return ans;
    }
}