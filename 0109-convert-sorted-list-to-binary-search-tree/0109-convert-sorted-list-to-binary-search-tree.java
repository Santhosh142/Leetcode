/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head,null);
    }
    
    public TreeNode buildTree(ListNode head,ListNode stop) {
        if(head == stop) return null;
        
        ListNode mid = middle(head,stop);
        TreeNode root = new TreeNode(mid.val);
        
        root.left = buildTree(head,mid);
        root.right = buildTree(mid.next,stop);
        
        return root;
        
    }
    
    public ListNode middle(ListNode head,ListNode stop) {
        if(head == stop) return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != stop && fast.next != stop) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}