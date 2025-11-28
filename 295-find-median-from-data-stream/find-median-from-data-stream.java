
//Re-solving on 28 Nov 2025

//intuition 1: Have two heaps (one minHeap and one maxHeap). maxHeap should store the first half of the 
//sorted list whereas the minHeap should store the second half of the sorted list. This way the median 
//will be on the top of either (odd) or both (even) the heaps.

//Everytime we add a number, add it to maxHeap, then remove from there and add it to minHeap. If this 
    //operation leads to minHeap.size > maxHeap.size, remove the top element from minHeap and add back to
    //maxHeap.

//In case of findMedian, if the size of both the heaps is not same (i.e. current array is of odd length),
    //return the top of maxHeap. And if the size of both the heaps is same (i.e. current array is of even
    //length), return the average of both the tops



class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap; 
   

    public MedianFinder() {
        minHeap = new PriorityQueue<>((a,b) -> (a-b));
        maxHeap = new PriorityQueue<>((a,b) -> (b-a));
    }

    public void addNum(int num) {
        maxHeap.offer(num);

        minHeap.offer(maxHeap.remove());

        if(minHeap.size() > maxHeap.size()){
            maxHeap.offer(minHeap.remove());
        }
      
    }

    public double findMedian() {
        if(minHeap.size() != maxHeap.size()){
            return (double)maxHeap.peek();
        }
        else{
            return (double)(maxHeap.peek() + minHeap.peek()) / 2;
        }
    }   
       

}



















/////////////////////////////////////////////////////////////////////////////////////////////////////////
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