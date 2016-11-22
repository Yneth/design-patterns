package ua.abond.pattern.battleship.view;

import ua.abond.pattern.battleship.core.Console;
import ua.abond.pattern.battleship.core.ReadLineListener;
import ua.abond.pattern.battleship.domain.Cell;
import ua.abond.pattern.battleship.domain.Player;
import ua.abond.pattern.battleship.domain.Ship;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BattleshipConsoleView implements BattleshipView {
    private static final Pattern SHIP_PATTERN = Pattern.compile("((([1-9]|10) ([1-9]|10)),?){1,4}");
    private static final Pattern CELL_PATTERN = Pattern.compile("([1-9]|10) ([1-9]|10)");

    private final Console console;
    private BuildShipListener buildShipListener;
    private ShootCellListener shootCellListener;

    private final ReadLineListener shootCellReadLine;
    private final ReadLineListener buildShipReadLine;

    public BattleshipConsoleView(Console console) {
        this.console = console;
        this.shootCellReadLine = this::shootCellReadLine;
        this.buildShipReadLine = this::buildShipReadLine;
    }

    @Override
    public void onGameStarted(Player currentPlayer) {
        ReadLineListener listener = buildShipReadLine;
        console.addReadLineListener(listener);
        console.println("Enter your ships: ");
    }

    @Override
    public void onGameFinished(Player player) {
        console.println("Payer " + player.toString() + " won.");
        console.println("Enter 'exit' to exit");
        console.removeReadLineListener(shootCellReadLine);
        console.removeReadLineListener(buildShipReadLine);
    }

    @Override
    public void onPlayerHit(Ship ship) {
        console.println("Enemy ship has been hit.");
    }

    @Override
    public void onPlayerMissed(Player currentPlayer) {
        console.println("You missed.");
    }

    @Override
    public void onGameReady() {
        console.removeReadLineListener(buildShipReadLine);
        console.addReadLineListener(shootCellReadLine);
    }

    private void buildShipReadLine(String str) {
        Ship ship;
        try {
            ship = parseShip(str);
            buildShipListener.onBuildShip(ship);
        } catch (ParseException e) {
            console.println("Input mismatch. Try again.");
        }
    }

    private void shootCellReadLine(String str) {
        Cell cell;
        try {
            cell = parseCell(str);
            shootCellListener.onCellChosen(cell);
        } catch (ParseException e) {
            console.println("Input mismatch. Try again.");
        }
    }

    private Cell parseCell(String str) throws ParseException {
        Matcher matcher = CELL_PATTERN.matcher(str);
        if (!matcher.matches()) {
            throw new ParseException("Input string didn't match.", 0);
        }
        String[] args = str.split(" ");
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        return new Cell(x, y);
    }

    private Ship parseShip(String str) throws ParseException {
        Matcher matcher = SHIP_PATTERN.matcher(str);
        if (!matcher.matches()) {
            throw new ParseException("Input string didn't match.", 0);
        }
        String[] args = str.split(",");
        List<Cell> cells = new ArrayList<>();
        for (String arg : args) {
            Cell cell = parseCell(arg);
            cells.add(cell);
        }
        return new Ship(cells);
    }

    @Override
    public void setShootCellListener(ShootCellListener listener) {
        this.shootCellListener = listener;
    }

    @Override
    public void setBuildShipListener(BuildShipListener listener) {
        this.buildShipListener = listener;
    }
}
