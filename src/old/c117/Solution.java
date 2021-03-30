package old.c117;


import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

class Solution {

    public Node connect(Node root) {

        if (root == null) {
            return null;
        }
        List<Node> currentLevel = new ArrayList<>();
        currentLevel.add(root);
        dfs(currentLevel);
        return root;

    }

    private void dfs(List<Node> nodes) {

        int size = nodes.size();
        if (size == 0) {
            return;
        }

        List<Node> nextLevel = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            Node node = nodes.get(i);
            if (node.left != null) {
                nextLevel.add(node.left);
            }
            if (node.right != null) {
                nextLevel.add(node.right);
            }
        }

        for (int i = 0; i < size - 1; i++) {
            Node node = nodes.get(i);
            node.next = nodes.get(i + 1);
        }

        dfs(nextLevel);

    }
}