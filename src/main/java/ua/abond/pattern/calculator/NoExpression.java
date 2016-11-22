package ua.abond.pattern.calculator;

public class NoExpression implements Expression {
    @Override
    public int evaluate() {
        throw new UnsupportedOperationException();
    }
}
