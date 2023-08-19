class Solution {
    public boolean isPalindrome(int x) {
        

        if(x < 0) return false;
        int rev = 0;
        int num = x;

        while(x != 0){
            rev = rev*10 + (x % 10);

            x = x / 10;

        }

        if(num == rev){
            return true;
        }
        return false;


//******************************************************************** */
 //    beats 6.14% 
        // String s = String.valueOf(x);

        // char[] arr = s.toCharArray();

        // int start = 0;
        // int end = arr.length - 1;

        // while(start <= end){
        //     if(arr[start ++] != arr[end --]){
        //         return false;
        //     }

        // }
        // return true;




//********************************************************************* */
   
        // if(x < 0){
        //     return false;
        // }
        // int count = 0;
        // int y = x;
        // while(x != 0){
        //     int temp = x % 10;
        //     count ++;
        //     x = x / 10;
        // }

        // int[] arr = new int[count];
        // int idx = 0;
        // while(y != 0){
        //     int temp = y % 10;
        //     arr[idx ++] = temp;
        //     y = y / 10;
        // }       

        // int start = 0;
        // int end = count - 1;

        // while(start <= end){
        //     if(arr[start ++] != arr[end --]){
        //         return false;
        //     }

        // }
        // return true;
    }
}