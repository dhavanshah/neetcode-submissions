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

    private Map<Integer, Node> cache;
    private int capacity;
    Node left;
    Node right;

    public LRUCache(int capacity) {
        
        this.cache = new HashMap<>();
        this.capacity = capacity;
        this.left = new Node(0,0);
        this.right = new Node(0,0);
        this.left.next = right;
        this.right.prev = left;
    }

    private void insert(Node node) {
        Node next = this.left.next;
        node.next = next;
        next.prev = node;
        node.prev = this.left;
        this.left.next = node;
    }

    private void remove(Node node) {
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
        Node node = new Node(key, value);
        cache.put(key, node);
        insert(node);

        if(cache.size() > capacity) {
            Node rem = this.right.prev;
            remove(rem);
            cache.remove(rem.key);
        }
    }
}
