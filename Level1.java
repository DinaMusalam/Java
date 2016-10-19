import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

 /**
 * A level is a world where a Girl can move around and jump on platforms.
 * 
 * @author Thomas Ejnefjäll, Dina Eid Musalam
 * @version 2014-08-03
 */
public class Level1 extends Level
{

    /**
     * Constructor for objects of class Level1.
     * 
     */
    public Level1()
    {    
         
    }
    
    @Override
    public void nextLevel()
    {
        Greenfoot.setWorld(new Level2());
    }
    
    /**
     * Populate the world with a Woman and platforms.
     */
    private void populateWorld()
    {
   
               
        //setPaintOrder(Girl.class); // girl ska vara den som ritta sist och det är när girl ska hoppa backom 
    }
}
