package ru.job4j.chess.figures.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) throws ImpossibleMoveException {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException();
        }
        int size = Math.abs(dest.getX() - position.getX());

        Cell[] steps = new Cell[size];

        int deltaX = dest.getX() - position.getX() > 0 ? 1 : -1;
        int deltaY = dest.getY() - position.getY() < 0 ? -1 : 1;

        int nextX = deltaX + position.getX(); //next step for X
        int nextY = deltaY + position.getY(); //next step for Y

        for (int index = 0; index < size; index++) {
            steps[index] = Cell.findBy(
                    (index * deltaX) + nextX,
                    (index * deltaY) + nextY);
        }
        return steps;
    }
    /**    throw new IllegalStateException(
                String.format("Could not way by diagonal from %s to %s", position, dest)
        );
     */

    public boolean isDiagonal(Cell position, Cell dest) {
        int checkLengthX = Math.abs(position.getX() - dest.getX());
        int checkLengthY = Math.abs(position.getY() - dest.getY());
        return checkLengthY == checkLengthX;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
