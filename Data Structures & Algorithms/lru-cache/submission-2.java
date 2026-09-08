class LRUCache {

    static class ListNode{
        int val;
        ListNode next, prev;

        ListNode(int val){
            this.val=val;
        }
    }

    ListNode head, tail;
    HashMap<Integer, ListNode> myMap;
    int capacity, count;

    public LRUCache(int capacity) {
        head = new ListNode(0);
        tail = new ListNode(0);

        head.next=tail;
        tail.prev=head;

        myMap = new HashMap<>();

        this.capacity = capacity;
        this.count = 0;
        
    }
    
    public int get(int key) {
        if(myMap.containsKey(key) && myMap.get(key).val!=-1){
            ListNode temp = myMap.get(key);
            temp.prev.next=temp.next;
            temp.next.prev=temp.prev;
            temp.next=head.next;
            temp.next.prev=temp;
            temp.next=head.next;
            temp.next.prev=temp;
            temp.prev=head;
            head.next=temp;
            
            return temp.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        ListNode temp;
        if(myMap.containsKey(key) && myMap.get(key).val!=-1){
            temp = myMap.get(key);
            temp.val=value;
            temp.prev.next=temp.next;
            temp.next.prev=temp.prev;
        }else if(myMap.containsKey(key)){
            temp = myMap.get(key);
            temp.val=value;
            count++;
        }else {
            temp = new ListNode(value);
            myMap.put(key,temp);
            count++;
        }

        temp.next=head.next;
        temp.next.prev=temp;
        temp.prev=head;
        head.next=temp; 

        if(count>capacity){
            tail.prev.val=-1;
            tail.prev = tail.prev.prev;
            tail.prev.next = tail;
            count--;
        }
    }
}
