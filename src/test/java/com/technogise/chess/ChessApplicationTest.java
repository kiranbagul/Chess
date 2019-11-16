package com.technogise.chess;

import com.technogise.chess.io.IOHelper;
import com.technogise.chess.model.Board;
import com.technogise.chess.model.Cell;
import com.technogise.chess.model.Position;
import com.technogise.chess.players.Horse;
import com.technogise.chess.players.Pawn;
import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ChessApplicationTest {

    @Test
    public void testEmptyBoard() {
        Board board = new Board(0);
        assertEquals(Collections.EMPTY_LIST, board.cells());
    }

    @Test
    public void testBoardWithCells() {
        Board board = new Board(2);
        List<Cell> cells = board.cells();
        assertEquals(4, cells.size());
    }

    @Test
    public void testPositionsForAPawn() {
        ChessApplication app = new ChessApplication(8);
        List<Position> probablePositions = app.getProbablePositions(new Cell(new Pawn(), new Position(3, 3)));
        assertEquals(1, probablePositions.size());
        assertEquals(new Position(3,4), probablePositions.get(0));
    }

    @Test
    public void testPositionsForAHorse() {
        ChessApplication app = new ChessApplication(8);
        Position current = new Position(3, 3);
        List<Position> probablePositions = app.getProbablePositions(new Cell(new Horse(), current));
        List<Position> expected = asList(
                new Position(current.x - 1, current.y - 2),
                new Position(current.x + 1, current.y - 2),
                new Position(current.x - 1, current.y + 2),
                new Position(current.x + 1, current.y + 2),
                new Position(current.x - 2, current.y - 1),
                new Position(current.x - 2, current.y + 1),
                new Position(current.x + 2, current.y - 1),
                new Position(current.x + 2, current.y + 1));
        assertThat(expected, IsIterableContainingInAnyOrder.containsInAnyOrder(probablePositions.toArray()));
    }

    @Test
    public void testPlayerPositionsWithIO_HorseE3() {
        final List<String> xC = asList("A", "B", "C", "D", "E", "F", "G", "H");
        IOHelper ioHelper = new IOHelper(8, xC);
        ChessApplication app = new ChessApplication(8);
        List<Position> probablePositions = app.getProbablePositions(ioHelper.getCellFrom("Horse E3"));
        assertThat(asList("F5, G4, G2, F1, D1, C2, C4, D5".split(",")),
                containsInAnyOrder(ioHelper.from(probablePositions).split(",")));
    }

    @Test
    public void testPlayerPositionsWithIO_KingD5() {
        final List<String> xC = asList("A", "B", "C", "D", "E", "F", "G", "H");
        IOHelper ioHelper = new IOHelper(8, xC);
        ChessApplication app = new ChessApplication(8);
        List<Position> probablePositions = app.getProbablePositions(ioHelper.getCellFrom("King D5"));
        assertThat(asList("C4, D6, E6, E5, E4, D4, C5, C6".split(",")),
                containsInAnyOrder(ioHelper.from(probablePositions).split(",")));
    }

}