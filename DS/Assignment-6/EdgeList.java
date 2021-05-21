import java.util.*;

public class EdgeList implements UndirectedWeightedGraph {
    private List<List<Edge>> edgeList;
    private Integer totalEdges;

    public EdgeList(Integer noOfVertex, List<Edge> graphEdges) {
        this.edgeList = new ArrayList<>(noOfVertex);
        this.totalEdges = 0;
        for (int vertexIndex = 0; vertexIndex < noOfVertex; vertexIndex++) {
            edgeList.add(new LinkedList<>());
        }
        for (Edge edge : graphEdges) {
            edgeList.get(edge.getStartVertex()).add(new Edge(edge.getStartVertex(), edge.getEndVertex(), edge.getWeight()));
            edgeList.get(edge.getEndVertex()).add(new Edge(edge.getEndVertex(), edge.getStartVertex(), edge.getWeight()));
            totalEdges++;
        }
    }

    @Override
    public boolean isConnected() {
        return size().equals(reachable(0).size());
    }

    @Override
    public List<Integer> reachable(Integer node) {
        List<Integer> reachableNodes = new LinkedList<>();
        reachable(node, new boolean[size()], reachableNodes);
        return reachableNodes;
    }

    private void reachable(Integer node, boolean[] visited, List<Integer> reachableNodes) {
        visited[node] = true;
        reachableNodes.add(node);
        for (Edge edge : edgeList.get(node)) {
            if (!visited[edge.getEndVertex()])
                reachable(edge.getEndVertex(), visited, reachableNodes);
        }
    }

    @Override
    public List<List<Edge>> minimumSpanningTree() {
        if (!isConnected())
            return null;
        PriorityQueue<Edge> minHeap = new PriorityQueue<>(size(), Comparator.comparing(Edge::getWeight));

        // Adding all edges of graph to minHeap
        for (List<Edge> listOfEdge : edgeList) {
            for (Edge edge : listOfEdge)
                minHeap.add(edge);
        }

        List<List<Integer>> edgeGroup = new ArrayList<>(size());
        List<Edge> edgesInMST = new LinkedList<>();
        /*
         * Every edge belongs to a group, referenced by it's index
		 * initially only they themselves are part of their group
		 */
        for (int nodeIndex = 0; nodeIndex < size(); nodeIndex++) {
            edgeGroup.add(new LinkedList<>());
            edgeGroup.get(nodeIndex).add(nodeIndex);
        }

        // Looping until a edge group has all nodes
        while (true) {
            Edge edge = minHeap.poll();
            // Only traversing edge if they connect two unconnected groups
            if (edgeGroup.get(edge.getStartVertex()) != edgeGroup.get(edge.getEndVertex())) {
                // Merging both groups
                for (Integer nodeIndexInSecond : edgeGroup.get(edge.getEndVertex())) {
                    edgeGroup.get(edge.getStartVertex()).add(nodeIndexInSecond);
                    edgeGroup.set(nodeIndexInSecond, edgeGroup.get(edge.getStartVertex()));
                }
                edgesInMST.add(edge);
            }
            // Exiting loop if the edgeGroup formed has all nodes
            if (size().equals(edgeGroup.get(edge.getStartVertex()).size()))
                break;
        }

        return new EdgeList(size(), edgesInMST).getEdgeList();
    }

    @Override
    public List<Integer> shortestPath(Integer sourceNode, Integer destinationNode) {
        PriorityQueue<Edge> minHeap = new PriorityQueue<>(size(), Comparator.comparing(Edge::getWeight));

        Integer[] bestDistanceAchieved = new Integer[size()];
        for (int nodeIndex = 0; nodeIndex < bestDistanceAchieved.length; nodeIndex++)
            bestDistanceAchieved[nodeIndex] = Integer.MAX_VALUE;

        Integer[] parentNode = new Integer[size()];
        // Adding edges of first edge to minHeap
        minHeap.addAll(edgeList.get(sourceNode));
        bestDistanceAchieved[sourceNode] = 0;

        // Looping until any edge is left to be traversed
        while (!minHeap.isEmpty()) {
            Edge edge = minHeap.poll();
            // If this edge takes to destination in less weight, update distance
            if (edge.getWeight() < bestDistanceAchieved[edge.getEndVertex()]) {
                bestDistanceAchieved[edge.getEndVertex()] = edge.getWeight();
                // Adding edges from these node to our heap
                for (Edge edgesFromNode : edgeList.get(edge.getEndVertex()))
                    minHeap.add(new Edge(bestDistanceAchieved[edge.getEndVertex()] + edgesFromNode.getWeight(), edgesFromNode.getStartVertex(), edgesFromNode.getEndVertex()));
                parentNode[edge.getEndVertex()] = edge.getStartVertex();
            }
        }

        // If secondNode was never reached
        if (bestDistanceAchieved[sourceNode] == Integer.MAX_VALUE)
            return null;

        List<Integer> path = new LinkedList<>();
        Integer thisNodeIndex = sourceNode;
        // Forming the path by going through parents until firstNode is reached 
        while (thisNodeIndex != null) {
            ((LinkedList<Integer>) path).addFirst(thisNodeIndex);
            thisNodeIndex = parentNode[thisNodeIndex];
        }

        return path;
    }

    public void addEdge(Integer startVertex, Integer endVertex, Integer weight) {
        edgeList.get(startVertex).add(new Edge(startVertex, endVertex, weight));
        edgeList.get(endVertex).add(new Edge(startVertex, endVertex, weight));
        totalEdges++;
    }

    public List<List<Edge>> getEdgeList() {
        return edgeList;
    }

    private Integer size() {
        return edgeList.size();
    }
}