package ua.abond.pattern.battleship.domain;

@FunctionalInterface
public interface PlayerMissedListener {
    void onPlayerMissed();
}
