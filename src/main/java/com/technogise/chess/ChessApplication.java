package com.technogise.chess;

import com.sun.org.apache.xpath.internal.SourceTreeManager;
import com.technogise.chess.io.IOHelper;
import com.technogise.chess.model.Board;
import com.technogise.chess.model.Cell;
import com.technogise.chess.model.Position;

import java.util.List;

import static java.util.Arrays.asList;

public class ChessApplication {

    private Board board;

    public ChessApplication(int size) {
        board = new Board(size);
    }

    public List<Position> getProbablePositions(Cell cell) {
        return board.getPossibleMoves(cell);
    }

    public static void main(String[] args) {
        final int size = 8;
        final List<String> xC = asList("A", "B", "C", "D", "E", "F", "G", "H");
        ChessApplication app = new ChessApplication(size);
        IOHelper ioHelper = new IOHelper(size, xC);
        List<Position> probablePositions = app.getProbablePositions(ioHelper.getCellFrom(args[0]));
        System.out.println(ioHelper.from(probablePositions));
    }


}
