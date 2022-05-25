/*
Visit - goes into a vertex
Explore - search for adjacent vertices
-> visit, then explore

USING DEPTH-FIRST SEARCH (need stack)

Given a boolean 2D matrix, find the number of islands.
A group of connected 1s forms an island.
For example, the below matrix contains 5 islands.

{{1, 1, 0, 0, 0},
 {0, 1, 0, 0, 1},
 {1, 0, 0, 1, 1},
 {0, 0, 0, 0, 0},
 {1, 0, 1, 0, 1}}

This is a variation of the standard problem:
“Counting the number of connected components in an undirected graph”. 

*/
import java.util.*;

public class NumberOfIslands {
    // fixed number of rows and columns
    static final int ROW = 5, COL = 5;

    // to check if a given (row, col) is safe to visit
    public static boolean isSafe(int M[][], int row, int col, boolean visited[][]) {
        return (row >= 0)       // row = 0, 1, 2, 3, 4
        && (row < ROW)          // ROW = 5
        && (col >= 0)           // col = 0, 1, 2, 3, 4
        && (col < COL)          // COL = 5
        && (M[row][col] == 1)   // island ground exists
        && !visited[row][col];  // ground is not visited
    }

    public static void DFS(int M[][], int row, int col, boolean visited[][]) {
        /*
        {{1, 8, 7},
         {2, 0, 6},
         {3, 4, 5}} -> 1, 2, 3, 4, 5, 6, 7, 8
        */
        int rowNum[] = new int[] {-1, -1, -1, 0, 0, 1, 1, 1};
        int colNum[] = new int[] {-1, 0, 1, -1, 1, -1, 0, 1};

        visited[row][col] = true;

        for (int i = 0; i < 8; i++) {
            if (isSafe(M, row + rowNum[i], col + colNum[i], visited))
                DFS(M, row + rowNum[i], col + colNum[i], visited);
        }
    }

    public static int countIslands(int M[][]) {
        boolean visited[][] = new boolean[ROW][COL];

        int count = 0;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                DFS(M, i, j, visited);
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) throws java.lang.Exception {
        int M[][] = new int[][] {{1, 1, 0, 0, 0},
                                 {0, 1, 0, 0, 1},
                                 {1, 0, 0, 1, 1},
                                 {0, 0, 0, 0, 0},
                                 {1, 0, 1, 0, 1}};
        NumberOfIslands I = new NumberOfIslands();
        System.out.println(countIslands(M));
        System.out.println("Number of islands is: " + I.countIslands(M));
    }
}
