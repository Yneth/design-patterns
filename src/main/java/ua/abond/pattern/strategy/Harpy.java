package ua.abond.pattern.strategy;

import ua.abond.pattern.strategy.behaviour.NullWalkBehaviour;
import ua.abond.pattern.strategy.behaviour.WingFlyBehaviour;

public class Harpy extends Creature {
    public Harpy() {
        this.walkBehaviour = new NullWalkBehaviour();
        this.flyBehaviour = new WingFlyBehaviour();
    }
}
