import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GreenBlob here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GreenBlob extends Actor
{
    private GreenfootImage[] images=new GreenfootImage[3];
    private double currentImage= 0;
    /**
     * Constructs blue blob.
     *
     */
    public GreenBlob() {
        images[0] = new GreenfootImage("green_blob1.png");
        images[1] = new GreenfootImage("green_blob2.png");
        images[2] = new GreenfootImage("green_blob3.png");
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
