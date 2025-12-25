class Solution {
    
    //Re-solving on 24 Dec 2025:

    //intuition 2:(Monotonic Stack - One pass)
        //Each bar can be extended towards its right or left in order to form a bigger triangle. 
        //The extension on left side depends on the closest smaller bar on left side 
        //The extension on right side depends on the closest smaller bar on right side
        //By finding the indices of left boundary and right boundary we can find the width along with which the current
            //bar can be extended. width = rightBoundary - leftBoundary - 1
        //Then we can find the max area possible by including current bar by: area = currHeight * width

        //Now to find the boundaries, we use a strictly increasing monotonic stack that stores the indices of bars
            //based on heights of bars.
        //We run one for loop and everytime we find that current top idx of stack (peek) have height that is greater than  
            //current height, this indicates that previous height cannot be extended and we have found the right boundary of
            //bar at peek() idx. We pop that to compute height for our area formula. For width formula: 
                //right will be the current idx (i)
                //left will be current peek() (after poping previous height).
                //=> this works because the stack will contain indices such that at any time the top index is
                    //of the largest height in the whole stack. 
            
            //To handle bars that have minimum height or the bars that will extend fully towards right, we introduce 
                //a special condition of making currHeight = 0 for i == heights.length. By doing this we force for 
                //all indices remaining in the stack to be popped out and hence computing the height accordingly:
                    //height = heights[stack.pop()]
                    //right = heights.length
                    //left = current peek() idx (or -1 if stack is empty)  

        //We keep the track of max area found till now with maxArea variable

    //TC: O(n)
    //Sc: O(n)
   
    public int largestRectangleArea(int[] heights) {
        
        Stack<Integer> stack = new Stack<>();
        int hLen = heights.length;

        int maxArea = 0;

        for(int idx = 0; idx <= hLen; idx ++){
            int currHeight = idx == hLen ? -1 : heights[idx];

            while(!stack.isEmpty() && currHeight <= heights[stack.peek()]){
                int height = heights[stack.pop()];
                
                int rightBoundary = idx;
                int leftBoundary = stack.isEmpty() ? -1 : stack.peek();

                int width = rightBoundary - leftBoundary - 1;
                
                maxArea = Math.max(maxArea, height * width);            
            }

            stack.push(idx);
        }

        return maxArea;

    }





































///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//     //Re-solving on 24 Dec 2025:

//     //intuition 1:(Monotonic Stack)
//         //For finding the largest rectangle area, we traverse all the bars and compute maximum possible area
//             //on both left and right side of that bar and updating the maxArea variable accordingly.
//         //For computing the maximum possible area for each bar, we need height and width. Height will be the
//             //current bar's height (heights[i]) and for finding width, we need to know how much does the current
//             //bar can be extended towards left and right. The extension depends on the first smaller bar encountered.
//         //Eg: if current bar is of 5 height at index 2 (input 1), then first smaller bar on left is 1 (index 1) and
//             //first smaller bar on right is 2 (index 4). Now this denotes that current bar cannot be extended towards left
//             //it but can be extended towards right by 1 unit (as bar at index 3 (height 6) can be used to extend bar of 
//             //height 5).

//         //Now to maintain first smaller bar idx on both left and right side, we will maintain two arrays. These arrays
//             //for any i index will store indices of first smaller left bar idx and first smaller right bar idx. 
//         //"Basically, for each bar, we compute the nearest smaller bar on both sides using monotonic increasing stacks,
//             //which gives us the maximum width that current bar can span to."

//         //“The bar can extend between the first smaller bars on the left and right; all bars in between have 
//             //height ≥ current height.”
        
//         //To build these arrays we first fill two strictly increasing monotonic stacks.
//             //“We maintain a strictly increasing monotonic stacks of indices based on bar heights.”
//             //leftSmallerIdxStack: this will store the first smaller bar's idx towards left of current bar
//             //rightSmallerIdxStack: this will store the first smaller bar's idx towards right of current bar
//                 //algo:
//                     //while(stack.peek() >= currentBar) stack.pop() => we don't like the greater bars
//                     //if stack is empty, store -1 in the respective array(means that there is no smaller bar on left/right side)
//                     //else store the stack.peek() in the respective array
                    
//                     //push current idx to stack

//         //Finally run a for loop over heights array and compute max area possible for each bar:
//             //=> Math.max(maxArea, heights[i] * (firstSmallerRightIdx[i] - firstSmallerLeftIdx[i] - 1)) => why do we do -1 here?
//                 //We do -1 here because both left and right indices point to bars that are smaller than current bars and hence
//                     //cannot be included in the width calculation. "The usable width is strictly between them" 

//     //TC: O(n)
//     //Sc: O(n)
   
//     public int largestRectangleArea(int[] heights) {
        
//         int hLen = heights.length;


//         int[] firstSmallerLeftIdx = new int[hLen];
//         int[] firstSmallerRightIdx = new int[hLen];

//         Stack<Integer> leftIdxStack = new Stack<>();
//         Stack<Integer> rightIdxStack = new Stack<>();

//         int maxArea = 0;

//         //filling firstSmallerLeftIdx (left -> right)
//         for(int i = 0; i < hLen; i ++){
//             int currHeight = heights[i];
//             firstSmallerLeftIdx[i] = -1; //rectangle extends to full left
//             //Why -1? => "It makes the width formula work uniformly, without extra conditions." 
//                 //"width = rightIdx - (-1) - 1 => rightIdx"
//             while(!leftIdxStack.isEmpty() && heights[leftIdxStack.peek()] >= currHeight){
//                 leftIdxStack.pop();
//             }
//             if(!leftIdxStack.isEmpty()){
//                 firstSmallerLeftIdx[i] = leftIdxStack.peek();
//             }
//             leftIdxStack.push(i);
//         }        

//         //filling firstSmallerRightIdx (right -> left)
//         for(int i = hLen - 1; i >= 0; i --){
//             int currHeight = heights[i];
//             firstSmallerRightIdx[i] = hLen; //rectangle extends to full right
//             //Just give an example of why we need hLen in the interview if asked
//             while(!rightIdxStack.isEmpty() && heights[rightIdxStack.peek()] >= currHeight){
//                 rightIdxStack.pop();
//             }

//             if(!rightIdxStack.isEmpty()){
//                 firstSmallerRightIdx[i] = rightIdxStack.peek();
//             }

//             rightIdxStack.push(i);
            
//         }


//         for(int i = 0; i < hLen; i ++){

//             maxArea = Math.max(maxArea, heights[i] * (firstSmallerRightIdx[i] - firstSmallerLeftIdx[i] - 1));
//         }

//         return maxArea;
        

//     }





































// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //intuition 2 (monotonic stack): Maintain two arrays, one for left smaller element and one for right smaller element
    // //Store the indices of elements in these arrays. Maintain two stacks as well for calculating these two arrays which
    // //store the index of an element

    // //After calculating the two arrays, run a for loop over heights while calculating the area for each heights[i] 
    // //by, area = (rightSmallerIndex[i] - leftSmallerIndex[i] - 1) * heights[i]

    // //Left smaller element algo :
    //     //Left -> right traversal
    //     //while(stack.peek() >= arr[i]) //we don't like greater elements in the stack
    //         //stack.pop()
    //     //if stack is not empty 
    //         //add stack.peek() to ans
    //     //stack.push(arr[i])

    // //Right smaller element algo :
    //     //Right -> left traversal
    //     //while(stack.peek() >= arr[i]) //we don't like greater elements in the stack
    //         //stack.pop()
    //     //if stack is not empty 
    //         //add stack.peek() to ans
    //     //stack.push(arr[i])

    //     //bottom to top increasing stack
    
    // public int largestRectangleArea(int[] heights) {
        
    //     int maxArea = 0;
    //     int heightsLen = heights.length;

    //     int[] leftSmallerElementIdx = new int[heightsLen];
    //     int[] rightSmallerElementIdx = new int[heightsLen];

    //     Stack<Integer> leftSmallerElementIdxStack = new Stack<>();
    //     Stack<Integer> rightSmallerElementIdxStack = new Stack<>();


    //     for(int i = 0; i < heightsLen; i ++){
    //         int currHeight = heights[i];
    //         while(!leftSmallerElementIdxStack.isEmpty() && heights[leftSmallerElementIdxStack.peek()] >= currHeight){
    //             leftSmallerElementIdxStack.pop();
    //         }
    //         if(leftSmallerElementIdxStack.isEmpty()){
    //             leftSmallerElementIdx[i] = -1; 
    //             //why we assign -1?
    //                 //basically when leftSmallerElementIdxStack.isEmpty(), we know that there is no height on the left
    //                 //that is smaller than the currHeight. This means that the currHeight bar can be extended fully 
    //                 //towards extreme left to include first idx ("0").

    //                 //Therefore, we assign -1 to include first index in the width while calculating the area.
    //                     //leftSmallerElementIdx[i] + 1 becomes 0 if leftSmallerElementIdx[i] = -1
    //                 //"Rectangle extends fully left"
    //         }
    //         else{
    //             leftSmallerElementIdx[i] = leftSmallerElementIdxStack.peek();
    //         }

    //         leftSmallerElementIdxStack.push(i);


    //     }

    //     for(int i = heightsLen - 1; i >=0 ; i --){
    //         int currHeight = heights[i];
    //         while(!rightSmallerElementIdxStack.isEmpty() && heights[rightSmallerElementIdxStack.peek()] >= currHeight){
    //             rightSmallerElementIdxStack.pop();
    //         }
    //         if(rightSmallerElementIdxStack.isEmpty()){
    //             // rightSmallerElementIdx[i] = -1;
    //             rightSmallerElementIdx[i] = heightsLen; 
    //             //why we assign heigthsLen instead of -1?
    //                 //basically when rightSmallerElementIdxStack.isEmpty(), we know that there is no height on the right that is
    //                 // smaller than the currHeight, and therefore the currHeight could be extened to the last of the 
    //                 //heights array. 
    //                 //Therefore we assing heightsLen to include the last index in the width while calculating area. 
    //                 //"Rectangle extends fully right"
    //         }
    //         else{
    //             rightSmallerElementIdx[i] = rightSmallerElementIdxStack.peek();
    //         }

    //         rightSmallerElementIdxStack.push(i);


    //     }
        

    //     for(int i = 0; i < heightsLen; i ++){
    //         // maxArea = Math.max(maxArea, Math.max(heights[i], (rightSmallerElementIdx[i] - leftSmallerElementIdx[i] - 1) * heights[i]));
    //         maxArea = Math.max(maxArea, (rightSmallerElementIdx[i] - (leftSmallerElementIdx[i] + 1)) * heights[i]);
    //     }

    //     return maxArea;

    // }












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