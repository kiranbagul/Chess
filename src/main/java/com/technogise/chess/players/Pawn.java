package com.technogise.chess.players;

import com.technogise.chess.model.Board;
import com.technogise.chess.model.Position;

import java.util.List;

import static java.util.Arrays.asList;

public class Pawn implements Player {

    @Override
    public List<Position> getPossiblePositions(Position position, Board board) {
        return asList(new Position(position.x, position.y + 1));
    }

    @Override
    public String getId() {
        return "Pawn";
    }
}
