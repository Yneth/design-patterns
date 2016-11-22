package ua.abond.pattern.battleship.view;

import ua.abond.pattern.battleship.domain.Player;
import ua.abond.pattern.battleship.domain.Ship;

public interface BattleshipView {
    void setShootCellListener(ShootCellListener listener);

    void setBuildShipListener(BuildShipListener listener);

    void onGameStarted(Player currentPlayer);

    void onGameFinished(Player currentPlayer);

    void onPlayerHit(Ship ship);

    void onPlayerMissed(Player currentPlayer);

    void onGameReady();
}
