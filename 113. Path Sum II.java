// 113. Path Sum II

class Solution {
    // 直接全局 省的每次都要作为参数传递到下一次递归
     List<List<Integer>> res;
     List<Integer> path;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        if(root == null)
            return res;
        // 根不空时 sum初始值直接为根值
        int sum = root.val;
        // 遍历路径
        travesal(root,targetSum,sum);
        return res;
    }
    public void travesal(TreeNode node, int targetSum, int sum){
        // 添加当前结点到路径中（就是上一递归传的node.left或node.right）
        path.add(node.val);
        // 遇到叶子结点 且 当前和等于目标和
        if(node.left == null && node.right == null && sum == targetSum)
            res.add(new ArrayList<>(path)); // 添加当前路径到结果集

        // 遍历非空孩子结点
        if(node.left != null){
            // sum + node.left.val（根值+左孩子值）作为参数传递给下一次递归 此时并没有影响当前递归的sum（根值）值 
            travesal(node.left, targetSum, sum + node.left.val);
        // 回溯 41行递归进去后,path中添加了左孩子结点(下一层的33行);此时想继续走右边路径,当然要回退到根结点(remove path中最后一个结点即可)
            path.remove(path.size() - 1);  
        }
        // 因此下面还是sum + node.right.val作为参数传递给下一次递归
        if(node.right != null){
            travesal(node.right, targetSum, sum + node.right.val);
            path.remove(path.size() - 1);  // 回溯
        }
    }
}