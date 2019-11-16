package com.technogise.chess.players;

import com.technogise.chess.model.Board;
import com.technogise.chess.model.Position;

import java.util.List;

public interface Player {

    List<Position> getPossiblePositions(Position position, Board board);

    String getId();
}
