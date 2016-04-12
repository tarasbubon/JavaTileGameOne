package dev.tilegame.states;

import dev.tilegame.Handler;
import dev.tilegame.entities.creatures.Player;
import dev.tilegame.worlds.World;

import java.awt.*;

public class GameState extends State
{
    private Player player;
    private World world;

    public GameState(Handler handler)
    {
        super(handler);
        world = new World(handler, "res/worlds/World1.txt");
        handler.setWorld(world);
        player = new Player(handler, 100, 100);
    }

    @Override
    public void tick()
    {
        world.tick();
        player.tick();
    }

    @Override
    public void render(Graphics g)
    {
        world.render(g);
        player.render(g);
    }
}
