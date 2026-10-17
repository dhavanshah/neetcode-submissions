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

// public class ListNode {
//     int val;
//     ListNode next;
    
//     ListNode() {}
    
//     ListNode(int val, ListNode next) { 
//         this.val = val;
//         this.next = next; 
//     }
// }

class Solution {
    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;        
        
        if(head == null) {
            return null;
        }

        if(head.next == null) {
            return head;
        }

        while(curr != null) {

            ListNode temp = curr.next;//saving the next of current so its not lost while changing the links
            curr.next = prev;//pointing the current to previous
            prev = curr;//shifting previous to point to current
            curr = temp;//traversing list
        }
        return prev;
    }
}
