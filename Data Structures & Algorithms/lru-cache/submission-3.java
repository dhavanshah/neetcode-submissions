class Node {
    int key;
    int value;
    Node prev;
    Node next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null; 
    }
}

class LRUCache {

    //use a doubly linked list to maintain the frequency of use
    //the key-values to the front of the list are recently used
    //the one at the end of the list(at the tail) is the one we
    //remove.
    private final Map<Integer, Node> cache;
    private int capacity;
    Node left;
    Node right;
    
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.left = new Node(0,0);
        this.right = new Node(0,0);
        this.left.next = right;
        this.right.prev = left;
    }

    public void insert(Node node) {
        Node temp = left.next;
        left.next = node;
        node.next = temp;
        node.prev = left;
        temp.prev = node;
    }

    public void remove(Node node) {
        Node next = node.next;
        Node prev = node.prev;

        next.prev = prev;
        prev.next = next;
        
    }
    
    public int get(int key) {
        
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            insert(node);

            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {

        if(cache.containsKey(key)) {
            remove(cache.get(key));
        }
        Node newNode = new Node(key,value);
        cache.put(key, newNode);
        insert(newNode);

        if(cache.size() > capacity) {
            Node del = this.right.prev;
            remove(del);
            cache.remove(del.key);
        }
    }
}
