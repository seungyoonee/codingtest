/*
Directed graph? Undirected graph?
Adjacency vertices?
Add edges / remove edges
*/
import java.util.*;

public class Graph {
    
    // number of vertices in graph
    private int v;

    // adjacency list
    private ArrayList<Integer>[] adjList;

    // Constructor
    public Graph(int vertices) {
        this.v = vertices;
        initAdjList();
    }

    @SuppressWarnings("unchecked")
    private void initAdjList() {
        // adjList[0] = [1, 2, 3]
        // adjList[1] = [0, 2, 3] ...
        adjList = new ArrayList[v];

        for (int i = 0; i < v; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int u, int v) {
        // directed vertices
        // 0 - 1, 0 - 2, ...
        adjList[u].add(v);
    }

    // prints all paths from src to dst
    public void printAllPaths(int src, int dst) {
        boolean[] isVisited = new boolean[v];
        // will print pathList as a result
        ArrayList<Integer> pathList = new ArrayList<>();

        // add source to path[]
        pathList.add(src);

        // call recursive utility
        printAllPathsUtil(src, dst, isVisited, pathList);
    }

    private void printAllPathsUtil(int src, int dst, boolean[] isVisited, List<Integer> pathList) {
        // if a route is found
        if (src == dst) {
            System.out.println(pathList);
            return;
        }

        // mark the current vertex
        isVisited[src] = true;

        // adjList[0] = [1, 2, 3]
        // i = 1, 2, 3
        for (int i : adjList[src]) {
            // if not visited
            if (!isVisited[i]) {
                // add the adj vertex to the result list
                pathList.add(i);
                // recur for other adj vertices
                printAllPathsUtil(i, dst, isVisited, pathList);
                pathList.remove(i);
            }
        }

        // if adj vertices of the current vertex is not the dst,
        // mark the current vertex
        isVisited[src] = false;
    }

    public static void main(String[] args) {
        /*
        0 -> 1
        ^  ^
        | X |
        v  v
        2  3
        */
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 1);
        g.addEdge(1, 3);

        int src = 2;
        int dst = 3;

        g.printAllPaths(2, 3);
    }
}
