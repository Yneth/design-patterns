package ua.abond.pattern.calculator;

import java.util.function.BiFunction;

public abstract class BinaryOperation implements Operation {
    protected final BiFunction<Expression, Expression, Integer> function;
    protected Expression left;
    protected Expression right;

    protected BinaryOperation(BiFunction<Expression, Expression, Integer> function) {
        this(function, null);
    }
    protected BinaryOperation(BiFunction<Expression, Expression, Integer> function, Expression left) {
        this(function, left, null);
    }

    protected BinaryOperation(BiFunction<Expression, Expression, Integer> function, Expression left, Expression right) {
        this.function = function;
        this.left = left;
        this.right = right;
    }

    public int evaluate() {
        return function.apply(left, right);
    }
}
