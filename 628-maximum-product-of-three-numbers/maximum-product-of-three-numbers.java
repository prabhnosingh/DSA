class Solution {

    //Solving on 30 Nov 2025:

    //intuition 2(without sorting): To make the product maximum we have to choose numbers that give max product.
    //If it has negatives, the smallest numbers (big negatives) will be at extreme
    //left and the largest numbers (big positives) will be at extreme right. 

    //So we can compute two different products and return the maximum of them:
        //Two left extreme nums * 1 right extreme nums 
        //Three right extreme nums 


    //The logic of finding maxProd from two different scenarios remain the same but we do not sort the array,
        //and instead find the all the different five numbers (max1 (nums[nLen - 1]), max2 (nums[nLen - 2]), 
        //max3 (nums[nLen - 3]), min1 (nums[0]) and min2 (nums[1]))


    public int maximumProduct(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = min1, max1 = Integer.MIN_VALUE, max2 = max1, max3 = max1;

        for(int num : nums){
            if(num <= min1){
                min2 = min1;
                min1 = num;
                // min2 = min1;
            }
            else if(num <= min2){
                min2 = num;
            }

            if(num >= max1){
                max3 = max2;
                max2 = max1;
                max1 = num;
            }
            else if(num >= max2){
                max3 = max2;
                max2 = num;
            }
            else if(num >= max3){
                max3 = num;
            }
        }

        return Math.max(max1 * max2 * max3, max1 * min1 * min2);


    }



////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Solving on 30 Nov 2025:

    // //intuition 1 (sorting): To make the product maximum we have to choose numbers that give max product.
    // //Sort the array, if it has negatives, the smallest numbers (big negatives) will be at extreme
    // //left and the largest numbers (big positives) will be at extreme right. 

    // //So we can compute two different products and return the maximum of them:
    //     //Two left extreme nums * 1 right extreme nums 
    //     //Three right extreme nums 

    // public int maximumProduct(int[] nums) {
    //     Arrays.sort(nums);  
    //     int nLen = nums.length;

    //     int case1Prod = nums[0] * nums[1] * nums[nLen - 1];
    //     int case2Prod = nums[nLen - 1] * nums[nLen - 2] * nums[nLen - 3];

    //     return Math.max(case1Prod, case2Prod);
    // }































/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Solving on 29 Nov 2025:

    // //intuition 1: Sort the array. There could be two scenarios:
    //     //all the numbers are positive or all are negative, in which case max numbers will be on the right 
    //         //end of the sorted array.
    //     //some numbers are negative and some are positive, in which case take leftmost 2 (least negative) 
    //         //and mutliply with rightmost positive.   

    //     //maxProd will be max of the above two scenarios

    // public int maximumProduct(int[] nums) {
    //     Arrays.sort(nums);

    //     //case 1
    //     int case1Prod = 1;
    //     // for(int i = nums.length; i >= 0; i --){
    //     //     case1Prod *= nums[i];
    //     // }
    //     case1Prod = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];

    //     //case 2
    //     int case2Prod = 1;
    //     case2Prod = nums[0] * nums[1] * nums[nums.length - 1];

    //     return Math.max(case1Prod, case2Prod);

    // }






















////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Solving on 29 Nov 2025:

    // //intuition 1: The maximum product of three numbers will come from 3 max numbers. 
    // //There can be three scenarios:
    //     //All the elements are positive: compute and return the product of last three nums after sorting 
    //     //All the elements are negatiev: compute and return the product of first three nums after sorting
    //     //Some elements are positive and some negative:  We only need two negative numbers (smallest) be part
    //         //of product as negative sign will be negated.
    
    // //Have three heaps. One maxHeap for negative nums, one minHeap for negative nums, and one maxHeap for positive nums
    //     //If either of them have 0 elements, return the product of top three elements from either of these
    //     //If both of them have combined 3 numbers, poll them all and return the product
    //     //If negative heap have only 1 element, only poll from positive heap
    //     //If negative heap is of size more than 1 (>= 2), remove the top 2 elements from minHeap for negative nums and add
    //     //to maxHeap for positive nums and then poll 3 from the maxHeap for positive nums and return the product

    // public int maximumProduct(int[] nums) {
    //     PriorityQueue<Integer> minHeapForNegativeNums = new PriorityQueue<>((a,b) -> (a-b));
    //     PriorityQueue<Integer> maxHeapForNegativeNums = new PriorityQueue<>((a,b) -> (b-a));

    //     PriorityQueue<Integer> maxHeapForPositiveNums = new PriorityQueue<>((a,b) -> (b-a));


    //     for(int num : nums){
    //         if(num >= 0){
    //             maxHeapForPositiveNums.offer(num);
    //         }
    //         else{
    //             maxHeapForNegativeNums.offer(num);
    //             minHeapForNegativeNums.offer(num);
    //         }
    //     }

    //     int negNumCount = maxHeapForNegativeNums.size();
    //     int posNumCount = maxHeapForPositiveNums.size();

    //     int maxProd = 1;

    //     if(negNumCount == 0){
    //         for(int i = 0; i <= 2; i ++){
    //             maxProd = maxProd * maxHeapForPositiveNums.poll();
    //         }
    //     }
    //     else if(posNumCount == 0){
    //         for(int i = 0; i <= 2; i ++){
    //             maxProd = maxProd * maxHeapForNegativeNums.poll();
    //         }

    //     }
    //     else if(negNumCount + posNumCount == 3){
    //         while(!maxHeapForNegativeNums.isEmpty()){
    //             maxProd *= maxHeapForNegativeNums.poll();
    //         }
    //         while(!maxHeapForPositiveNums.isEmpty()){
    //             maxProd *= maxHeapForPositiveNums.poll();
    //         }
    //     }
    //     else if(negNumCount >= 2){
    //         int neg1 = minHeapForNegativeNums.poll();
    //         int neg2 = minHeapForNegativeNums.poll();
    //         int tempProd = neg1 * neg2 * maxHeapForPositiveNums.peek();

    //         for(int i = 0; i <= 2; i ++){
    //             if(maxHeapForPositiveNums.isEmpty()) break;
    //             maxProd = maxProd * maxHeapForPositiveNums.poll();
    //         }
    //         maxProd = Math.max(maxProd, tempProd);

    //     }
    //     else{
    //         for(int i = 0; i <= 2; i ++){
    //             maxProd = maxProd * maxHeapForPositiveNums.poll();
    //         }
    //     }
    

    //     return maxProd;

    // }
}