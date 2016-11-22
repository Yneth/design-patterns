package ua.abond.pattern.battleship;

import ua.abond.pattern.battleship.core.Console;
import ua.abond.pattern.battleship.core.impl.ConsoleApplication;
import ua.abond.pattern.battleship.domain.AIPlayer;
import ua.abond.pattern.battleship.domain.BattleshipGame;
import ua.abond.pattern.battleship.presenter.BattleshipPresenter;
import ua.abond.pattern.battleship.view.BattleshipConsoleView;
import ua.abond.pattern.battleship.view.BattleshipView;

final class Main {
    private Main() {

    }

    public static void main(String[] args) throws Exception {
        try (Console console = new ConsoleApplication()) {
            BattleshipView view = new BattleshipConsoleView(console);
            BattleshipGame game = new BattleshipGame(new AIPlayer(), new AIPlayer());

            new BattleshipPresenter(view, game);

            console.run();
        }
    }
}
