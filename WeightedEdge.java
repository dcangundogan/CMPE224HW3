public class WeightedEdge implements Comparable<WeightedEdge> {
    int src, dest;
    double weight;


    WeightedEdge(int src, int dest, double weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(WeightedEdge o) {
        if (this.weight < o.weight) {
            return -1;
        }
        else if (this.weight==o.weight) {
            return 0;

        }
        else {
            return 1;
        }
    }
    public int either() {
        return src;
    }
    public int other(int vertex){
        if (vertex == this.src) return dest;
        else return src;


    }
    public String toString() {
        return String.format("%d-%d w:%.2f", src, dest,weight);
    }
}
