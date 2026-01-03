class Solution {

    //re-solving: 03 Jan 2026

    //intuition 1: Hashset
        //Use a hashset to store all the numbers in nums. Then traverse nums array and for each num
            //run a while loop until there are numbers next to num available in the set.  
        //There can only be 1 sequence of length greater than half of the numsLen. Therefore, when such 
                //a sequence is found, return immediately without traversing remaining elements. This shortens
                //the for loop.

    public int longestConsecutive(int[] nums) {
        
        int numsLen = nums.length;
        if(numsLen == 0 || numsLen == 1) return numsLen;

        HashSet<Integer> numSet = new HashSet<>();

        for(int num : nums){
            numSet.add(num);
        }

        int longestConsSeq = 1;

        for(int i = 0; i < numsLen; i ++){
            int currNum = nums[i];

            int currConsSeq = 1; 

            if(!numSet.contains(currNum - 1)){ //only proceed with while loop if we know that currNum is the 
                //start of a new consecutive sequence
                while(numSet.contains(currNum + 1)){
                    currConsSeq += 1;
                    currNum += 1;
                }
            }

            longestConsSeq = Math.max(longestConsSeq, currConsSeq);
            //There can only be 1 sequence of length greater than half of the numsLen. Therefore, when such 
                //a sequence is found, return immediately without traversing remaining elements. This shortens
                //the for loop.
            if(longestConsSeq > numsLen / 2) return longestConsSeq; 


        } 

        return longestConsSeq;

        
    }   





































    ///////////////////////////////////////////////////////////////////////////////////////////////////

    // //re-solving: 13 Oct 2025

    // //intuition 4: Update each number in a hashMap with true as a value against each key. Now again traverse the array and check
    // //for each number whether we have the prev number. If yes then that means that the current num is not the start of a sequence.
    // //So we skip it as we don't want to calculate in-between sequences.. 

    // public int longestConsecutive(int[] nums) {
        
    //     int lenOfLongestConsSeq = 0;
        
    //     // HashMap<Integer, Boolean> numsMap = new HashMap<>(); 
    //     HashSet<Integer> numsSet = new HashSet<>(); 

    //     for(int num : nums){
    //         numsSet.add(num);
    //     }

    //     for(int num : nums){ //O(n ^ 2)
    //         // if(!numsMap.get(num)){
    //         //     continue;
    //         // }

    //         if(!numsSet.contains(num - 1)){ //if there is a num - 1 in the map then that means that num is not the start
    //         //of a sequence. We are looking for start of a sequence
            
    //             int currSeqLen = 1;
    //             int nextNum = num + 1;
    //             while(numsSet.contains(nextNum)){  
    //                 currSeqLen += 1;
    //                 nextNum = nextNum + 1;
    //             }
    //             lenOfLongestConsSeq = Math.max(currSeqLen, lenOfLongestConsSeq);
    //         }

    //         if(lenOfLongestConsSeq > nums.length / 2){ //there can only be one sequence with length greater than 
    //         //half of the length of nums 
    //             return lenOfLongestConsSeq; 
    //         }
    //     }
          

    //     return lenOfLongestConsSeq;

    // }

    // ///////////////////////////////////////////////////////////////////////////////////////////////////
    // //re-solving: 13 Oct 2025

    // //intuition 3: Update each number in a hashMap with true as a value against each key. Now again traverse the array and check
    // //for each number whethe we have the next number available or not through a while loop. 

    // public int longestConsecutive(int[] nums) {
        
    //     int lenOfLongestConsSeq = 0;
        
    //     HashMap<Integer, Boolean> numsMap = new HashMap<>(); 

    //     for(int num : nums){
    //         numsMap.put(num, true);
    //     }

    //     for(int num : nums){ //O(n ^ 2)
    //         if(!numsMap.get(num)){
    //             continue;
    //         }
    //         int currSeqLen = 1;
    //         int nextNum = num + 1;
    //         while(numsMap.containsKey(nextNum)){  
    //             numsMap.put(nextNum, false); //marking it as traversed
    //             currSeqLen += 1;
    //             nextNum = nextNum + 1;
    //         }
    //         lenOfLongestConsSeq = Math.max(currSeqLen, lenOfLongestConsSeq);
    //     }
          

    //     return lenOfLongestConsSeq;

    // }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //intuition 1: This could have been done easily by sorting and then applying sliding window but that would be O(nlogn)
    // //intuition 2: A freq arr can be used - len = max - min + 1 where each index denotes the number

    // //Memory limit exceeded
    // public int longestConsecutive(int[] nums) {
        
    //     int lenOfLongestConsSeq = 0;
    //     int maxNum = Integer.MIN_VALUE;
    //     int minNum = Integer.MAX_VALUE;

    //     for(int num : nums){
    //         maxNum = Math.max(maxNum, num);
    //         minNum = Math.min(minNum, num);
    //     }

    //     int[] freqArr = new int[maxNum - minNum + 1];

    //     for(int num : nums){
    //         freqArr[num - minNum] += 1;
    //     }

    //     for(int i = 0; i < freqArr.length; i ++){
    //         int currSeqLen = 0;
    //         while(i < freqArr.length && freqArr[i] != 0){
    //             currSeqLen += 1; 
    //             i ++;
    //         }
    //         lenOfLongestConsSeq = Math.max(currSeqLen, lenOfLongestConsSeq);
    //     }

    //     return lenOfLongestConsSeq;

    // }
}