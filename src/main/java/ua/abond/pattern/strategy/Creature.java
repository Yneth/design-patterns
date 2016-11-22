package ua.abond.pattern.strategy;

import ua.abond.pattern.strategy.behaviour.FlyBehaviour;
import ua.abond.pattern.strategy.behaviour.WalkBehaviour;

public abstract class Creature {
    protected FlyBehaviour flyBehaviour;
    protected WalkBehaviour walkBehaviour;

    public Creature() {
    }

    public void fly() {
        flyBehaviour.fly();
    }

    public void walk() {
        walkBehaviour.walk();
    }
}
