package OOPS.TicTac;

public class TickTacToeMain {

    public static void main(String[] args){

        Board board=new Board(3);

        Game game=new Game(board);

        game.InitilizePlayers();
        while (game.startPlay());

        game.getWinner(); // Winner Status if needs to be saved


        // Game Over

    }
}
