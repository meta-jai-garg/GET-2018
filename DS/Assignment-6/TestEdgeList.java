import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TestEdgeList {
    /**
     * when graph is connected
     */
    @Test
    public void testIsConnected1() {
        UndirectedWeightedGraph graph = new EdgeList(4, Arrays.asList(new Edge(0, 1, 2), new Edge(1, 2, 3), new Edge(0, 3, 4), new Edge(3, 2, 5)));
        assertTrue(graph.isConnected());
    }

    /**
     * when graph is not connected
     */
    @Test
    public void testIsConnected2() {
        UndirectedWeightedGraph graph = new EdgeList(4, Arrays.asList(new Edge(0, 1, 2), new Edge(0, 3, 4)));
        assertFalse(graph.isConnected());
    }

    @Test
    public void testReachable() {
        UndirectedWeightedGraph graph = new EdgeList(4, Arrays.asList(new Edge(0, 1, 2), new Edge(1, 2, 3), new Edge(0, 3, 4), new Edge(3, 2, 5)));
        List<Integer> expected = graph.reachable(0);
        List<Integer> actual = new ArrayList<>(Arrays.asList(0, 1, 2, 3));
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void testMinimumSpanningTree() {
        UndirectedWeightedGraph graph = new EdgeList(4, Arrays.asList(new Edge(0, 1, 2), new Edge(1, 2, 3), new Edge(0, 3, 4), new Edge(3, 2, 5)));
        List<List<Edge>> expected = graph.minimumSpanningTree();
        assertEquals(4, expected.size());
    }

    @Test
    public void testShortestPath() {
        UndirectedWeightedGraph graph = new EdgeList(6, Arrays.asList(new Edge(0, 1, 2), new Edge(1, 3, 1), new Edge(3, 5, 2), new Edge(1, 4, 1), new Edge(4, 5, 2), new Edge(0, 2, 4), new Edge(2, 5, 5)));
        List<Integer> expected = graph.shortestPath(0, 5);
//        List<Integer> actual = new ArrayList<>(Arrays.asList(0, 1, 2));
//        assertEquals(expected.toString(), actual.toString());
        System.out.println(expected.toString());
    }
}
