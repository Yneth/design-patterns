package ua.abond.pattern.strategy.behaviour;

public class VampireBatFlyBehaviour implements FlyBehaviour {

    @Override
    public void fly() {
        System.out.println(VampireBatFlyBehaviour.class.getSimpleName());
    }
}
