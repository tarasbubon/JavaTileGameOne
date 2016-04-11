package dev.tilegame.states;

import dev.tilegame.Game;
import dev.tilegame.entities.creatures.Player;
import dev.tilegame.worlds.World;

import java.awt.*;

public class GameState extends State
{
    private Player player;
    private World world;

    public GameState(Game game)
    {
        super(game);
        player = new Player(game, 100, 100);
        world = new World(game, "res/worlds/World1.txt");
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
