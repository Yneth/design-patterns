package ua.abond.pattern.battleship.domain;

@FunctionalInterface
public interface GameReadyListener {
    void onGameReady();
}
