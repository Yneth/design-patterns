package ua.abond.pattern.battleship.domain;

import java.util.Optional;

public abstract class Player {
    protected final Field playerField;
    protected final Field enemyField;

    public Player() {
        this.playerField = new Field(10, 10);
        this.enemyField = new Field(playerField.getWidth(), playerField.getHeight());
    }

    public boolean hasReceivedShot(Cell cell) {
        return playerField.isPartOfShip(cell);
    }

    public boolean isOutOfShips() {
        return playerField.isAllShipsDestroyed();
    }

    public Optional<Ship> getHitShip(Cell cell) {
        return playerField.getShipContaining(cell);
    }

    public abstract void makeMove(Cell cell);

    public abstract void buildShip(Ship ship);

    public boolean isReady() {
        return false;
    }
}
