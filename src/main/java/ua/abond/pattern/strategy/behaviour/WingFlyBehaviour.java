package ua.abond.pattern.strategy.behaviour;

public class WingFlyBehaviour implements FlyBehaviour {

    @Override
    public void fly() {
        System.out.println(WingFlyBehaviour.class.getSimpleName());
    }
}
