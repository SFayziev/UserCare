package com.sh.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by Admin on 10.06.2015.
 */
public class ImageResizer {
    private  BufferedImage originalImage;
    private  int IMG_WIDTH = 240;
    private  int IMG_HEIGHT = 360;
    private  int type;

    public ImageResizer(int IMG_WIDTH, int IMG_HEIGHT,  URL url) throws IOException {
        this.IMG_WIDTH = IMG_WIDTH;
        this.IMG_HEIGHT = IMG_HEIGHT;
        originalImage = ImageIO.read(url);
            type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
        getPicture();
    }
    public ImageResizer(int IMG_WIDTH, int IMG_HEIGHT,  String  pathtoImg) throws IOException {
        this.IMG_WIDTH = IMG_WIDTH;
        this.IMG_HEIGHT = IMG_HEIGHT;
//        URL url = new URL(pathtoImg);
        originalImage = ImageIO.read( new File(pathtoImg));
//        originalImage = ImageIO.read(originalImage);
        type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
        getPicture();
    }

    public ImageResizer(int IMG_WIDTH, int IMG_HEIGHT,  InputStream stream) throws IOException {
        this.IMG_WIDTH = IMG_WIDTH;
        this.IMG_HEIGHT = IMG_HEIGHT;
        originalImage = ImageIO.read( stream );
        type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
    }


    public   BufferedImage resizeImage(){
        BufferedImage resizedImage = new BufferedImage( IMG_WIDTH, IMG_HEIGHT,  type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
        g.dispose();

        return resizedImage;
    }

    public BufferedImage resizeImageWithHint(){
        if (IMG_HEIGHT==0 && IMG_WIDTH==0) return originalImage;
        float db  ;
        Coords coords = new Coords();

        coords.x = originalImage.getWidth();
        coords.y = originalImage.getHeight();
        System.out.println(coords.x + " X " + coords.y);

        db = coords.y /coords.x ;
        if (IMG_HEIGHT==0){
            IMG_HEIGHT= Math.round(IMG_WIDTH*db);
        }

        if (IMG_WIDTH==0){
            IMG_WIDTH= Math.round(IMG_HEIGHT/db);
        }

        BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
        g.dispose();
        g.setComposite(AlphaComposite.Src);

        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        return resizedImage;
    }

    class Coords {
        float x;
        float y;
    };

    public void getPicture() throws IOException {
                float db = IMG_WIDTH/IMG_WIDTH ;
                Coords coords = new Coords();
                Coords newcoords = new Coords();
                coords.x = originalImage.getWidth();
                coords.y = originalImage.getHeight();
                System.out.println(coords.x + " X " + coords.y);

                if ((coords.x / coords.y) < db) {
                    newcoords.y = coords.x * (1 / db);
                    int dif = (int) ((coords.y - newcoords.y) / 2);
                    System.out.println(" new " +  coords.x + " X " + newcoords.y + "  dif" + dif);
                    originalImage = originalImage.getSubimage(0, dif, (int) coords.x, (int) coords.y - 2*dif);

                } else {
                    newcoords.x = coords.y * db;
                    int dif = (int) ((coords.x - newcoords.x) / 2);
                    System.out.println(" new " +  newcoords.x + " X " + coords.y + "  dif" + dif);
                    originalImage = originalImage.getSubimage(dif, 0, (int) coords.x -2*dif, (int) coords.y );
                }
    }


}
