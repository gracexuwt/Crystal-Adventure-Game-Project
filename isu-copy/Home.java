import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The GameHall contains all mini games, the menu, and the shop
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Home extends World
{
    //Mini game Button
    private Button rps = new Button(new GreenfootImage("RPS.png"));
    private Button jackpot = new Button(new GreenfootImage("jackpot.png"));
    
    // Menu, Achievements, Shop, Inventory Button
    private Button pausemenu = new Button(new GreenfootImage("MenuButton.png"));
    private Button achievements = new Button(new GreenfootImage("AchievementsButton.png"));
    private Button shop = new Button(new GreenfootImage("ShopButton.png"));
    private Button inventory = new Button(new GreenfootImage("InventoryButton.png"));
    // Pause menu Button
    public static Button resume = new Button(new GreenfootImage("resumebutton.png"));
    public static Button backToTitle = new Button(new GreenfootImage("BackToTitleButton.png"));
    public static Button backToHome = new Button(new GreenfootImage("BackToArcadeButton.png"));
    public Button musicOnMenu = new Button(new GreenfootImage("Menu-MusicOnButton.png"));
    public Button musicOffMenu = new Button(new GreenfootImage("Menu-MusicOffButton.png"));
    
    // Amount of Golden Tickets the player has
    public static Crystals currency = new Crystals();
    /**
     * Constructor for objects of class GameHall.
     * 
     */
    public Home()
    {    
        super(960, 540, 1); 
        
        //add games
        addObject(rps, 466, 220);
        addObject(jackpot, 466, 384);
        //add pause menu & shop
        addObject(pausemenu, 760, 92);
        addObject(achievements, 760, 205);
        addObject(shop, 760, 318);
        addObject(inventory, 760, 432);
        
    }
    
    public void act()
    {
        //show Golden Tickets
        addObject(currency, 130, 500);
        if(Greenfoot.mouseClicked(rps))
        {
            Title.click.play();
            //Greenfoot.setWorld(new RockPaperScissor());
        }
        else if(Greenfoot.mouseClicked(jackpot))
        {
            Title.click.play();
            //Greenfoot.setWorld(new Jackpot());
        }
        //Achievements
        if(Greenfoot.mouseClicked(achievements))
        {
            Title.click.play();
            //Greenfoot.setWorld(new Achievements());
        }
        // Shop
        if(Greenfoot.mouseClicked(shop))
        {
            Title.click.play();
            if(!Button.shopExists) //initialize a new shop
            {
                Button.shopExists = true;
                //Greenfoot.setWorld(new Shop());
            }
            //else Greenfoot.setWorld(Shop.shop); //if player already went in the shop, then save the previous shop world
        }
        //Inventory
        if(Greenfoot.mouseClicked(inventory)){
            Title.click.play();
            //Greenfoot.setWorld(new Inventory());
        }
        //Menu
        if(Greenfoot.mouseClicked(pausemenu))
        {
            Title.click.play();
            drawPauseMenu(); //Summons the pause menu screen
        }
        // On the Menu screen:
        if(Greenfoot.mouseClicked(musicOnMenu)){
            Title.bgm.pause();
            addObject(musicOffMenu, 480, 300);
            removeObject(musicOnMenu);
        }
        if(Greenfoot.mouseClicked(musicOffMenu)){
            Title.bgm.playLoop();
            addObject(musicOnMenu, 480, 300);
            removeObject(musicOffMenu);
        }
        checkPause(); 
    }
    
    // This method draws the pause menu
    public void drawPauseMenu(){
        removeObjects(getObjects(null)); //removes all Button on GameHall
        
        // Pause menu screen Button
        //addObject(new Picture(new GreenfootImage("menuscreen.png")), 480, 270);
        addObject(resume, 480, 240);
        if(Title.bgm.isPlaying()) addObject(musicOnMenu, 480, 300);
        else addObject(musicOffMenu, 480, 300);
        addObject(backToTitle, 480, 360);
    }
    
    // This method checks whether the player presses resume, backtotitle, or backtoarcade
    public static void checkPause(){
        if(Greenfoot.mouseClicked(resume))
        {
            Title.click.play();
            Greenfoot.setWorld(new Home());
        }
        if(Greenfoot.mouseClicked(backToTitle))
        {
            Title.click.play();
            Greenfoot.setWorld(new Title());
        }
        if(Greenfoot.mouseClicked(backToHome))
        {
            Title.click.play();
            Greenfoot.setWorld(new Home());
        }
    }
}
