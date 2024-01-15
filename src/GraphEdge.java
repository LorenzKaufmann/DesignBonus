public class GraphEdge {

    private GraphNode startNode;
    private GraphNode endNode;
    private boolean isBichrom = false;

    public GraphEdge(int startId, int endId) {
        this.startNode = new GraphNode(startId);
        this.endNode = new GraphNode(endId);
        checkBichrom();
    }

    private void checkBichrom() {
        this.isBichrom = startNode.getColor() != endNode.getColor();
    }
}
