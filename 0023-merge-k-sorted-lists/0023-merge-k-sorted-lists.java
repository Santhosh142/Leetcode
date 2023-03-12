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
    public ListNode mergeKLists(ListNode[] lists) 
    {
        ArrayList<Integer> alist = new ArrayList<>();
        for(ListNode newhead : lists)
        {
            while(newhead != null)
            {
                alist.add(newhead.val);
                newhead=newhead.next;
            }
        }
        Collections.sort(alist);
        int sz = alist.size();
        ListNode head = null;
        ListNode temp = head;
        for(int i=0;i<sz;i++)
        {
            ListNode newNode = new ListNode(alist.get(i));
            if(head == null)
            {
                head = newNode;
                temp = newNode;
            }
            else
            {
                temp.next = newNode;
                temp = newNode;
            }
        }
        return head;
    }
}