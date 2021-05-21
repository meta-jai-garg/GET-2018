import java.util.List;

public interface UndirectedWeightedGraph {
    /**
     * method to check if graph is connected or not
     *
     * @return true if graph is connected
     */
    boolean isConnected();

    /**
     * method to find reachable nodes from given node
     *
     * @param node is vertex
     * @return list of nodes that are reachable
     */
    List<Integer> reachable(Integer node);

    /**
     * method to find minimum spanning tree
     *
     * @return list of edges in spanning tree
     */
    List<List<Edge>> minimumSpanningTree();

    /**
     * method to find shortest path between two nodes
     *
     * @param sourceNode      source
     * @param destinationNode destination
     * @return shortest path
     */
    List<Integer> shortestPath(Integer sourceNode, Integer destinationNode);
}
