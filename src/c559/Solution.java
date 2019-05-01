package c559;

import node.Node;

import java.util.ArrayList;
import java.util.List;



public class Solution {
    private int result = 0;
    public int maxDepth(Node root) {
        inOrder(root, 0);
        return this.result;
    }


    private void inOrder(Node node, int depth) {
        if (node == null) {
            return;
        }
        depth += 1;

        if (node.children.size() > 0) {
            for (Node children :
                    node.children) {
                inOrder(children, depth);
            }
        }else {
            this.result = Math.max(this.result, depth);
        }

    }

    public static void main(String[] args) {

        Node node5 = new Node(5, new ArrayList<>());
        Node node6 = new Node(6, new ArrayList<>());

        Node node3 = new Node(3, new ArrayList<>());
        node3.children.add(node5);
        node3.children.add(node6);
        Node node4 = new Node(4, new ArrayList<>());
        node4.val = 4;
        Node node2 = new Node(2, new ArrayList<>());
        node2.val = 2;

        Node root = new Node(1, new ArrayList<>());
        root.children.add(node3);
        root.children.add(node2);
        root.children.add(node4);

        Solution s = new Solution();
        s.maxDepth(root);
    }
}
