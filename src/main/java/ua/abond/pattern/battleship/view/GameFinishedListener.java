package ua.abond.pattern.battleship.view;

import ua.abond.pattern.battleship.domain.Player;

@FunctionalInterface
public interface GameFinishedListener {
    void onGameFinished(Player winner);
}
