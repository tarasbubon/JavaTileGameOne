package dev.tilegame;

import dev.tilegame.gfx.GameCamera;
import dev.tilegame.input.KeyManager;
import dev.tilegame.input.MouseManager;
import dev.tilegame.worlds.World;

public class Handler
{
    private Game game;
    private World world;

    public Handler(Game game)
    {
        this.game = game;
    }

    public KeyManager getKeyManager()
    {
        return game.getKeyManager();
    }

    public GameCamera getGameCamera()
    {
        return game.getGameCamera();
    }

    public MouseManager getMouseManager()
    {
        return game.getMouseManager();
    }

    public int getWidth()
    {
        return game.getWidth();
    }

    public int getHeight()
    {
        return game.getHeight();
    }

    //GETTERS AND SETTERS
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
}

