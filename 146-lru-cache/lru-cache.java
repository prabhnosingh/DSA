
// class LRUCache {
 class Node {
    public int key;
    public int val;
    public Node next;
    public Node prev;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        next = null;
        prev = null;
    }
}

class LRUCache {
    private Map<Integer, Node> m;
    private Node head;
    private Node tail;
    private int size;

    public LRUCache(int capacity) {
        size = capacity;
        m = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    private void deleteNode(Node p) {
        Node pre = p.prev;
        Node nex = p.next;
        pre.next = nex;
        nex.prev = pre;
    }

    private void addNode(Node newnode) {
        Node temp = head.next;
        head.next = newnode;
        newnode.prev = head;
        newnode.next = temp;
        temp.prev = newnode;
    }

    public int get(int key) {
        if (!m.containsKey(key))
            return -1;

        Node p = m.get(key);
        deleteNode(p);
        addNode(p);
        m.put(key, head.next);
        return head.next.val;
    }

    public void put(int key, int value) {
        if (m.containsKey(key)) {
            Node c = m.get(key);
            deleteNode(c);
            c.val = value;
            addNode(c);
            m.put(key, head.next);
        } else {
            if (m.size() == size) {
                Node prev = tail.prev;
                deleteNode(prev);
                Node l = new Node(key, value);
                addNode(l);
                m.remove(prev.key);
                m.put(key, head.next);
            } else {
                Node l = new Node(key, value);
                addNode(l);
                m.put(key, head.next);
            }
        }
    }
}
    // class Node{
       
    //         int key;
    //         int val;
    //         Node prev;
    //         Node next;

    //         Node(int key, int val){
    //             this.key = key;
    //             this.val = val;
             
    //         }
    //     }
    // Node head = new Node(-1, -1);
    // Node tail = new Node(-1, -1);


    // HashMap<Integer, Node> map = new HashMap<>();
    // int cap = 0;
   
   
    // public LRUCache(int capacity) {
    //     cap = capacity;

    //     //tail indicates LRU and head indicates most recently used 
    //     head.next = tail;
    //     tail.prev = head;
    // } 


    //    //insert node at the right
    // public void addNode(Node newNode){
    //     Node temp = head.next;

    //     newNode.next = temp;
    //     newNode.prev = head;

    //     head.next = newNode;
    //     temp.prev = newNode; //this temp.prev is equivalent to "nodeNextToHead.prev",because
    //                         // temp = head.next and "head.next" is nodeNextToHead.

    // }
    // //remove from the list
    // public void deleteNode(Node delNode){
    //     Node prevv = delNode.prev;
    //     Node nextt = delNode.next;

    //     prevv.next = nextt;
    //     nextt.prev = prevv;
    // }
    
    // public int get(int key) {
    //     if(map.containsKey(key)){
    //         Node resNode = map.get(key);
    //         int ans = resNode.val;

    //         map.remove(key);
    //         deleteNode(resNode);
    //         addNode(resNode);

    //         map.put(key, head.next);
    //         return ans;            
    //     }
         
    //     return -1;
    // }
    
    // public void put(int key, int value) {
    //      if(map.containsKey(key)){
    //         Node curr = map.get(key);
    //         map.remove(key);
    //         deleteNode(curr);
    //     }   // if the key exists in "hashMap" then we remove it from both the "map" and "list"
    //         // as in case of "map", we have to update the "value"(pointer to the node) and in
    //         // case of "list" we have to update it to "recently used" by placing it next to
    //         // the "head".

    //     if(map.size() == cap){
    //         //remove from the list and delete the LRU from the hashmap

    //        map.remove(tail.prev.key);
    //        deleteNode(tail.prev);
             
    //     }

    //     addNode(new Node(key, value));
    //     map.put(key, head.next);
    // }
// }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */