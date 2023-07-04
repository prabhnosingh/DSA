// class Solution {


//     public static String sortString(String input){
//         char[] tempArray = input.toCharArray();

//         Arrays.sort(tempArray);

//         return new String(tempArray);
//     }
//     public boolean checkInclusion(String s1, String s2) {

//         String sortS1 = sortString(s1);

//         int winLen = s1.length();

//         int beg =0;
//         int end = winLen;

//         while(end <= s2.length()){
//             String sortWin = sortString(s2.substring(beg,end));
//             beg++;
//             end++;
//             if(sortWin.equals(sortS1)){
//                 return true;
//             }
            
//         }

//         return false;
//    }
// }
class Solution{
 public boolean checkInclusion(String s1, String s2){
     
if(s1.length() > s2.length()) return false;
     int[] arr1 = new int[26];
     int[] arr2 = new int[26];

    // int len = s1.length();
     for(int i = 0; i < s1.length(); i++){
         arr1[s1.charAt(i) - 'a'] ++;
         arr2[s2.charAt(i) - 'a'] ++;

     }

     if(Arrays.equals(arr1, arr2)) return true;

     int beg = 0;
     int end = s1.length(); 

     while(end < s2.length()){

         arr2[s2.charAt(end) - 'a']++;
         arr2[s2.charAt(beg) - 'a']--;

         if(Arrays.equals(arr1, arr2)) return true;

         beg++;
         end++;
     }
     return false;


 }}