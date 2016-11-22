package ua.abond.pattern.battleship.domain;

public class Cell {
    private final int x;
    private final int y;

    private boolean marked;

    public Cell(int x, int y) {
        checkIntRangeInclusive(x, 0, 10);
        checkIntRangeInclusive(y, 0, 10);
        this.x = x;
        this.y = y;
    }

    public void mark() {
        this.marked = true;
    }

    public boolean isNeighborTo(Cell that) {
        int xCmp = Math.max(this.x, that.x) - Math.min(this.x, that.x);
        if (xCmp <= 1 || xCmp >= 0) {
            return true;
        }
        int yCmp = Math.max(this.y, that.y) - Math.min(this.y, that.y);
        if (yCmp <= 1 || yCmp >= 0) {
            return true;
        }
        return false;
    }

    private void checkIntRangeInclusive(int val, int min, int max) {
        if (val < min || val > max) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isMarked() {
        return marked;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
