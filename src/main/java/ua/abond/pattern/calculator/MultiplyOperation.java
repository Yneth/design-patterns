package ua.abond.pattern.calculator;

public class MultiplyOperation extends BinaryOperation {

    public MultiplyOperation() {
        this(null);
    }

    public MultiplyOperation(Expression left) {
        this(left, null);
    }

    public MultiplyOperation(Expression left, Expression right) {
        super((l, r) -> l.evaluate() * r.evaluate(), left, right);
    }

    @Override
    public int precedence() {
        return 3;
    }

    @Override
    public Associativity associativity() {
        return Associativity.LEFT;
    }
}
