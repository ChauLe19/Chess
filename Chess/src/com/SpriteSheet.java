package com;

import java.awt.image.BufferedImage;
import java.io.IOException;
import net.coobird.thumbnailator.Thumbnails;

public class SpriteSheet
{
    private BufferedImage sprite;
    private double boxSize = 115;

    public SpriteSheet(BufferedImage ss)
    {
        this.sprite = ss;
    }
    
    public SpriteSheet(BufferedImage ss, int boxSize)
    {
        double height = boxSize/(this.boxSize) * ss.getHeight();
        double width = boxSize/(this.boxSize) * ss.getWidth();
        
        try
        {
            this.sprite = Thumbnails.of(ss).size((int)width, (int)height).asBufferedImage();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public BufferedImage grabImage(int col, int row, int width, int height)
    {
        return sprite.getSubimage(col * width - width, row * height - height,
            width, height);

    }
}
