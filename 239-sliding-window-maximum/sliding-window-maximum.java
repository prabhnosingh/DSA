class Solution {

    

    //Re-Solving on 03 Jan 2025:

    //intuition 1: Deque
        //We maintain a double-ended queue (Deque). This queue will store the correspoding indices of 
            //numbers from nums. The front of the queue will always contain the largest number's index.
            //If while traversing nums we get a larger element than the back of the queue, we poll all
            //the smaller elements from the back of the queue. Basically the queue will maintain an
            //increasing order of numbers from back -> front. 
        //First insert k elements in the queue such that the index of largest element is at the front
        
        //Size of output array will by nums.length - k + 1 (found by manually taking first example)

        //Make sure that the front of the queue is not an outdated element's index, i.e. some element  
            //that is supposed to be out of current window.

        //Why we store indices instead of numbers themselves in the queue.

    public int[] maxSlidingWindow(int[] nums, int k) {

        if(k == 1) return nums;

        Deque<Integer> queue = new ArrayDeque<>();
        int[] maxWindow = new int[nums.length - k + 1];
        queue.offer(0);

        int maxWindowIdx = 0;

        for(int i = 1; i < nums.length; i ++){
            
            int currNum = nums[i];

            if(i - k >= 0){ //window of k size has been traversed
                maxWindow[maxWindowIdx ++] = nums[queue.peekFirst()];
            }
            if(queue.peekFirst() <= i - k) queue.pollFirst(); //making sure outdated element is not at the front of queue

            // if(!queue.isEmpty() && currNum > nums[queue.peekLast()]){ //a greater element has been found, poll all the smaller elements
                while(!queue.isEmpty() && currNum > nums[queue.peekLast()]){
                    queue.pollLast();
                }
                // queue.offerLast(i);
            // }
            // else{
            //     queue.offerLast(i);
            // }
            
            queue.offerLast(i);


        } 
        // if(queue.)
        maxWindow[maxWindowIdx] = nums[queue.peekFirst()]; //adding last element in maxWindow as maxWindow is being updated laggingly

        return maxWindow;


    }






































////////////////////////////////////////////////////////////////////////////////////////////////////////////
//     //24 Oct 2025: intuition 3 (deque): Use a deque to store the indices of the elements of nums.
//     //Our result of maximum window will be at the front of the queue. We will maintain the queue
//     //in such a way that if any bigger number is encountered compared to peekLast, we remove all 
//     //the indices of smaller numbers from the queue.

//     //When we move towards right, we will have to make sure that front of the queue does not contain
//     //the i - k index as that will be an outdated element, given that we have moved towards right.
//     //i = 4, k = 3 ==> left should be at 2 and if the front of the queue is 1, then we remove that 
//     //from the queue.

//     //We remove the indices of smaller numbers from the deque's back.

//     //We add current number's idx from back of deque 

//     //We check if we have acheived a window size of k, if yes, we add the number at idx that is at
//     //front of the queue to our ans array.

//     //Basically we will try to maintain the queue in an increasing order from back->front and make 
//     //sure that the front does not contain any outdated number. 

//     public int[] maxSlidingWindow(int[] nums, int k) {
//         if(k == 1) return nums;
//         int[] maxSlidingWindow = new int[nums.length - k + 1];
//         int idx = 0;
//         Deque<Integer> numQueue = new ArrayDeque<>();

//         // int right = 0;

//         for(int i = 0; i < nums.length; i ++){

//             // if(numQueue.isEmpty()){
//             //     numQueue.offerLast(i);
//             //     // continue;
//             // }

//             if(!numQueue.isEmpty() && numQueue.peekFirst() == i - k){ //if element at front of the queue
//             //is out of the window bounds remove it from the front 
//                 numQueue.pollFirst(); 
//             }

//             while(!numQueue.isEmpty() && nums[i] > nums[numQueue.peekLast()]){
//                 numQueue.pollLast(); //remove the indices of numbers that are smaller than the nums[i]
//             }

//             numQueue.offerLast(i);

//             if(!numQueue.isEmpty() && i - k  + 1 >= 0){ //size of window is equal to k. Update the ans 
//                 maxSlidingWindow[idx ++] = nums[numQueue.peekFirst()];
//             }
//         }

//         return maxSlidingWindow;

// ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //24 Oct 2025: intuition 2: maintain a minheap (priorityQueue) of size k. While moving right, remove the 
    // //number at left from the priorityQueue and add the number from right + 1 and peek the new max.

    // public int[] maxSlidingWindow(int[] nums, int k) {
    //     int maxSum = Integer.MIN_VALUE;
    //     int[] maxSlidingWindow = new int[nums.length - k + 1];
    //     int idx = 0;
        
    //     PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a)); 
    //     //A negative result means a comes before b
    //     //A positive result means b comes before a

    //     //initializing maxHeap first
    //     for(int i =  0; i < k; i ++){
    //         maxHeap.offer(nums[i]);
    //     }

    //     maxSlidingWindow[idx ++] = maxHeap.peek();

    //     int right = k - 1;
    //     int left = 0;

    //     while(right < nums.length - 1){
    //         maxHeap.remove(nums[left ++]);
    //         right += 1;
    //         maxHeap.offer(nums[right]);

    //         maxSlidingWindow[idx ++] = maxHeap.peek();
    //     }

    //     return maxSlidingWindow;

    // }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //24 Oct 2025: intuition 1: Run a for loop and keep track of sum of numbers within the first window.
    // // Afterwards, subtract the number at left - 1 and add the number at new right (right + 1). Keep
    // //track of maximum in this process ->>> WRONG Interpretation of the question

    // public int[] maxSlidingWindow(int[] nums, int k) {
    //     int maxSum = Integer.MIN_VALUE;
    //     int[] maxSlidingWindow = new int[nums.length - k + 1];
    //     int idx = 0;

    //     int currSum = 0;
    //     //calculating sum of startin window
    //     for(int i = 0; i < k; i ++){
    //         currSum += nums[i];
    //     }
    //     maxSum = currSum;
    //     maxSlidingWindow[idx ++] = currSum;
    //     int left = 0;
    //     int right = k - 1;

    //     while(true){
    //         currSum -= nums[left ++];
    //         if(right + 1 < nums.length){
    //             right += 1;
                 
    //             currSum += nums[right];
    //             maxSum = Math.max(currSum, maxSum);
    //             maxSlidingWindow[idx ++] = maxSum;
    //         }
    //         else{
    //             return maxSlidingWindow;
    //         }
            
    
    //     }

}