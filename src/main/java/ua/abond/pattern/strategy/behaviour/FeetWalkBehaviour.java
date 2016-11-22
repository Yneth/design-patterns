package ua.abond.pattern.strategy.behaviour;

public class FeetWalkBehaviour implements WalkBehaviour {

    @Override
    public void walk() {
        System.out.println(FeetWalkBehaviour.class.getSimpleName());
    }
}
