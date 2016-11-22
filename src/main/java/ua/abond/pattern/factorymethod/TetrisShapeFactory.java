package ua.abond.pattern.factorymethod;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TetrisShapeFactory {
    private static final TetrisShapeFactory INSTANCE = new TetrisShapeFactory();

    private final Random random;
    private final List<TetrisShape> shapes;

    private TetrisShapeFactory() {
        random = new Random();
        shapes = Arrays.asList(
                new TetrisShape("***\n***"),
                new TetrisShape("**\n**"),
                new TetrisShape("*\n*\n*\n*"),
                new TetrisShape(" * \n***"),
                new TetrisShape("*\n***"),
                new TetrisShape("**\n**\n**\n**"),
                new TetrisShape("*******"),
                new TetrisShape("*******\n*******"),
                new TetrisShape("****\n****\n****\n****")
        );
    }

    public TetrisShape createRandom() {
        int min = 0;
        int max = shapes.size() - 1;
        double gaussian = Math.abs(random.nextGaussian());
        int index = (int) Math.min(Math.max(gaussian * max, min), max);
        return new TetrisShape(shapes.get(index));
    }

    public static TetrisShapeFactory getInstance() {
        return INSTANCE;
    }
}
