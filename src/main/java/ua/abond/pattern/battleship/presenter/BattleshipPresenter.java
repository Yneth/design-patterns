package ua.abond.pattern.battleship.presenter;

import ua.abond.pattern.battleship.domain.BattleshipGame;
import ua.abond.pattern.battleship.domain.Cell;
import ua.abond.pattern.battleship.domain.Ship;
import ua.abond.pattern.battleship.view.BattleshipView;

import java.util.Objects;

public class BattleshipPresenter {
    private final BattleshipView view;
    private final BattleshipGame game;

    public BattleshipPresenter(BattleshipView view, BattleshipGame game) {
        Objects.requireNonNull(view);
        Objects.requireNonNull(game);

        this.view = view;
        this.game = game;
        this.initialize();

        this.view.onGameStarted(game.getCurrentPlayer());
    }

    private void initialize() {
        game.setGameOverListener(this::onGameOver);
        game.setPlayerMissedListener(this::onPlayerMissed);
        game.setPlayerHitListener(this::onPlayerHit);
        game.setGameReadyListener(this::onGameReady);

        view.setShootCellListener(this::onCellChosen);
        view.setBuildShipListener(this::onBuildShip);
    }

    private void onPlayerHit() {
        view.onPlayerHit(game.getHitShip().get());
    }

    private void onGameReady() {
        view.onGameReady();
    }

    private void onPlayerMissed() {
        view.onPlayerMissed(game.getCurrentPlayer());
        game.swapPlayers();
    }

    private void onGameOver() {
        view.onGameFinished(game.getCurrentPlayer());
    }

    private void onBuildShip(Ship ship) {
        game.buildShip(ship);
    }

    private void onCellChosen(Cell cell) {
        game.turn(cell);
    }
}
