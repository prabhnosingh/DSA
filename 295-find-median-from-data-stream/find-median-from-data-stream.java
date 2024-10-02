class MedianFinder {

    PriorityQueue<Integer> smallHeap;
    PriorityQueue<Integer> bigHeap;

    public MedianFinder() {
        smallHeap = new PriorityQueue<>(Collections.reverseOrder()); // max heap
        bigHeap = new PriorityQueue<>(); // min heap
    }

    public void addNum(int num) {

        if(smallHeap.size() != 0 && bigHeap.size() != 0){
            if(num >= bigHeap.peek()){                bigHeap.offer(num);
            }
    
            else{
                smallHeap.offer(num);
            }
        }
        else{
            smallHeap.offer(num);
        }
        
        int smallHeapLen = smallHeap.size();
        int bigHeapLen = bigHeap.size();

        if(Math.abs(smallHeapLen - bigHeapLen) > 1){
            if(smallHeapLen > bigHeapLen){
                bigHeap.offer(smallHeap.poll());
            }
            else{
                smallHeap.offer(bigHeap.poll());
            }
        }

    }

    public double findMedian() {
        int smallHeapLen = smallHeap.size();
        int bigHeapLen = bigHeap.size();

        double med = 0.0;

        int lenDiff = smallHeapLen - bigHeapLen;

        if(lenDiff == 0){
            med = (smallHeap.peek() + bigHeap.peek()) / 2.0;
        }
        else{
            if(lenDiff < 0){
                med = bigHeap.peek();
            }
            else{
                med = smallHeap.peek();
            }
        }

        return med;

    }

// TLE 
    // ArrayList<Integer> numList = new ArrayList<>();;
    // public MedianFinder() {
    //     // numList = new ArrayList<>();
    // }
    
    // public void addNum(int num) {
    //     numList.add(num);
    //     Collections.sort(numList);
    // }
    
    // public double findMedian() {
    //     double med = 0.0;
    //     int len  = numList.size();
    //     if(len % 2 != 0){
    //         med = numList.get(len / 2);
    //     }
    //     else{
    //         med = (numList.get(len / 2) + numList.get((len /2) - 1)) / 2.0;
    //         // System.out.println(numList.get(len / 2) + numList.get((len /2) - 1));
    //     }

    //     return med;
    // }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */