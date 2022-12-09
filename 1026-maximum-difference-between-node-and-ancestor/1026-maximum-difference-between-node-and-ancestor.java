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
    int maxi = Integer.MIN_VALUE;
    public int maxAncestorDiff(TreeNode root) {
        utility(root);
        return maxi;
    }
    public void getMax(TreeNode node, TreeNode check) {
        if(node == null || check == null) return;
        int diff = Math.abs(node.val - check.val);
        maxi = Math.max(diff, maxi);
        getMax(node, check.left);
        getMax(node, check.right);
        
    }
    public void utility(TreeNode node) {
        if(node == null) return;
        getMax(node, node);
        utility(node.left);
        utility(node.right);
    }
    

}