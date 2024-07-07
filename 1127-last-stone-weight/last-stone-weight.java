class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int stone : stones){
            maxHeap.offer(stone);
        }

        while(maxHeap.size() > 1){
            int firstStone = maxHeap.poll();
            int secondStone = maxHeap.poll();
            int diff = firstStone - secondStone;
            
            if(diff != 0){
                maxHeap.offer(diff);
            }
        }
        maxHeap.offer(0);

        // return maxHeap.size() > 0 ? maxHeap.poll() : 0;
        return maxHeap.peek();
    }
}