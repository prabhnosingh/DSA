class Solution {
    public String[] findRelativeRanks(int[] score) {
        
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int s : score){
            queue.offer(s);
        }

        int count = 1;
        while(queue.size() != 0){
            map.put(queue.poll(), count ++);
        }
        String[] answer = new String[score.length];
        int i = 0;
        for(int s : score){
            switch(map.get(s)){
                case 1:
                answer[i ++] = "Gold Medal";
                break;

                case 2:
                answer[i ++] = "Silver Medal";
                break;
                
                case 3:
                answer[i ++] = "Bronze Medal";
                break;

                default:
                answer[i ++] = map.get(s) + "";

            }
            
        }

        return answer;

    }
}