import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Title extends World
{
    //Game start and exit buttons
    private Button startButton = new Button(new GreenfootImage("Play-button.png"));
    private Button exitButton = new Button(new GreenfootImage("ExitButton.png"));
    private Button achievements = new Button(new GreenfootImage("Achievements-button.png"));
    
    // Background music and sound effects
    public static GreenfootSound bgm = new GreenfootSound("Music.mp3");
    public static GreenfootSound cursor = new GreenfootSound("Cursor.mp3");
    public static GreenfootSound click = new GreenfootSound("Click.mp3");
    public static GreenfootSound winSound = new GreenfootSound("win-sound.mp3");
    public static GreenfootSound loseSound = new GreenfootSound("lose-sound.mp3");
    public static GreenfootSound cashSound = new GreenfootSound("cash-sound.mp3");
    // Music On/Off buttons
    private Button musicOn = new Button(new GreenfootImage("musicon.png"));
    private Button musicOff = new Button(new GreenfootImage("musicoff.png"));
    
    public static boolean[] gamesPlayed = new boolean[4];
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Title()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(960, 540, 1); 
        // Add home, exit, and music buttons
        addObject(startButton, 480, 320);
        addObject(achievements,480,400);
        addObject(exitButton, 480, 480);
        addObject(musicOff, 930, 30);
        
        //No games played yet
        for(boolean played : gamesPlayed) played=false;
    }
    
    // Act() method is called when the player presses Run
    public void act()
    {
        if(Greenfoot.mouseClicked(startButton)) {
            click.play();
            Greenfoot.setWorld(new Home());
        }
        if(Greenfoot.mouseClicked(exitButton)) {
            click.play();
            removeObjects(getObjects(null));
            setBackground(new GreenfootImage("ExitScreen.png"));
            Critters.setCurrency(100);
            bgm.pause();
            Greenfoot.stop();
        }
        //Achievements
        if(Greenfoot.mouseClicked(achievements))
        {
            Title.click.play();
            Greenfoot.setWorld(new Achievements());
        }
        // If player clicked on the music on/off switch
        if(Greenfoot.mouseClicked(musicOn)){
            bgm.pause();
            addObject(musicOff, 930, 30);
            removeObject(musicOn);
        }
        if(Greenfoot.mouseClicked(musicOff)){
            Title.bgm.playLoop();
            addObject(musicOn, 930, 30);
            removeObject(musicOff);
        }
    }
}
