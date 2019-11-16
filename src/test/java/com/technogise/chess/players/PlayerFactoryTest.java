package com.technogise.chess.players;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerFactoryTest {

    @Test
    void getPlayer() {
        assertEquals("King", PlayerFactory.getPlayer("King").getId());
        assertEquals("Queen", PlayerFactory.getPlayer("Queen").getId());
        assertEquals("Rook", PlayerFactory.getPlayer("Rook").getId());
        assertEquals("Horse", PlayerFactory.getPlayer("Horse").getId());
        assertEquals("Bishop", PlayerFactory.getPlayer("Bishop").getId());
        assertEquals("Pawn", PlayerFactory.getPlayer("Pawn").getId());
    }
}