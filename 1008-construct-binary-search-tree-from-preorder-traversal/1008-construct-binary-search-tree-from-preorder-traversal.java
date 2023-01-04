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
    public TreeNode bstFromPreorder(int[] preorder) {
        int len = preorder.length;
        return construct(preorder, 0, len - 1);
    }
    
    public TreeNode construct(int[] preorder, int start, int end) {
        if(start > end) return null;
        
        TreeNode root = new TreeNode(preorder[start]);
        int k = start + 1;
        while(k <= end) {
            if(preorder[k] > preorder[start]) {
                break;
            }
            k++;
        }
        root.left = construct(preorder, start + 1, k - 1);
        root.right = construct(preorder, k , end);
        return root;
    }
}