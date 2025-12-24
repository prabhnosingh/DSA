class Solution {
    //intuition 2 (monotonic stack): Maintain two arrays, one for left smaller element and one for right smaller element
    //Store the indices of elements in these arrays. Maintain two stacks as well for calculating these two arrays which
    //store the index of an element

    //After calculating the two arrays, run a for loop over heigths while calculating the area for each heights[i] 
    //by area = (rightSmallerIndex[i] - leftSmallerIndex[i] - 1) * heights[i]

    //Left smaller element algo :
        //Left -> right traversal
        //while(stack.peek() >= arr[i]) //we don't like greater elements in the stack
            //stack.pop()
        //if stack is not empty 
            //add stack.peek() to ans
        //stack.push(arr[i])

    //Right smaller element algo :
        //Right -> left traversal
        //while(stack.peek() >= arr[i]) //we don't like greater elements in the stack
            //stack.pop()
        //if stack is not empty 
            //add stack.peek() to ans
        //stack.push(arr[i])

        //bottom to top increasing stack
    
    public int largestRectangleArea(int[] heights) {
        
        int maxArea = 0;
        int heightsLen = heights.length;

        int[] leftSmallerElementIdx = new int[heightsLen];
        int[] rightSmallerElementIdx = new int[heightsLen];

        Stack<Integer> leftSmallerElementIdxStack = new Stack<>();
        Stack<Integer> rightSmallerElementIdxStack = new Stack<>();


        for(int i = 0; i < heightsLen; i ++){
            int currHeight = heights[i];
            while(!leftSmallerElementIdxStack.isEmpty() && heights[leftSmallerElementIdxStack.peek()] >= currHeight){
                leftSmallerElementIdxStack.pop();
            }
            if(leftSmallerElementIdxStack.isEmpty()){
                leftSmallerElementIdx[i] = -1; 
                //why we assign -1?
                    //basically when leftSmallerElementIdxStack.isEmpty(), we know that there is no height on the left
                    //that is smaller than the currHeight. This means that the currHeight bar can be extended fully 
                    //towards extreme left to include first idx ("0").

                    //Therefore, we assign -1 to include first index in the width while calculating the area.
                        //leftSmallerElementIdx[i] + 1 becomes 0 if leftSmallerElementIdx[i] = -1
                    //"Rectangle extends fully left"
            }
            else{
                leftSmallerElementIdx[i] = leftSmallerElementIdxStack.peek();
            }

            leftSmallerElementIdxStack.push(i);


        }

        for(int i = heightsLen - 1; i >=0 ; i --){
            int currHeight = heights[i];
            while(!rightSmallerElementIdxStack.isEmpty() && heights[rightSmallerElementIdxStack.peek()] >= currHeight){
                rightSmallerElementIdxStack.pop();
            }
            if(rightSmallerElementIdxStack.isEmpty()){
                // rightSmallerElementIdx[i] = -1;
                rightSmallerElementIdx[i] = heightsLen; 
                //why we assign heigthsLen instead of -1?
                    //basically when rightSmallerElementIdxStack.isEmpty(), we know that there is no height on the right that is
                    // smaller than the currHeight, and therefore the currHeight could be extened to the last of the 
                    //heights array. 
                    //Therefore we assing heightsLen to include the last index in the width while calculating area. 
                    //"Rectangle extends fully right"
            }
            else{
                rightSmallerElementIdx[i] = rightSmallerElementIdxStack.peek();
            }

            rightSmallerElementIdxStack.push(i);


        }
        

        for(int i = 0; i < heightsLen; i ++){
            // maxArea = Math.max(maxArea, Math.max(heights[i], (rightSmallerElementIdx[i] - leftSmallerElementIdx[i] - 1) * heights[i]));
            maxArea = Math.max(maxArea, (rightSmallerElementIdx[i] - (leftSmallerElementIdx[i] + 1)) * heights[i]);
        }

        return maxArea;

    }












    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //intuition 1 (monotonic stack): Left smaller element -> In traversing the heights. 

    // //Left greater element algo :
    //     //Left -> right traversal
    //     //while(stack.peek() <= arr[i])
    //         //stack.pop()
    //     //if stack is not empty 
    //         //add stack.peek() to ans
    //     //stack.push(arr[i])

    // //Left smaller element algo :
    //     //Left -> right traversal
    //     //while(stack.peek() >= arr[i])
    //         //stack.pop()
    //     //if stack is not empty 
    //         //add stack.peek() to ans
    //     //stack.push(arr[i])

    //     //bottom to top increasing stack
    // //Store a pair of index and number in stack. When a smaller element is encountered, pop elements from 
    // //the stack until a smaller or equal element is encountered. Now push the currHeight in stack with index
    // //of last popped element because that was the last height from which the currHeight is greater and now an
    // //even smaller (or equal) height has been found than the currHeight. 
    
    // //After each pop, calculate the curr area that the popped height could have given by
    // //currHeight x (currIdx - "idx from currHeight pair")
    
    // //After traversing the whole array, if we have still left with some heights in the stack, then that means 
    // //they should be extended till the last of the array from their stored indices 


    // //try with two stacks (one for indices and one for heights) instead of pair
    // public int largestRectangleArea(int[] heights) {
        
    //     int maxArea = 0;
    //     Stack<Pair<Integer, Integer>> stack = new Stack<>(); //idx, height

    //     for(int i = 0; i < heights.length; i ++){
    //         int currHeight = heights[i];
    //         int numberOfPops = 0;
    //         //using lastPoppedIdx to track the popped index as the last value of this variable will denote
    //         //the idx of the height that is present just before a smaller height than curr height is 
    //         //encountered
    //         // int lastPoppedIdx = 0;
    //         int lastPoppedIdx = i; //intializing lastPoppedIdx to i as in case the below condition of while
    //         //loop is not fulfilled, then the currHeight should be mapped to its own index and not 0
    //         while(!stack.isEmpty() && stack.peek().getValue() >= currHeight){ 
    //             Pair<Integer, Integer> currPair = stack.pop();

    //             int poppedIdx = currPair.getKey();
    //             int poppedHeight = currPair.getValue();
    //             lastPoppedIdx = poppedIdx;
    //             int currArea = poppedHeight * (i - poppedIdx);
    //             maxArea = Math.max(currArea, maxArea);
    //         }
    //         stack.push(new Pair<>(lastPoppedIdx, currHeight));
    //     }
    //     while(!stack.isEmpty()){
    //         Pair<Integer, Integer> currPair = stack.pop();

    //         int poppedIdx = currPair.getKey();
    //         int poppedHeight = currPair.getValue();

    //         int currArea = poppedHeight * (heights.length - poppedIdx);
    //         maxArea = Math.max(currArea, maxArea);

    //     }

    //     return maxArea;


    // }
}