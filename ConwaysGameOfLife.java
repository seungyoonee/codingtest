public class ConwaysGameOfLife {
    
    public static void nextGeneration(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        int[][] next = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                
                int aliveNeighbors = 0;
                for (int a = -1; a <= 1; a++) {
                    for (int b = -1; b <= 1; b++) {
                        if ((i + a >= 0 && i + a < row) && (j + b >= 0 && j + b < col)) {
                            aliveNeighbors += grid[i + a][j + b];
                        }
                    }
                }

                aliveNeighbors -= grid[i][j];

                if (grid[i][j] == 1 && aliveNeighbors < 2) {
                    next[i][j] = 0;
                }
                else if (grid[i][j] == 1 && aliveNeighbors > 3) {
                    next[i][j] = 0;
                }
                else if (grid[i][j] == 0 && aliveNeighbors == 3) {
                    next[i][j] = 1;
                }
                else {
                    next[i][j] = grid[i][j];
                }
            }
        }

        System.out.println("Next Generation: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (next[i][j] == 0) {
                    System.out.print(".");
                }
                else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        
        int[][] grid = {
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
            { 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }};

        nextGeneration(grid);
    }
}
