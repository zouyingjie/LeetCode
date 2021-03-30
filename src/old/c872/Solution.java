package old.c872;

import node.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * 遍历两棵树获取其子节点列表，然后比较
     */

    private List<TreeNode> current = new ArrayList<>();
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        List<TreeNode> l1 = new ArrayList<>();
        List<TreeNode> l2 = new ArrayList<>();

        current = l1;
        postOrder(root1);
        current = l2;
        postOrder(root2);

        int size1 = l1.size();
        int size2 = l2.size();

        if (size1 != size2) {
            return false;
        }

        for (int i = 0; i < size1; i ++) {
            if (l1.get(i).val != l2.get(i).val) {
                return false;
            }
        }
        return true;
    }

    public void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            this.current.add(node);
        }else {
            postOrder(node.left);
            postOrder(node.right);
        }
    }
}
