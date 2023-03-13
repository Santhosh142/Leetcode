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
    public boolean isSymmetric(TreeNode root) {
        return validate(root.left, root.right);
    }
    public boolean validate(TreeNode node1, TreeNode node2) {
        if(node1 == null && node2 == null) return true;
        if(node1 != null && node2 == null) return false;
        if(node1 == null && node2 != null) return false;
        
        if(node1.val != node2.val) return false;
        boolean left = validate(node1.left, node2.right);
        boolean right = validate(node1.right, node2.left);
        return left && right;
    }
}