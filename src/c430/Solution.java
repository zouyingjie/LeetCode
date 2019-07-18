package c430;

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
}

class Solution {
    public Node flatten(Node head) {
        return helper(head);

    }

    private Node helper(Node node) {
        if (node == null) {
            return null;
        }

        Node next = helper(node.next);
        Node child = helper(node.child);

        if (child != null) {
            Node tmpChild = child;

            while (tmpChild.next != null) {
                tmpChild = tmpChild.next;
            }

            tmpChild.next = next;
            node.next = child;
        }

        return node;
    }


}