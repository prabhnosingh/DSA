class Solution {

    //Solving on 22 Nov 2025

    //intuition 2: using arrays.sort after each negation
    
    //To maximize the sum:
        //if there are negative numbers, the largest negative element should be converted to a positive element.
        //if there are positive numbers only, the smallest element should be convereted to a negative element.

        //Use minheap to store the elements. Remove the top most element:
            //if a 0 is found, then apply all the negations to it. This makes sense as now we know that there
                //are no more negative numbers
            //After negating the element, offer back to the heap and for remaining k do the negation for smallest elements

    //TC: O(klogn) (negations) 
    //SC: O(1)
    public int largestSumAfterKNegations(int[] nums, int k) {
        

        while(k != 0){
            Arrays.sort(nums);
            if(nums[0] == 0){
                break;
            }
            nums[0] = nums[0] * -1;
            
            k --;
        }
        
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        return sum;

    }


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Solving on 22 Nov 2025

    // //intuition 1: To maximize the sum:
    //     //if there are negative numbers, the largest negative element should be converted to a positive element.
    //     //if there are positive numbers only, the smallest element should be convereted to a negative element.

    //     //Use minheap to store the elements. Remove the top most element:
    //         //if a 0 is found, then apply all the negations to it. This makes sense as now we know that there
    //             //are no more negative numbers
    //         //After negating the element, offer back to the heap and for remaining k do the negation for smallest elements

    // //TC: O(nlogn + nlogn + klogn) (insert + negations + remove) 
    // //SC: O(n)
    // public int largestSumAfterKNegations(int[] nums, int k) {
        
    //     PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> (a - b));

    //     for(int num : nums){
    //         minHeap.offer(num);
    //     }

    //     while(k != 0){
    //         int currNum = minHeap.remove();

    //         if(currNum == 0){
    //             break;
    //         }
    //         currNum = currNum * -1;
    //         minHeap.offer(currNum);
    //         k --;
    //     }

    //     int sum = 0;
    //     while(!minHeap.isEmpty()){
    //         sum += minHeap.remove();
    //     }

    //     return sum;

    // }
}