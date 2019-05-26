package leetcode;

import java.util.HashMap;
import java.util.Objects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Q133_CloneGraphTest {

    Q133_CloneGraph test = new Q133_CloneGraph();
    UndirectedGraphNode root;
    @BeforeEach
    void setup() {
        root = new UndirectedGraphNode(0);
        UndirectedGraphNode child1 = new UndirectedGraphNode(1);
        root.neighbors.add(child1);
        root.neighbors.add(new UndirectedGraphNode(2));
        root.neighbors.add(new UndirectedGraphNode(3));

        child1.neighbors.add(new UndirectedGraphNode(4));
        child1.neighbors.add(new UndirectedGraphNode(5));

        // add a loop in the graph
        child1.neighbors.add(child1);



    }
    @Test
    void cloneGraphBfs() {
        UndirectedGraphNode clone1 = test.cloneGraphDfs(root, new HashMap());
        UndirectedGraphNode clone2 = test.cloneGraphBfs(root);
        UndirectedGraphNode cloned = test.bfs(root);

//        assertEquals(clone1, root);
//        assertEquals(clone2, root);
//        assertEquals(clone2, root);
    }
}