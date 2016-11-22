package ua.abond.pattern.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Subscriber {
    private final String name;
    private final List<Magazine> ownedMagazines;

    public Subscriber(String name) {
        this.name = name;
        this.ownedMagazines = new ArrayList<>();
    }

    public void receive(Magazine m) {
        Objects.requireNonNull(m);
        ownedMagazines.add(m);
    }

    public List<Magazine> getOwnedMagazines() {
        return new ArrayList<>(ownedMagazines);
    }
}
