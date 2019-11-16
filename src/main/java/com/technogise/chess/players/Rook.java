package com.technogise.chess.players;

import com.technogise.chess.model.Board;
import com.technogise.chess.model.Position;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.abs;

public class Rook implements Player {

    @Override
    public List<Position> getPossiblePositions(Position position, Board board) {
        int x = position.x;
        int y = position.y;
        return board.cells().stream()
                .map(c -> c.position)
                .filter(pos -> ((x - pos.x == 0) || (y - pos.y == 0)) && !pos.equals(position))
                .collect(Collectors.toList());
    }

    @Override
    public String getId() {
        return "Rook";
    }
}
