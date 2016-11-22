package ua.abond.pattern.battleship.core.impl;

import org.apache.log4j.Logger;
import ua.abond.pattern.battleship.core.Console;
import ua.abond.pattern.battleship.core.ReadLineListener;
import ua.abond.pattern.battleship.core.StartedListener;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ConsoleApplication implements Console {
    public static final String EXIT_STRING = "exit";

    private static final String EMPTY_STRING = "";
    private static final Logger LOGGER = Logger.getLogger(ConsoleApplication.class);

    private final InputStream in;
    private final OutputStream out;

    private final List<StartedListener> startedListeners;
    private final List<ReadLineListener> readLineListeners;

    public ConsoleApplication() {
        this(System.in, System.out);
    }

    public ConsoleApplication(InputStream in, OutputStream out) {
        Objects.requireNonNull(in, "InputStream cannot be null.");
        Objects.requireNonNull(out, "OutputStream cannot be null.");

        this.readLineListeners = new LinkedList<>();
        this.startedListeners = new LinkedList<>();

        this.in = in;
        this.out = out;
    }

    @Override
    public void run() {
        startedListeners.forEach(StartedListener::onStarted);
        Scanner scanner = new Scanner(in);
        try {
            String line = EMPTY_STRING;
            do {
                final String readLine = line;
                readLineListeners.forEach(l -> l.onReadLine(readLine));

                waitNewLine(scanner);

                line = scanner.nextLine();
            } while (!EXIT_STRING.equalsIgnoreCase(line));
        } finally {
            dispose();
            scanner.close();
        }
    }

    @Override
    public void print(String str) {
        Objects.requireNonNull(str, "Input string cannot be null");
        try {
            out.write(str.getBytes());
        } catch (IOException e) {
            LOGGER.error("Failed to print message: " + str, e);
        }
    }

    @Override
    public void println(String str) {
        Objects.requireNonNull(str, "Input string cannot be null");
        print(str + "\n");

    }

    @Override
    public void addStartedListener(StartedListener listener) {
        this.startedListeners.add(listener);
    }

    @Override
    public void removeStartedListener(StartedListener listener) {
        this.startedListeners.remove(listener);
    }

    @Override
    public void addReadLineListener(ReadLineListener listener) {
        this.readLineListeners.add(listener);
    }

    @Override
    public void removeReadLineListener(ReadLineListener listener) {
        this.readLineListeners.remove(listener);
    }

    @Override
    public void close() throws Exception {
        dispose();
    }

    private void waitNewLine(Scanner scanner) {
        while (!scanner.hasNextLine()) ;
    }

    private void dispose() {
        try {
            in.close();
            out.close();
        } catch (IOException e) {
            LOGGER.error("Failed to close io streams", e);
        }
    }
}
