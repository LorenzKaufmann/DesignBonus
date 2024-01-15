import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    // Set degree to your liking, it has to be below 10
    public static int degree = 4;

    public static void main(String[] args) throws Exception {
        ArrayList<Integer> V1 = new ArrayList<>();
        ArrayList<Integer> E1 = new ArrayList<>();
        ArrayList<Integer> V2 = new ArrayList<>();
        ArrayList<Integer> E2 = new ArrayList<>();
        ArrayList<Integer> V3 = new ArrayList<>();
        ArrayList<Integer> E3 = new ArrayList<>();
        ArrayList<Integer> VForTutor = new ArrayList<>();
        ArrayList<Integer> EForTutor = new ArrayList<>();

        // HOW TO USE
        /*  First off you have to enter the ids of each node into the VForTutor list (ids can be any positive number inc. 0),
            after that add all edges into the EForTutor list, this list can only contain ids from vertices that you have already
            added to the VForTutor list. Furthermore, the EForTutorList should be used, so that 2 values always represent an edge.
            For example 1 the first edge has nodes 1 and 2, the second edge has nodes 6 and 2 and so on.
         */

        // Example 1
        V1.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        E1.addAll(Arrays.asList(1, 2, 6, 2, 5, 10, 4, 2, 4, 5, 3, 7, 3, 9, 5, 8, 6, 7, 1, 6, 4, 10, 2, 8));
        Graph g1 = new Graph(degree, V1, E1);
        System.out.println("Iterations for example 1:  " + colorGraph(g1));

        // Example 2
        V2.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        E2.addAll(Arrays.asList(1, 5, 3, 10, 5, 9, 6, 10, 7, 2, 8, 7, 3, 4, 4, 8, 8, 10, 9, 2, 6, 5));
        Graph g2 = new Graph(degree, V2, E2);
        System.out.println("Iterations for example 2:  " + colorGraph(g2));

        // Example 3
        V3.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        E3.addAll(Arrays.asList(1, 2, 1, 7, 1, 3, 2, 7, 2, 8, 3, 8, 3, 9, 3, 10, 4, 9, 4, 10, 5, 1, 5, 8, 6, 10, 6, 9, 3, 2));
        Graph g3 = new Graph(degree, V3, E3);
        System.out.println("Iterations for example 3:  " + colorGraph(g3));

        // Example for Tutor

        VForTutor.addAll(Arrays.asList());
        EForTutor.addAll(Arrays.asList());
        Graph gForTutor = new Graph(degree, VForTutor, EForTutor);
        System.out.println("Iterations for Tutor example:  " + colorGraph(gForTutor));
    }

    public static int colorGraph(Graph g) {
        boolean stop = false;
        int iterations = 0;
        while(!stop) {
            for (int i : g.V.keySet()) {
                GraphNode curNode = g.V.get(i);
                if (!curNode.getColor().equals(Graph.Color.WHITE))
                    continue;
                curNode.setColorAndInformNeighbor();
            }
            stop = true;
            for (int i : g.V.keySet()) {
                if (g.V.get(i).getColor() == (Graph.Color.WHITE)) {
                    stop = false;
                    break;
                }
            }
            iterations += 1;
        }
        return iterations;
    }
}