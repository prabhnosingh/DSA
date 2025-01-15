class Solution {
    public List<String> letterCombinations(String digits) {
        char[] digitsArray = digits.toCharArray();
        HashMap<String, String> alphabetsMap = new HashMap<>();
        List<String> res = new ArrayList<>();
        int idx = 0;
        // if(digits.length() == 0){
        //     return res;
        // }
        for(char ch : digitsArray){
            switch(ch){
                case '2':
                    alphabetsMap.put("2", "abc");
                    break;
                case '3':
                    alphabetsMap.put("3", "def");
                    break;

                case '4':
                    alphabetsMap.put("4", "ghi");
                    break;
                 
                case '5':
                    alphabetsMap.put("5", "jkl");
                    break;
                 
                case '6':
                    alphabetsMap.put("6", "mno");
                    break;
                 
                case '7':
                    alphabetsMap.put("7", "pqrs");
                    break;
 
                case '8':
                    alphabetsMap.put("8", "tuv");
                    break;
 
                case '9':
                    alphabetsMap.put("9", "wxyz");
                    break;
 
            }

        }
        
        dfs(digits, new ArrayList<>(), alphabetsMap, res, 0);
        return res;

        
    }

    private void dfs(String digits, List<Character> currCombination, HashMap<String, String> alphabetsMap, List<String> res, int start){
                
            if(currCombination.size() == digits.length()){
                if(digits.length() == 0){
                    return;
                }
                String temp = "";
                for(char c : currCombination){
                    temp += c;
                }
                res.add(temp);
                return;
            }

            for(char ch : alphabetsMap.get(digits.charAt(start) + "").toCharArray()){
                currCombination.add(ch);
                dfs(digits, currCombination, alphabetsMap, res, start + 1);
                currCombination.remove(currCombination.size() - 1);
                
            }

                


        }

    
}