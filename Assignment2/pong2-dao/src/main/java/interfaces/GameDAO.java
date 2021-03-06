package interfaces;

import entities.Game;

public interface GameDAO {
    Game findGame(int id);
    void insertGame(Game game);
    void updateGame(Game game);
    void deleteGame(Game game);
}