package com.technogise.chess.players;

public class PlayerFactory {

    private static PlayerFactory playerFactory = new PlayerFactory();

    private PlayerFactory() {
    }

    public static Player getPlayer(String id) {
        Player player;
        switch (id) {
            case "Queen":
                player = new Queen();
                break;
            case "King":
                player = new King();
                break;
            case "Bishop":
                player = new Bishop();
                break;
            case "Rook":
                player = new Rook();
                break;
            case "Horse":
                player = new Horse();
                break;
            case "Pawn":
                player = new Pawn();
                break;
            default:
                throw new IllegalArgumentException("Invalid player.");
        }
        return player;
    }

    public static PlayerFactory getInstance() {
        return playerFactory;
    }
}
