package ua.abond.pattern.calculator;

public class DivideOperation extends BinaryOperation {

    public DivideOperation() {
        this(null);
    }

    public DivideOperation(Expression left) {
        this(left, null);
    }

    public DivideOperation(Expression left, Expression right) {
        super((e0, e1) -> e0.evaluate() / e1.evaluate(), left, right);
    }

    @Override
    public int precedence() {
        return 0;
    }

    @Override
    public Associativity associativity() {
        return null;
    }
}
