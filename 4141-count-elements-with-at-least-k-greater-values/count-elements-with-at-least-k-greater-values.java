class Solution {

    //Solving on 29 Nov 2025:

    //intuition 1: Have freqArray that stores the frequency of the nums
    
    public int countElements(int[] nums, int k) {
        if(nums.length == 0){
            return 0;
        }
        // if(nums.length == 1){
        //     return 1;
        // }
        if(k == 0){
            return nums.length;
        }
        // HashSet<Integer> set = new HashSet<>();
        // HashMap<Integer, Integer> map  = new HashMap<>();

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int num : nums){
            // map.put(num, map.getOrDefault(num, 0) + 1);
            // set.add(num);
            minHeap.offer(num);
        }
        int count = 0;
        while(minHeap.size() > k){
            int currNum = minHeap.poll();
            int currNumCount = 1;
            //removing same duplicate element
            while(minHeap.size() != 0 && minHeap.peek() == currNum){
                currNumCount += 1;
                minHeap.poll();
            }
            if(minHeap.size() >= k){
                // count += map.get(currNum);
                count += currNumCount;
            }
        }
        // System.out.println(count);

        return count;
    }

//////////////////////////////////////////////////////////////////
    // //Solving on 29 Nov 2025:

    // //intuition 1: Use heaps. Use minHeap to store all the elements. Then poll the first element
    //     //and recaclulate the size of heap, if it is greater than equal to k, add to your count.
    // //Only add unique elements, have a hashset to make sure that  
    // public int countElements(int[] nums, int k) {
    //     HashSet<Integer> set = new HashSet<>();

    //     PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    //     for(int num : nums){
    //         if(set.add(num)){
    //             minHeap.offer(num);
    //         }
    //     }
    //     int count = 0;
    //     while(minHeap.size() > k){
    //         int currNum = minHeap.poll();

    //         if(minHeap.size() >= k){
    //             count += 1;
    //         }
    //     }

    //     return count;
    // }
}