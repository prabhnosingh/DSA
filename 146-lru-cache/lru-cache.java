
class Node{
       
            int key;
            int val;
            Node prev;
            Node next;

            Node(int key, int val){
                this.key = key;
                this.val = val;
             
            }
        }
        
class LRUCache {
    
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);


    HashMap<Integer, Node> map = new HashMap<>();
    int cap = 0;
   
   
    public LRUCache(int capacity) {
        cap = capacity;

        //tail indicates LRU and head indicates most recently used 
        head.next = tail;
        tail.prev = head;
    } 


       //insert node at the right
    public void addNode(Node newNode){
        Node temp = head.next;

        newNode.next = temp;
        newNode.prev = head;

        head.next = newNode;
        temp.prev = newNode; //this temp.prev is equivalent to "nodeNextToHead.prev",because
                            // temp = head.next and "head.next" is nodeNextToHead.

    }
    //remove from the list
    public void deleteNode(Node delNode){
        Node prevv = delNode.prev;
        Node nextt = delNode.next;

        prevv.next = nextt;
        nextt.prev = prevv;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node resNode = map.get(key);
            int ans = resNode.val;

            map.remove(key);
            deleteNode(resNode);
            addNode(resNode);

            map.put(key, head.next);
            return ans;            
        }
         
        return -1;
    }
    
    public void put(int key, int value) {
         if(map.containsKey(key)){
            Node curr = map.get(key);
            map.remove(key);
            deleteNode(curr);
        }   // if the key exists in "hashMap" then we remove it from both the "map" and "list"
            // as in case of "map", we have to update the "value"(pointer to the node) and in
            // case of "list" we have to update it to "recently used" by placing it next to
            // the "head".

        if(map.size() == cap){
            //remove from the list and delete the LRU from the hashmap

           map.remove(tail.prev.key);
           deleteNode(tail.prev);
             
        }

        addNode(new Node(key, value));
        map.put(key, head.next);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */