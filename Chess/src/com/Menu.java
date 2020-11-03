package com;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Menu
{
    Font titleFont = new Font("arial", 1, 70);
    Font buttonFont = new Font("arial", 1, 50);


    public Menu()
    {
        // TODO Auto-generated constructor stub
    }


    public void tick()
    {

    }


    public void render(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.setFont(titleFont);
        g.drawString("CHESS", 325, 100);
        g.setFont(buttonFont);
        // Should be changed to be more dynamic rather than fixed size and
        // position
        g.drawRect(300, 200, 300, 75);
        g.drawString("PLAY", 380, 260);
        g.drawRect(300, 350, 300, 75);
        g.drawString("SETTINGS", 330, 410);
        g.drawRect(300, 500, 300, 75);
        g.drawString("QUIT", 390, 560);
    }
}
