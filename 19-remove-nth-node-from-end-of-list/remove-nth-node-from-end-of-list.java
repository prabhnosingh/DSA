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




        ListNode dummy = new ListNode(0, head);
        
        dummy.next = head;

        ListNode p1 = dummy;
        ListNode p2 = dummy;
        int i = 0;
        while(i != n + 1 && p2 != null){
            p2 = p2.next;
            i ++;
        }

        while(p2 != null){
            p2 = p2.next;
            p1 = p1.next;
        }

        p1.next = p1.next.next;

        return dummy.next;

       
    // **********************************************************************
    //    ListNode pointer = head;
    //    int len = 0;


    //    while(pointer != null){
    //        pointer = pointer.next;
    //        len ++;
    //    }
    //    if(len == 1){
    //        return null;
    //    }
       
    //    int loc = len - n;
    //     ListNode i = head;
    //     int count = 0;
    //    while(i != null && i.next != null){

    //        if( loc - 1 < 0||count == loc - 1){

    //            if(loc - 1 < 0) {
    //               return head = i.next;
    //            }
               
    //                 i.next = i.next.next;
               
               
    //        }
    //        i = i.next;
    //        count ++;
    //    }
    //     return head;
       
       
    
       
       
       
//************************************************************************************ */   
       
    //     ListNode node_count = head;
    //     int count =0;
    //     while(node_count != null){
    //         node_count = node_count.next;
    //         count++;
    //     }
    //             if(n == count){
    //         head = head.next;
    //         return head;
    //     }


    //     ListNode current = head;
    //     for(int i=0; i<count; i++){
    //         if(i==count-n-1){
    //             current.next= current.next.next;
                
    //         }
    //         else{
    //         current = current.next;}
    //     }
    //    return head;
        
    }
}