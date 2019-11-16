package com.technogise.chess.model;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

import static java.util.Collections.unmodifiableList;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

public class Board {
    private List<Cell> cells;
    private int size;

    public Board(int size) {
        this.cells = range(0, size).mapToObj(i -> range(0, size)
                .mapToObj(j -> new Cell(new Position(i, j))).collect(toList()))
                .flatMap(Collection::stream)
                .collect(toList());
        this.size = size;
    }

    public List<Cell> cells() {
        return unmodifiableList(cells);
    }

    public List<Position> getPossibleMoves(Cell cell) {
        if (!isWithingBounds(cell.position)) {
            throw new IllegalArgumentException("Invalid position");
        }
        return cell.player.map(p -> p.getPossiblePositions(cell.position, this)
                .stream().filter(this::isWithingBounds).collect(toList()))
                .orElseThrow(() -> new IllegalArgumentException("Player not available"));
    }

    private boolean isWithingBounds(Position pos) {
        return pos.x > -1 && pos.x < size && pos.y > -1 && pos.y < size;
    }
}
