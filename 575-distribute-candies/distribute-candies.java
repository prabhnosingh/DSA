class Solution {
    //Solving on 30 Nov 2025:

    //intuition 1: As Alice has to eat n/2 candies, the max number of different types of candies    
        //will be Math.min(typeOfCandies, n/2)
        //To find the typeOfCandies, you can use a hashSet or frequency array.
            //HashSet will be too easy and computationaly heavy, go with freq array
            //Count the entries in freq array that have values greater than 0 to get the 
                //number of different types of candies
    public int distributeCandies(int[] candyType) {
        
        int maxCandyType = Integer.MIN_VALUE;
        int minCandyType = Integer.MAX_VALUE;

        for(int candy : candyType){
            minCandyType = Math.min(minCandyType, candy);
            maxCandyType = Math.max(maxCandyType, candy);
        }

        int[] freqArray = new int[maxCandyType - minCandyType + 1];
        
        for(int candy : candyType){
            freqArray[candy - minCandyType] += 1;
        }


        int differentCandyTypes = 0;
        for(int freq : freqArray){
            if(freq > 0){
                differentCandyTypes += 1;
            }
        }

        return Math.min(candyType.length / 2 , differentCandyTypes);
    }





































///////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Solving on 29 Nov 2025:

    // //intuition 2 (98.67%): Have a freqArray count the different types of candies. Then find maxCandiesAllowed = candyType / 2.
    // //Then find maxCandyTypesPossible = Math.min(uniqueCandyTypes, maxCandiesAllowed)
    // public int distributeCandies(int[] candyType) {
    //     int[] candyFreqArray = new int[candyType.length];

    //     int maxCandy = Integer.MIN_VALUE;
    //     int minCandy = Integer.MAX_VALUE;

    //     for(int candy : candyType){ 
    //         maxCandy = Math.max(maxCandy, candy);
    //         minCandy = Math.min(minCandy, candy);
    //     }

    //     int[] freqArr = new int[maxCandy - minCandy + 1];
    //     for(int candy : candyType){ 
    //         freqArr[candy - minCandy] ++;
    //     }

    //     int uniqueCandyTypes = 0;
    //     for(int freq : freqArr){
    //         if(freq > 0){
    //             uniqueCandyTypes += 1;
    //         }
    //     }



    //     return Math.min(uniqueCandyTypes, candyType.length / 2);
    // }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Solving on 29 Nov 2025:

    // //intuition 1 (30.96%): Have a hashSet to count the different types of candies. Then find maxCandiesAllowed = candyType / 2.
    // //Then find maxCandyTypesPossible = Math.min(set.size, maxCandiesAllowed)
    // public int distributeCandies(int[] candyType) {
    //     HashSet<Integer> candyTypeSet = new HashSet<>();

    //     for(int candy : candyType){
    //         candyTypeSet.add(candy);
    //     }

    //     return Math.min(candyTypeSet.size(), candyType.length / 2);
    // }
}