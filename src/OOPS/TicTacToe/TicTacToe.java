package OOPS.TicTacToe;

class TicTacToe {

    int[] rows;
    int[] cols;
    int diagonal;
    int antiDiagonal;

    /**
     * Initialize your data structure here.
     */
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
    }

    /**
     * Player {player} makes a move at ({row}, {col}).
     *
     * @param row    The row of the board.
     * @param col    The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either:
     * 0: No one wins.
     * 1: Player 1 wins.
     * 2: Player 2 wins.
     */
    public int move(int row, int col, int player) {

        int moveValue = player == 1 ? 1 : -1;

        rows[row] += moveValue;
        cols[col] += moveValue;
        if (row == col) diagonal += moveValue;
        if (row + col == rows.length - 1) antiDiagonal += moveValue;


        if (Math.abs(rows[row]) == rows.length ||
                Math.abs(cols[col]) == rows.length ||
                Math.abs(diagonal) == rows.length ||
                Math.abs(antiDiagonal) == rows.length
        ) return player;


        return 0;

    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
