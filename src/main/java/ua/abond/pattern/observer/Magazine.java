package ua.abond.pattern.observer;

import java.util.Objects;

public class Magazine {
    private final String name;

    public Magazine(String name) {
        Objects.requireNonNull(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
