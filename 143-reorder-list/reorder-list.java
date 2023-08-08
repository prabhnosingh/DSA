// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode() {}
//  *     ListNode(int val) { this.val = val; }
//  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  * }
//  */
// class Solution {
//     public void reorderList(ListNode head) {
        
//         if (head == null || head.next == null) {
//             return;
//         } 

//         ListNode slow = head;
//         ListNode fast = head.next;

//         while(fast != null && fast.next != null){
//             slow = slow.next;
//             fast = fast.next.next;
//         }

//         ListNode second = slow.next;
//         slow.next = null;
//         ListNode prev = null;

//         //reversing the second half
//         while(second != null){
//             ListNode temp = second.next;
//             second.next = prev;
//             prev = second;
//             second = temp;
//         }

//         //merging both the halfs

//         ListNode first = head;
//         second = prev;

//         while(second != null){
//             ListNode temp1 = first.next;
//             ListNode temp2 = second.next;

//             first.next =  second;
//             second.next = temp1;
//             first = temp1;
//             second = temp2; 
        
//         }


//     }
// }

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
    public void reorderList(ListNode head) {
        
           if (head == null || head.next == null) {
            return;
        }

        // Step 1: Find the middle of the linked list
        ListNode middle = findMiddle(head);

        // Step 2: Reverse the second half of the linked list
        ListNode reversed = reverseLinkedList(middle.next);
        middle.next = null;

        // Step 3: Merge the first half and the reversed second half alternately
        mergeLists(head, reversed);
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    private void mergeLists(ListNode l1, ListNode l2) {
        while (l2 != null) {
            ListNode temp1 = l1.next;
            ListNode temp2 = l2.next;
            l1.next = l2;
            l2.next = temp1;
            l1 = temp1;
            l2 = temp2;
        }
    }
}
