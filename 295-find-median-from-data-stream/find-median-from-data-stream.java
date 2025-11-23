
//Re-solving on 23 Nov 2025

//intuition 2 (beats 13.6%): Maintain two heaps, one min Heap and one max Heap. 
    //Every time addNum is called add to max heap
    //The remove the top elemnt from maxHeap and add it to the minHeap
    //If minHeap.size() > maxHeap.size(). Remove the top from min and add it to max to
        //maintain the median at top of maxHeap 
    //If findMedian is called:
        //if both heaps are of equal size, then return average of tops of both heaps
        //if the size of maxHeap is greater than minHeap, return top to maxHeap

class MedianFinder {

    PriorityQueue<Integer> first_half;
    PriorityQueue<Integer> second_half;

    public MedianFinder() {
        first_half = new PriorityQueue<>((a,b) -> (b-a)); //max Heap
        second_half = new PriorityQueue<>((a,b) -> (a-b)); //min Heap
    }
    
    public void addNum(int num) {
        second_half.offer(num);
        first_half.offer(second_half.remove());

        if(first_half.size() > second_half.size()){
            second_half.offer(first_half.remove());
        }
    }
    
    public double findMedian() {
       if(first_half.size() == second_half.size()){ //even numbers
            return (double)(first_half.peek() + second_half.peek()) / 2;
       }
       else{
        return (double) second_half.peek();
       }
    }

}


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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