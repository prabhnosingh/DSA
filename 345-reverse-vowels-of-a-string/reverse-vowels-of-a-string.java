class Solution {
    public String reverseVowels(String s) {
    
    boolean[] vowels = new boolean[128];

    char[] ch = s.toCharArray();
    for(char c : "aeiouAEIOU".toCharArray()){

        vowels[c] = true;
    }

    int start = 0;
    int end = s.length() - 1;
    
    while(start < end){

        while(start < end && !vowels[ch[start]]){
            start ++;
        }


        while(start < end && !vowels[ch[end]]){
            end --;
        }

        char temp = ch[start];
        ch[start] = ch[end];

        ch[end] = temp; 

        start ++;
        end --;



    }

    return new String(ch);
//********************************************************************** */    
    //beats 89.2%    
    //    if(s == null && s.length() == 0){
    //        return s;
    //    }

    // //    String vowels = "aieouAIEOU";

    // HashSet<Character> set = new HashSet<>();

    // set.add('a');
    // set.add('e');
    // set.add('i');
    // set.add('o');
    // set.add('u');
    // set.add('A');
    // set.add('E');
    // set.add('O');
    // set.add('U');
    // set.add('I');

    //    char[] chars = s.toCharArray();

    //    int start = 0;
    //    int end = s.length() - 1;

    //    while(start < end){

    //        while(start < end && !set.contains(chars[start])){
    //            start ++;
    //        }

    //        while(start < end && !set.contains(chars[end])){
    //            end --;
    //        }
    //     //    while(start < end && !vowels.contains(chars[start]+ "")){
    //     //        start ++;
    //     //    }

    //     //    while(start < end && !vowels.contains(chars[end]+ "")){
    //     //        end --;
    //     //    }

    //        char temp = chars[end];
    //        chars[end] = chars[start];

    //        chars[start] = temp;

    //        start ++;
    //        end --;
    //    }
    //    return new String(chars);
    }
} 