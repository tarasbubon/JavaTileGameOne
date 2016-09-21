package dev.tilegame.items;

import dev.tilegame.Handler;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class ItemManager
{
    private Handler handler;
    private ArrayList<Item> items;

    public ItemManager(Handler handler)
    {
        this.handler = handler;
        items = new ArrayList<>();
    }

    public void tick()
    {
        Iterator<Item> it = items.iterator();
        while(it.hasNext())
        {
            Item i = it.next();
            i.tick();
            if(i.isPickedUp())
            {
                it.remove();
            }
        }
    }

    public void render(Graphics g)
    {
        for(Item i : items)
        {
            i.setHandler(handler);
            i.render(g);
        }
    }

    public void addItem(Item i)
    {
        items.add(i);
    }

    //GETTER AND SETTERS
    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
