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

    //intuition 2: Merging linked lists into one main ans list as we traverse lists
    public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists.length == 0){
            return null;
        }

        ListNode list1 = lists[0];

        if(lists.length == 1){
            return list1;
        }


        // ListNode listPointer = 
        for(int i = 1; i < lists.length; i ++){
            ListNode list1Pointer = list1;
            ListNode list2Pointer = lists[i];
            ListNode newMergedList = new ListNode();
            ListNode mergedListPointer = newMergedList;
            while(list1Pointer != null && list2Pointer != null){
                if(list1Pointer.val <= list2Pointer.val){
                    mergedListPointer.next = list1Pointer;
                    mergedListPointer = mergedListPointer.next;
                    list1Pointer = list1Pointer.next;
                }
                else{
                    mergedListPointer.next = list2Pointer;
                    mergedListPointer = mergedListPointer.next;
                    list2Pointer = list2Pointer.next;
                }
            }

            while(list1Pointer != null){
                mergedListPointer.next = list1Pointer;
                mergedListPointer = mergedListPointer.next;
                list1Pointer = list1Pointer.next;
            }

            while(list2Pointer != null){
                mergedListPointer.next = list2Pointer;
                mergedListPointer = mergedListPointer.next;
                list2Pointer = list2Pointer.next;
            }

            list1 = newMergedList.next;
        }

        return list1;
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Re-solving on 22 Nov 2025:

    // //intuition 1 (beats 35.85%): Offer all the elements from each linked list to a min heap. At last
    // //construct a final linked list by removing from the min heap

    // //We should also insert new independant nodes (without "next" addresses) to avoid any cycle
    // //formation while constructing final linked list as if nodes are passed directly, their
    // //next is also being passed with them, and in some scenarios like lists = [[-2,-1,-1,-1],[]]
    // //where -1 nodes have next of -1 nodes, we can have a case where one of the -1 nodes goes to 
    // //the last of the final list while its next still points to another -1 node that is somewhere
    // //in the middle of the final list.
    // public ListNode mergeKLists(ListNode[] lists) {
    //     PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> (a.val - b.val)); 
    //     //sort list nodes based on their values 
    //     ListNode ansRoot = new ListNode(); //dummy node 
    //     ListNode tempNode = ansRoot;

    //     for(ListNode list : lists){
    //         ListNode currNode = list;
    //         while(currNode != null){
    //             ListNode temp = new ListNode(currNode.val); //to avoid cycles while construcing final linked
    //             //list (eg: lists = [[-2,-1,-1,-1],[]])
    //             minHeap.offer(temp);
    //             currNode = currNode.next;
    //         }
    //     }

    //     while(!minHeap.isEmpty()){
    //         // System.out.println(minHeap.peek().val);
    //         tempNode.next = minHeap.remove();
    //         tempNode = tempNode.next;
    //     }

    //     return ansRoot.next;
    // }
}