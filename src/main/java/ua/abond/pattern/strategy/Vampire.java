package ua.abond.pattern.strategy;

import ua.abond.pattern.strategy.behaviour.FeetWalkBehaviour;
import ua.abond.pattern.strategy.behaviour.VampireBatFlyBehaviour;

public class Vampire extends Creature {
    public Vampire() {
        this.walkBehaviour = new FeetWalkBehaviour();
        this.flyBehaviour = new VampireBatFlyBehaviour();
    }
}
