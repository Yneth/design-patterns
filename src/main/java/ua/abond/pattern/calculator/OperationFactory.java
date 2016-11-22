package ua.abond.pattern.calculator;

import java.util.Objects;

public class OperationFactory {
    private static final OperationFactory INSTANCE = new OperationFactory();

    private OperationFactory() {
    }

    public Operation create(String op) {
        Objects.requireNonNull(op);

        if ("-".equals(op)) {
            return new MinusOperation();
        }
        else if ("+".equals(op)) {
            return new PlusOperation();
        }
        else if ("*".equals(op)) {
            return new MultiplyOperation();
        }
        else if ("/".equals(op)) {
            return new DivideOperation();
        }
        throw new IllegalArgumentException("Passed wrong argument");
    }

    public static OperationFactory getInstance() {
        return INSTANCE;
    }
}
