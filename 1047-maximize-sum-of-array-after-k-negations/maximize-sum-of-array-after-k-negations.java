class Solution {

    //Solving on 22 Nov 2025

    //intuition 2 (beats 5.5%): 
        //Sort the array
        //Run for loop and negate each negative or zero number while k > 0, else break
        //Sort the array
        //Check if k is odd, if yes then negate the nums[0] number as this is the smallest one
            //and as the k is odd this number will result in "- nums[0]" irrespective of value of k
    
    

    //TC: O(nlogn) (sorting) 
    //SC: O(1)
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;

        for(int i = 0; i < nums.length; i ++){
            if(nums[i] <= 0 && k > 0){
                nums[i] = -1 * nums[i]; 
                k --;
            }
            else{ //either we have reached positive numbers of k have become zero
                break;
            }
        }

        Arrays.sort(nums);

        if(k % 2 != 0){ //k is odd
            nums[0] = -1 * nums[0];
        }

        for(int num : nums){
            sum += num;
        }

        return sum;
    }


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Solving on 22 Nov 2025

    // //intuition 2 (beats 5.5%): using arrays.sort after each negation
    
    // //To maximize the sum:
    //     //if there are negative numbers, the largest negative element should be converted to a positive element.
    //     //if there are positive numbers only, the smallest element should be convereted to a negative element.

    //     //Use minheap to store the elements. Remove the top most element:
    //         //if a 0 is found, then apply all the negations to it. This makes sense as now we know that there
    //             //are no more negative numbers
    //         //After negating the element, offer back to the heap and for remaining k do the negation for smallest elements

    // //TC: O(k*nlogn) (negations) 
    // //SC: O(1)
    // public int largestSumAfterKNegations(int[] nums, int k) {
        

    //     while(k != 0){
    //         Arrays.sort(nums);
    //         if(nums[0] == 0){
    //             break;
    //         }
    //         nums[0] = nums[0] * -1;
            
    //         k --;
    //     }
        
    //     int sum = 0;
    //     for(int num : nums){
    //         sum += num;
    //     }
    //     return sum;

    // }


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Solving on 22 Nov 2025

    // //intuition 1 (beats 38%): To maximize the sum:
    //     //if there are negative numbers, the largest negative element should be converted to a positive element.
    //     //if there are positive numbers only, the smallest element should be convereted to a negative element.

    //     //Use minheap to store the elements. Remove the top most element:
    //         //if a 0 is found, then apply all the negations to it. This makes sense as now we know that there
    //             //are no more negative numbers
    //         //After negating the element, offer back to the heap and for remaining k do the negation for smallest elements

    // //TC: O(nlogn + klogn + nlogn) (insert + negations + remove) 
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