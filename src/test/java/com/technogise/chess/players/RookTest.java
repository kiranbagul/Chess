package com.technogise.chess.players;

import com.technogise.chess.model.Board;
import com.technogise.chess.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.*;

class RookTest {

    @Test
    void getPossibleRookPositionsCase1() {
        Rook rook = new Rook();
        Position current = new Position(1, 1);
        List<Position> possiblePositions = rook.getPossiblePositions(current, new Board(5));
        Assertions.assertEquals(8, possiblePositions.size());
        List<Position> expected = asList(
                new Position(current.x, current.y - 1),
                new Position(current.x, current.y + 1),
                new Position(current.x, current.y + 2),
                new Position(current.x, current.y + 3),
                new Position(current.x - 1, current.y),
                new Position(current.x + 1, current.y),
                new Position(current.x + 2, current.y),
                new Position(current.x + 3, current.y));
        assertThat(expected, containsInAnyOrder(possiblePositions.toArray()));
    }

}