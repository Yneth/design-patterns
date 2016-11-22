package ua.abond.pattern.battleship.domain;

import java.util.Arrays;
import java.util.Optional;

public class Field {
    private final int width;
    private final int height;
    private final Cell[] cells;

    private Ship[] ships;

    public Field(int width, int height) {
        this(width, height, new Ship[10]);
    }

    public Field(int width, int height, Ship[] ships) {
        this.width = width;
        this.height = height;
        this.ships = ships;
        this.cells = new Cell[width * height];
    }

    public void setMarked(Cell cell) {
        cells[cell.getX() + cell.getY() * height].mark();
    }

    public boolean isPartOfShip(Cell cell) {
        return getShipContaining(cell).isPresent();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isAllShipsDestroyed() {
        return Arrays.stream(ships).allMatch(Ship::isDestroyed);
    }

    public Optional<Ship> getShipContaining(Cell cell) {
        return Arrays.stream(ships).
                filter(s -> s.isPartOfShip(cell)).
                findFirst();
    }
}
