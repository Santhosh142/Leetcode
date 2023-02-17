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
    int minDiff;
    TreeNode previous = null;
    public int minDiffInBST(TreeNode root) {
        minDiff = Integer.MAX_VALUE;
        solve(root);
        return minDiff;
    }
    
    public void solve(TreeNode root) {
        if(root == null) return;
        
        solve(root.left);
        if(previous != null) minDiff = Math.min(minDiff, root.val - previous.val);
        previous = root;
        solve(root.right);
    }
}