/*
There are n cities connected by some number of flights.
You are given an array flights where
flights[i] = [from, to, price]
indicates that there is a flight from city [from] to city [to] with cost [price].

You are also given three integers
src, dst, and k,
return the cheapest price from src to dst with at most k stops.
If there is no such route, return -1.
*/
import java.util.*;

public class CheapestFlightsWithinKStops {

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        HashMap<Integer, List<int[]>> graph = new HashMap<>();

        // flight = [0, 1, 100], [1, 2, 100], ...
        // graph = 0: {1, 100}, {2, 500}, 1: {2, 100}, {3, 600}, ...
        for (int[] flight : flights) {
            // src
            if (!graph.containsKey(flight[0]))
                graph.put(flight[0], new ArrayList<int[]>());
            // dst, cost
            graph.get(flight[0]).add(new int[] {flight[1], flight[2]});
        }

        // minheap
        PriorityQueue<Flight> q = new PriorityQueue<>((a,b) -> (a.cost - b.cost));

        // Flight(src, dst, cost)
        q.add(new Flight(src, -1, 0));

        while (!q.isEmpty()) {

            Flight curr = q.remove();

            if (curr.src == dst) {
                return curr.cost;
            }

            if (curr.dst < k) {
                // graph = src: dst, cost
                List<int[]> nexts = graph.getOrDefault(curr.src, new ArrayList<int[]>());
                // next = [dst, cost]
                for (int[] next : nexts) {
                    q.add(new Flight(next[0], curr.dst + 1, curr.cost + next[1]));
                }
            }
        }
        return -1;
    }

    public static boolean checkIfRouteExists(int[][] flights, int src, int dst) {

        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

        // flight = [0, 1, 100], [1, 2, 100], ...
        for (int[] flight : flights) {

            if (!graph.containsKey(flight[0]))
                graph.put(flight[0], new ArrayList<Integer>());
            graph.get(flight[0]).add(flight[1]);
        }
        System.out.println(graph);

        return bfs(graph, src, dst);
    }

    public static Boolean bfs(HashMap<Integer, ArrayList<Integer>> graph, int src, int dst) {

        if (src == dst) {
            return true;
        }

        if (!graph.containsKey(src)) {
            return false;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i : graph.get(src)) {
            q.add(i);
        }
        System.out.println(q);
        while (!q.isEmpty()) {
            int destination = q.remove();
            System.out.println(destination);

            if (destination == dst) {
                return true;
            }

            if (graph.containsKey(destination)) {
                for (int i : graph.get(destination)) {
                    if (!q.contains(i))
                        q.add(i);
                }
            }
            System.out.println("q:" + q);
        }

        return false;
    }

    public static void main(String args[]) {
        /*
        Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
        Output: 700
        0 - 1
          X |
        3 - 2
        */
        int n = 4;
        int[][] flights1 = new int[][] {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        int src = 0;
        int dst = 3;
        int k = 1;
        
        int cheapestPrice = findCheapestPrice(n, flights1, src, dst, k);
        //System.out.println(cheapestPrice);

        /*
        Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
        Output: 200
        */
        n = 3;
        int[][] flights2 = new int[][] {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        src = 0;
        dst = 2;
        k = 1;
        cheapestPrice = findCheapestPrice(n, flights2, src, dst, k);
        //System.out.println(cheapestPrice);

        /*
        Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
        Output: 500
        */
        n = 3;
        int[][] flights3 = new int[][] {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        src = 0;
        dst = 2;
        k = 0;
        cheapestPrice = findCheapestPrice(n, flights3, src, dst, k);
        //System.out.println(cheapestPrice);

        //System.out.println(checkIfRouteExists(flights3, src, dst));

        int[][] flights4 = new int[][] {{0, 1, 0}, {0, 3, 0}, {1, 2, 0}, {3, 1, 0}, {3, 4, 0}, {2, 5, 0}, {2, 6, 0}, {4, 8, 0}, {5, 4, 0}, {6, 7, 0}, {0, 9, 0}};
        System.out.println(checkIfRouteExists(flights4, 2, 9));

    }
}

class Flight {
    int src;
    int dst;
    int cost;

    public Flight(int src, int dst, int cost) {
        this.src = src;
        this.dst = dst;
        this.cost = cost;
    }
}