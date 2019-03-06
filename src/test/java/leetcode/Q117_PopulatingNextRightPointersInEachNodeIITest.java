package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q117_PopulatingNextRightPointersInEachNodeIITest {

    Q117_PopulatingNextRightPointersInEachNodeII underTest = new Q117_PopulatingNextRightPointersInEachNodeII();

    @Test
    void connect() {
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        root.left.left = new TreeLinkNode(4);
        root.left.right = new TreeLinkNode(5);
        root.right.right = new TreeLinkNode(7);

        underTest.connect(root);
        TreeLinkNode node = root;
        while (node.left != null) {
            node = node.left;
        }
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}