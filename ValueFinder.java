import java.util.*;

public class ValueFinder {
    public static HW3_Q2_solution.WeightedGraph createGraph(List<String> lines) {
        // Parse the number of vertices from the first line.
        int V = Integer.parseInt(lines.get(0).trim());
        // Initialize a new WeightedGraph with the given number of vertices.
        HW3_Q2_solution.WeightedGraph graph = new HW3_Q2_solution.WeightedGraph(V);

        // Iterate through the lines representing edges, starting from the third line.
        for (int i = 2; i < lines.size(); i++) {
            // Split each line into parts representing source, destination, and weight.
            String[] parts = lines.get(i).split(" ");
            int src = Integer.parseInt(parts[0]);
            int dest = Integer.parseInt(parts[1]);
            int weight = Integer.parseInt(parts[2]);

            // Add the edge to the graph.
            graph.addEdge(new HW3_Q2_solution.WeightedEdge(src, dest, weight));
        }
        return graph;
    }
}
