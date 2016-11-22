package ua.abond.pattern.battleship.domain;

public class HumanPlayer extends Player {

    @Override
    public void makeMove(Cell cell) {
        enemyField.setMarked(cell);
    }

    @Override
    public void buildShip(Ship ship) {

    }
}
