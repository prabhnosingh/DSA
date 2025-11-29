
//Re-solving on 28 Nov 2025

//intuition 3: Have two heaps (one minHeap(secondHalf) and one maxHeap(firstHalf)). This way the median 
//will be on the top of either (odd) or both (even) the heaps.

//Everytime we add a number, check if firstHalf and second half are both empty:
    //If they both are non-empty then:
        //if the num is greater than equal to the top of second half, add the num to second half
        //if the num is smaller than equal to the top of first half, add the num to the first half
    //else if one of them is non-empty then:
        //add the num to first half


//Then rebalance both the heaps. If either of them have a size greater than the other by more than 1 (or
    //>= 2), shift the top element from the greater heap to the smaller heap

//In case of findMedian, if the size of both the heaps is not same (i.e. current array is of odd length),
    //return the top of the heap that have greater size. And if the size of both the heaps is 
    //same (i.e. current array is of even length), return the average of both the tops



class MedianFinder {

    PriorityQueue<Integer> secondHalf;
    PriorityQueue<Integer> firstHalf; 
   

    public MedianFinder() {
        secondHalf = new PriorityQueue<>((a,b) -> (a-b));
        firstHalf = new PriorityQueue<>((a,b) -> (b-a));
    }

    public void addNum(int num) {
        
        //adding element to either of the heaps
        if(!firstHalf.isEmpty() && !secondHalf.isEmpty()){
            if(firstHalf.peek() >= num){
                firstHalf.offer(num);
            }
            // else if(secondHalf.peek() <= num){
            //     secondHalf.offer(num);
            // }
            else {
                secondHalf.offer(num);
            }
        }
        else{
            firstHalf.offer(num);
        }

        //rebalancing: this is required as we cannot let one of the heaps to grow in size while
        //the other one remains lesser in size. This will ensure our median finding logic works.
        if(firstHalf.size() > secondHalf.size() + 1){
        // if(firstHalf.size() >= secondHalf.size() + 2){
            secondHalf.offer(firstHalf.poll());
        }
        else if(secondHalf.size() > firstHalf.size() + 1){ 
            // System.out.println(firstHalf.size());
            // System.out.println(secondHalf.size());
            firstHalf.offer(secondHalf.poll());
        }



      
    }

    public double findMedian() {

        System.out.println();
        if(firstHalf.size() == secondHalf.size()){ //even length array
            return (double) (firstHalf.peek() + secondHalf.peek()) / 2;
        }
        else{
            if(firstHalf.size() > secondHalf.size()){
                return (double) firstHalf.peek();
            }
            else{
                return (double) secondHalf.peek();
            }
        }

    }
       

}



















/////////////////////////////////////////////////////////////////////////////////////////////////////////

// //Re-solving on 28 Nov 2025

// //intuition 2: Have two heaps (one minHeap(secondHalf) and one maxHeap(firstHalf)). This way the median 
// //will be on the top of either (odd) or both (even) the heaps.

// //Everytime we add a number, check if first half is empty or the currNum is smaller than equal to the peek
//     //of first half, if yes, add the number to firstHalf. Else add the number to second half.

// //The rebalance both the heaps. If either of them have a size greater than the other by more than 1 (or
//     //>= 2), shift the top element from the greater heap to the smaller heap

// //In case of findMedian, if the size of both the heaps is not same (i.e. current array is of odd length),
//     //return the top of the heap that have greater size. And if the size of both the heaps is 
//     //same (i.e. current array is of even length), return the average of both the tops



// class MedianFinder {

//     PriorityQueue<Integer> secondHalf;
//     PriorityQueue<Integer> firstHalf; 
   

//     public MedianFinder() {
//         secondHalf = new PriorityQueue<>((a,b) -> (a-b));
//         firstHalf = new PriorityQueue<>((a,b) -> (b-a));
//     }

//     public void addNum(int num) {
        
//         //adding element to either of the heaps
//         if(firstHalf.isEmpty() || firstHalf.peek() >= num){
//             firstHalf.offer(num);
//         }
//         else{
//             secondHalf.offer(num);
//         }

//         //rebalancing: this is required as we cannot let one of the heaps to grow in size while
//         //the other one remains lesser in size. This will ensure our median finding logic works.
//         if(firstHalf.size() > secondHalf.size() + 1){
//         // if(firstHalf.size() >= secondHalf.size() + 2){
//             secondHalf.offer(firstHalf.poll());
//         }
//         else if(secondHalf.size() > firstHalf.size() + 1){ 
//             // System.out.println(firstHalf.size());
//             // System.out.println(secondHalf.size());
//             firstHalf.offer(secondHalf.poll());
//         }



      
//     }

//     public double findMedian() {
//         if(firstHalf.size() == secondHalf.size()){ //even length array
//             return (double) (firstHalf.peek() + secondHalf.peek()) / 2;
//         }
//         else{
//             if(firstHalf.size() > secondHalf.size()){
//                 return (double) firstHalf.peek();
//             }
//             else{
//                 return (double) secondHalf.peek();
//             }
//         }

//     }
       

// }



















// /////////////////////////////////////////////////////////////////////////////////////////////////////////

// //Re-solving on 28 Nov 2025

// //intuition 1: Have two heaps (one minHeap and one maxHeap). maxHeap should store the first half of the 
// //sorted list whereas the minHeap should store the second half of the sorted list. This way the median 
// //will be on the top of either (odd) or both (even) the heaps.

// //Everytime we add a number, add it to maxHeap, then remove from there and add it to minHeap. If this 
//     //operation leads to minHeap.size > maxHeap.size, remove the top element from minHeap and add back to
//     //maxHeap.

// //In case of findMedian, if the size of both the heaps is not same (i.e. current array is of odd length),
//     //return the top of maxHeap. And if the size of both the heaps is same (i.e. current array is of even
//     //length), return the average of both the tops


//TC: Per add num: worst case is 5 operations (3 offer, 2 remove)
// class MedianFinder {

//     PriorityQueue<Integer> minHeap;
//     PriorityQueue<Integer> maxHeap; 
   

//     public MedianFinder() {
//         minHeap = new PriorityQueue<>((a,b) -> (a-b));
//         maxHeap = new PriorityQueue<>((a,b) -> (b-a));
//     }

//     public void addNum(int num) {
//         maxHeap.offer(num);

//         minHeap.offer(maxHeap.remove());

//         if(minHeap.size() > maxHeap.size()){
//             maxHeap.offer(minHeap.remove());
//         }
      
//     }

//     public double findMedian() {
//         if(minHeap.size() != maxHeap.size()){
//             return (double)maxHeap.peek();
//         }
//         else{
//             return (double)(maxHeap.peek() + minHeap.peek()) / 2;
//         }
//     }   
       

// }



















// /////////////////////////////////////////////////////////////////////////////////////////////////////////
// //Re-solving on 23 Nov 2025

// //intuition 3 (Optimizing intuition 2): Maintain two heaps, one min Heap and one max Heap. 
//     //Every time addNum is called add to max heap
//     //The remove the top elemnt from maxHeap and add it to the minHeap
//     //If minHeap.size() > maxHeap.size(). Remove the top from min and add it to max to
//         //maintain the median at top of maxHeap 
//     //If findMedian is called:
//         //if both heaps are of equal size, then return average of tops of both heaps
//         //if the size of maxHeap is greater than minHeap, return top to maxHeap


//         ///////////////////////////still not better than the 99% beats submitted code//////////////////////

// class MedianFinder {

//     private PriorityQueue<Integer> small; // max-heap
//     private PriorityQueue<Integer> large; // min-heap

//     public MedianFinder() {
//         small = new PriorityQueue<>(Collections.reverseOrder());
//         large = new PriorityQueue<>();
//     }

//     public void addNum(int num) {

//         // Step 1: Always push to max-heap first
//         if (small.isEmpty() || num <= small.peek()) {
//             small.offer(num);
//         } else {
//             large.offer(num);
//         }

//         // Step 2: Rebalance heaps (sizes differ by > 1)
//         if (small.size() > large.size() + 1) {
//             large.offer(small.poll());
//         } else if (large.size() > small.size() + 1) {
//             small.offer(large.poll());
//         }
//     }

//     public double findMedian() {
//         if (small.size() == large.size()) {
//             return (small.peek() + large.peek()) / 2.0;
//         }
//         return small.size() > large.size() ? small.peek() : large.peek();
//     }

// }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// //Re-solving on 23 Nov 2025

// //intuition 2 (beats 13.6%): Maintain two heaps, one min Heap and one max Heap. 
//     //Every time addNum is called add to max heap
//     //The remove the top elemnt from maxHeap and add it to the minHeap
//     //If minHeap.size() > maxHeap.size(). Remove the top from min and add it to max to
//         //maintain the median at top of maxHeap 
//     //If findMedian is called:
//         //if both heaps are of equal size, then return average of tops of both heaps
//         //if the size of maxHeap is greater than minHeap, return top to maxHeap

// class MedianFinder {

//     PriorityQueue<Integer> first_half;
//     PriorityQueue<Integer> second_half;

//     public MedianFinder() {
//         first_half = new PriorityQueue<>((a,b) -> (b-a)); //max Heap
//         second_half = new PriorityQueue<>((a,b) -> (a-b)); //min Heap
//     }
    
//     public void addNum(int num) {
//         first_half.offer(num);
//         second_half.offer(first_half.remove());

//         if(second_half.size() > first_half.size()){
//             first_half.offer(second_half.remove());
//         }
//     }
    
//     public double findMedian() {
//        if(first_half.size() == second_half.size()){ //even numbers
//             return (double)(first_half.peek() + second_half.peek()) / 2;
//        }
//        else{
//         return (double) first_half.peek();
//        }
//     }

// }


// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// //Re-solving on 23 Nov 2025

// //intuition 1 (TLE): Maintain two heaps, one min Heap and one max Heap. 
// //Every time addNum is called add to max heap
// //If the findMeian is called, remove the elements from maxHeap and add it to the minHeap, until 
// //the size of both the heaps become equal or size of minHeap exeeds.
//     //If the size of both the heaps become equal, take peak from both the heaps and return the mean
//     //If the size of minHeap is greater, take a peek from minHeap and return that
// //top of both and 

// class MedianFinder {

//     PriorityQueue<Integer> minHeap;
//     PriorityQueue<Integer> maxHeap;

//     public MedianFinder() {
//         minHeap = new PriorityQueue<>((a,b) -> (a-b));
//         maxHeap = new PriorityQueue<>((a,b) -> (b-a));
//     }
    
//     public void addNum(int num) {
//         maxHeap.offer(num);
//     }
    
//     public double findMedian() {
//         while(minHeap.size() < maxHeap.size()){
//             minHeap.offer(maxHeap.remove());
//         }
//         double median = 0.0; 
//         if(minHeap.size() == maxHeap.size()){
//             median = (double) (minHeap.peek() + maxHeap.peek()) / 2;
//         }

//         else{ //minHeap.size() > maxHeap.size();
//             median = (double) minHeap.peek();
//         }
        
//         //adding back the elements from minHeap to maxHeap
//         while(!minHeap.isEmpty()){
//             maxHeap.offer(minHeap.remove());
//         }

//         return median;
//     }

// }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */