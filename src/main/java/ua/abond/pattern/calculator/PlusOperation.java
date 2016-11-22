package ua.abond.pattern.calculator;

public class PlusOperation extends BinaryOperation {

    public PlusOperation() {
        this(null);
    }

    public PlusOperation(Expression left) {
        super(null, null);
    }

    public PlusOperation(Expression left, Expression right) {
        super((l, r) -> l.evaluate() + r.evaluate(), left, right);
    }

    @Override
    public int precedence() {
        return 2;
    }

    @Override
    public Associativity associativity() {
        return Associativity.LEFT;
    }
}
