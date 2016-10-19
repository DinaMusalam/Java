import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.util.List;

/**
 * Mover provides basic movement methods and methods to check and handle Mover's interaction
 * with floor, ceiling and walls. Use this as a superclass for actors that should be able to move 
 * left and right, jump up and fall down.
 * 
 * @author Griff (griff@kvusd.org)
 * @author Thomas Ejnefjäll, Dina Musalam
 * @version 2014-06-04
 */
public class Mover extends Actor
{
    private static final int ACCELERATION = 1;    // när flika han inte nåt under sig    //down (gravity)
    private static final int HORIZONTAL_SPEED = 4;    //running speed (sideways)
    private static final int JUMP_STRENGTH = 16;      //determines how high we can jump
    private static final int MAX_VERTICAL_SPEED = 9;  //we can not faster than this // max speed när flicka ramla ner
    private int verticalSpeed = 0; //speed now                    //current vertical speed. 0 = on ground. >0 = jumping up. <0 = falling down
    
    /**
     * Constructs a Mover.
     */
    public Mover()
    {
        
    }
    
    /**
     * Check so the Mover do not move through plattforms.
     */
    public void checkCollisions()
    {
        checkFall();// ramla
        checkPlatformAbove();// när finns platform
        checkWalls();        // if she is at the edge
        
    }
    
    /**
     * Move right.
     */
    public void moveRight()
    {
        setLocation (getX() + HORIZONTAL_SPEED, getY()); // get x + speed+ y
    }
    
    /**
     * Move left.
     */
    public void moveLeft()
    {
        setLocation (getX() - HORIZONTAL_SPEED, getY());
    }
    
    /**
     * Jump.
     */
     public void jump()
    {
        verticalSpeed = -JUMP_STRENGTH;//speed for att tralla ner och - for att ramla up (jump)
        fall(); // for att minska speed
    }    
        
    /**
     * Check if the Mover is on the ground, or is standing on a platform.
     * 
     * @return true if the Mover is on the ground, false if not.
     */
    
    public boolean isOnGround()
    {
        boolean onGround = false; // if she is står på en platform 
        
                  
       Actor ground = getOneObjectAtOffset(0, getImage().getHeight()/2 , Platform.class);
        
       Actor blueGround = getOneObjectAtOffset(0, getImage().getHeight()/2 , BlueBrick.class);
       
       Actor greenGround = getOneObjectAtOffset(0, getImage().getHeight()/2 , GreenBrick.class);
       
       
        // koll om vi har annt object under oss. (0) direkt under oss. get bild och hight och dela med 2 ( om det finns en plats form )
        if(ground != null)       // return fals eller true om det finns platform 
        {
            moveOutOfGround(ground); // if boolen return true so flika ska står en pixil upp of platform
            onGround = true;       // return true jag är på marken        
        }  
        else if (blueGround != null && blueGround.getImage().getTransparency() != 120)
        {
            moveOutOfGround(blueGround); // if boolen return true so flika ska står en pixil upp of platform
            onGround = true;        
        }
          else if (greenGround != null && greenGround.getImage().getTransparency() != 120)
        {
            moveOutOfGround(greenGround); // if boolen return true so flika ska står en pixil upp of platform
            onGround = true;        
        }
        
        return onGround ;
    }
  

     /**
     * Check if the Mover is on the Brick, or is standing on a Brick.
     * 
     * @return true if the Mover is on the Brick, false if not.
     */
    public boolean isOnBrick()
    {
     boolean visibility = false;
           Actor blueBlob = getOneIntersectingObject(BlueBlob.class);
           Level world=(Level)getWorld();
           List<BlueBrick> blueBrick =  world.getObjects(BlueBrick.class);
           
           if (blueBlob != null )
            {      
                while (blueBrick!=null)
                {
               
                BlueBrick bluebrick =  (BlueBrick)((Level)getWorld()).getObjects(BlueBrick.class);
                //BlueBrick bluebrick1 =  (BlueBrick)((Level)getWorld()).getObjects(BlueBrick.class).get(1);
                bluebrick.getImage().setTransparency(255);
                //bluebrick1.getImage().setTransparency(255);
            }
                visibility = true;
        }  
    }
    /**
     * Check if the Mover has moved inside a wall, if so move it out of the wall.
     */
    private void checkWalls() // kolla att vi är inte gå in på vägen 
    {        
        Actor rightWall = getOneObjectAtOffset(getImage().getWidth() / 2, 0, Platform.class);
        Actor rightBlueBrick = getOneObjectAtOffset(getImage().getWidth() / 2, 0, BlueBrick.class);
        Actor rightGreenBrick = getOneObjectAtOffset(getImage().getWidth() / 2, 0, GreenBrick.class);
        // ta bild och ta half of bild och kolla om det gå genom väg 
        Actor leftWall = getOneObjectAtOffset(getImage().getWidth() / -2, 0, Platform.class);
        Actor leftBlueBrick = getOneObjectAtOffset(getImage().getWidth() / -2, 0, BlueBrick.class);
        Actor leftGreenBrick = getOneObjectAtOffset(getImage().getWidth() / -2, 0, GreenBrick.class);
        
        
        if(rightWall != null)
        {
            moveOutOfRightWall(rightWall);
        }
        else if(leftWall != null)
        {
            moveOutOfLeftWall(leftWall);            
        }  
         else  if(rightBlueBrick != null)
        {
            moveOutOfRightWall(rightBlueBrick);
        }
        else if(rightGreenBrick != null)
        {
            moveOutOfLeftWall(rightGreenBrick);            
        } 
          else  if(leftBlueBrick != null)
        {
            moveOutOfRightWall(leftBlueBrick);
        }
        else if(leftGreenBrick != null)
        {
            moveOutOfLeftWall(leftGreenBrick);            
        }
    }
    

    
    /**
     * Move out of a wall on our left side.
     * 
     * @param wall the wall we want to move out of.
     */
    private void moveOutOfLeftWall(Actor wall)
    {
        int wallWidth = wall.getImage().getWidth();// size for wall
        int newX = wall.getX() + (wallWidth + getImage().getWidth())/2;
        // var ska vi står 
        setLocation(newX + HORIZONTAL_SPEED, getY());           
    }
    
    /**
     * Move out of a wall on our right side.
     * 
     * @param wall the wall we want to move out of.
     */
    private void moveOutOfRightWall(Actor wall)
    {
        int wallWidth = wall.getImage().getWidth();
        int newX = wall.getX() - (wallWidth + getImage().getWidth())/2;
        setLocation(newX - HORIZONTAL_SPEED, getY());                
    }
    
    /**
     * Check if we have jumped into a platform above (our ceiling), if so move 
     * out of the ceiling and make sure we start to fall down.
     */
    private void checkPlatformAbove() // kolla om det finns tak över oss och man räkna från 0 - minus
    {        
        Actor ceiling = getOneObjectAtOffset(0, getImage().getHeight() / -2, Platform.class);
        Actor ceilingBlue = getOneObjectAtOffset(0, getImage().getHeight() / -2, BlueBrick.class);
        Actor ceilingGreen = getOneObjectAtOffset(0, getImage().getHeight() / -2, GreenBrick.class);
        //Actor ImageTrancparent= this.getImage().getTransparency();
        
        if(ceiling != null) // if ture 
        {
            verticalSpeed = 1;       // speed ner      
            moveOutOfCeiling(ceiling);  // ramla ner           
        }  
         if(ceilingBlue != null) // if ture 
        {
            verticalSpeed = 1;       // speed ner      
            moveOutOfCeiling(ceilingBlue);  // ramla ner           
        } 
         if(ceilingGreen != null) // if ture 
        {
            verticalSpeed = 1;       // speed ner      
            moveOutOfCeiling(ceilingGreen);  // ramla ner           
        } 
    }
    
    /**
     * Move out of the ceiling.
     * 
     * @param ceiling the ceiling we want to move out of.
     */
    private void moveOutOfCeiling(Actor ceiling)
    {
        int ceilingHeight = ceiling.getImage().getHeight();
        int newY = ceiling.getY() + (ceilingHeight + getImage().getHeight()) / 2;
        setLocation(getX(), newY);        
    }
        
    /**
     * Check if we have reach ground. If we have reach ground stop falling.
     */
    private void checkFall()
    {
        // koll om vi har kammit till en platform 
        if (isOnGround()) {
            verticalSpeed = 0;
        }
        else {
            fall();
        }
    }
    
            
    /**
     * Fall faster and faster.
     */
    private void fall()
    {
        setLocation (getX(), getY() + verticalSpeed);
        verticalSpeed = verticalSpeed + ACCELERATION;
        
        if(verticalSpeed > MAX_VERTICAL_SPEED) // our speed mer än max speed
        {
            verticalSpeed = MAX_VERTICAL_SPEED;
        }
    }
    
    /**
     * Move out of the ground.
     * 
     * @param ground the ground we want to move out of.
     */
    private void moveOutOfGround(Actor ground)
    {
        // kolla marken och räkna location och var vi ska står 
        int groundHeight = ground.getImage().getHeight();
        int newY = ground.getY() - (groundHeight + getImage().getHeight())/2;
        setLocation(getX(), newY);              
    }
}
