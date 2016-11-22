package ua.abond.pattern.battleship.domain;

import java.util.Optional;

public class BattleshipGame {
    private Player currentPlayer;
    private Player otherPlayer;

    private Cell lastMove;

    private GameOverListener gameOverListener;
    private PlayerMissedListener playerMissedListener;
    private PlayerHitListener playerHitListener;
    private GameReadyListener gameReadyListener;

    public BattleshipGame(Player first, Player second) {
        this.currentPlayer = first;
        this.otherPlayer = second;
    }

    public void buildShip(Ship ship) {
        currentPlayer.buildShip(ship);

        if (currentPlayer.isReady() && otherPlayer.isReady()) {
            gameReadyListener.onGameReady();
        }
    }

    public void turn(Cell cell) {
        lastMove = cell;
        currentPlayer.makeMove(cell);

        if (isOver()) {
            gameOverListener.onGameOver();
        }
        else if (hasMissed()) {
            playerMissedListener.onPlayerMissed();
        }
        else if (!hasMissed()) {
            playerHitListener.onPlayerHit();
        }
    }

    public boolean isOver() {
        return otherPlayer.isOutOfShips();
    }

    public boolean hasMissed() {
        return otherPlayer.hasReceivedShot(lastMove);
    }

    public void swapPlayers() {
        Player temp = otherPlayer;
        otherPlayer = currentPlayer;
        currentPlayer = temp;

        lastMove = null;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Player getOtherPlayer() {
        return otherPlayer;
    }

    public Optional<Ship> getHitShip() {
        return otherPlayer.getHitShip(lastMove);
    }

    public void setGameOverListener(GameOverListener gameOverListener) {
        this.gameOverListener = gameOverListener;
    }

    public void setPlayerMissedListener(PlayerMissedListener playerMissedListener) {
        this.playerMissedListener = playerMissedListener;
    }

    public void setPlayerHitListener(PlayerHitListener playerHitListener) {
        this.playerHitListener = playerHitListener;
    }

    public void setGameReadyListener(GameReadyListener gameReadyListener) {
        this.gameReadyListener = gameReadyListener;
    }
}
