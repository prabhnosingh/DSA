/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {

    //Solving on 15 Aug 2026

    //intuition 1: BFS traversal
        //put each node in a queue and run BFS

    public List<List<Integer>> levelOrder(Node root) {
       
        List<List<Integer>> levelOrder = new ArrayList<>();

        if(root == null) return levelOrder;

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int currQueueSize = queue.size();

            List<Integer> currLevel = new ArrayList<>(); 
            for(int i = 0; i < currQueueSize; i ++){
                Node currNode = queue.poll();
                currLevel.add(currNode.val);
                //currNode's children are stored  in a list
                //so traverse over the list and add all the children to queue
                for(Node child : currNode.children){
                    queue.offer(child);
                } 
            }
            levelOrder.add(currLevel);
           
        }

        return levelOrder;

    }
}