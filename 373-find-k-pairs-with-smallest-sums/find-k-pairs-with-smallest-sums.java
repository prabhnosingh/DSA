

class Solution{


    //Re-solving on 26 Nov 2025

    //intuition 1 (without HashSet): Have a custom class, whose each object stores the nums (num1 and num2), 
        //their indices(idx1 and idx2) along with the sum of num1 and num2.
    //Have minHeap that takes the object of this custom class and sorts the objects based on the 
        //sum (obj.sum)
    //Two ways to insert elements in minHeap:
        //First go with inserting all possible combinations while maintaining a visited hashset
            //that will ensure no duplicate indices are added in the minHeap. Start with inserting 
            //0,0 from both arrays and then expanding to next possible indices. 0,0 will lead to 
            //0,1 or 1,0

        //Second go with first inserting all possible combinations of all first array's indices 
            //with second array's first (0) index. This will remove the need of a visited Hashset.
            //Then when we pop the smallest object at any time, we check if idx2 + 1 goes out of 
            //bounds of second array's length, if no, we insert the object in minHeap
            //0,0, 1,0, 2,0, 3,0 -> 0,1, 1,1, 2,1, 3,1
        //After each poll, add the list of numbers (2 numbers) to the ans list of k smallest pairs
    //major optimization is of choosing minimum from k and nums1.length while inserting combinations 
        //of nums1's all elements array with nums2's first element as we only need k initial pairs 
        //to have our answer

    static class Pair{
        int num1, num2, idx1, idx2, sum;

        Pair(int num1, int num2, int idx1, int idx2){
            this.num1 = num1;
            this.idx1 = idx1;

            this.num2 = num2;
            this.idx2 = idx2;

            this.sum = num1 + num2;
        }
    }
    //second approach (without using visited hashSet)
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a,b) -> (a.sum-b.sum));
        // HashSet<String> visited = new HashSet<>();
        List<List<Integer>> kSmallestPairs = new ArrayList<>();

        //add all the combinations of nums1 elements with nums2's first element
        for(int i = 0; i < Math.min(k, nums1.length); i ++){ //major optimization is of choosing minimum
        //from k and nums1.length while inserting combinations of nums1's all elements array with nums2's
        // first element as we only need k initial pairs to have our answer
            Pair pairObj = new Pair(nums1[i], nums2[0], i, 0);
            
            minHeap.offer(pairObj);

        }

        // visited.add(0 + "," + 0); // "0,0"
        

        while(kSmallestPairs.size() != k){
            Pair currSmallestSumPairObj = minHeap.poll();
            int idx1 = currSmallestSumPairObj.idx1;
            int idx2 = currSmallestSumPairObj.idx2;
            // int num1 = currSmallestSumPairObj.num1;
            // int num2 = currSmallestSumPairObj.num2;

            // kSmallestPairs.add(new ArrayList<>(Arrays.asList(nums1[idx1], nums2[idx2])));
            kSmallestPairs.add(Arrays.asList(nums1[idx1], nums2[idx2]));

            // int newIdx1 = idx1 + 1;
            int newIdx2 = idx2 + 1;

            if(newIdx2 < nums2.length){ //0,1
                minHeap.offer(new Pair(nums1[idx1], nums2[newIdx2], idx1, newIdx2));
            }

        }
        

        return kSmallestPairs;

    }















////////////////////////////////////////////////////////////////////////////////////////////

    // //Re-solving on 26 Nov 2025

    // //intuition 1 (using HashSet): Have a custom class, whose each object stores the nums (num1 and num2), 
    //     //their indices(idx1 and idx2) along with the sum of num1 and num2.
    // //Have minHeap that takes the object of this custom class and sorts the objects based on the 
    //     //sum (obj.sum)
    // //Two ways to insert elements in minHeap:
    //     //First go with inserting all possible combinations while maintaining a visited hashset
    //         //that will ensure no duplicate indices are added in the minHeap. Start with inserting 
    //         //0,0 from both arrays and then expanding to next possible indices. 0,0 will lead to 
    //         //0,1 or 1,0

    //     //Second go with first inserting all possible combinations of all first array's indices 
    //         //with second array's first (0) index. This will remove the need of a visited Hashset.
    //         //Then when we pop the smallest object at any time, we check if idx2 + 1 goes out of 
    //         //bounds of second array's length, if no, we insert the object in minHeap
    //     //After each poll, add the list of numbers (2 numbers) to the ans list of k smallest pairs

    // static class Pair{
    //     int num1, num2, idx1, idx2, sum;

    //     Pair(int num1, int num2, int idx1, int idx2){
    //         this.num1 = num1;
    //         this.idx1 = idx1;

    //         this.num2 = num2;
    //         this.idx2 = idx2;

    //         this.sum = num1 + num2;
    //     }
    // }
    // //first approach (using visited hashSet)
    // public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

    //     PriorityQueue<Pair> minHeap = new PriorityQueue<>((a,b) -> (a.sum-b.sum));
    //     HashSet<String> visited = new HashSet<>();
    //     List<List<Integer>> kSmallestPairs = new ArrayList<>();

    //     Pair initialPairObj = new Pair(nums1[0], nums2[0], 0, 0);

    //     minHeap.offer(initialPairObj);
    //     visited.add(0 + "," + 0); // "0,0"
        

    //     while(kSmallestPairs.size() != k){
    //         Pair currSmallestSumPairObj = minHeap.poll();
    //         int idx1 = currSmallestSumPairObj.idx1;
    //         int idx2 = currSmallestSumPairObj.idx2;
    //         int num1 = currSmallestSumPairObj.num1;
    //         int num2 = currSmallestSumPairObj.num2;

    //         kSmallestPairs.add(new ArrayList<>(Arrays.asList(num1, num2)));

    //         int newIdx1 = idx1 + 1;
    //         int newIdx2 = idx2 + 1;

    //         if(newIdx1 < nums1.length && visited.add(newIdx1 + "," + idx2)){ //1,0
    //             minHeap.offer(new Pair(nums1[newIdx1], nums2[idx2], newIdx1, idx2));
    //         }

    //         if(newIdx2 < nums2.length && visited.add(idx1 + "," + newIdx2)){ //0,1
    //             minHeap.offer(new Pair(nums1[idx1], nums2[newIdx2], idx1, newIdx2));
    //         }

    //     }
        

    //     return kSmallestPairs;

    // }















////////////////////////////////////////////////////////////////////////////////////////////
    // //Re-solving on 22 Nov 2025

    // //intuition 2 (minHeap): 
    //     //Have a Pair custom class that takes idx1, idx2, num1, num2 and computes sum = num1 + num2 
    //     //Have a minHeap of type Pair with comparator based on Pari.sum and offer it all nums1 elements
    //         //mapped to nums2[0] element
    //     //Then remove the elements from minHeap and add it to ansList, then check if idx2 is still less than
    //         //nums2.length, if yes offer new Pair(idx1, idx2 + 2, nums1[idx1], nums2[idx2 + 1]) to consider
    //         //the next combination as well
        
    //     //By following this algo, we ensure that the smallest pair is always on the top to the minHeap.

    //     //This works as it is guaranteed that the smallest pair will be (0, 0), then it will be either from
    //     //(1, 0) or (0, 1). 
    //         //If smallest is (1,0) then next will be from either (1,1) (added now) or (2,0) (already there) 
    //         //If smallest is (0,1) then next will be from either (1,0) (already there) or (0,2) (added now)
    
    // static class Pair{
    //     int idx1, idx2, num1, num2, sum;
    //     Pair(int idx1, int idx2, int num1, int num2){
    //         this.idx1 = idx1;
    //         this.idx2 = idx2;

    //         this.num1 = num1;
    //         this.num2 = num2;

    //         this.sum = num1 + num2;
    //     }

    // }



    // public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            
    //     List<List<Integer>> smallestPairs = new ArrayList<>();
    //     PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> (a.sum - b.sum));       

    //     // for(int i = 0; i < nums1.length; i ++){ //we only need k pairs, so triming the initializaiton of heap
    //     //to first k elements (or even smaller) of nums1 array. This makes sense as we will find our k pairs within
    //     //these pairs only
    //     for(int i = 0; i < Math.min(k, nums1.length); i ++){
    //         minHeap.offer(new Pair(i, 0, nums1[i], nums2[0])); //inserting first k or all nums1 elements mapped 
    //         //to nums2's 0 index element
    //     }

    //     while(!minHeap.isEmpty() && smallestPairs.size() < k){
    //         Pair smallestSumPair = minHeap.remove();
    //         int idx1 = smallestSumPair.idx1;
    //         int idx2 = smallestSumPair.idx2;
    //         // smallestPairs.add(new ArrayList<>(Arrays.asList(smallestSumPair.num1, smallestSumPair.num2)));
    //         smallestPairs.add(new ArrayList<>(Arrays.asList(nums1[idx1], nums2[idx2])));

    //         if(idx2 + 1 < nums2.length){
    //             minHeap.offer(new Pair(idx1, idx2 + 1, nums1[idx1], nums2[idx2 + 1]));

    //         }
    //     }

    //     return smallestPairs;
    // }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Re-solving on 22 Nov 2025

    // //intuition 1 (TLE): Have a minHeap and offer it all the combinations of possible sums, then remove first k pairs
    // //We don't need to offer all the combinations though
    
    // public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
    //     List<List<Integer>> smallestPairs = new ArrayList<>();
    //     PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>((a, b) -> ((a.get(0) + a.get(1)) - (b.get(0) + b.get(1))));       

    //     for(int i = 0; i < nums1.length; i ++){
    //         for(int j = 0; j < nums2.length; j ++){
    //             minHeap.offer(new ArrayList<>(Arrays.asList(nums1[i], nums2[j])));
    //         }
    //     }

    //     while(k != 0){
    //         smallestPairs.add(minHeap.remove());
    //         k --;
    //     }

    //     return smallestPairs;
    // }






























///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //re-solving: 12 Oct 2025

    // //intuition 2(heap): The logic is to start with 0,0 and then travers 0, 1 and 1, 0. Then for 0,1 traverse 0,2 and 1,1
    // //as after 0,0 the next smallest sum will be either in 0,1 or 1,0. 
    // //For 0,1 next smallest sum will be in either 0,2 or 1,1
    // //For 1,0 next smallest sum will be in either 2,0 or 1,1 => Here we observe that we have redundant pairs. To avoid this
    // //we use visited set.

    // //visited set's need can be removed if we add i,0 pairs to minheap initially, where i is the index of nums1.
    // //kind of mapping elements of nums1 with nums2[0] 

    // //And later only adding pointer2 increments to the heap. This way duplicates are avoided 

    // static class Pair{
    //         int p1, p2, num1, num2, sum;
    //         Pair(int p1, int p2, int num1, int num2){
    //             this.p1 = p1;
    //             this.p2 = p2;
    //             this.num1 = num1;
    //             this.num2 = num2;
    //             this.sum = num1 + num2;

    //         }
    //     }
    
    // public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        

    //     PriorityQueue<Pair> minHeap = new PriorityQueue<>((pair1, pair2) -> (pair1.sum - pair2.sum));
    //     List<List<Integer>> kPairsWithSmallestSums = new ArrayList<>();

    //     // Set<String> visited = new HashSet<>();
    //     for(int i = 0; i < nums1.length; i ++){
    //         minHeap.offer(new Pair(i, 0, nums1[i], nums2[0]));
    //     }
    //     // visited.add("0, 0");


    //     while(!minHeap.isEmpty() && kPairsWithSmallestSums.size() < k){
    //         Pair tempPair = minHeap.poll();
    //         int pointer1 = tempPair.p1;
    //         int pointer2 = tempPair.p2;

    //         kPairsWithSmallestSums.add(new ArrayList<>(Arrays.asList(nums1[pointer1], nums2[pointer2])));

    //         // if(pointer1 + 1 < nums1.length && visited.add((pointer1 + 1) + ", " + pointer2)){
    //         //     minHeap.add(new Pair(pointer1 + 1, pointer2, nums1[pointer1 + 1], nums2[pointer2]));
    //         // }
    //         if(pointer2 + 1 < nums2.length){
    //             minHeap.add(new Pair(pointer1, pointer2 + 1, nums1[pointer1], nums2[pointer2 + 1]));
    //         }

    //     }
    //     return kPairsWithSmallestSums;

       

    // }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //re-solving: 12 Oct 2025

    // //intuition 1(heap): The logic is to start with 0,0 and then travers 0, 1 and 1, 0. Then for 0,1 traverse 0,2 and 1,1
    // //as the after 0,0 the next smallest sum will be either in 0,1 or 1,0. 
    // //For 0,1 next smallest sum will be in either 0,2 or 1,1
    // //For 1,0 next smallest sum will be in either 2,0 or 1,1 => Here we observe that we have redundant pairs. To avoid this
    // //we use visited set.

    

    // static class Pair{
    //         int p1, p2, num1, num2, sum;
    //         Pair(int p1, int p2, int num1, int num2){
    //             this.p1 = p1;
    //             this.p2 = p2;
    //             this.num1 = num1;
    //             this.num2 = num2;
    //             this.sum = num1 + num2;

    //         }
    //     }
    
    // public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        

    //     PriorityQueue<Pair> minHeap = new PriorityQueue<>((pair1, pair2) -> (pair1.sum - pair2.sum));
    //     List<List<Integer>> kPairsWithSmallestSums = new ArrayList<>();

    //     Set<String> visited = new HashSet<>();

    //     minHeap.offer(new Pair(0, 0, nums1[0], nums2[0]));
    //     visited.add("0, 0");


    //     while(!minHeap.isEmpty() && kPairsWithSmallestSums.size() < k){
    //         Pair tempPair = minHeap.poll();
    //         int pointer1 = tempPair.p1;
    //         int pointer2 = tempPair.p2;

    //         kPairsWithSmallestSums.add(new ArrayList<>(Arrays.asList(nums1[pointer1], nums2[pointer2])));

    //         if(pointer1 + 1 < nums1.length && visited.add((pointer1 + 1) + ", " + pointer2)){
    //             minHeap.add(new Pair(pointer1 + 1, pointer2, nums1[pointer1 + 1], nums2[pointer2]));
    //         }
    //         if(pointer2 + 1 < nums2.length && visited.add(pointer1 + ", " + (pointer2 + 1))){
    //             minHeap.add(new Pair(pointer1, pointer2 + 1, nums1[pointer1], nums2[pointer2 + 1]));
    //         }

    //     }
    //     return kPairsWithSmallestSums;

       

    // }





























    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // // intuition 1 (TLE): use a priorityQueue of max length k with a comparator of smallest (u + v). 
    // // Keep adding elements for each possible combination using double for loop (though this part could be optimized)
    
    // public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    //     // PriorityQueue<int[]> pq = new PriorityQueue<>((b, a) -> Integer.compare(a[0] + a[1], b[0] + b[1]));  // maxHeap
    //     PriorityQueue<List<Integer>> pq = new PriorityQueue<>((b, a) -> 
    //     Integer.compare(a.get(0) + a.get(1), b.get(0) + b.get(1)));  // maxHeap
    //     // try updating this with list instead of array
    //     List<List<Integer>> ans = new ArrayList<>();
    //     for(int i = 0; i < nums1.length; i ++){
    //         for(int j = 0; j < nums2.length; j ++){
    //             pq.offer(new ArrayList<>(List.of(nums1[i], nums2[j])));
    //             if(pq.size() > k){
    //                 pq.poll();
    //             }
    //         }

    //     }

    //     for(int i2 = 0; i2 < k; i2 ++){
    //         // int[] temp = pq.poll();
    //         // ans.add(Arrays.asList(temp[0], temp[1]));
    //         ans.add(pq.poll());
    //     }
    //     return ans;
    // }

///////////////////////////////////////////////////////////////////////////////////////////////////
    // intuition 2 (after seeing the editorial): use the already sorted arrays to your advantage and only traverse
    // necessary pairs. 

    //At each step, we chose the minimum sum pair from the remaining leftover pairs and the next two new pairs.
    //The answer will not be present outside of these pairs being considered only because the arrays are sorted. 
    // We repeat this process until we get k pairs.
    
//     public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

//         int nums1Len = nums1.length;
//         int nums2Len = nums2.length;

//         List<List<Integer>> ans = new ArrayList<>();

//         Set<Pair<Integer, Integer>> visited = new HashSet<>(); // storing a dedicated two-element tuple type (Pair<K,V>). 
//         // It can only ever hold exactly two things (a “first” and a “second”), and its whole purpose is to model a pair.

//         PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] - b[0])); // sort based on sum of nums 
//         // (first element of a and b int arrays)
        
//         minHeap.offer(new int[]{nums1[0] + nums2[0], 0, 0});
//         visited.add(new Pair<Integer, Integer>(0, 0));

//         while(k > 0 && !minHeap.isEmpty()){
//             int[] top = minHeap.poll();

//             int i = top[1]; // format of top array -> sum, nums1 index, nums2 index
//             int j = top[2];

//             ans.add(List.of(nums1[i], nums2[j]));

//             if(i + 1 < nums1Len && !visited.contains(new Pair<Integer, Integer>(i + 1, j))){
//                 minHeap.offer(new int[]{nums1[i + 1] + nums2[j], i + 1, j});
//                 visited.add(new Pair<Integer, Integer>(i + 1, j));
//             } 
                // Keep adding probable pairs to minHeap in the hope that one of them might get utilized in the future
                // when all other pairs are giving higher sums than that particular pair
//             if(j + 1 < nums2Len && !visited.contains(new Pair<Integer, Integer>(i, j + 1))){
//                 minHeap.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
//                 visited.add(new Pair<Integer, Integer>(i, j + 1));
//             }
//             k --;

//         }
//         return ans;


//     }
// }

////////////////////////////////////////////////////////////////////////////////
// understand the below solution (copied) -> Also try to to look at more optimized solutions and observe what they exactly did to reduce time complexity

/*
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a,b) -> a.sum - b.sum);
        Set<String> visited = new HashSet<>();

        //we're going to do BFS traversal using priorityQueue(minHeap)(Basically we're simulating dikstra's algo)
        minHeap.offer(new Pair(0, 0, nums1[0], nums2[0]));
        visited.add("0,0");

        while(!minHeap.isEmpty() && result.size() != k){
            Pair curr = minHeap.poll();
            int i = curr.i, j = curr.j;
            result.add(Arrays.asList(nums1[i],nums2[j]));
            if(i+1 < nums1.length && visited.add((i+1)+","+j)) minHeap.offer(new Pair(i+1, j, nums1[i+1], nums2[j]));
            if(j+1 < nums2.length && visited.add(i+","+(j+1))) minHeap.offer(new Pair(i, j+1, nums1[i], nums2[j+1]));
        }

        return result;
    }

    static class Pair{
        int i, j, num1, num2, sum;
        Pair(int i, int j, int num1, int num2){
            this.i = i;
            this.j = j;
            this.num1 = num1;
            this.num2 = num2;
            this.sum = num1+num2;
        }
    }
}
*/

/* More optimal solution through we don't have to use the set to prevent duplicates(it's time consuming). We can prevent it by first pushing first k elements of nums1 mapped with the 0th element of nums2 in the minHeap.
*/

// class Solution {
//     public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

//         List<List<Integer>> result = new ArrayList<>();
//         PriorityQueue<Pair> minHeap = new PriorityQueue<>((a,b) -> a.sum - b.sum);


//         //we're going to do BFS traversal using priorityQueue(minHeap)(Basically we're simulating dikstra's algo)
//         for(int i = 0; i < Math.min(k, nums1.length); i++){ //pushing first k of nums1
//             minHeap.offer(new Pair(i, 0, nums1[i], nums2[0]));
//         }


//         while(!minHeap.isEmpty() && result.size() != k){
//             Pair curr = minHeap.poll();
//             int i = curr.i, j = curr.j;
//             result.add(Arrays.asList(nums1[i], nums2[j]));
//             if(j+1 < nums2.length) minHeap.offer(new Pair(i, j+1, nums1[i], nums2[j+1]));
//         }

//         return result;
//     }

//     static class Pair{
//         int i, j, num1, num2, sum;
//         Pair(int i, int j, int num1, int num2){
//             this.i = i;
//             this.j = j;
//             this.num1 = num1;
//             this.num2 = num2;
//             this.sum = num1+num2;
//         }
//     }
}











