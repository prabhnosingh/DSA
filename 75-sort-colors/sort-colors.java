// class Solution {
//     //intuition 1: Apply Bubble sort to sort the array in place. This will take more than 1 passes. 

//     //TC: O(n^2)
//     //SC: O(1)                
//     public void sortColors(int[] nums) {
        
//         for(int pass = 0; pass < nums.length - 1; pass ++){
//             for(int i = 1; i < nums.length; i ++){
//                 if(nums[i] < nums[i - 1]){ //if previous element is greater than next, then swap
//                     int temp = nums[i];
//                     nums[i] = nums[i - 1];
//                     nums[i - 1] = temp;
//                 }
//             }
//         }

//     }
// }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//intuition 2: We have to utilize the property of all 0, 1, 2s. It is supposed to be 1 pass somehow.
//have 3 pointers, 1 for each red (0), white (1) and blue (2). Consider tracking these 3 pointers each color and swap numbers.
//r, w, b: r will be red pointer and it will signify left side (all 0s) of our sorted array, w will be white pointer and it will 
//signify current element being traversed and b will be blue pointer and it will signify right side (all 2s) of our sorted array.

//be arranging 0s on the left and 2s on the right, we will automatically have 1s in the middle of the final sorted array.

//stop when w pointer crosses b pointer

class Solution {    
    public void sortColors(int[] nums) {
        int len = nums.length;

        int red = 0;
        int white = 0;
        int blue = len - 1;

        while(white <= blue){
            if(nums[white] == 2){ //swap num at white with num at blue
                int temp = nums[blue]; 
                nums[blue] = nums[white];
                nums[white] = temp;
                blue --; //because we are fixing all 2s towards the right of the array and we just moved a 2 at blue index
            }

            else if(nums[white] == 0){ //swap num at white with num at red
                int temp = nums[red];
                nums[red] = nums[white];
                nums[white] = temp; 
                red ++; //because we are fixing all the 0s towards the left of the array and we just moved a 0 at red index
                white ++; //because all the white numbers should be behind all the red numbers
            }

            else{ //if nums[white] == 1
                white ++;
            }
        }
        
    }
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



// class Solution {

//     //intuition 3: Have a hashmap to store the frequency of 0, 1 and 2. Then update the input array in one - go

//     //TC: O(n)
//     //SC: O(1) as we only have red, white and blue colors

//     public void sortColors(int[] nums) {
//         HashMap<Integer, Integer> map = new HashMap<>();
//         for(int num : nums){ //O(n)
//             map.put(num, map.getOrDefault(num, 0) + 1);
//         }
//     int currIdx = 0;
//     for(int color = 0; color <= 2; color ++){ //O(3)
//         if(map.containsKey(color)){
//             int i = 0;
//             for(i = currIdx; i < currIdx + map.get(color); i ++){ //O(n)
//                 // if(i == nums.length) break;
//                 nums[i] = color;
//             }   
//             currIdx = i;
//         }
        
//     }


// }
// }