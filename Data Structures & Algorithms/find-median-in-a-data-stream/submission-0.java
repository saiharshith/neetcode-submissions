class MedianFinder {
    PriorityQueue<Integer> pq1,pq2;
    public MedianFinder() {
        pq1=new PriorityQueue<>((a,b)->Integer.compare(b,a));
        pq2=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(pq1.isEmpty() || pq1.peek()>=num){
            pq1.offer(num);
        }else{
            pq2.offer(num);    
        }

        if(pq1.size()>pq2.size()+1){
            pq2.offer(pq1.poll());
        }else if(pq1.size()<pq2.size()){
            pq1.offer(pq2.poll());
        }
    }
    
    public double findMedian() {
        if((pq1.size()+pq2.size())%2==0){
            return ((double)(pq1.peek()+pq2.peek()))/2;    
        }else{
            return pq1.peek();
        }    
    }
}
