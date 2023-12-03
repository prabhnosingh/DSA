class Solution {
    public String removeStars(String s) {
        
        char[] ch = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for(char c : ch){
            if(c != '*'){
                stack.push(c);
            }
            else{
                stack.pop();
            }
        }

        String s1 = "";
        while(!stack.empty()){
            s1 += stack.pop();
        }
        char[] c2 = new char[s1.length()];
        int idx = 0;
        for(int i = s1.length() - 1; i >= 0; i --){
            c2[idx ++] = s1.charAt(i);
        }

        

        return String.valueOf(c2);
    }
} 