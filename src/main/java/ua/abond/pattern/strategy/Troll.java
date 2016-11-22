package ua.abond.pattern.strategy;

import ua.abond.pattern.strategy.behaviour.FeetWalkBehaviour;
import ua.abond.pattern.strategy.behaviour.NullFlyBehaviour;

public class Troll extends Creature {
    public Troll() {
        this.walkBehaviour = new FeetWalkBehaviour();
        this.flyBehaviour = new NullFlyBehaviour();
    }
}
