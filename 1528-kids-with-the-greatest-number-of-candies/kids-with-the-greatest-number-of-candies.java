class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        int[] arr = Arrays.copyOfRange(candies, 0, candies.length);
        Arrays.sort(candies);
        int maxCandies = candies[candies.length - 1];
        ArrayList<Boolean> ans = new ArrayList<>();

        for(int candy : arr){
            if(candy + extraCandies >= maxCandies){
                ans.add(true);
            }
            else{
                ans.add(false);
            }
            
        }
        return ans;

//************************************************************************** */        
        // ArrayList<Boolean> ans = new ArrayList<>();

        // int maxCandies = candies[0];
        // for(int candy : candies){
        //     if(maxCandies < candy){
        //         maxCandies = candy;
        //     }
        // }

         
        // for(int candy : candies){
        //     if(candy + extraCandies >= maxCandies){
        //         ans.add(true);
        //     }
        //     else{
        //         ans.add(false);
        //     }
            
        // }
        // return ans;
    }
}