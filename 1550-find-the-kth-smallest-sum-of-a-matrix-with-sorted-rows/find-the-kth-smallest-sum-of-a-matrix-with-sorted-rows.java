class Solution {

    //Solving on 24 Nov 2025:

    //intuition 1 (min heap): Have a minheap that stores int[] arrays of size mat.length(rows). 
    //Store the index of first element from each row (also the smallest from that row) in an int[] array and offer to heap
        //The heap type will be of int[][] which will take [[0,0], [1,0], [2,0]] as first input. Comparator will take the index
            //and find the corresponding number from mat and sort based on the sum of corresponding numbers.
    //Then after removing the currSmallestSum array, add +1 to each col index and store it in the heap to compute next smallest
        //array with small sum. In this example the next step will offer  [[0,1], [1,0], [2,0]] ,  [[0,0], [1,1], [2,0]] and  
        //[[0,0], [1,0], [2,1]] arrays to the heap 
    //Stop after k iterations

    //have a custom class that takes one int array of arrays "int[][]" for index of each number in mat in same order as actual
    //numbers array (int array)
    //make it like level order traversal that you did in "merge k sorted lists"
    //also this question is somewhat similar to "373. Find K Pairs with Smallest Sums"

    //a = [[0,1], [1,0], [2,0]]

    static class ArraySum{
        int[][] indices;
        int[] nums;
        int sum;
        ArraySum(int[][] indices, int[] nums){
            this.indices = indices;
            this.nums = nums;
            int tempSum = 0;
            for(int num : nums){
                tempSum += num;
            }
            this.sum = tempSum;
        }

    }

    public int kthSmallest(int[][] mat, int k) {
        // PriorityQueue<int[][]> minHeap = new PriorityQueue<>((a, b) -> ((mat[a[0][0]][a[0][1]] + mat[a[1][0]][a[1][1]] + 
        // mat[a[2][0]][a[2][1]]) - (mat[b[0][0]][b[0][1]] + mat[b[1][0]][b[1][1]] + mat[b[2][0]][b[2][1]])));

        PriorityQueue<ArraySum> minHeap = new PriorityQueue<>((a, b) -> (a.sum - b.sum));

        HashSet<String> visitedIdxSet = new HashSet<>(); //for avoiding duplicate indices being added to heap

        int rows = mat.length;
        int cols = mat[0].length;
        
        int[][] initialIdxArray = new int[rows][2];
        int[] initialNumsArray = new int[rows];
        StringBuilder idxArrayString = new StringBuilder();
        for(int row = 0; row < rows; row ++){
            initialIdxArray[row] = new int[]{row, 0};
            initialNumsArray[row] = mat[row][0];
            idxArrayString.append(row).append(",").append(0).append(","); //1,0,2,0,
            // idxArrayString.append();
        }
        minHeap.offer(new ArraySum(initialIdxArray, initialNumsArray));
        visitedIdxSet.add(idxArrayString.toString());


        while(k > 1 && !minHeap.isEmpty()){
            ArraySum currArraySumObject = minHeap.poll();

            int[][] indices = currArraySumObject.indices;

            int[] nums = currArraySumObject.nums; 

            //
            // System.out.print("nums : [");
            // for(int s = 0; s < nums.length; s ++){
            //     System.out.print(nums[s] + ",");
            // }
            // System.out.println("]");
            //

            for(int i = 0; i < rows; i ++){
                int[][] newIndices = new int[rows][2];
                for(int row = 0; row < rows; row ++){
                    newIndices[row] = Arrays.copyOf(indices[row], indices[row].length);
                }

                int[] newNums = Arrays.copyOf(nums, nums.length); //using copyOf to have deep copy and avoid updating 
                //elements in the original array

              

                if(indices[i][1] + 1 < cols){
                    newIndices[i] = new int[]{i, indices[i][1] + 1}; //increasing column by 1
                    newNums[i] = mat[i][indices[i][1] + 1];

                    // System.out.print("newNums : [");
                    StringBuilder idxArrayString2 = new StringBuilder();
                    for(int l = 0; l < rows; l ++){
                        idxArrayString2.append(newIndices[l][0]).append(",").append(newIndices[l][1]).append(",");
                    }
                    // System.out.println("]");
                    String key = idxArrayString2.toString();
                    if(!visitedIdxSet.add(key)) continue; 
                    
                    minHeap.offer(new ArraySum(newIndices, newNums)); 
                }

                
            }
            // System.out.println("bye");
            k --;
            // System.out.println(k);

        }
        int ansSum = 0;
        ansSum = minHeap.peek().sum;
        // while(!minHeap.isEmpty()){
        //     ArraySum ans = minHeap.poll();
        //     System.out.println(ans.sum);
        // }
        return ansSum;
    }
}