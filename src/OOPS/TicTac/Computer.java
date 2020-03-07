package OOPS.TicTac;

public class Computer extends Player {

    public Computer(int player) {
        super(player);
    }

    @Override
    public void getPosition(Board board) {
        // Generate for row coordinate
        // Generate for col coordinate
        // Validate if they are in bounds
        // Validate if not already filled
        this.setMove(new Move(0,0));
    }
}
