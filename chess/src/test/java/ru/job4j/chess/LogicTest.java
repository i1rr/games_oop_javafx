package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;
import ru.job4j.chess.figures.black.BishopBlack;

public class LogicTest {

    @Ignore
    @Test
    public void whenWayIsFree()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.H6);
    }

    @Ignore
    @Test
    public void whenWayIsNotFree()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        try {
            Logic logic = new Logic();
            logic.add(new BishopBlack(Cell.C1));
            logic.add(new BishopBlack(Cell.D2));
            logic.move(Cell.C1, Cell.H6);
        } catch (OccupiedCellException e) {
            System.out.println("OccupiedCellException is caught");
        }
    }

    @Ignore
    @Test
    public void whenFigureNotFound()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        try {
            Logic logic = new Logic();
            logic.move(Cell.C1, Cell.H6);
        } catch (FigureNotFoundException e) {
            System.out.println("FigureNotFoundException is caught");
        }
    }

    @Ignore
    @Test
    public void whenMove()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        try {
            Logic logic = new Logic();
            logic.add(new BishopBlack(Cell.C1));
            logic.move(Cell.C1, Cell.H1);
        } catch (ImpossibleMoveException e) {
            System.out.println("ImpossibleMoveException is caught");
        }
    }
}