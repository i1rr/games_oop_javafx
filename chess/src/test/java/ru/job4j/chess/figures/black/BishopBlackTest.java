package ru.job4j.chess.figures.black;

import org.junit.Test;

import ru.job4j.chess.*;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.white.BishopWhite;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {

    @Test
    public void position() {
        BishopBlack bb = new BishopBlack(Cell.A1);
        assertThat("A1", is(bb.position().toString()));
    }

    @Test
    public void copy() {
        BishopBlack bb = new BishopBlack(Cell.A1);
        bb = (BishopBlack) bb.copy(Cell.A2);
        assertThat(bb.position().toString(), is("A2"));
    }

    @Test
    public void way() throws ImpossibleMoveException {
        BishopBlack bb = new BishopBlack(Cell.C1);
        assertThat(bb.way(Cell.G5), is(new Cell[] {Cell.D2, Cell.E3, Cell.F4, Cell.G5}));
    }

    @Test
    public void whenIsNotDiagonal() {
        BishopBlack bb = new BishopBlack(Cell.A1);
        assertThat(bb.isDiagonal(bb.position(), Cell.G6), is (false));
    }

    @Test
    public void whenIsDiagonal() {
        BishopBlack bb = new BishopBlack(Cell.C1);
        assertThat(bb.isDiagonal(bb.position(), Cell.G5), is (true));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenImpossibleMoveException() throws ImpossibleMoveException {
        BishopBlack bb = new BishopBlack(Cell.C1);
        bb.way(Cell.C2);
    }

    @Test(expected = FigureNotFoundException.class)
    public void whenFigureNotFoundException() throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        Logic ll = new Logic();
        ll.move(Cell.E3, Cell.A1);
    }

    @Test(expected = OccupiedCellException.class)
    public void whenCellIsOccupied() throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        Logic ll = new Logic();
        BishopBlack bb = new BishopBlack(Cell.A2);
        BishopWhite bw = new BishopWhite(Cell.B3);
        ll.add(bb);
        ll.add(bw);

        ll.move(Cell.A2, Cell.C4);
    }
}