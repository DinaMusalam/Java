import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A Girl that can jump on platforms and have fun.
 * 
 * @author Thomas Ejnefjäll 
 * @version 2014-06-04
 */
public class Girl extends Mover
{
    /**
     * Constructs a Girl.
     */
    public Girl()
    {
        
    }
    
    @Override
    public void act() 
    {
       
       checkKeys();
       checkCollisions();
       isOnBrick();
       //checkForBlob();
       checkDoor();
      
    } 
    
    private void checkDoor()
    {
         Level level = (Level)getWorld();
        if (getOneIntersectingObject(Door.class) != null)
       {
           level.nextLevel();
        }
        
    }
    
   
    /**
     * Check if the user has pressed any keys used in the game. If so act accordingly.
     */
    private void checkKeys()
    {
        if (Greenfoot.isKeyDown("left") )
        {            
            moveLeft();
        }
        if (Greenfoot.isKeyDown("right") )
        {            
            moveRight();
        }
        if (Greenfoot.isKeyDown("up"))
        {
            if (isOnGround())
            {
                jump();
            }
        }
    } 
    
       /**
     * Check if the Girl walk throght BlueBlob, if so then the BlueBrick become dark. 
    */
    private void checkForBlob()
    {
        Actor blueBlob = getOneIntersectingObject(BlueBlob.class);
        
        
        if(blueBlob!= null)
        {
            blueBlob.getImage().setTransparency(250);
        }
        else 
        {
             blueBlob.getImage().setTransparency(120);
        }
       
    } 
}
