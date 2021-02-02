package ru.job4j.chess;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;
import java.util.Arrays;

public final class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        figures[index++] = figure;
    }

    public void move(Cell source, Cell dest)
            throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        int index = findBy(source);
        Cell[] steps = figures[index].way(dest);
        free(steps);
        figures[index] = figures[index].copy(dest);
    }

    private boolean free(Cell[] steps) throws OccupiedCellException {
           int figuresAmount = 0;
           for (int i = 0; i < figures.length ; i++) {
               if (figures[i] == null) {
                   break;
               }
               figuresAmount++;
           }
               for (int j = 0; j < figuresAmount; j++) {
                   for (int k = 0; k < steps.length; k++) {
                       if(figures[j].position().equals(steps[k])) {
                           throw new OccupiedCellException();
                       }
                   }
               }

        return true;
    }

    public void clean() {
        Arrays.fill(figures, null);
        index = 0;
    }

    private int findBy(Cell cell) throws FigureNotFoundException {
        for (int index = 0; index != figures.length; index++) {
            Figure figure = figures[index];
            if (figure != null && figure.position().equals(cell)) {
                return index;
            }
        }
        throw new FigureNotFoundException();
    }
}
