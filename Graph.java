// Java program to print DFS traversal
// from a given graph
import java.util.*;

// This class represents a
// directed graph using adjacency
// list representation
class Graph {


    private HashMap<Integer,ArrayList<Integer>> adjList = new HashMap<>();
    private int vertices;





    boolean addVertex(int v){
        if (adjList.get(v)!=null) return false;
        adjList.put(v,new ArrayList<>());
        this.vertices++;
        return true;
    }
    boolean addEdge(int v, int w)
    {
        if (adjList.get(v)==null && adjList.get(w)==null){
            addVertex(v);
            addVertex(w);
        }
        else if (adjList.get(v)==null){
            addVertex(v);

        }
        else if (adjList.get(w)==null) {
            addVertex(w);

        }

        adjList.get(v).add(w);
        adjList.get(w).add(v);
        return true;
    }

    // A function used by DFS
    private void DFSUtil(int v, boolean visited[])
    {

        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");


        // Recur for all the vertices adjacent to this
        // vertex
        Iterator<Integer> i = adjList.get(v).listIterator();
        //System.out.println("Started with "+ i);
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]){


                DFSUtil(n, visited);
        }

    }

    }

    // The function to do DFS traversal.
    // It uses recursive DFSUtil()
    public void DFS(Integer v)
    {
        // Mark all the vertices as
        // not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[adjList.size()];

        // Call the recursive helper
        // function to print DFS
        // traversal
        DFSUtil(v, visited);
    }
    public void BFS(int vertex){




        bfsHelper(vertex);



    }


    private  void bfsHelper(int vertex){
        Queue<Integer> q = new LinkedList<>();
        boolean marked[] = new boolean[this.vertices];
        int distTo[] = new int[this.vertices];
        Integer edgeTo[] = new Integer[this.vertices];





        q.offer(vertex);
        marked[vertex] = true;

        distTo[vertex]= 0;
        while (!q.isEmpty()){
            Integer temp = q.remove();
            System.out.print(temp + "->");

            for (Integer w : adjList.get(temp)){
                if (!marked[w]){


                    distTo[w] = distTo[temp] + 1;
                    marked[w]=true;
                    edgeTo[w]=temp;
                    q.add(w);
                    //
                }
            }



        }
        String edgeToStr = Arrays.toString(edgeTo);
        System.out.println(edgeToStr);


    }
    public void printGraph(){
        System.out.println(adjList);
    }
    public void printEdgeTo(int edgeTo[]){
        System.out.println(Arrays.toString(edgeTo));


    }
    public void printdistTo(int distTo[]){
        System.out.println(Arrays.toString(distTo));


    }
    public void ssspp(int source){
        boolean visited[]= new boolean[this.vertices];
        Integer edgeTo[]= new Integer[this.vertices];
        int distTo[]= new int[this.vertices];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        sssppHelper(source,visited,edgeTo,distTo);
        System.out.println("Shortest distances from source " + source + ":");
        for (int i = source+1; i < vertices; i++) {

            System.out.print("Vertex " + i + ": ");
            printShortestPath(source, i, edgeTo);
            System.out.println();
        }
        System.out.println();
        System.out.println("sp to the destination:");

        System.out.println(sp(4,edgeTo));




    }
    private void sssppHelper(int vertex, boolean[] visited, Integer[] edgeTo, int[] distTo){
        Queue<Integer> q = new LinkedList<>();
        distTo[vertex]=0;
        visited[vertex]=true;
        q.add(vertex);
        while(!q.isEmpty()){
            Integer temp = q.remove();
            System.out.print(temp + "->");
            for (int w : adjList.get(temp)){
                if (!visited[w]){
                    visited[w]=true;
                    edgeTo[w]=temp;
                    distTo[w]= distTo[temp] + 1;
                    q.add(w);

                }
            }
        }



    }
    private void printShortestPath(int source, int destination, Integer edgeTo[]) {
        LinkedList<Integer> path = new LinkedList<>();
        int v = destination; // Start from the destination vertex

        // Trace back the shortest path from destination to source
        while (v != source) {
            path.addFirst(v); // Add the current vertex to the front of the path
            v = edgeTo[v]; // Move to the predecessor vertex
        }
        path.addFirst(source);
        System.out.println(path);
    }
    private LinkedList<Integer> sp(Integer destination,Integer edgeTo[]){
        LinkedList<Integer> path = new LinkedList<>();
        Integer v = destination;
        while(v!=null){
            path.addFirst(v);
            v = edgeTo[v];


        }
        return path;

    }


    // Driver Code

}

