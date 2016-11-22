package ua.abond.pattern.battleship.view;

import ua.abond.pattern.battleship.domain.Ship;

@FunctionalInterface
public interface BuildShipListener {
    void onBuildShip(Ship ship);
}
