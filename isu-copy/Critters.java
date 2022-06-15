import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class contains the Golden Tickets, which is the currency of this game
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Critters extends Actor
{
    public static int numOfCritters = 100;
    
    public static boolean gained150 = false;
    public static boolean gained200 = false;
    /**
     * Act - do whatever the GoldenTickets wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setImage(new GreenfootImage("Critters: " + numOfCritters, 30, new Color(255, 186, 8), new Color(0,0,0,0), Color.BLACK));
        
        //Used for tracking achievements
        if(getCurrency() >= 150)
        {
            gained150 = true;
        }
        if(getCurrency() >= 200)
        {
            gained200 = true;
        }
    }
    
    // Returns the number of tickets
    public static int getCurrency()
    {
        return numOfCritters;
    }
    
    // Sets the number of tickets
    public static void setCurrency(int num)
    {
        numOfCritters = num;
    }
    
}
