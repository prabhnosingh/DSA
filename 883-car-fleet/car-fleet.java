class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int lenP = position.length;
    
        double[] timeArr = new double[target];
    
            int fleet = 0;

            for(int i = 0; i < lenP; i++){
            int pos = position[i];
            int distance = target - pos;
            double time = (double)(distance) / speed[i];

            timeArr[pos] = time;
            
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