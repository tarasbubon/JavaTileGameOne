package dev.tilegame.states;

import dev.tilegame.Handler;
import dev.tilegame.UI.ClickListener;
import dev.tilegame.UI.UIImageButton;
import dev.tilegame.UI.UIManager;
import dev.tilegame.gfx.Assets;

import java.awt.*;

public class MenuState extends State
{
    private UIManager uiManager;

    public MenuState(Handler handler)
    {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);

        uiManager.addObject(new UIImageButton(200, 200, 128, 64, Assets.btn_start, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                State.setState(handler.getGame().gameState);
            }
        }));
    }

    @Override
    public void tick()
    {
        uiManager.tick();

        //Temporary just go directly to the GameState, skip the menu state
        handler.getMouseManager().setUiManager(null);
        State.setState(handler.getGame().gameState);
    }

    @Override
    public void render(Graphics g)
    {
        uiManager.render(g);
    }
}
