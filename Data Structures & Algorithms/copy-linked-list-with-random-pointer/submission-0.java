/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node answer = new Node(0), temp1 = head, temp2=answer;

        HashMap<Node, Node> myMap = new HashMap<>();

        while(temp1!=null){
            temp2.next=new Node(temp1.val);
            myMap.put(temp1,temp2.next);
            temp1=temp1.next;
            temp2=temp2.next;    
        }

        temp1=head; temp2=answer.next;
        while(temp1!=null){
            if(temp1.random!=null){
                temp2.random=myMap.get(temp1.random);        
            }
            temp1=temp1.next;
            temp2=temp2.next;
        }

        return answer.next;

    }
}
