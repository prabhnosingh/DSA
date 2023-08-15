class Solution {
    public int[] dailyTemperatures(int[] t) {
    
        // Stack<Integer> stack = new Stack<>();
        // int[] ans = new int[t.length];
        
        // int idx = 0;
        // for(int temp : t){
        //     if(stack.empty()){
        //         stack.push(t);
        //     }

        //     else{
        //         if(stack.seek() < t){
        //             int days = 0;
        //             while(stack.seek() < t){
        //                 stack.pop();
        //                 days ++;

        //             }
        //             stack.push(t);
        //             ans[idx ++] = days;
        //         }
        //         else{
        //             stack.push(t);
        //         }
        //     }


        // }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
        Stack<Integer> st = new Stack<>();
        int len = t.length;
        int ans[] = new int[len];
        for(int i = 0; i<len; i++){
         while(st.size()>0 && t[i]>t[st.peek()]){
             ans[st.peek()] = i-st.pop();
         }
         st.push(i);

    }
    return ans;
}}