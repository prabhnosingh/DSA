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
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];

        while(lists.length > 1){

            List<ListNode> mergedLists = new ArrayList<>();

            for(int i = 0; i < lists.length; i += 2){

                ListNode list1 = lists[i];
                ListNode list2 = i + 1 >= lists.length ? null : lists[i + 1];
                mergedLists.add(mergeTwoLists(list1, list2));
            }

            lists = mergedLists.toArray(new ListNode[0]);

        }

        return lists[0];



        // ********************************* Beats 15% *************************************
        // if(lists.length == 0) return null;
        
        // ListNode ans = lists[0];
        // ListNode ansCurr = ans;
        // for(int i = 1; i < lists.length; i ++){

        //         ans = mergeTwoLists(ans, lists[i]);
        
        //     }
        //     return ans;

        }


        public ListNode mergeTwoLists(ListNode head1, ListNode head2){

            if(head1 == null) return head2;
            if(head2 == null) return head1;

            ListNode dummy = new ListNode(0);
            ListNode curr = dummy;


            while(head1 != null && head2 != null){

                if(head1.val < head2.val){
                    curr.next = head1;
                    head1 = head1.next;
                }
                else{
                    curr.next = head2;
                    head2 = head2.next;
                }

                curr = curr.next;

            }

            curr.next = head2 == null ? head1 : head2;
            return dummy.next;
        }
        
    }
