class Solution {
    //Solving on 29 Nov 2025:

    //intuition 2: Have a freqArray count the different types of candies. Then find maxCandiesAllowed = candyType / 2.
    //Then find maxCandyTypesPossible = Math.min(uniqueCandyTypes, maxCandiesAllowed)
    public int distributeCandies(int[] candyType) {
        int[] candyFreqArray = new int[candyType.length];

        int maxCandy = Integer.MIN_VALUE;
        int minCandy = Integer.MAX_VALUE;

        for(int candy : candyType){ 
            maxCandy = Math.max(maxCandy, candy);
            minCandy = Math.min(minCandy, candy);
        }

        int[] freqArr = new int[maxCandy - minCandy + 1];
        for(int candy : candyType){ 
            freqArr[candy - minCandy] ++;
        }

        int uniqueCandyTypes = 0;
        for(int freq : freqArr){
            if(freq > 0){
                uniqueCandyTypes += 1;
            }
        }



        return Math.min(uniqueCandyTypes, candyType.length / 2);
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Solving on 29 Nov 2025:

    // //intuition 1: Have a hashSet to count the different types of candies. Then find maxCandiesAllowed = candyType / 2.
    // //Then find maxCandyTypesPossible = Math.min(set.size, maxCandiesAllowed)
    // public int distributeCandies(int[] candyType) {
    //     HashSet<Integer> candyTypeSet = new HashSet<>();

    //     for(int candy : candyType){
    //         candyTypeSet.add(candy);
    //     }

    //     return Math.min(candyTypeSet.size(), candyType.length / 2);
    // }
}