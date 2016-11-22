package ua.abond.pattern.battleship.core;

public interface Console extends AutoCloseable {
    void run();
    void print(String str);
    void println(String str);

    void addStartedListener(StartedListener listener);
    void removeStartedListener(StartedListener listener);

    void addReadLineListener(ReadLineListener listener);
    void removeReadLineListener(ReadLineListener listener);
}
