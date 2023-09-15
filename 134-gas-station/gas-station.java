class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0;
        int costSum = 0;
        int len = gas.length;
        for(int i = 0; i < len; i ++){
            gasSum += gas[i];
            costSum += cost[i];
        }
        if(gasSum < costSum){
            return -1;
        }
        int ans = 0;
        int total = 0;
        
       for(int i = 0; i < len; i ++){
           total += gas[i] - cost[i];
         
            
           if(total < 0){
               total = 0;
               ans = i + 1;
           }
       }
       return ans;
    }
}