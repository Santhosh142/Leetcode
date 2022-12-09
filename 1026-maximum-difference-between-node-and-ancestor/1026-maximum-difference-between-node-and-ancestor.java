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
        solve(root, root.val, root.val);
        return maxi;
    }
    
    public void solve(TreeNode root, int minAncestor, int maxAncestor) {
        if(root == null) return;
        
        int maxDiff = Math.max(Math.abs(root.val - minAncestor), Math.abs(root.val - maxAncestor));
        
        maxi = Math.max(maxi, maxDiff);
        if(root.val > maxAncestor) maxAncestor = root.val;
        if(root.val < minAncestor) minAncestor = root.val;
        solve(root.left, minAncestor, maxAncestor);
        solve(root.right, minAncestor, maxAncestor);

    }
    

}