package ua.abond.pattern.battleship.domain;

import java.util.List;

public class Ship {
    private List<Cell> cells;

    public Ship(List<Cell> cells) {
        checkNeighboringCells(cells);
        this.cells = cells;
    }

    public boolean isDestroyed() {
        return cells.stream().allMatch(Cell::isMarked);
    }

    public boolean isPartOfShip(Cell cell) {
        return cells.contains(cell);
    }

    private void checkNeighboringCells(List<Cell> cells) {
        for (int i = 0; i < cells.size() - 1; i++) {
            Cell cell = cells.get(i);
            Cell nextCell = cells.get(i + 1);

            if (!cell.isNeighborTo(nextCell)) {
                throw new IllegalArgumentException();
            }
        }
    }
}
