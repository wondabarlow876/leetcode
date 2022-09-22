// 1640. Check Array Formation Through Concatenation

// 方法一：哈希表
// 因为数组 \textit{arr}arr 每个整数互不相同，且 \textit{pieces}pieces 的整数也互不相同，所以我们可以通过 \textit{arr}arr 固定 \textit{pieces}pieces 的放置。使用哈希表 \textit{index}index 记录 \textit{pieces}pieces 各个数组的首元素与数组下标的对应关系。

// 我们不断地将 \textit{pieces}pieces 中的数组与数组 \textit{arr}arr 相对应，对于当前遍历的元素 \textit{arr}[i]arr[i]，如果它不存在于哈希表中，说明我们无法将 \textit{pieces}pieces 与数组 \textit{arr}arr 相对应，直接返回 \text{false}false；否则我们找到对应的数组 \textit{pieces}[j]pieces[j]，然后将它与 \textit{arr}[i]arr[i] 及之后的整数进行比较（在比较过程中，如果判断相等不成立，直接返回 \text{false}false），判断都相等后，将 ii 相应地向后移。全部 \textit{pieces}pieces 都匹配成功后，返回 \text{true}true。

// 作者：LeetCode-Solution
// 链接：https://leetcode.cn/problems/check-array-formation-through-concatenation/solution/neng-fou-lian-jie-xing-cheng-shu-zu-by-l-rnkn/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces){
        int n=arr.length, m=pieces.length;
        // 用哈希表index 记录 pieces 各个数组的首元素与数组下标的对应关系
        Map<Integer, Integer> index = new HashMap<Integer, Integer>();
        for(int i=0; i<m; i++){
            index.put(pieces[i][0], i);
        }
        // 遍历的元素arr[i]
        for(int i=0;i<n;) {
            // 如果它不存在于哈希表中，直接返回 false
            if(!index.containsKey(arr[i])){
                return false;
            }
            // 找到对应的数组 pieces[j]
            int j=index.get(arr[i]), len=pieces[j].length;
            // 将 arr[i] 及之后的整数与index[j]里的整数进行比较
            for(int k=0;k<len;k++) {
                if(arr[i+k] != pieces[j][k]) {
                    return false;
                }
            }
            i=i+len;
        }
        // 全部遍历结束表示true
        return true;
    }
}