class Solution {
    public int[] dailyTemperatures(int[] t) {
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