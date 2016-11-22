package ua.abond.pattern.calculator;

import java.util.*;
import java.util.regex.Pattern;

public class ExpressionBuilder {
    private interface Test {
        void act(Deque<Expression> values, Deque<Expression> ops, String op);
    }

    private static final String OP_REGEX = "(?<=[-+*/])|(?=[-+*/])";
    private Map<String, Action> actions = new HashMap<>();

    public ExpressionBuilder() {
        actions.put("\\d+", (vs, ops, i) -> vs.push(i));
        actions.put("+", ExpressionBuilder::pushOperator);
        actions.put("-", ExpressionBuilder::pushOperator);
        actions.put("*", ExpressionBuilder::pushOperator);
        actions.put("/", ExpressionBuilder::pushOperator);
        actions.put("(", (vs, ops, op) -> ops.push(op));
        actions.put(")", ExpressionBuilder::popEnclosingParentheses);
    }

    public Expression buildTree(String expression) {
        String[] literals = expression.split(OP_REGEX);

        final Deque<String> operators = new ArrayDeque<>();
        final Deque<String> values = new ArrayDeque<>();
        Arrays.stream(literals).forEach(l -> actions.keySet().stream()
                .filter(re -> {
                    Pattern pattern = Pattern.compile(re);
                    return pattern.matcher(l).matches();
                })
                        .findFirst()
                        .map(actions::get)
                        .ifPresent(action -> action.act(values, operators, l))
        );
        return null;
    }

    private static void pushOperator(Deque<String> vals, Deque<String> ops, String op) {
        String op1 = ops.peek();
        while (isLeftAssoc(op) && lessOrEqual(op, op1) ||
                isRightAssoc(op) && less(op, op1)) {
            vals.push(ops.pop());
        }
        ops.push(op1);
    }

    private static void popEnclosingParentheses(Deque<String> vals, Deque<String> ops, String op) {
        String op1 = ops.pop();
        while (!op1.equals("(")) {
            vals.push(op1);
            op1 = ops.pop();
        }
    }

    private static boolean isLeftAssoc(String op) {
        return false;
    }

    private static boolean isRightAssoc(String op) {
        return false;
    }

    private static boolean less(String op0, String op1) {
        return false;
    }

    private static boolean lessOrEqual(String op0, String op1) {
        return less(op0, op1) || false;
    }

    private static boolean hasLowerPrecedence(String op0, String op1) {
        return false;
    }

    @FunctionalInterface
    private interface Action {
        void act(Deque<String> val, Deque<String> ops, String op);
    }
}
