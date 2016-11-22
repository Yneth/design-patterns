package ua.abond.pattern.calculator;

public class Value implements Expression {
    private final int value;

    public Value(int value) {
        this.value = value;
    }

    @Override
    public int evaluate() {
        return value;
    }
}
