package c590;

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

/**
 * 采用后续遍历的方式去遍历一个 N 叉树、
 *
 * 对 N 叉树进行递归遍历，优先遍历子节点，然后在遍历自身。
 * 每个节点都需要一次遍历，然后将值添加到列表中，时间复杂度为 O(N)，空间复杂度为 O(N)。
 *
 */
public class Solution {


    private List<Integer> result = new ArrayList<>();
    public List<Integer> postorder(Node root) {

        if (root == null) {
            return result;
        }

        this.postOrderWithValue(root);
        return this.result;
    }

    private void postOrderWithValue(Node node) {
        if (node.children != null) {
            for (Node n:
                    node.children) {
                postorder(n);
            }
        }
        this.result.add(node.val);

    }
}
