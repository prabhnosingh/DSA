class Solution {
    public int maxArea(int[] height) {

        int start = 0;
        int end = height.length - 1;

        int maxWater = 0;

        while(start < end){

            int minHeight = Math.min(height[start], height[end]);

            maxWater = Math.max((minHeight * (end - start)), maxWater);

            while(start < end && minHeight >= height[end]){
                end --;
            }
            while(start < end && minHeight >= height[start]){
                start ++;
            }

        }
        return maxWater;



/////////////////////////////////////////////////////////////////////////////////////////////////////
// beats 56.76 %
        // int start = 0;
        // int end = height.length - 1;
        
        // int maxWater = 0;
        // while(start < end){

        //     int water = 0;

        //     int minHeight = Math.min(height[start], height[end]);

        //     int len = end - start;

        //     water = len * minHeight;

        //     maxWater = Math.max(water, maxWater);

        //     if(height[start] < height[end]){
        //         start ++;
        //     }
        //     else{
        //         end --;
        //     }




        // }

        // return maxWater;




































//*********************************************************************** */
        // int max=0;
        // int p1=0;
        // int p2=height.length-1;

        // while(p1<p2){
        //     int h = Math.min(height[p1], height[p2]);

        //     int area = (p2-p1)*h;

        //     if(h==height[p1] && h==height[p2]){
        //         p1++;
        //         p2--;
        //     }
        //     else if(h==height[p2]){
        //         p2--;
        //     }
        //     else{
        //         p1++;
        //     }

        //     max= Math.max(area, max);

        // }

        // return max;


        
    }
}