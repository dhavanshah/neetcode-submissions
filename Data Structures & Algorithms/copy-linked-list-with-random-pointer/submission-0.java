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

        Map<Node, Node> nodeMap = new HashMap<>();

        Node curr = head;
        while(curr != null) {
            Node newNode = new Node(curr.val);
            nodeMap.put(curr, newNode);
            // System.out.println("Val:" + newNode.val);
            // System.out.println("Next val:" + newNode.next.val);
            //System.out.println("Random val:" + newNode.next.random.val);
            curr = curr.next;
        }

        curr = head;
        while(curr != null) {
            Node copy = nodeMap.get(curr);
            copy.next = nodeMap.get(curr.next);
            copy.random = nodeMap.get(curr.random);

            curr = curr.next;
        }


        return nodeMap.get(head);
    }
}
