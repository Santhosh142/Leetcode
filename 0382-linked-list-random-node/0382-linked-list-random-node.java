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
class Solution {

    ArrayList<Integer> alist = new ArrayList<>();
    
    public Solution(ListNode head) 
    {
        while(head!=null)
        {
            alist.add(head.val);
            head=head.next;
        }
    }
    
    public int getRandom() 
    {
        return alist.get((int)(Math.random()*alist.size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */