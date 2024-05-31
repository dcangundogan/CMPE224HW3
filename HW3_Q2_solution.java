import java.util.*;

public class HW3_Q2_solution {

    // Represents a weighted edge in a graph.
    public static class WeightedEdge implements Comparable<WeightedEdge> {
        int src, dest;
        int weight;

        // Constructs a WeightedEdge with given source, destination, and weight.
        WeightedEdge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        // Compares this edge with another based on weight.
        @Override
        public int compareTo(WeightedEdge o) {
            return Integer.compare(this.weight, o.weight);
        }

        // Returns one end of the edge.
        public int either() {
            return src;
        }

        // Returns the other end of the edge given one end.
        public int other(int vertex) {
            return vertex == this.src ? dest : src;
        }

        // Returns a string representation of the edge.
        @Override
        public String toString() {
            return String.format("%d %d %d", src, dest, weight);
        }
    }

    // Represents a weighted graph.
    public static class WeightedGraph {
        private HashMap<Integer, ArrayList<WeightedEdge>> adjList;
        private int V;

        // Constructs a WeightedGraph with a given number of vertices.
        WeightedGraph(int V) {
            this.V = V;
            adjList = new HashMap<>();
        }

        // Adds a vertex to the graph if it doesn't already exist.
        private boolean addVertex(int v) {
            if (!adjList.containsKey(v)) {
                adjList.put(v, new ArrayList<WeightedEdge>());
                return true;
            }
            return false;
        }

        // Adds an edge to the graph.
        public void addEdge(WeightedEdge weightedEdge) {
            int v = weightedEdge.either();
            int w = weightedEdge.other(v);

            if (!adjList.containsKey(v)) {
                addVertex(v);
            }
            if (!adjList.containsKey(w)) {
                addVertex(w);
            }
            adjList.get(v).add(weightedEdge);
        }

        // Returns the number of vertices in the graph.
        public int V() {
            return V;
        }

        // Helper class for Dijkstra's algorithm to represent nodes.
        private class Node implements Comparable<Node> {
            int vertex;
            int dist;

            // Constructs a Node with a given vertex and distance.
            Node(int vertex, int dist) {
                this.vertex = vertex;
                this.dist = dist;
            }

            // Compares this node with another based on distance.
            @Override
            public int compareTo(Node other) {
                return Integer.compare(this.dist, other.dist);
            }
        }

        // Helper method for Dijkstra's algorithm.
        private double[] dijkstraHelper(int source, int[] previous) {
            double[] distTo = new double[V];
            Arrays.fill(distTo, Double.POSITIVE_INFINITY);
            distTo[source] = 0;

            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(source, 0));

            while (!pq.isEmpty()) {
                Node current = pq.poll();
                int vertex = current.vertex;
                double distance = current.dist;

                if (distance > distTo[vertex]) continue;

                if (!adjList.containsKey(vertex)) continue;

                for (WeightedEdge edge : adjList.get(vertex)) {
                    int neighbor = edge.other(vertex);
                    double newDist = distTo[vertex] + edge.weight;
                    if (newDist < distTo[neighbor]) {
                        distTo[neighbor] = newDist;
                        pq.add(new Node(neighbor, (int) newDist));
                        previous[neighbor] = vertex;
                    }
                }
            }

            return distTo;
        }

        // Runs Dijkstra's algorithm from a given source to specified end points.
        public void dijkstra(int source, int[] endPoints) {
            int[] previous = new int[V];
            Arrays.fill(previous, -1);

            double[] distTo = dijkstraHelper(source, previous);

            for (int endPoint : endPoints) {
                if (distTo[endPoint] == Double.POSITIVE_INFINITY) {
                    System.out.println("No path to " + endPoint);
                    continue;
                }

                List<Integer> path = new ArrayList<>();
                for (int temp = endPoint; temp != -1; temp = previous[temp]) {
                    path.add(temp);
                }
                Collections.reverse(path);

                System.out.print("0");
                for (int i = 1; i < path.size(); i++) {
                    System.out.print(" " + path.get(i));
                }
                System.out.println(" " + (int) distTo[endPoint]);
            }
        }
    }

    public static void main(String[] args) {
        // Reads text from the input file.
        List<String> text = FileRead.readFile("HW3_Q2.txt");

        // Creates a graph from the input text.
        WeightedGraph graph = ValueFinder.createGraph(text);
        int V = graph.V();
        int E = Integer.parseInt(text.get(1).trim());

        System.out.println("V=" + V);
        System.out.println("E=" + E);

        // Prints the edges read from the file.
        for (String line : text.subList(2, text.size())) {
            System.out.println(line);
        }

        System.out.println("The result");

        // Specifies the end points for Dijkstra's algorithm and runs it.
        int[] endPoints = {1, 2, 3};
        graph.dijkstra(0, endPoints);
    }
}
