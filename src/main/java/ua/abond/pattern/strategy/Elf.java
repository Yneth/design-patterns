package ua.abond.pattern.strategy;

import ua.abond.pattern.strategy.behaviour.FeetWalkBehaviour;
import ua.abond.pattern.strategy.behaviour.NullFlyBehaviour;

public class Elf extends Creature {
    public Elf() {
        this.flyBehaviour = new NullFlyBehaviour();
        this.walkBehaviour = new FeetWalkBehaviour();
    }
}
