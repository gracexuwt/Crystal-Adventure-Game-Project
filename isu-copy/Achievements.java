import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Achievements page keeps track of the achievements the player has reached
 * 
 * @Melanie
 */
public class Achievements extends World
{
    //Greyed Out Achievements
    public final int fg_FULL = 1;
    public final int ag_FULL = 4;
    public final int gt200_FULL = 1200;
    public final int jp_FULL = 1;
    public final int gp_FULL = 3;
    public final int mg_FULL = 1;
    public final int fi_FULL = 1;
    public final int ai_FULL = 6;
    
    public Achievement fg = new Achievement(new GreenfootImage("Achievement 1.png"), 0, fg_FULL);
    public Achievement ag = new Achievement(new GreenfootImage("Achievement 2.png"), 0, ag_FULL);
    public Achievement gt200 = new Achievement(new GreenfootImage("Achievement 3.png"), 0, gt200_FULL);
    public Achievement jp = new Achievement(new GreenfootImage("Achievement 5.png"), 0, jp_FULL);
    public Achievement gp = new Achievement(new GreenfootImage("Achievement 6.png"), 0, gp_FULL);
    public Achievement mg = new Achievement(new GreenfootImage("Achievement 7.png"), 0, mg_FULL);
    public Achievement fi = new Achievement(new GreenfootImage("Achievement 4.png"), 0, fi_FULL);
    public Achievement ai = new Achievement(new GreenfootImage("Achievement 8.png"), 0, ai_FULL);
    /**
     * Constructor for objects of class Achievements.
     * 
     */
    public Achievements()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(960, 540, 1); 
        
        //Set up greyed achievements 
        addObject(fg, 240, 165);
        addObject(ag, 240, 270);
        addObject(jp,240,372);
        addObject(gt200, 240, 482);
        addObject(gp, 734, 165);
        addObject(mg, 734, 270);
        addObject(fi, 734, 372);
        addObject(ai, 734, 482);
        addObject(Home.backToHome, 820, 60);
        
        //Show latest achievements
        addAchievements();
    }
    
    public void act()
    {
        Home.checkPause();
    }
    
    public void addAchievements()
    {
        int gt = Critters.getCurrency();
        updateAch(fg, numGamesPlayed(), 1); //Played First Game
        updateAch(ag, numGamesPlayed(), 4); //Played all games
        updateAch(gt200, Critters.gained200, gt); //Gained 200 Golden Tickets
        //updateAch(jp, Jackpot.gainedWin, 0); //Gained the WIN combo in Jackpot Game
        updateAch(fi, Shop.boughtItems.size(), 1); //Bought first item from shop
        updateAch(ai, Shop.boughtItems.size(), 6); //Bought all items from shop
    }
    
    /**
     * Updates achievement progress bar
     * @param ach = Achievement to update
     * @param condition = the current value of the number whos value determines the achievement progress
     * @param limit = the value the condition has to reach
     */
    private void updateAch(Achievement ach, int condition, int limit)
    {
        if(condition >= limit)
        {
            removeObject(ach);
        }
        else
        {
            ach.setProgress(condition);
        }
    }
    /**
     * Updates achievement progress bar
     * @param ach = Achievement to update
     * @param condition = the achievement the player has to reach
     * @param updater = current progress to condition
       */
    private void updateAch(Achievement ach, boolean condition, int updater)
    {
        if(condition)
        {
            removeObject(ach);
        }
        else
        {
            if(updater != 0)
            {
                ach.setProgress(updater);
            }
        }
    }
    
    //Check the number of games played
    private int numGamesPlayed()
    {
        int counter = 0;
        for(boolean game: Title.gamesPlayed)
        {
            if(game)
            {
                counter++;
            }
        }
        return counter;
    }
}
