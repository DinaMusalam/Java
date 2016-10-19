import java.util.*;
/**
 *  Created levels for the game Moving Girl.
 * 
 * @author (Dina.E Musalam) 
 * @version (2014-08-02)
 */
public class LevelCreator  
{
   private List<String[]> levels;
    /**
     * Constructs a LevelCreator
     */
    public LevelCreator()
    {
        levels = createLevels();
    }
    
    private List<String[]> createLevels()
    {
        List<String[]> levels = new ArrayList<String[]>();
        
        levels.add(new String[] {
                "                ",
                "  G             ",
                "    B PPP       ",
                "                ",
                "   RR       P   ",
                "   ZZ       P   ",
                "      K     P   ",
                "      P     P   ",
                "            P   ",
                "    RRR     P   ",
                "          B P D ",
                "PPPPPPPPPPPPPPPP" });
                
        levels.add(new String[] {
                "     B    K     ",
                "  Z           D ",
                "   Z  RRRRRRZZZZ",
                "    Z           ",
                "     Z          ",
                "G  RRRZRRRRRRR  ",
                "R      Z       K",
                "RR      Z       ",
                "RRR      Z      ",
                "RRRR      Z     ",
                "RRRRR  B   Z    ",
                "PPPPPPPPPPPPPPPP" });
        return levels;        
    }

    /**
     * Create a level.
     * 
     * @param levelNumber the level number
     * @return a String[] representing the level
     */
    public String[] createLevel(int levelNumber)
    {
        String[] level = null;
        
        if(levelNumber < levels.size())
        {
            level = levels.get(levelNumber);            
        }
        return level;
    }
}
