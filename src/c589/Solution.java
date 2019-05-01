package c589;

import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class Solution {

    private List<Integer> result = new ArrayList<>();

    public List<Integer> preorder(Node root) {

        if (root == null) {
            return this.result;
        }
        this.order(root);
        return this.result;
    }


    public void order(Node node) {
        if (node == null) {
            return;
        }
        this.result.add(node.val);

        if (node.children != null) {
            int length = node.children.size();
            for (int i = 0; i < length; i ++) {
                this.order(node.children.get(i));
            }
        }
    }
}
