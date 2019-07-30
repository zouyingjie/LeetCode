package c138;


// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;

    }
};


class Solution {


    public Node copyRandomList(Node head) {

        return helper(head);
    }

    public Node helper(Node node) {
        if (node == null) {
            return null;
        }

        Node next = node.next;
        Node random = node.random;

        helper(next);
        helper(random);

        Node tmp = new Node(node.val, next, random);

        return tmp;


    }
}