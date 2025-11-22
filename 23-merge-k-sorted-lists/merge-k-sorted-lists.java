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

    //Re-solving on 22 Nov 2025:

    //intuition 1: Offer all the elements from each linked list to a min heap. At last
    //construct a final linked list by removing from the min heap
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> (a.val - b.val)); 
        //sort list nodes based on their values 
        ListNode ansRoot = new ListNode(); //dummy node 
        ListNode tempNode = ansRoot;

        for(ListNode list : lists){
            ListNode currNode = list;
            while(currNode != null){
                ListNode temp = new ListNode(currNode.val); //to avoid cycles while construcing final linked
                //list (eg: lists = [[-2,-1,-1,-1],[]])
                minHeap.offer(temp);
                currNode = currNode.next;
            }
        }

        while(!minHeap.isEmpty()){
            System.out.println(minHeap.peek().val);
            tempNode.next = minHeap.remove();
            tempNode = tempNode.next;
        }

        return ansRoot.next;
    }
}