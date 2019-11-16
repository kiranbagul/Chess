package com.technogise.chess.model;

import com.technogise.chess.players.Player;

import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.ofNullable;

public class Cell {

    public final Optional<Player> player;
    public final Position position;

    public Cell(Player player, Position position) {
        this.player = ofNullable(player);
        this.position = position;
    }

    public Cell(Position position) {
        this.player = empty();
        this.position = position;
    }


}