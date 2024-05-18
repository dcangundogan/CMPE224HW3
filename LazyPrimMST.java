import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class LazyPrimMST {
    private boolean[] marked;
    private Queue<WeightedEdge> mst = new LinkedList<>();
    private PriorityQueue<WeightedEdge> pq = new PriorityQueue<>();

    public LazyPrimMST(WeightedGraph G) {
        marked = new boolean[G.V()];
        visit(G,0);
        while (!pq.isEmpty()) {

        }
    }




    private void visit(WeightedGraph g, int i) {
    }


}
