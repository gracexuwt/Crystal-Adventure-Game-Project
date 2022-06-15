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
    private Button rps = new Button(new GreenfootImage("1.png"));
    private Button adv = new Button(new GreenfootImage("2.png"));
    private Button math = new Button(new GreenfootImage("3.png"));
    private Button jackpot = new Button(new GreenfootImage("4.png"));
    
    // Menu, Achievements, Shop, Inventory Button
    private Button pausemenu = new Button(new GreenfootImage("Menu-button.png"));
    private Button shop = new Button(new GreenfootImage("ShopButton.png"));
    private Button inventory = new Button(new GreenfootImage("InventoryButton.png"));
    private Button choose = new Button(new GreenfootImage("chooseButton.png"));
    // Pause menu Button
    public static Button resume = new Button(new GreenfootImage("resumebutton.png"));
    public static Button backToTitle = new Button(new GreenfootImage("BackToTitleButton.png"));
    public static Button backToHome = new Button(new GreenfootImage("BackToHomeButton.png"));
    public Button musicOnMenu = new Button(new GreenfootImage("Menu-MusicOnButton.png"));
    public Button musicOffMenu = new Button(new GreenfootImage("Menu-MusicOffButton.png"));

    /**
     * Constructor for objects of class GameHall.
     * 
     */
    public Home()
    {    
        super(960, 540, 1); 
        
        addObject(choose,480,300);
        //add pause menu & shop
        addObject(pausemenu, 170, 432);
        addObject(shop, 480, 432);
        addObject(inventory, 790, 432);
        
    }
    
    public void act()
    {
        //show Golden Tickets
        addObject(Title.currency, 873, 500);
        if(Greenfoot.mouseClicked(rps))
        {
            Title.click.play();
            Greenfoot.setWorld(new RockPaperScissor());
        }
        else if(Greenfoot.mouseClicked(jackpot))
        {
            Title.click.play();
            Greenfoot.setWorld(new Jackpot());
        }
        // Shop
        if(Greenfoot.mouseClicked(shop))
        {
            Title.click.play();
            if(!Button.shopExists) //initialize a new shop
            {
                Button.shopExists = true;
                Greenfoot.setWorld(new Shop());
            }
            else Greenfoot.setWorld(Shop.shop); //if player already went in the shop, then save the previous shop world
        }
        //Inventory
        if(Greenfoot.mouseClicked(inventory)){
            Title.click.play();
            Greenfoot.setWorld(new Inventory());
        }
        //Choose Adventure
        if(Greenfoot.mouseClicked(choose)){
            Title.click.play();
            drawAdventure();
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
        checkGame();
    }
    
    // This method draws the pause menu
    public void drawPauseMenu(){
        removeObjects(getObjects(null)); //removes all Button on GameHall
        
        // Pause menu screen Button
        addObject(new Picture(new GreenfootImage("menuscreen.png")), 480, 270);
        addObject(resume, 480, 240);
        if(Title.bgm.isPlaying()) addObject(musicOnMenu, 480, 300);
        else addObject(musicOffMenu, 480, 300);
        addObject(backToTitle, 480, 360);
    }
    
    //This method draw the choose your adventure screen
    public void drawAdventure(){
        removeObjects(getObjects(null));
        addObject(new Picture(new GreenfootImage("quest.png")), 480, 270);
        addObject(backToHome,130,500);
        //add games
        addObject(rps, 360, 220);
        addObject(jackpot, 360, 400);
        addObject(adv,600,220);
        addObject(math,600,400);
    }
    
    //Checks if player presses on a game
    public void checkGame(){
        if(Greenfoot.mouseClicked(jackpot)){
            Title.click.play();
            Greenfoot.setWorld(new Jackpot());
        }
        if(Greenfoot.mouseClicked(adv)){
            Title.click.play();
            Greenfoot.setWorld(new Adventure());
        }
        if(Greenfoot.mouseClicked(rps)){
            Title.click.play();
            Greenfoot.setWorld(new RockPaperScissor());
        }
        if(Greenfoot.mouseClicked(math)){
            Title.click.play();
            Greenfoot.setWorld(new MeowMath());
        }
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
