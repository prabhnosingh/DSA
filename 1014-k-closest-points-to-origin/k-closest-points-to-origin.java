class Solution {
    
    //Re-solving on 24 Nov 2025:

    //intuition 2(using int[]): Have a max heap of size k that takes arraylist of integers and compares a.get(0)^2 + a.get(0)^2
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((b,a) -> ((a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1])));
        int[][] kClosest = new int[k][2];
        int idx = 0;
        
        for(int[] point : points){
            maxHeap.offer(point);
            
            if(maxHeap.size() > k) maxHeap.remove(); //to keept the size upto k only
        }
        

        while(!maxHeap.isEmpty()){
            int[] currPoint = maxHeap.remove();

            
            kClosest[idx ++] = currPoint;
        }

        return kClosest;

    }
    
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Re-solving on 24 Nov 2025:

    // //intuition 1: Have a max heap of size k that takes arraylist of integers and compares a.get(0)^2 + a.get(0)^2
    // public int[][] kClosest(int[][] points, int k) {
    //     PriorityQueue<List<Integer>> maxHeap = new PriorityQueue<>((b,a) -> (
    //         (a.get(0)*a.get(0) + a.get(1)*a.get(1)) 
    //         - (b.get(0)*b.get(0) + b.get(1)*b.get(1))));
    //     int[][] kClosest = new int[k][2];
    //     int idx = 0;
        
    //     for(int[] point : points){
    //         maxHeap.offer(new ArrayList(Arrays.asList(point[0], point[1])));
            
    //         if(maxHeap.size() > k) maxHeap.remove(); //to keept the size upto k only
    //     }
        

    //     while(!maxHeap.isEmpty()){
    //         List<Integer> currPoint = maxHeap.remove();

    //         int[] point = {currPoint.get(0), currPoint.get(1)};
    //         kClosest[idx ++] = point;
    //     }

    //     return kClosest;

    // }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // intuition 1: use minHeap to store coordinates and distance (dist, x, y) and sort based on dist for all points 
    // then poll first k and return
    // public int[][] kClosest(int[][] points, int k) {
    //     int[][] ans = new int[k][2];
    //     PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] - b[0])); // a[0] denotes dist for point 'a' 
    //     // from origin 
        
    //     for(int[] point : points){
    //         int dist = (int) (Math.pow(point[0], 2) + Math.pow(point[1], 2)); // we do not need square root as we are only
    //         // comparing and do not care about exact values
    //         // using (int) as Math.pow's return value is double and in any given case we cannot have two decimal 
    //         // coordinates(because points is of type int[][]), therefore we do not loose any decimal values by 
    //         // doing '(int)' and it safely assigns the value to variable 'dist'

    //         minHeap.offer(new int[]{dist, point[0], point[1]}); 
    //     }

    //     for(int i = 0; i < k; i ++){
    //         int[] temp = minHeap.poll();
    //         ans[i] = new int[]{temp[1], temp[2]}; // x, y
    //     }
    //     return ans;
    // }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////

//     //intuition 2: use custom comparator
//     public int[][] kClosest(int[][] points, int k) {
//         int[][] ans = new int[k][2];
//         Comparator<int[]> comp = new Comparator<int[]>(){
//             @Override
//             public int compare(int[] first, int[] second){
//                 int firstDist = first[0] * first[0] + first[1] * first[1];
//                 int secondDist = second[0] * second[0] + second[1] * second[1];
//                 return Integer.compare(firstDist, secondDist);
//              }
//         };

//         PriorityQueue<int[]> minHeap = new PriorityQueue<>(comp);

//         for(int[] point : points){
//             minHeap.offer(point);
//         }

//         int i = 0;
//         while (i < k){
//             ans[i ++] = minHeap.poll();
//         }
//         return ans;
//     }

// }
























/////////////////////////////////////////////////////////////////

    //Re-solving: intuition 1: We can solve this problem by using minHeap (priority Queue) that
    //takes x and y coordinates, and sorts different points by using a custom comparator
    //and comparing distance of each point from origin. At the last, output k points by polling
    //k elements from the min heap

    //first solve it with min heap and then other approaches (divide and conquer, QuickSelect, 
    //Sorting etc.)

    //TC: O(nlogn (insertion) + nlogk (polling)) = O(nlogn) -> where n is the number of points
    //SC: O(n) -> max size of heap 
    // public int[][] kClosest(int[][] points, int k) {
    //     int[][] ans = new int[k][2];
    //     PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> ((a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1])));


    //     for(int[] point : points){
    //         minHeap.offer(point);
    //     }

    //     int idx = 0;
    //     while(k > 0){
    //         ans[idx] = minHeap.poll();
    //         // System.out.println(ans[idx]);
    //         k --; 
    //         idx ++;
    //     }
    //     return ans;
    // }


    // //doing with maxheap to reduce TC

    // //TC: O(nlog)
    // //SC:
    // public int[][] kClosest(int[][] points, int k) {
    //     int[][] ans = new int[k][2];
    //     PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> ((b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1])));


    //     for(int[] point : points){
    //         maxHeap.offer(point);
    //         if(maxHeap.size() == k + 1){
    //             maxHeap.poll();
    //         }
    //     }

    //     int idx = 0;
    //     while(k > 0){
    //         ans[idx] = maxHeap.poll();
    //         // System.out.println(ans[idx]);
    //         k --; 
    //         idx ++;
    //     }
    //     return ans;
    // }

}





































