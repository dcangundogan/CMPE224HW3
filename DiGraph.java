import java.util.*;

public class DiGraph {
    public HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
    int vertices;
    boolean marked[] = new boolean[this.vertices];
    int distTo[] = new int[this.vertices];
    int edgeTo[] = new int[this.vertices];






    boolean addVertex(int v){
        if (adjList.get(v)!=null) return false;
        adjList.put(v,new ArrayList<>());
        this.vertices++;
        return true;
    }
    boolean addEdge(int v, int w)
    {
        if (adjList.get(v)== null && adjList.get(w) == null){
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





        q.offer(vertex);
        marked[vertex] = true;

        distTo[vertex]= 0;
        while (!q.isEmpty()){
            int temp = q.remove();
            System.out.print(temp + "->");

            for (int w : adjList.get(temp)){
                if (!marked[w]){


                    distTo[w] = distTo[temp] + 1;
                    marked[w]=true;
                    edgeTo[w]=temp;
                    q.add(w);
                    //
                }
            }



        }

    }

        public void printEdgeTo(int edgeTo[]){
            System.out.println(Arrays.toString(edgeTo));


        }


            public void printDiGraph(){
                System.out.println(adjList);

            }
    void topologicalSortUtil(int v, boolean visited[],
                             Stack<Integer> stack)
    {
        // Mark the current node as visited.
        visited[v] = true;


        // Recur for all the vertices adjacent to this
        // vertex
        Iterator<Integer> it = adjList.get(v).iterator();
        while (it.hasNext())
        {
            int i = it.next();
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);
        }

        // Push current vertex to stack which stores result
        stack.push(v);
    }


    void topologicalSort()
    {
        Stack<Integer> stack = new Stack<>();

        // Mark all the vertices as not visited
        boolean visited[] = new boolean[this.vertices];

        for (int i = 0; i < this.vertices; i++)
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);

        // Print contents of stack
        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");
    }















}

