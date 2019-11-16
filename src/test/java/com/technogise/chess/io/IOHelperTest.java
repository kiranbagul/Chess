package com.technogise.chess.io;

import com.technogise.chess.model.Cell;
import com.technogise.chess.model.Position;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

class IOHelperTest {

    private static IOHelper ioHelper;

    @BeforeAll
    public static void init() {
        final List<String> xC = asList("A", "B", "C", "D", "E", "F", "G", "H");
        ioHelper = new IOHelper(8, xC);
    }

    @Test
    void errorOnEmptyInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            assertEquals(null, ioHelper.getCellFrom(""));
        });
    }

    @Test
    void errorOnNullInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            assertEquals(null, ioHelper.getCellFrom(null));
        });
    }

    @Test
    void errorOnInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            assertEquals(null, ioHelper.getCellFrom("AD"));
        });
    }

    @Test
    void parsePositions() {
        assertTrue(isAsExpected("King", 0, 0, ioHelper.getCellFrom("King A1")));
        assertTrue(isAsExpected("Queen", 0, 3, ioHelper.getCellFrom("Queen A4")));
        assertTrue(isAsExpected("Rook", 4, 2, ioHelper.getCellFrom("Rook E3")));
        assertTrue(isAsExpected("Horse", 5, 3, ioHelper.getCellFrom("Horse F4")));
    }

    private boolean isAsExpected(String player, int x, int y, Cell actual) {
        return actual.player.get().getId().equals(player) && actual.position.equals(new Position(x, y));
    }

    @Test
    void outputPositions() {
        assertEquals("A1", ioHelper.from(asList(new Position(0, 0))));
        assertEquals("A4", ioHelper.from(asList(new Position(0, 3))));
        assertEquals("E3", ioHelper.from(asList(new Position(4, 2))));
        assertEquals("F4, A1", ioHelper.from(asList(new Position(5, 3), new Position(0, 0))));
        assertEquals("F4, A1, B1", ioHelper.from(asList(new Position(5, 3), new Position(0, 0), new Position(1, 0))));
    }
}