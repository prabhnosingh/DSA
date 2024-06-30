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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        //creating dummy node
        ListNode ans = new ListNode();
        //assigning pointer
        ListNode curr = ans;

        int carry = 0;
        while(l1 != null || l2 != null || carry != 0){

            int v1 = l1 != null ? l1.val : 0;
            int v2 = l2 != null ? l2.val : 0;


            int val = v1 + v2 + carry;
            carry = val / 10;
            val = val % 10;
            curr.next = new ListNode(val);
            
            //update pointers
            curr = curr.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;


        }

        return ans.next;




        // **************************************Not optimal answer(brute force)(also getting numberFormatException for a large number due to number exceeding the range of integer)*************************************************

    //             ListNode reversedList1 = reverseList(l1);
    //     ListNode reversedList2 = reverseList(l2);

    //     int num1 = 0;
    //     int num2 = 0;
    //     ListNode currNode = reversedList1;
    //     String s1 = "";
    //     while(currNode != null){

    //         s1 += currNode.val;
    //         currNode = currNode.next;
    //     }
    //     currNode = reversedList2;
    //     String s2 = "";
    //     while(currNode != null){

    //         s2 += currNode.val;
    //         currNode = currNode.next;
    //     }

    //     num1 = Integer.parseInt(s1);
    //     num2 = Integer.parseInt(s2);

     

    //     int sum = num1 + num2;


    //     ListNode ansList = new ListNode(0);
    //     if(sum == 0) return ansList;
    //     ListNode pointer = ansList;

    //     while(sum != 0){

    //         ListNode digit = new ListNode(sum % 10);
    //         pointer.next = digit;
    //         sum = sum / 10;
    //         pointer = pointer.next;
    //     } 


    //     return ansList.next;
    // }
    //  public ListNode reverseList(ListNode head){
            
    //         ListNode curr = head;
    //         ListNode prev = null;
    //         while(curr != null){

    //             ListNode temp = curr.next;
    //             curr.next = prev;

    //             prev = curr;
    //             curr = temp;
    //         }
    //         return prev;
    //     }
    }
}