import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

 /**
 * A level is a world where a Girl can move around and jump on platforms.
 * 
 * @author Thomas Ejnefjäll, Dina Eid Musalam
 * @version 2014-08-03
 */
public class Level extends World
{
    private int levelNumber = 0;
    private LevelCreator  levelCreator= new LevelCreator();
    
    private GreenfootImage fadeImage;
    

    /**
     * Constructs a Level.
     */
    public Level()
    {         
        super(800, 600, 1); 
        nextLevel();
        
    }
    /**
     * Builds a level from the String[].
     * 
     * @param level a String[] that represents the level.
     */
    public void buildLevel(String[] level)
    {
        int cellSize = 50;
        
        for(int i = 0; i < level.length; i ++)
        {
            for(int j = 0; j < level[i].length(); j ++)
            {
                Actor actor = createActor(level[i].charAt(j));   
                
                if(actor != null)
                {
                    addObject(actor, cellSize / 2 + cellSize * j, cellSize / 2 + cellSize * i);
                }
            }
        }
    }
    /**
     * Create an Actor based on the parameter.
     * <p>LEGEND<br>
     * B = BlueBlob<br>
     * R = BlueBrick<br>
     * K = GreenBlob<br>
     * Z = GreenBrick<br>
     * P = Platform<br>
     * G = Girl<br>
     * D = Door</p>
     * 
     * @param c a char value representing the Actor we want to create or null if there was no Actor for the value. 
     */
    private Actor createActor(char c)
    {
        Actor actor = null;
        
        
        if(c == 'B')
        {
            actor = new BlueBlob();
        } 
        else if(c == 'P')
        {
            actor = new Platform();
        }
        else if(c == 'G')
        {
            actor = new Girl();
        }    
         else if(c == 'R')
        {
            actor = new BlueBrick();
            actor.getImage().setTransparency(120);
        }        
         else if(c == 'K')
        {
            actor = new GreenBlob();
        }        
         else if(c == 'Z')
        {
            actor = new GreenBrick();
             actor.getImage().setTransparency(120);
        }  
          else if(c == 'D')
        {
            actor = new Door();
        }
        return actor;        
    }
    
    /**
     * Go to next level.
     */
    public void nextLevel()
    {
        String[] level = levelCreator.createLevel(levelNumber ++);
        
        if(level == null)
        {
            Greenfoot.stop();
        }
        else 
        {
            this.removeObjects(getObjects(null));
            buildLevel(level);
        }
    }
      
}
