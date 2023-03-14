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
    public int sumNumbers(TreeNode root) {
        return solve(root, 0);
    }
    public int solve(TreeNode root, int count) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) {
            return count * 10 + root.val;
        }
        
        return solve(root.left , count * 10 + root.val) + solve(root.right, count * 10 + root.val);
    }
}