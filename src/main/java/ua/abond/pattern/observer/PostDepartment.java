package ua.abond.pattern.observer;

import java.util.LinkedList;
import java.util.List;

public class PostDepartment {
    private final List<Subscriber> subscribers;

    public PostDepartment() {
        this.subscribers = new LinkedList<>();
    }

    public void add(Subscriber s) {
        subscribers.add(s);
    }

    public void remove(Subscriber s) {
        subscribers.remove(s);
    }

    public void publish(Magazine m) {
        for (Subscriber s : subscribers) {
            s.receive(m);
        }
    }
}
