class Solution {
    public int largestRectangleArea(int[] heights) {

    Stack<Integer> s = new Stack<>();
         
         int len = heights.length;
         int maxArea = 0;
         for( int i = 0; i <= len; i++){
             int h = (i == len ? 0 : heights[i]);

             if(s.isEmpty() || h >= heights[s.peek()]){
                 s.push(i);
             }
             else{
                 int tp = s.pop();
                 maxArea = Math.max(maxArea, heights[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i --;
             }

               
            }
            return maxArea;

       
        // int width = 0;
        // int area = 0;
        // while(!stack.empty()){
        //     width ++;
        //     if(stack.peek() > h){
        //         h = stack.pop();
        //         area = Math.max(area, h*width);            
        //         }


        // }

        // return area;

    


//************************************************************ */
        // Stack<Integer> stack = new Stack<>();
        //     int max = heights[0];
        //     int prevMax = -1;

        //     for(int i : heights){
        //         stack.push(i);
        //     }

        //     while(!stack.isEmpty()){
        //         if(max <= stack.peek()){
        //             max = stack.pop();
        //         }

        //         if(max >= prevMax){
                    
        //         }
        //     }



        // if(heights.length == 1){
        //     return heights[0];
        // }
        // // int max = heights[0];
         
        // Arrays.sort(heights);

        // int max = heights[heights.length - 1];
        // int prevMax = heights[heights.length - 2];

        // if(max == 0 ){
        //     return 0;
        // } 
        // else if(prevMax == 0){
        //     return max;
        // }


//********************************************************** */



        // for(int i = 0; i < heights.length; i++){
        //     if(heights[i] == 0) continue;
        //     if(heights[i] >= max){
               
        //         max = heights[i];
        //     }
          
        // }
        // int prevMax = max;
        // for(int i = 0; i < heights.length; i++){
        //         if(heights[i] >= prevMax && prevMax <= max){
        //                         prevMax = heights[i];
        //     }
        // }


//************************************************** */
        // if(prevMax == max){
        //     return Math.max(max, max*2);
        // }
        // int area = prevMax*2;
        // return area;

    }   
}