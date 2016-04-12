package dev.tilegame.entities.creatures;

import dev.tilegame.Handler;
import dev.tilegame.gfx.Animation;
import dev.tilegame.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature
{
    //Animations
    private Animation animDown, animUp, animLeft, animRight;

    public Player(Handler handler, float x, float y)
    {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

        bounds.x = 22;
        bounds.y = 30;
        bounds.width = 19;
        bounds.height = 33;

        //Animations
        animDown = new Animation(500, Assets.player_down);
        animUp = new Animation(500, Assets.player_up);
        animLeft = new Animation(500, Assets.player_left);
        animRight = new Animation(500, Assets.player_right);
    }

    @Override
    public void tick()
    {
        //Animations
        animDown.tick();
        animUp.tick();
        animLeft.tick();
        animRight.tick();
        //Movement
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
    }

    private void getInput()
    {
        xMove = 0;
        yMove = 0;

        if(handler.getKeyManager().up)
            yMove = -speed;
        if(handler.getKeyManager().down)
            yMove = speed;
        if(handler.getKeyManager().left)
            xMove = -speed;
        if(handler.getKeyManager().right)
            xMove = speed;
    }

    @Override
    public void render(Graphics g)
    {
        g.drawImage(getCurrentAnimationFrame(),
                    (int)(x - handler.getGameCamera().getxOffset()),
                    (int)(y - handler.getGameCamera().getyOffset()),
                    width,
                    height,
                    null);
//        g.setColor(Color.red);
//        g.fillRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()),
//                   (int)(y + bounds.y - handler.getGameCamera().getyOffset()),
//                   bounds.width,
//                   bounds.height);
    }

    private BufferedImage getCurrentAnimationFrame()
    {
        if(xMove < 0)
        {
            return animLeft.getCurrentFrame();
        }
        else if(xMove > 0)
        {
            return animRight.getCurrentFrame();
        }
        else if(yMove < 0)
        {
            return animUp.getCurrentFrame();
        }
        else
        {
            return animDown.getCurrentFrame();
        }
    }
}
