package ua.abond.pattern.calculator;

public class MinusOperation extends BinaryOperation {

    public MinusOperation() {
        this(null);
    }

    public MinusOperation(Expression left) {
        this(left, null);
    }

    public MinusOperation(Expression left, Expression right) {
        super((e0, e1) -> e0.evaluate() - e1.evaluate(), left, right);
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
