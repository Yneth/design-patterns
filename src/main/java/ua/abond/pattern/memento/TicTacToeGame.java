package ua.abond.pattern.memento;

public class TicTacToeGame {
    private static final int PLAYER_1 = 1;
    private static final int PLAYER_2 = 2;

    private Field.Memento previousTurn;

    private Field field;
    private int currentPlayerMask;

    public void turn(int x, int y) {
        previousTurn = field.createMemento();
        field.set(x, y, currentPlayerMask);
        swapPlayerMask();
    }

    public void setToPreviousTurn() {
        field.restore(previousTurn);
    }

    private void swapPlayerMask() {
        currentPlayerMask = currentPlayerMask == PLAYER_1 ? PLAYER_2 : PLAYER_1;
    }
}
