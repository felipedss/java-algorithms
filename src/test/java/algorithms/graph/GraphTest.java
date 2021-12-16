package algorithms.graph;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class GraphTest {

    @Test
    void test() {
        Graph graph = new Graph();
        graph.addEdge(1, 2);
        graph.addEdge(1, 5);
        graph.addEdge(2, 5);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(15, 20);
        assertTrue(graph.hasPathDFS(3, 4));
        assertTrue(graph.hasPathDFS(1, 4));
        assertFalse(graph.hasPathDFS(1, 20));
        assertTrue(graph.hasPathBFS(3, 4));
        assertTrue(graph.hasPathBFS(1, 4));
        assertFalse(graph.hasPathBFS(1, 20));
    }
}
