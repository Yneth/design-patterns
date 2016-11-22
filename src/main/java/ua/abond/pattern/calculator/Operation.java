package ua.abond.pattern.calculator;

public interface Operation extends Expression {
    int precedence();
    Associativity associativity();
}
