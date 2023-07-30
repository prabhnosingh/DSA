class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int lenP = position.length;
    
        double[] timeArr = new double[target];
    
            int fleet = 0;
           
            Stack<Double> stackT = new Stack<>();
          

            for(int i = 0; i < lenP; i++){
            // int distance = target - position[i];
            // double time = (double)(distance / speed[i]);

            // timeArr[position[i]] = time;
            timeArr[position[i]]= (double)(target - position[i]) / speed[i];
            
             }

            double prev = 0.0;

            for(int j = target - 1; j >= 0; j--){
                double cur = timeArr[j];
                if(cur > prev){
                    prev = cur;
                    fleet++;
                }
                }
            
            













        // int[] times = new int[lenP];
   
        
        // for(int i = 0; i < lenP; i++){
        //     int distance = target - position[i];
        //     int time = distance / speed[i];

        //     times[i] = time;
            
        // }

        // int start = 0;
        // int end = 1;
        // while(start < end && end < lenP){
        //     if(times[start] == times[end] || times[start] > times[end] && position[start] > position[end]){
                
        //         if(end == lenP-1){
        //             fleet ++;
        //         }
        //         end ++;
        //     }
        //     else{
        //         start = end;
        //         end ++;
        //         fleet ++;
        //     }
        // }   
            return fleet;


    }
}