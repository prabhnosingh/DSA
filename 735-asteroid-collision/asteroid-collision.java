class Solution {

     public int[] asteroidCollision(int[] asteroids) {

        int index = -1;

        for(int currentAsteroid: asteroids){

            boolean current_A_Undestroyed = true;

            while(current_A_Undestroyed && index >= 0 && currentAsteroid < 0 && asteroids[index] > 0){
                current_A_Undestroyed = currentAsteroid + asteroids[index] < 0;
                if(currentAsteroid + asteroids[index] <= 0){
                    -- index;
                }

            }

            if(current_A_Undestroyed){
                asteroids[++ index] = currentAsteroid;
            }

        }

        return Arrays.copyOfRange(asteroids, 0, index + 1);


     }
}




















////////////////////////////////////////////////////////////
   // beats 12%

//         public boolean isSameSign(int x, int y){
//             if(x * y > 0){
//                 return true;
//             }
//             else{
//                 return false;
//             }
//         }
//   public int[] asteroidCollision(int[] a) {

//         Stack<Integer> s1 = new Stack<>();
    
//         for(int i = 0; i < a.length; i ++){

//           if(s1.size() == 0 || (s1.peek() < 0 && a[i] > 0) || isSameSign(s1.peek(), a[i])){
//               s1.push(a[i]);
//           }
          
//           else{
//               while(s1.size() > 0 && s1.peek() <= Math.abs(a[i]) && !isSameSign(s1.peek(), a[i])){

//               if(s1.size() > 0 && s1.peek() == Math.abs(a[i])){
//                   s1.pop();
               
//                   break;
//               }
//               if(s1.size() > 0) s1.pop();
             
//               if(s1.size() == 0 || s1.size() > 0 && isSameSign(s1.peek(), a[i])){
//                   s1.push(a[i]);
//               }
//               }

//           }



//       }
//     int n = s1.size();
//     int[] ans = new int[n];
//     n--;
//     while(s1.size() != 0){
//           ans[n --] = s1.pop(); 
//       }

//       return ans;
//   }



























/////////////////////////////////////////////////////////////////////////

    //     public boolean samesign(int x, int y){
    //         if(x < 0 && y < 0){
    //             return true;
    //         }
    //         else if(x > 0 && y > 0){
    //             return true;
    //         }
    //         return false;
    //     }

    // public int[] asteroidCollision(int[] a) {

    //     Stack<Integer> s1 = new Stack<>();

    //     for(int i = 0; i < a.length; i ++){
    //         if(s1.size() == 0 || (s1.peek() < 0 && a[i] > 0) || samesign(s1.peek(), a[i])){
    //             s1.push(a[i]);
                
    //         }

    //         else{
    //             while(s1.size() > 0 && s1.peek() > 0 && s1.peek() < Math.abs(a[i])){
    //                 s1.pop();
    //             }

    //             if(s1.size() == 0 || s1.peek() < 0){
    //                 s1.push(a[i]);
    //             }
    //             else if(s1.peek() == Math.abs(a[i])){
    //                 s1.pop();
    //             }

    //         }
    //     }


        
    //     int[] ans = new int[s1.size()];
    //     int i = s1.size() - 1;
    //     while (!s1.isEmpty()) {
    //         ans[i] = s1.peek();
    //         i--;
    //         s1.pop();
    //     }


    //     return ans;
// } 

// }