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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int N = 0;
        ListNode curr = head;
        while(curr != null) {
            N++;
            curr = curr.next;
        }

        int m = N - n;

        if(m == 0) {
            return head.next;
        }

        curr = head;
        for(int i = 1; i < N; i++) {

            if((i) == m) {
                curr.next = curr.next.next;
                break;
            }
            curr = curr.next;
        }
        return head;

    }
}