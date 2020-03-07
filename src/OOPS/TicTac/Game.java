package OOPS.TicTac;

public class Game {

    private Board board;
    private int pass;

    private Player selected;

    private Player player1;
    private Player player2;

    private int winner;


    public Game(Board board) {
        this.board = board;
        pass = 0;
    }

    public void InitilizePlayers() {

        // Ask if 1st Player is Human or Computer
        this.player1 = new Human(1);
//        this.player1=new Computer(1);

        // Ask if 2nd Player is Human or Computer

//        this.player2=new Human(2);
        this.player2 = new Computer(2);

        // Player 1 will play first
        selected = player1;

    }

    public boolean startPlay() {

        if (whoWon() == 0) {

            if (selected.getPlayer() == 1)
                player1.move(board);
            else
                player2.move(board);

            pass++; // Increase count of play , will used to break the game when it crosses 9

            int gameStatus = whoWon();

            if (gameStatus == 1) {
                // Player 1 has won
                setWinner(player1.getPlayer());
                return false;
            } else if (gameStatus == 2) {
                // Player 2 has won
                setWinner(player2.getPlayer());
                return false;
            }

            if (pass == board.getSize()) {
                // Game is draw
                setWinner(0);
                return false;
            }
        }
            return true;

        }

        private int whoWon () {
            // Return 0 if No one has won
            // Return 1 if player 1 has won
            // Return 2 if player 2 has won

            // WIll user board to find out who won

            return 0;
        }

        public boolean isHasMovesLeft () {
            return pass == board.getSize();
        }


        private void setWinner (int winnerCode){
            this.winner = winnerCode;
        }

        public int getWinner (){
            return winner;
        }
    }
