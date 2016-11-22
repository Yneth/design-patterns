package ua.abond.pattern.battleship.view;

import ua.abond.pattern.battleship.domain.Cell;

@FunctionalInterface
public interface ShootCellListener {
    void onCellChosen(Cell cell);
}
