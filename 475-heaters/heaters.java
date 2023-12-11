class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int hoLen = houses.length;
        int heLen = heaters.length;

        int i = 0;
        int j = 0;

        int rad = 0;

        while(j < heLen && i < hoLen){

            int dist1 = Math.abs(houses[i] - heaters[j]);
            int dist2 = Integer.MAX_VALUE;
            
            if(j + 1 < heLen){
                dist2 = Math.abs(houses[i] - heaters[j + 1]);
            }

            if(dist1 < dist2){

                rad = Math.max(rad, dist1);
                i ++;
            }
            else{

                j ++;
            }


        }

        return rad;
        
    }
}