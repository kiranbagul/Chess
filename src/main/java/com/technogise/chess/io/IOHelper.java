package com.technogise.chess.io;

import com.technogise.chess.model.Cell;
import com.technogise.chess.model.Position;

import java.util.List;

import static com.technogise.chess.players.PlayerFactory.getPlayer;
import static java.lang.Integer.parseInt;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.joining;

public class IOHelper {

    private static final String POSITION_ERROR = "Input must in format '<PLAYER> <POSITION>', ex. King A1, Current board size is : ";
    private static final String FORMAT_ERROR = "Input must in format '<PLAYER> <POSITION>', ex. King A1";

    private final int size;
    private final List<String> xCordinatesNames;

    public IOHelper(int size, List<String> xCordinatesNames) {
        this.size = size;
        this.xCordinatesNames = xCordinatesNames;
    }

    public Cell getCellFrom(String posStr) {
        return ofNullable(posStr).map(s -> s.split(" "))
                .filter(this::isValid)
                .map(s -> {
                    String[] p = s[1].split("");
                    return isValid(p) ? new Cell(getPlayer(s[0]), new Position(getX(p[0]), getY(p[1]))) : null;
                }).orElseThrow(() -> new IllegalArgumentException(FORMAT_ERROR));
    }

    public String from(List<Position> positions) {
        return positions.stream().map(p -> xCordinatesNames.get(p.x) + (p.y + 1)).collect(joining(", "));
    }

    private boolean isValid(String[] in) {
        return in.length == 2;
    }

    private int getX(String x) {
        return xCordinatesNames.indexOf(x);
    }

    private int getY(String yStr) {
        int y;
        try {
            y = parseInt(yStr) - 1;
        } catch (Exception e) {
            throw new IllegalArgumentException(POSITION_ERROR + size);
        }
        if (y > size)
            throw new IllegalArgumentException(POSITION_ERROR + size);
        return y;
    }


}
