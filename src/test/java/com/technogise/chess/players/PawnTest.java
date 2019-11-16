package com.technogise.chess.players;

import com.technogise.chess.model.Board;
import com.technogise.chess.model.Cell;
import com.technogise.chess.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.IntStream.range;
import static org.junit.jupiter.api.Assertions.*;

class PawnTest {

    @Test
    void getPossiblePawnPositionsCase1() {
        Pawn pawn = new Pawn();
        List<Position> possiblePositions = pawn.getPossiblePositions(new Position(1, 1), new Board(3));
        Assertions.assertEquals(1, possiblePositions.size());
        Assertions.assertEquals(new Position(1, 2), possiblePositions.get(0));
    }

    @Test
    void getPossiblePawnPositionsCase2() {
        Pawn pawn = new Pawn();
        List<Position> possiblePositions = pawn.getPossiblePositions(new Position(2, 1), new Board(5));
        Assertions.assertEquals(1, possiblePositions.size());
        Assertions.assertEquals(new Position(2, 2), possiblePositions.get(0));
    }
}