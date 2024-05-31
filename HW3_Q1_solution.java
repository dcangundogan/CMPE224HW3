//import java.util.*;
//
//public class HW3_Q1_solution {
//
//    public static class WeightedEdge implements Comparable<WeightedEdge> {
//        int src, dest;
//        int weight;
//
//        WeightedEdge(int src, int dest, int weight) {
//            this.src = src;
//            this.dest = dest;
//            this.weight = weight;
//        }
//
//        @Override
//        public int compareTo(WeightedEdge o) {
//            return Integer.compare(this.weight, o.weight);
//        }
//
//        public int either() {
//            return src;
//        }
//
//        public int other(int vertex) {
//            if (vertex == this.src) return dest;
//            else return src;
//        }
//
//        @Override
//        public String toString() {
//            return String.format("%d-%d w:%.2f", src, dest, (double) weight);
//        }
//        public void print(HW3_Q1_solution t){
//
//
//        }
//    }
//
//    public static class KruskalAlgorithm {
//        class Subset {
//            int parent, rank;
//        }
//
//        int V, E;
//        List<WeightedEdge> edges;
//
//        public KruskalAlgorithm(int V, List<WeightedEdge> edges) {
//            this.V = V;
//            this.edges = edges;
//            this.E = edges.size();
//        }
//
//        int find(Subset[] subsets, int i) {
//            if (subsets[i].parent != i) {
//                subsets[i].parent = find(subsets, subsets[i].parent);
//            }
//            return subsets[i].parent;
//        }
//
//        void union(Subset[] subsets, int x, int y) {
//            int xroot = find(subsets, x);
//            int yroot = find(subsets, y);
//
//            if (subsets[xroot].rank < subsets[yroot].rank) {
//                subsets[xroot].parent = yroot;
//            } else if (subsets[xroot].rank > subsets[yroot].rank) {
//                subsets[yroot].parent = xroot;
//            } else {
//                subsets[yroot].parent = xroot;
//                subsets[xroot].rank++;
//            }
//        }
//
//        public void kruskalMST() {
//            List<WeightedEdge> result = new ArrayList<>();
//            int e = 0;
//
//            Collections.sort(edges);
//
//            Subset[] subsets = new Subset[V];
//            for (int v = 0; v < V; ++v) {
//                subsets[v] = new Subset();
//                subsets[v].parent = v;
//                subsets[v].rank = 0;
//            }
//
//            int i = 0;
//            while (e < V - 1) {
//                WeightedEdge nextEdge = edges.get(i++);
//                int x = find(subsets, nextEdge.src);
//                int y = find(subsets, nextEdge.dest);
//
//                if (x != y) {
//                    result.add(nextEdge);
//                    e++;
//                    union(subsets, x, y);
//                }
//            }
//
//            int minimumCost = 0;
//            for (WeightedEdge edge : result) {
//                if (edge.src < edge.dest) {
//                    System.out.println(edge.src + " " + edge.dest + " " + edge.weight);
//                } else {
//                    System.out.println(edge.dest + " " + edge.src + " " + edge.weight);
//                }
//                minimumCost += edge.weight;
//            }
//            System.out.println("The Minimum Spanning Tree value= " + minimumCost);
//        }
//    }
//
//    public static void main(String[] args) {
//        List<String> lines = FileRead.readFile("HW3_Q1.txt");
//        List<WeightedEdge> edges = ValueFinder.createGraph(lines);
//        int V = Integer.parseInt(lines.get(0).trim());
//        System.out.println("V=" + V);
//        System.out.println("E=" + edges.size());
//
//        // Create an adjacency list representation of the graph
//        Map<Integer, List<WeightedEdge>> adjList = new TreeMap<>();
//        for (int i = 0; i < V; i++) {
//            adjList.put(i, new ArrayList<>());
//        }
//
//        for (WeightedEdge edge : edges) {
//            adjList.get(edge.src).add(edge);
//        }
//
//        // Sort the adjacency list
//        for (int i = 0; i < V; i++) {
//            List<WeightedEdge> list = adjList.get(i);
//            list.sort(Comparator.comparingInt(o -> o.dest));
//        }
//
//        // Print the adjacency list with edge weights
//        for (int i = 0; i < V; i++) {
//            List<WeightedEdge> list = adjList.get(i);
//            for (WeightedEdge edge : list) {
//                System.out.println(edge.src + " " + edge.dest + " " + edge.weight);
//            }
//            for (WeightedEdge edge : list) {
//                System.out.println(edge.dest + " " + edge.src + " " + edge.weight);
//            }
//        }
//
//        KruskalAlgorithm kruskal = new KruskalAlgorithm(V, edges);
//        kruskal.kruskalMST();
//    }
//}
