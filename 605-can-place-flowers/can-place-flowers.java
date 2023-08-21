class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        if(flowerbed.length == 1){
            if(flowerbed[0] == 0){
                n --;
            }
            return n > 0 ? false : true;
        }
        
        for(int i = 0; i < flowerbed.length; i ++){
            if(flowerbed[i] == 1){
                i ++;
            }
            else if(i + 1 != flowerbed.length && flowerbed[i + 1] != 1){
                n --;
                flowerbed[i] = 1;
                i ++;
            }
            else if(i + 1 == flowerbed.length && flowerbed[i - 1] != 1){
                n --;
                
            }
        }
        return n > 0 ? false : true;
    }
}