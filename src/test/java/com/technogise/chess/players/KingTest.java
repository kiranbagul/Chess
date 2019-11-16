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

class KingTest {
    @Test
    void getPossibleKingPositionsCase1() {
        King king = new King();
        Position current = new Position(1, 1);
        List<Position> possiblePositions = king.getPossiblePositions(current, new Board(5));
        Assertions.assertEquals(8, possiblePositions.size());
        List<Position> expected = asList(
                new Position(current.x, current.y - 1),
                new Position(current.x, current.y + 1),
                new Position(current.x - 1, current.y - 1),
                new Position(current.x - 1, current.y),
                new Position(current.x - 1, current.y + 1),
                new Position(current.x + 1, current.y - 1),
                new Position(current.x + 1, current.y),
                new Position(current.x + 1, current.y + 1));
        assertThat(expected, containsInAnyOrder(possiblePositions.toArray()));
    }


}