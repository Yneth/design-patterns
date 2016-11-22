package ua.abond.pattern.strategy;

import ua.abond.pattern.strategy.behaviour.FeetWalkBehaviour;
import ua.abond.pattern.strategy.behaviour.NullFlyBehaviour;

public class Ork extends Creature {
    public Ork() {
        this.walkBehaviour = new FeetWalkBehaviour();
        this.flyBehaviour = new NullFlyBehaviour();
    }
}
