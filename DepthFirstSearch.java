import java.util.LinkedList;

public class DepthFirstSearch {
    
}

class Graph {
    private int V; // number of vertices

    // array of lists for adjacency lists
    private LinkedList<Integer> adj[];

    // constructor
    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; v++) {
            adj[i] = new LinkedList();
        }
    }

    void addEdge(int v, int w) {
        
    }
}