// class Solution {
//     public void rotate(int[] nums, int k) {

//         int len = nums.length-1;
//         k=k%(len+1);
//         rev(nums , 0, len-k);
//         rev(nums, len-k+1, len);
//         rev(nums, 0,  len);


        
//     }

//     public int[] rev(int [] arr, int start, int end){
//         while(start<end){
//             int temp = arr[end];
//             arr[end]= arr[start];
//             arr[start]= temp;

//             start++;
//             end--;
//         }
//         return arr;
//     }
// }
class Solution {

    public static void cal( int len, int k, int[] nums){
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> que = new LinkedList<>();

          for(int i=0; i<=len-k; i++){
            que.add(nums[i]);
        }
        for(int i= len-1; i>len-1-k; i-- ){
            stack.push(nums[i]);
        }
        int count =0;
     
        for(int i=0; i<k; i++){
            nums[i] = stack.pop();
            count =i;
        }
        for(int j=0; j<len-k; j++){
            nums[++count]= que.remove();
        }
    }
    public void rotate(int[] nums, int k) {
        
        
        int len = nums.length;
        
        if(len>1 && k>=1 && k<len){
        cal(len, k, nums);
        }

        else if(len>1 && k>=1 && k>len){
           k = k%len;
           cal(len,k,nums);
            // if(k%2 == 0){
            //     cal(len-1,0,nums);
            // }
            // else{
            //     cal(len,k,nums);
            // }

        }
        // else if(k>=1 && k==len){
            
        // }
        // else{

        // }
     
    }
}