import javax.xml.stream.events.EndDocument;
import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Graph {

    enum Color {
        RED,
        GREEN,
        BLUE,
        YELLOW,
        PURPLE,
        BLACK,
        PINK,
        BROWN,
        GRAY,
        ORANGE,
        WHITE
    }

    private int degree = -1;
    private int colorAmount = -1;
    private ArrayList<Graph.Color> possibleColors = new ArrayList<>();
    public HashMap<Integer, GraphNode> V = new HashMap<>();
    public ArrayList<GraphEdge> E = new ArrayList<>();

    private ArrayList<Integer> verticesIds = new ArrayList<>();
    private ArrayList<Integer> edgeIds = new ArrayList<>();

    public Graph(int degree, ArrayList<Integer> V, ArrayList<Integer> E) throws Exception {
        if (degree + 1 > 10)
            throw new Exception("Please choose a degree that is smaller then 10.");
        this.degree = degree;
        this.colorAmount = degree + 1;
        this.verticesIds = (ArrayList<Integer>) V.clone();
        this.edgeIds = (ArrayList<Integer>) E.clone();
        createNodes(V);
        createConnections(E);
        possibleColors.addAll(Arrays.asList(Color.values()).subList(0, colorAmount));
    }

    private void createConnections(ArrayList<Integer> edges) throws Exception {
        if (edges.size() % 2 != 0)
            throw new Exception("Integers given as edges are not of size multiple of 2!");
        for (int i = 0; i < edges.size(); i+= 2) {
            if (!verticesIds.contains(edges.get(i)) || !verticesIds.contains(edges.get(i+1)))
                throw new Exception("One of the given edge integers was not found in the given Vertices!");
            E.add(new GraphEdge(edges.get(i), edges.get(i + 1)));
            V.get(edges.get(i)).addNeighbor(V.get(edges.get(i+1)));
            V.get(edges.get(i+1)).addNeighbor(V.get(edges.get(i)));
        }
    }

    private void createNodes (ArrayList<Integer> ids) {
        for (Integer id : ids) V.put(id, new GraphNode(id));
    }
}
