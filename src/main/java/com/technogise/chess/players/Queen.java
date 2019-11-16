package com.technogise.chess.players;

import com.technogise.chess.model.Board;
import com.technogise.chess.model.Cell;
import com.technogise.chess.model.Position;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.abs;
import static java.util.stream.Collectors.toList;

public class Queen implements Player {

    @Override
    public List<Position> getPossiblePositions(Position position, Board board) {
        int x = position.x;
        int y = position.y;
        return board.cells().stream()
                .map(c -> c.position)
                .filter(pos -> (abs(x - pos.x) == abs(y - pos.y)) || (x - pos.x == 0) || (y - pos.y == 0))
                .filter(pos -> !pos.equals(position))
                .collect(toList());
    }

    @Override
    public String getId() {
        return "Queen";
    }
}
