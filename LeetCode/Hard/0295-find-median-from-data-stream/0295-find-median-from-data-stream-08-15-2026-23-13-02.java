class MedianFinder {
    
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    int count = 0;
    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
    }
    
    public void addNum(int num) {

        min.offer(num);
        count++;
        while(count > 1 && max.size() < count/2){
            max.offer(min.poll());
        }

        if(!max.isEmpty() && max.peek() > min.peek()){
            int temp = max.poll();
            max.offer(min.poll());
            min.offer(temp);
        }
    }
    
    public double findMedian() {
        
        if(count%2 == 0){
            return (min.peek() + max.peek())/2.0;
        }
        return min.peek();

    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */