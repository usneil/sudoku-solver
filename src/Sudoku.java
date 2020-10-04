public class Sudoku {
        // 2D Array Board
        // 0 means to-be-solved
	public static int[][] SUDOKU = {
            {5,3,0,0,7,0,0,0,0},
            {6,0,0,1,9,5,0,0,0},
            {0,9,8,0,0,0,0,6,0},
            {8,0,0,0,6,0,0,0,3},
            {4,0,0,8,0,3,0,0,1},
            {7,0,0,0,2,0,0,0,6},
            {0,6,0,0,0,0,2,8,0},
            {0,0,0,4,1,9,0,0,5},
            {0,0,0,0,8,0,0,7,9},
    };

    private int[][] board; // create 2-D grid board
    public static final int EMPTY = 0; // initialize empty cells
    public static final int SIZE = 9; // grid size

    // update board initial contents
    public Sudoku(int[][] board) {
        this.board = new int[SIZE][SIZE];
        
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                this.board[i][j] = board[i][j];
            }
        }
    }

    // check if a possible number has been placed in that specific row
    private boolean isInRow(int row, int number) {
        for (int i = 0; i < SIZE; i++)
            if (board[row][i] == number)
                return true;
        
        return false;
    }

    // check if a possible number has been placed in that specific column
    private boolean isInCol(int col, int number) {
        for (int i = 0; i < SIZE; i++)
            if (board[i][col] == number)
                return true;
        
        return false;
    }

    // check if a possible number has been placed in that specific 3x3 box
    private boolean isInBox(int row, int col, int number) {
        int r = row - row % 3;
        int c = col - col % 3;
        
        for (int i = r; i < r + 3; i++)
            for (int j = c; j < c + 3; j++)
                if (board[i][j] == number)
                    return true;
        
        return false;
    }

    // check number possibility based on Sudoku game rules
    private boolean isValid(int row, int col, int number) {
        return !isInRow(row, number)  &&  !isInCol(col, number)  &&  !isInBox(row, col, number);
    }

    // solve by recursive BackTracking algorithm
    public boolean solve() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                // search an empty cell
                if (board[row][col] == EMPTY) {
                    // try possible numbers
                    for (int number = 1; number <= SIZE; number++) {
                        if (isValid(row, col, number)) {
                            // number checked and valid
                            this.display(); // print out the board
                            board[row][col] = number;
                            if (solve()) { // recursion call
                                return true;
                            } else { // if not a solution, then empty the cell and we continue
                                board[row][col] = EMPTY;
                            }
                        }
                    }

                    return false;
                }
            }
        }

        return true; // when solved
    }

    public void display() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(" " + board[i][j]);
            }
        
            System.out.println();
        }
        
        System.out.println();
    }

    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku(SUDOKU);
        System.out.println("Begin Sudoku:\n");
        sudoku.display();
        
        // only if solve() returns True then solvable
        if (sudoku.solve()) {
            System.out.println("Solved!");
            sudoku.display();
        } else {
            System.out.println("Unsolvable..");
        }
    }
}
