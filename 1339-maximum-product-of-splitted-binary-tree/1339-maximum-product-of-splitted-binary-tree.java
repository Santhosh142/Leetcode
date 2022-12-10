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
class Solution {
    long totalSum = 0, maxSum = 0;
    public int maxProduct(TreeNode root) {
        solve(root);
        long val = getMaxSum(root);
        return (int)(maxSum % ((int)Math.pow(10, 9) + 7));
    }
    public void solve(TreeNode node) {
        if(node == null) return;
        totalSum += (long)node.val;
        solve(node.left);
        solve(node.right);
    }
    public long getMaxSum(TreeNode root) {
        if(root == null) return 0;
        
        long left = getMaxSum(root.left);
        long right = getMaxSum(root.right);
        long subSum = left + right + root.val;
        maxSum = Math.max(maxSum, subSum * (totalSum - subSum));
        return subSum;
    }
}