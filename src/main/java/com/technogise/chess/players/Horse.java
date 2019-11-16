package com.technogise.chess.players;

import com.technogise.chess.model.Board;
import com.technogise.chess.model.Position;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.range;

public class Horse implements Player {

    @Override
    public List<Position> getPossiblePositions(Position position, Board board) {
        Position pos1 = new Position(position.x + 1, position.y + 2);
        Position pos2 = new Position(position.x + 2, position.y + 1);
        Position pos3 = new Position(position.x + 2, position.y - 1);
        Position pos4 = new Position(position.x + 1, position.y - 2);
        Position pos5 = new Position(position.x - 1, position.y - 2);
        Position pos6 = new Position(position.x - 2, position.y - 1);
        Position pos7 = new Position(position.x - 2, position.y + 1);
        Position pos8 = new Position(position.x - 1, position.y + 2);
        return Arrays.asList(pos1, pos2, pos3, pos4, pos5, pos6, pos7, pos8);
    }

    @Override
    public String getId() {
        return "Horse";
    }
}
