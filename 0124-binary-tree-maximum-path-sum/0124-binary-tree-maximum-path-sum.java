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
    int res = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        int ans = maxSum(root);
        return res;
    }
    public int maxSum(TreeNode root) {
        if(root == null) return 0;
        
        int left = Math.max(0, maxSum(root.left));
        int right = Math.max(0, maxSum(root.right));
        
        int currPath = left + right + root.val;
        res = Math.max(res, currPath);
        
        return Math.max(left, right) + root.val;
    }
}