class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
// Beats 74.36 %
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

//***************************** Beats 19.79 %*************************************************************** */

//     PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparing(a -> a[0])); 
//     // a -> a[0] means that a (which is an array of integers) will be compared based on the first element of the array(which is a[0])

//     for(int[] point : points){
//         int dist = point[0] * point[0] + point[1] * point[1];

//         minHeap.offer(new int[]{dist, point[0], point[1]});
//     }
//     int[][] res = new int[k][2];
//     k --;
//     while(k >= 0 && minHeap.size() != 0){
//         int[] temp = minHeap.poll();
//         // res[k][0] = temp[1];
//         // res[k --][1] = temp[2];

//         res[k --] = new int[]{temp[1], temp[2]};
//     }

// return res;





    }
}