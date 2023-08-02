public class Sudoku {
    public static boolean solveSudoku(int[][] grid) {
        int N = grid.length;
        int emptyRow = -1, emptyCol = -1;

        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 0) {
                    emptyRow = i;
                    emptyCol = j;
                    break;
                }
            }
            if (emptyRow != -1)
                break;
        }

        if (emptyRow == -1)
            return true;

        
        for (int num = 1; num <= 9; num++) {
            if (isValidMove(grid, emptyRow, emptyCol, num)) {
               
                grid[emptyRow][emptyCol] = num;

                if (solveSudoku(grid))
                    return true;

                grid[emptyRow][emptyCol] = 0;
            }
        }
        return false;
    }

    public static boolean isValidMove(int[][] grid, int row, int col, int num) {
        int N = grid.length;
        int boxSize = (int) Math.sqrt(N);

        for (int i = 0; i < N; i++) {
            if (grid[row][i] == num || grid[i][col] == num)
                return false;
        }
        int boxStartRow = row - row % boxSize;
        int boxStartCol = col - col % boxSize;
        for (int i = 0; i < boxSize; i++) {
            for (int j = 0; j < boxSize; j++) {
                if (grid[boxStartRow + i][boxStartCol + j] == num)
                    return false;
            }
        }

        return true;
    }

    public static void printSudoku(int[][] grid) {
        int N = grid.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
            {3, 0, 6, 5, 0, 8, 4, 0, 0},
            {5, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 8, 7, 0, 0, 0, 0, 3, 1},
            {0, 0, 3, 0, 1, 0, 0, 8, 0},
            {9, 0, 0, 8, 6, 3, 0, 0, 5},
            {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
            {1, 3, 0, 0, 0, 0, 2, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 7, 4},
            {0, 0, 5, 2, 0, 6, 3, 0, 0} 
   
        };

        if (solveSudoku(grid)) {
            System.out.println("Congratulation!!, Sudoku solved:");
            printSudoku(grid);
        } else {
            System.out.println("Sorry! ,No solution exists for the given Sudoku.");
        }
    }
}
