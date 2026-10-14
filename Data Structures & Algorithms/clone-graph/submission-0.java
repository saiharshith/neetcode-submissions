/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node,Node> myMap;

    private Node helper(Node node){
        if(node==null){
            return null;
        }
        if(myMap.containsKey(node)){
            return myMap.get(node);
        }
        Node answer = new Node();
        myMap.put(node,answer);
        answer.val = node.val;
        for(Node x : node.neighbors){
            answer.neighbors.add(helper(x));     
        }

        return answer;
        
    }
    public Node cloneGraph(Node node) {
        myMap = new HashMap<>();
        return helper(node);
    }
}