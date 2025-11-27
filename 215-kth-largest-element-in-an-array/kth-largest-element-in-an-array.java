class Solution {
 
    //Re-solving on 26 Nov 2025:

    //intuition 2: use minHeap of size of k and adding elements in minHeap only if the current peek element is
    //smaller
    
    public int findKthLargest(int[] nums, int k) {
       
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> (a-b));

        for(int num : nums){
            if(minHeap.size() < k){
                minHeap.offer(num);
            }
            else{
                if(num > minHeap.peek()){
                    minHeap.poll();
                    minHeap.offer(num);
                }
            }

            // if(minHeap.size() > k){
            //     minHeap.poll();
            // }
        }

        return minHeap.poll();
    }




////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Re-solving on 26 Nov 2025:

    // //intuition 1: use minHeap of size of k
    
    // public int findKthLargest(int[] nums, int k) {
       
    //     PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> (a-b));

    //     for(int num : nums){
    //         minHeap.offer(num);

    //         if(minHeap.size() > k){
    //             minHeap.poll();
    //         }
    //     }

    //     return minHeap.poll();
    // }



































////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//     //Re-solving on 23 Nov 2025:

//     //intuition 2 (optimmized - beats 70%): use min-heap based priority queue that have a maximum size of k. If 
//     //the new element is less than the top element (peek) leave that element, don't add it in heap.
//     //If the element is greater than top, then add it in heap while making sure that size is of heap
//     //is still k.

//     //TC: O(nlogk) where n is the length of nums
//     //SC: O(k)
    
//     public int findKthLargest(int[] nums, int k) {
//         PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> (a-b));

//         for(int num : nums){
//             if(minHeap.size() < k){
//                 minHeap.offer(num);
//             }
//             else if(minHeap.size() == k){
//                 if(num < minHeap.peek()){
//                     continue;
//                 }
//                 else if(num >= minHeap.peek()){
//                     minHeap.remove();
//                     minHeap.offer(num);
//                 }
//             }
//         }

//         return minHeap.remove();


//     }


// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Re-solving on 23 Nov 2025:

    // //intuition 1 (beats 60%): use min-heap based priority queue that have a maximum size of k

    // //TC: O(nlogk) where n is the length of nums
    // //SC: O(k)
    
    // public int findKthLargest(int[] nums, int k) {
    //     PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> (a-b));

    //     for(int num : nums){
    //         minHeap.offer(num);

    //         if(minHeap.size() > k){
    //             minHeap.remove();
    //         }
    //     }

    //     return minHeap.remove();


    // }

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // intuition 1: use priorityQueue(minHeap) of size k(poll if size goes above k), return the first element after
    // offering all the values in nums
    // TC: O(n log k)
    // SC: O(k) (heap size)
    // public int findKthLargest(int[] nums, int k) {
    //     PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    //     for(int num : nums){ // O(n + n log k + n log k)
    //         minHeap.offer(num); // O(log k)
    //         if(minHeap.size() > k){
    //             minHeap.poll(); // O(log k)
    //         }
    //     }
    //     return minHeap.poll(); 
    // }

////////////////////////////////////////////////////////////
// copied solution


    // public int findKthLargest(int[] nums, int k) {
    //     int max = Integer.MIN_VALUE;
    //     int min = Integer.MAX_VALUE;
    //     int length = nums.length;
    //     min = Arrays.stream(nums).min().getAsInt(); // builds IntStream pipeline, calls into library code and performs internal iteration and checks
    //     // this is slower than simple for loop (below) as in this there is more method-call overhead and iterator logic.
    //     max = Arrays.stream(nums).max().getAsInt();
    //     int[] count = new int[max - min +1];
    //     for(int i = 0; i < length; ++i){
    //         count[nums[i] - min]++;
    //     }

    //     for(int i = count.length -1; i >=0 ; --i){
    //             k -= count[i];
    //             if(k <=0){
    //                 return i + min;
    //             }
                
    //     }
    //     return 0;
    // }




////////////////////////////////////////////////////////////////////////////////////////////////
    // intuition 2: use max and min to create an arrray and store the frequencies of each number by subracting the min from each.
    // By this the largest element will be the one at last index of this array and the frequency will be the value at that index.
    // Subtract the frequency from k until k becomes less than equal to 0, at this moment return the index + min
    //TC: O(n)
    //SC: O(max - min) => O(n)


    // public int findKthLargest(int[] nums, int k) {
    //     int min = Integer.MAX_VALUE;
    //     int max = Integer.MIN_VALUE;

    //     for(int num : nums){ // O(n)
    //         if(num < min){
    //             min = num;
    //         }
    //         if(num > max){
    //             max = num;
    //         }
    //     }

    //     int[] freq = new int[max - min + 1];

    //     for(int i = 0; i < nums.length; i ++){ // O(n) 
    //     // basically index of freq array represents a num and the values of freq array represent the frequency of the
    //     // num, which is the index //
    //         freq[nums[i] - min] ++; 
    //     }

    //     for(int i = freq.length - 1; i >= 0; i --){ // O(max - min) => O(n)
    //         k = k - freq[i];
    //         if(k <= 0){
    //             return i + min;
    //         }
    //     }

    //     return 0;

    // }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////




























// resolving

    //intuition 1: Use maxheap to store the numbers. If size of maxHeap goes above k then poll. At last return maxHea.poll.

    //TC: O(nlogn (offering) + klogn (polling)) -> O(nlogn) where n is the length of nums
    //SC: O(k)
    // public int findKthLargest(int[] nums, int k) {

    //     PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));


    //     for(int num : nums){
    //         maxHeap.offer(num);
    //         // if(maxHeap.size() > k){
    //         //     maxHeap.poll();
    //         // }
    //     }

    //     while(k > 1){
    //         maxHeap.poll();
    //         k --;
    //     }

    //     return maxHeap.poll();
    // }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // //intuition 2: Use max / min to build a frequency array that stores numbers as index (num - min) and frequencies of each
    // //number as value. Based on the frequencies (starting from right) return the kth largest num.  

    // public int findKthLargest(int[] nums, int k) {
    //     int minNum = Integer.MAX_VALUE;
    //     int maxNum = Integer.MIN_VALUE;

    //     for(int num : nums){
    //         minNum = Math.min(num, minNum);
    //         maxNum = Math.max(num, maxNum);
    //     }


    //     int[] freqArr = new int[maxNum - minNum + 1]; // 6 - 1 + 1 = 6
        
    //     for(int num : nums){
    //         freqArr[num - minNum] ++;
    //     }

    //     for(int i = freqArr.length - 1; i >= 0; i --){
    //         k -= freqArr[i]; //k - frequency of elements from right (largest)
    //         if(k <= 0){
    //             return i + minNum;
    //         }
    //     }

    //     return 0;


    // }
}
















