public class Main {

    public static void main(String args[])
    {
        //Graph g = new Graph();
        //Graph graph = new Graph();
        Graph demo = new Graph();
        DiGraph g = new DiGraph();

//        graph.addEdge(0, 1);
//        graph.addEdge(0, 2);
//        graph.addEdge(1, 2);
//        graph.addEdge(1, 3);
//        graph.addEdge(2, 4);
//        graph.addEdge(3, 4);
//
//        graph.ssspp(0);
//        graph.BFS(0);
        demo.addEdge(0,2);
        demo.addEdge(0,1);
        demo.addEdge(0,5);
        demo.addEdge(2,3);
        demo.addEdge(2,4);
        demo.addEdge(3,4);
        demo.addEdge(3,5);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        //g.printDiGraph();
        //g.topologicalSort2();




//        System.out.println("Following is Depth First Traversal "
//                        + "(starting from vertex 2)");
//
//         //Function call
//        g.DFS(2);
//        System.out.println();
//
//        System.out.print(
//                "Breadth First Traversal starting from vertex 0: ");
//        graph.BFS(0);
//        demo.BFS(0);
//        demo.ssspp(0);
        WeightedGraph graph = new WeightedGraph(5);
        graph.addEdge(new WeightedEdge(0, 1, 0.89));
        graph.addEdge(new WeightedEdge(0, 2, 2));
        graph.addEdge(new WeightedEdge(1, 2, 5));
        graph.addEdge(new WeightedEdge(1, 3, 10));
        graph.addEdge(new WeightedEdge(2, 3, 3));
        graph.addEdge(new WeightedEdge(2, 4, 2));
        graph.addEdge(new WeightedEdge(3, 4, 8));
        graph.printList();
        //graph.djikstras(0);



    }
}