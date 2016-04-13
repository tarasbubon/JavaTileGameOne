package dev.tilegame.entities.statics;

import dev.tilegame.Handler;
import dev.tilegame.gfx.Assets;
import dev.tilegame.tiles.Tile;

import java.awt.*;

public class Tree extends StaticEntity
{
    public Tree(Handler handler, float x, float y)
    {
        super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT * 2);

        bounds.x = 10;
        bounds.y = (int)(height / 1.5f);
        bounds.width = width - 20;
        bounds.height = (int)(height - height / 1.5f);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.tree, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    }
}
