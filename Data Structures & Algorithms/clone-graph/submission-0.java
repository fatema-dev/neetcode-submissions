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
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>(); //map node to clone
        
        return clone(node, map);
    }

    public Node clone(Node node, Map<Node, Node> map){
        if(node == null){
            return null;
        }
        
        if(map.containsKey(node)){
            return map.get(node);
        }
      
        Node clone = new Node(node.val);
        map.put(node, clone);

        for(Node n : node.neighbors){
            clone.neighbors.add(clone(n,map));
        }

        return clone;
        }
    }
