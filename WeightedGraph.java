import java.util.*;

class WeightedGraph {


    //private List<WeightedEdge>[] adjList;
    private HashMap<Integer, ArrayList<WeightedEdge>> adjList = new HashMap<>();
    private int V;

    WeightedGraph(int V) {
        this.V = V;
    }
    private boolean addVertex(int v) {
        if (!adjList.containsKey(v)) {
            adjList.put(v, new ArrayList<WeightedEdge>());
            return true;
        }
        return false;
    }


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
        adjList.get(w).add(weightedEdge);





    }
    public void printList() {
        System.out.println(adjList);
    }
    public void dijkstra(){

    }

    public int V() {
        return V;
    }
    private double[] dijkstrasHelper(int source){
        double[] distTo = new double[V];
        Arrays.fill(distTo, Double.POSITIVE_INFINITY);
        distTo[source] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> a[1]));
        pq.add(new int[]{source, 0}); // Use an array or a custom class to store vertex and its distance

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int vertex = current[0];
            double distance = current[1];

            if (distance > distTo[vertex]) continue; // Skip if we've already found a better path

            if (!adjList.containsKey(vertex)) continue; // Skip if no outgoing edges

            for (WeightedEdge edge : adjList.get(vertex)) {
                int neighbor = edge.other(vertex);
                double newDist = distTo[vertex] + edge.weight;
                if (newDist < distTo[neighbor]) {
                    distTo[neighbor] = newDist;
                    pq.add(new int[]{neighbor, (int) newDist});
                }
            }
        }

        return distTo;



    }
    public void djikstras(int source){
        double arr[] = dijkstrasHelper(source);
        int i =0;
        for (Double d : arr){
            System.out.println("Shortest distance from vertex 0 to vertex " + i + ": " + d);
            i++;


        }

    }

}