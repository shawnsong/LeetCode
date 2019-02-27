package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q116_PopulatingNextRightPointersInEachNodeTest {

    @Test
    void connect() {
        Q116_PopulatingNextRightPointersInEachNode test = new Q116_PopulatingNextRightPointersInEachNode();
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        root.left.left = new TreeLinkNode(4);
        root.left.right = new TreeLinkNode(5);
        root.right.left = new TreeLinkNode(6);
        root.right.right = new TreeLinkNode(7);

        test.connect(root);
    }
}