class Solution {
    //Solving on 29 Nov 2025:

    //intuition 1: Have a hashSet to count the different types of candies. Then find maxCandiesAllowed = candyType / 2.
    //Then find maxCandyTypesPossible = Math.min(set.size, maxCandiesAllowed)
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> candyTypeSet = new HashSet<>();

        for(int candy : candyType){
            candyTypeSet.add(candy);
        }

        return Math.min(candyTypeSet.size(), candyType.length / 2);
    }
}