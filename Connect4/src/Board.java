public class Board {

    int size = 8;
    String[][] grid = new String[size][size];  //make 8x8 2D array of strings


    //constructor initializes the whole
    // grid with 0's when created
    public Board() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                grid[row][col] = "-";
            }
        }
    }

    //************ ALGORITHM #1 ***************
    //displayBoard will output a board to the console
    public void printBoard() {
        System.out.println("Updated board:");
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {

                System.out.print(grid[row][col] + " ");  //prints out each value in each array

            }
            System.out.print("\n");  // "\n" is the character for "new line"
        }
    }

    //************ ALGORITHM #2 ***************
    //makes a move on the board - changes a position to "token value"
    public void makeMove(int col, String token) {

        for (int i = size - 1; i >= 0; i--) {
            if (grid[i][col].equals("-")) {
                grid[i][col] = token;
                break;
            }
        }

    }


    public boolean colHasRoom(int col) {
        if (grid[0][col].equals("-")) {
            return true;
        }
        return false;
    }


    //************ ALGORITHM #3 ***************
    // return true if there are 4 in a row anywhere on the board
    // for now, any move at 0,0 ends game
    public boolean checkWin(String token) {

        boolean v = checkWinVertical(token);
        boolean h = checkWinHorizontal(token);
        boolean d = checkWinDiagonal(token);

        return v || h || d;
    }

    public boolean checkWinVertical(String token) {
        for (int col = 0; col < 8; col++) {
            for (int row = 0; row < 5; row++) {
                if (grid[row][col].equals(token) &&
                        grid[row + 1][col].equals(token) &&
                        grid[row + 2][col].equals(token) &&
                        grid[row + 3][col].equals(token)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkWinHorizontal(String token) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 5; col++) {
                if (grid[row][col].equals(token) &&
                        grid[row][col + 1].equals(token) &&
                        grid[row][col + 2].equals(token) &&
                        grid[row][col + 3].equals(token)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkWinDiagonal(String token) {
        for (int row = 4; row < 6; row++) {
            for (int col = 4; col < 6; col++) {
                if ((grid[row][col].equals(token) &&
                        grid[row + 1][col + 1].equals(token) &&
                        grid[row + 2][col + 2].equals(token) &&
                        grid[row + 3][col + 3].equals(token))
                        ||

                        (grid[row][col].equals(token) &&
                                grid[row - 1][col + 1].equals(token) &&
                                grid[row - 2][col + 2].equals(token) &&
                                grid[row - 3][col + 3].equals(token))
                        ||

                        grid[row][col].equals(token) &&
                                grid[row + 1][col - 1].equals(token) &&
                                grid[row + 2][col - 2].equals(token) &&
                                grid[row + 3][col - 3].equals(token)
                        ||
                        (grid[row][col].equals(token) &&
                                grid[row - 1][col - 1].equals(token) &&
                                grid[row - 2][col - 2].equals(token) &&
                                grid[row - 3][col - 3].equals(token))) {
                    return true;
                }
            }
        }
        return false;
    }

}
