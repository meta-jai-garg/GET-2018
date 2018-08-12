public class Edge {
    private Integer startVertex, endVertex, weight;

    public Edge(Integer startVertex, Integer endVertex, Integer weight) {
        this.startVertex = startVertex;
        this.endVertex = endVertex;
        this.weight = weight;
    }

    public Integer getStartVertex() {
        return startVertex;
    }

    public Integer getEndVertex() {
        return endVertex;
    }

    public Integer getWeight() {
        return weight;
    }
}