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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy = new ListNode(0, list1);
        ListNode head = dummy;
        ListNode mid1 = null, mid2 = null;
        int count = 0;
        while(count <= b && dummy != null) {
            if(count == a) {
                mid1 = dummy;
            }
            if(count == b) {
                mid2 = dummy.next;
                dummy.next = null;
            }
            count++;
            dummy = dummy.next;
        }
        ListNode newHead = new ListNode(0, list2);
        mid1.next = newHead.next;
        while(mid1.next != null) mid1 = mid1.next;
        mid1.next = mid2.next;
        return head.next;
    }
}