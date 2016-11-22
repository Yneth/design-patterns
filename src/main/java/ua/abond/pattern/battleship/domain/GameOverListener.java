package ua.abond.pattern.battleship.domain;

@FunctionalInterface
public interface GameOverListener {
    void onGameOver();
}
