package ua.abond.pattern.factorymethod;

public class TetrisShape {
    private final String shape;

    public TetrisShape(String shape) {
        this.shape = shape;
    }

    public TetrisShape(TetrisShape shape) {
        this.shape = shape.shape;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof TetrisShape))
            return false;

        TetrisShape that = (TetrisShape) o;

        return shape.equals(that.shape);

    }

    @Override
    public int hashCode() {
        return shape.hashCode();
    }

    @Override
    public String toString() {
        return shape;
    }
}
