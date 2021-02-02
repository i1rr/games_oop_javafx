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
        int size = dest.getX() - position.getX();
        size = size > 0 ? size : size * -1;
        Cell[] steps = new Cell[size];
        int deltaX = dest.getX() - position.getX() > 0 ? 1 : -1;
        int deltaY = dest.getY() - position.getY() < 0 ? -1 : 1;
        for (int index = 0; index < size; index++) {
            steps[index] = Cell.findBy((index * deltaX) + deltaX + position.getX(),
                    (index * deltaY) + deltaY+ position.getY());
        }
        return steps;
    }
    /**    throw new IllegalStateException(
                String.format("Could not way by diagonal from %s to %s", position, dest)
        );
     */

    public boolean isDiagonal(Cell position, Cell dest) {
        int checkLengthX = position.getX() > dest.getX() ?
                position.getX() - dest.getX() : dest.getX() - position.getX();
        int checkLengthY = position.getY() > dest.getY() ?
                position.getY() - dest.getY() : dest.getY() - position.getY();
        return checkLengthY == checkLengthX;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
