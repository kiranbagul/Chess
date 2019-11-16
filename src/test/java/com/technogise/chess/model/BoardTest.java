package com.technogise.chess.model;

import com.technogise.chess.players.Horse;
import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BoardTest {

    @Test
    public void testCellBoundsForValidMoves() {
        Position current = new Position(0, 0);
        List<Position> probablePositions = new Board(8).getPossibleMoves(new Cell(new Horse(), current));
        List<Position> expected = asList(
                new Position(current.x + 1, current.y + 2),
                new Position(current.x + 2, current.y + 1));
        assertThat(expected, IsIterableContainingInAnyOrder.containsInAnyOrder(probablePositions.toArray()));
    }

    @Test
    public void testCellForInvalidPosition() {
        Position current = new Position(-1, 0);
        assertThrows(IllegalArgumentException.class, () -> {
            assertEquals(null, new Board(8).getPossibleMoves(new Cell(new Horse(), current)));
        });
    }

}