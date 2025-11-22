class Solution {
    //Re-solving on 22 Nov 2025:

    //intuition 1 (heap) (beats 22.54%): Have a heap and initialize it with all stones. Then remove two stones at a time and
    //offer back the result of smash (if non-zero). At last return the final result 
    
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> (b-a));

        for(int stoneW : stones){
            maxHeap.offer(stoneW);
        }

        while(maxHeap.size() > 1){
            int stone1 = maxHeap.remove();
            int stone2 = maxHeap.remove();

            int smashResult = stone1 - stone2;
            if(smashResult != 0){
                maxHeap.offer(smashResult);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.remove();

    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////
 
    // //Re-solving on 22 Nov 2025:

    // //intuition 1 (heap) (beats 22.54%): Have a heap and initialize it with all stones. Then remove two stones at a time and
    // //offer back the result of smash (if non-zero). At last return the final result 
    
    // public int lastStoneWeight(int[] stones) {
    //     PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> (b-a));

    //     for(int stoneW : stones){
    //         maxHeap.offer(stoneW);
    //     }

    //     while(maxHeap.size() > 1){
    //         int stone1 = maxHeap.remove();
    //         int stone2 = maxHeap.remove();

    //         int smashResult = stone1 - stone2;
    //         if(smashResult != 0){
    //             maxHeap.offer(smashResult);
    //         }
    //     }

    //     return maxHeap.isEmpty() ? 0 : maxHeap.remove();

    // }
 







 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 
    // intuition 1 (priority queue): Use max heap to get two pops and then insert the result 
    //back to the heap, return the last or, 0 if empty 
    // public int lastStoneWeight(int[] stones) {
    //     int ans = 0;

    //     PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a)); //max elemnet at top
    //     for(int stone : stones){
    //         maxHeap.offer(stone);
    //     }

    //     while(maxHeap.size() > 1){
    //         int stone1 = maxHeap.poll();
    //         int stone2 = maxHeap.poll();
    //         int collisionRes = stone1 - stone2;
    //         if(collisionRes != 0){
    //             maxHeap.offer(collisionRes);
    //         }
    //     }

    //     return maxHeap.size() != 0 ? maxHeap.poll() : 0;

    // }

    ////////////////////////////////////////////////////////////

    // //inutition 2 (two pointer): use two pointers in a sorted array from the reverse
    // public int lastStoneWeight(int[] stones) {
    // //    if(stones.length == 1){
    // //         return stone;
    // //    } 
    //    Arrays.sort(stones);

    //    for(int i = stones.length - 1; i > 0; i --){
    //         int collisionRes = stones[i] - stones[i - 1];
    //         stones[i - 1] = collisionRes; // replacing stones[i - 1] with the collision result
    //         // stones = Arrays.copyOfRange(stones, 0, i);
    //         Arrays.sort(stones, 0, i); // sort stones array from 0 to i - 1(inclusive) because we don't need to sort the 
    //         // array after i - 1 (inclusive) as we don't need it anymore
    //    }
    //    return stones[0]; // this works because the final result will be added to stones[i - 1] (i == 1 -> i - 1 = 0) 
    // }

}