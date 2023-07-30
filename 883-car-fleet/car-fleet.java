class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
       
    
        double[] timeArr = new double[target];
    
            int fleet = 0;
          

            for(int i = 0; i < position.length; i++){
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
        
            return fleet;


    }
}