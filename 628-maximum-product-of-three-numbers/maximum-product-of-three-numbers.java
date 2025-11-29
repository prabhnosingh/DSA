class Solution {

    //Solving on 29 Nov 2025:

    //intuition 1: The maximum product of three numbers will come from 3 max numbers. 
    //There can be three scenarios:
        //All the elements are positive: compute and return the product of last three nums after sorting 
        //All the elements are negatiev: compute and return the product of first three nums after sorting
        //Some elements are positive and some negative:  We only need two negative numbers (smallest) be part
            //of product as negative sign will be negated.
    
    //Have three heaps. One maxHeap for negative nums, one minHeap for negative nums, and one maxHeap for positive nums
        //If either of them have 0 elements, return the product of top three elements from either of these
        //If both of them have combined 3 numbers, poll them all and return the product
        //If negative heap have only 1 element, only poll from positive heap
        //If negative heap is of size more than 1 (>= 2), remove the top 2 elements from minHeap for negative nums and add
        //to maxHeap for positive nums and then poll 3 from the maxHeap for positive nums and return the product

    public int maximumProduct(int[] nums) {
        PriorityQueue<Integer> minHeapForNegativeNums = new PriorityQueue<>((a,b) -> (a-b));
        PriorityQueue<Integer> maxHeapForNegativeNums = new PriorityQueue<>((a,b) -> (b-a));

        PriorityQueue<Integer> maxHeapForPositiveNums = new PriorityQueue<>((a,b) -> (b-a));


        for(int num : nums){
            if(num >= 0){
                maxHeapForPositiveNums.offer(num);
            }
            else{
                maxHeapForNegativeNums.offer(num);
                minHeapForNegativeNums.offer(num);
            }
        }

        int negNumCount = maxHeapForNegativeNums.size();
        int posNumCount = maxHeapForPositiveNums.size();

        int maxProd = 1;

        if(negNumCount == 0){
            for(int i = 0; i <= 2; i ++){
                maxProd = maxProd * maxHeapForPositiveNums.poll();
            }
        }
        else if(posNumCount == 0){
            for(int i = 0; i <= 2; i ++){
                maxProd = maxProd * maxHeapForNegativeNums.poll();
            }

        }
        else if(negNumCount + posNumCount == 3){
            while(!maxHeapForNegativeNums.isEmpty()){
                maxProd *= maxHeapForNegativeNums.poll();
            }
            while(!maxHeapForPositiveNums.isEmpty()){
                maxProd *= maxHeapForPositiveNums.poll();
            }
        }
        else if(negNumCount >= 2){
            int neg1 = minHeapForNegativeNums.poll();
            int neg2 = minHeapForNegativeNums.poll();
            int tempProd = neg1 * neg2 * maxHeapForPositiveNums.peek();

            for(int i = 0; i <= 2; i ++){
                if(maxHeapForPositiveNums.isEmpty()) break;
                maxProd = maxProd * maxHeapForPositiveNums.poll();
            }
            maxProd = Math.max(maxProd, tempProd);

        }
        else{
            for(int i = 0; i <= 2; i ++){
                maxProd = maxProd * maxHeapForPositiveNums.poll();
            }
        }
    

        return maxProd;

    }
}