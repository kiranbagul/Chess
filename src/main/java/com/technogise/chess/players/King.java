package com.technogise.chess.players;

import com.technogise.chess.model.Board;
import com.technogise.chess.model.Position;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.rangeClosed;

public class King implements Player {

    @Override
    public List<Position> getPossiblePositions(Position position, Board board) {
        return rangeClosed(-1, 1).mapToObj(i -> rangeClosed(-1, 1)
                .mapToObj(j -> new Position(position.x + i, position.y + j)).collect(toList()))
                .flatMap(Collection::stream)
                .filter(pos -> !pos.equals(position))
                .collect(toList());
    }

    @Override
    public String getId() {
        return "King";
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
