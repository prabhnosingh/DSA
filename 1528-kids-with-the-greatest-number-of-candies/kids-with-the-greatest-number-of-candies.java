class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        
        ArrayList<Boolean> ans = new ArrayList<>();

        int maxCandies = candies[0];
        for(int candy : candies){
            if(maxCandies < candy){
                maxCandies = candy;
            }
        }

         
        for(int candy : candies){
            if(candy + extraCandies >= maxCandies){
                ans.add(true);
            }
            else{
                ans.add(false);
            }
            
        }
        return ans;
    }
}