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
    public ListNode deleteDuplicates(ListNode head) {
        
        ListNode curr = head;
        ListNode ans = curr;
        while(curr != null){
            
            boolean isDuplicate = false;

            ListNode prev = curr;  
            while(curr.next != null && curr.val == curr.next.val){
                isDuplicate = true;
                curr = curr.next;
            }

            prev.next = curr.next;
            curr = curr.next;
        

    }

    return ans;
    }
}