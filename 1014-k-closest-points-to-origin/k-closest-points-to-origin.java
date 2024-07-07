class Solution {
    public int[][] kClosest(int[][] points, int k) {
        

        Comparator<int[]> comp = new Comparator<int[]>(){
            @Override
            public int compare(int[] first, int[] second){
                int firstDist = first[0] * first[0] + first[1] * first[1]; 
                int secondDist = second[0] * second[0] + second[1] * second[1]; 
                return Integer.compare(firstDist, secondDist);
            }
        };

        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>(comp);
        for(int[] point : points){
            minHeap.offer(point);
        }

        int[][] ans = new int[k][2];
        k --;
        while(k >= 0 && minHeap.size() != 0){
            // System.out.println(minHeap.size());
            ans[k --] = minHeap.poll();
        }

        return ans;




    }
}