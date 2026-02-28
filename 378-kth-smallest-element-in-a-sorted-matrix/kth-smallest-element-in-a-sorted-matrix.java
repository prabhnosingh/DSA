class Solution {

    //Solving on 28 Feb 2026

    //intution 1: Binary search
        //Find min and max
        //Then find mid with min + (max-min)/2
            //We do this as in best case all the numbers could be aligned 
                //from min to max with an increment of 1. So by searching
                //from mid, we will optimizing our search.
        //Then find the placement of mid element in the matrix by finding
            //index of upper bound (first greater than element) of mid in
            //each row.
        //We will add these indices to find the position of mid element.
        //Now if the position of the mid element is equal to k we return mid
        //else if the position is less than k then we move left to mid
        //else if the position is more than k then we move rigth to mid
        //we stop at left == right

        //TC: nlogn * logR
            //logR for outer binary search : binary search on range of matrix  
            //nlogn for finding upper bound (inner binary search) 
            //R = Range of ans : |max-min|

        //SC: O(1)

    public int kthSmallest(int[][] matrix, int k) {

        int left = matrix[0][0];
        int right = matrix[matrix.length-1][matrix.length-1];

        while(left < right){
            int mid = left + (right-left)/2;

            int currMidPos = findPosOfMid(matrix, mid);
            // if(currMidPos == k){
            //     return mid;
            // }
            if(currMidPos < k){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }

        return left;
    }

    private int findPosOfMid(int[][] matrix, int mid){
        int rows = matrix.length;
        int pos = 0;
        for(int i = 0; i < rows; i ++){
            pos += findUpperBoundIdx(matrix, mid, i);
        }
        return pos;
    }

    private int findUpperBoundIdx(int[][] matrix, int target, int row){
        int cols = matrix.length;
        if(matrix[row][0] > target) return 0;
        if(matrix[row][cols-1] <= target) return cols;


        int left = 0;
        int right = cols-1;

        int currUpperBoundIdx = -1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(matrix[row][mid] > target){
                currUpperBoundIdx = mid;
                right = mid - 1;
            }
            else if(matrix[row][mid] <= target){
                left = mid + 1;
            }
        }
        return currUpperBoundIdx;


    }
}