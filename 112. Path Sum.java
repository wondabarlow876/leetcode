/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

//  广度优先遍历 Breadth-First-Search （宽度）
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        // 复习 Queue：单端队列，早进早出，常见实现类LinkedList
        // 定义两个队列（单链表）
        Queue<TreeNode> queNode = new LinkedList<TreeNode>();
        Queue<Integer> queVal = new LinkedList<Integer>();
        // offer方法在不违反容量限制的情况下立即将指定元素插入此队列。此方法优于add()方法，因为此方法在容器容量已满时不会抛出异常，因为它返回 false。  
        // 一个队列插入节点
        // 一个队列插入值
        queNode.offer(root);
        queVal.offer(root.val);
        // 当节点队列不为空
        while (!queNode.isEmpty()) {
            // poll 类似 remove，删除队列头部，就是第一个推入的元素
            TreeNode now = queNode.poll();
            int temp = queVal.poll();
            // 如果当前节点是叶子节点，则计算队列里的值是否==sum，那么返回true，否则继续
            if (now.left == null && now.right == null) {
                if (temp == sum) {
                    return true;
                }
                // 如果 刚进入队列的值 不等于 sum，继续下面的代码
                continue;
            }
            // 如果左节点不为零，一个队列插入左节点，另一个队列的值加上左节点的值
            if (now.left != null) {
                queNode.offer(now.left);
                queVal.offer(now.left.val + temp);
            }
            // 如果右节点不为零，一个队列插入右节点，另一个队列的值加上右节点的值
            if (now.right != null) {
                queNode.offer(now.right);
                queVal.offer(now.right.val + temp);
            }
        }
        return false;
    }
}
// 时间复杂度 O(n)
// 时间复杂度 O(n)

// 递归
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        // 如果只有一个跟节点，那么只要判断当前节点的值是否等于sum 返回T or F
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        // 否则递归左右节点
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
// 时间复杂度 O(n)
// 时间复杂度 O(n)