import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class BlueBlob here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlueBlob extends Actor
{
    private GreenfootImage[] images=new GreenfootImage[3];
    private double currentImage= 0;
    /**
     * Constructs blue blob.
     *
     */
    public BlueBlob() {
        images[0] = new GreenfootImage("blue_blob1.png");
        images[1] = new GreenfootImage("blue_blob2.png");
        images[2] = new GreenfootImage("blue_blob3.png");
        setImage(images[0]); 
    }
    @Override
    public void act() 
    {
       switchImage();
    }   
    /**
     * Switch the image every second update
     */
    private void switchImage() {
        currentImage = currentImage + 0.2;
        if(currentImage >= images.length) {
            currentImage = 0;
        }        
        setImage(images[(int)currentImage]);
    }
 
}
