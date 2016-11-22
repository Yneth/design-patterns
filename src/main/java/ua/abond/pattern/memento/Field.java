package ua.abond.pattern.memento;

public class Field {
    private static final int WIDTH = 3;
    private static final int HEIGHT = WIDTH;

    private int[] cells;

    public Field() {
        this.cells = new int[WIDTH * HEIGHT];
    }

    public void set(int x, int y, int value) {
        checkBounds(x);
        checkBounds(y);

        cells[x + y * HEIGHT] = value;
    }

    public void restore(Memento memento) {
        this.cells = memento.getCells();
    }

    public Memento createMemento() {
        return new Memento(cells);
    }

    private void checkBounds(int x) {
        if (x >= WIDTH || x < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    public static class Memento {
        private int[] cells;

        protected Memento(int[] cells) {
            this.cells = cells.clone();
        }

        public int[] getCells() {
            return cells;
        }

        public void setCells(int[] cells) {
            this.cells = cells;
        }
    }
}
