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
    public ListNode reverseList(ListNode head) {


        if(head == null){
            return null;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode currNext = curr.next; 

        while(curr != null){
            curr.next = prev;
            prev = curr;
            curr = currNext;
            if(currNext == null){
                break;
            }
            currNext = currNext.next;

        }

        return prev;



























////////////////////////////////////////////////////////////////////
        // if(head == null) return null;
        // if(head.next == null) return head;

        // ListNode newHead = reverseList(head.next);

        // head.next.next = head;
        // head.next = null;

        // return newHead;
    }

















//////////////////////////////////////////////////////////
    //         if(head == null) return null;
    //         return recur(head);

    // }        
    //     public ListNode recur(ListNode head){
            
    //         if(head.next == null) return head;
    //         ListNode newHead = recur(head.next);

    //         // ListNode temp = head.next;
    //         // temp.next = head;
    //         head.next.next = head;
    //         head.next = null;
    //         return newHead;
    //     }


        
//******************************************************************** */
        // ListNode curr = head;
        // ListNode prev = null;

        // while(curr != null){
        //     ListNode nxt = curr.next;
        //     curr.next = prev;
        //     prev = curr;
        //     curr = nxt;

        // }

        // return prev;
    // }
}