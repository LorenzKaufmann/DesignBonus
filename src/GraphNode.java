import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GraphNode {

    private static long seed = 318490849;
    private static Random generator = new Random(seed);

    private int id = -1;
    private ArrayList<Graph.Color> availableColors = new ArrayList<>(List.of(Graph.Color.values()));
    private Graph.Color color = Graph.Color.WHITE;
    private Graph.Color candidateColor;
    private ArrayList<GraphNode> neighbors = new ArrayList<>();

    public GraphNode(int id) {
        this.id = id;
        this.candidateColor = Graph.Color.values()[generator.nextInt(availableColors.size()-1)];
    }

    public Graph.Color getColor() {
        return this.color;
    }

    public Graph.Color getCandidateColor() {
        return this.candidateColor;
    }

    public void addNeighbor(GraphNode node) {
        neighbors.add(node);
    }

    public void setColorAndInformNeighbor() {
        boolean canSetCandidateColor = true;
        for (int i = 0; i < neighbors.size(); i++) {
            if(neighbors.get(i).getColor() == candidateColor) {
                canSetCandidateColor = false;
                break;
            }
        }
        if(canSetCandidateColor) {
            this.color = candidateColor;
            informNeighbors();
        } else {
            this.availableColors.remove(candidateColor);
            this.candidateColor = Graph.Color.values()[generator.nextInt(availableColors.size()-1)];
        }

    }

    private void informNeighbors() {
        for (int i = 0; i < neighbors.size(); i++)
            neighbors.get(i).availableColors.remove(candidateColor);
    }

}
