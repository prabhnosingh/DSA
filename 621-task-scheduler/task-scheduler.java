class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int tasksCount = tasks.length;
        HashMap<Character, Integer> map = new HashMap<>();

        for(char ch : tasks){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // this is a minHeap that will act as a maxHeap because of reverseOder()
        maxHeap.addAll(map.values());

        int time = 0;
        Deque<int[]> queue = new ArrayDeque<>(); // queue of pairs of [count, idleTime]

        while(!maxHeap.isEmpty() || !queue.isEmpty()){
            
            if(!queue.isEmpty() && time >= queue.peek()[1]){ //queue.peek()[1] => indicates "idleTime"
                maxHeap.offer(queue.poll()[0]); // queue.poll()[0] => indicates "count" of a specific character(A, B, C ....)
            }

            if(!maxHeap.isEmpty()){
                int count = maxHeap.poll() - 1;
                if(count > 0){
                    queue.offer(new int[]{count, time + n + 1});
                }
            }
            time ++;
        }
        return time;


    }
}