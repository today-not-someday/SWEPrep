package OOPS.TicTac;

public class Human extends Player {

    public Human(int player) {
        super(player);
    }

    @Override
    public void getPosition(Board board) {

        // ASK for row coordinate
        // ASK for col coordinate
        // Validate if they are in bounds
        // Validate if not already filled
        this.setMove(new Move(0,0));

    }
}
