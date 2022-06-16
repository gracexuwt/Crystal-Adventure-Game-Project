import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Adventure here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Adventure extends World
{
    // Buttons for player to interact with
    private Button antartica = new Button(new GreenfootImage("ice.png"));
    private Button desert = new Button(new GreenfootImage("desert.png"));
    private Button amazon = new Button(new GreenfootImage("amazon.png"));
    
    Button q1a = new Button(new GreenfootImage("A. by spitting", 40, Color.BLACK, Color.WHITE));
            Button q1b = new Button(new GreenfootImage("B. by sneezing", 40, Color.BLACK, Color.WHITE));
            Button q1c = new Button(new GreenfootImage("C. by coughing", 40, Color.BLACK, Color.WHITE));
    Button q2a = new Button(new GreenfootImage("A. Catastrophic molt", 40, Color.BLACK, Color.WHITE));
            Button q2b = new Button(new GreenfootImage("B. Molting", 40, Color.BLACK, Color.WHITE));
            Button q2c = new Button(new GreenfootImage("C. Metamorphosis", 40, Color.BLACK, Color.WHITE));
    Button q3a = new Button(new GreenfootImage("A. 14 km/h", 40, Color.BLACK, Color.WHITE));
            Button q3b = new Button(new GreenfootImage("B. 18 km/h", 40, Color.BLACK, Color.WHITE));
            Button q3c = new Button(new GreenfootImage("C. 36 km/h", 40, Color.BLACK, Color.WHITE));
            
    private Counter corrects = new Counter();
    /**
     * Constructor for objects of class Adventure.
     * 
     */
    public Adventure()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(960, 540, 1); 
        addObject(antartica, 220, 320);
        addObject(desert,480,320);
        addObject(amazon,740,320);
    }
    
    public void act(){
        if(Greenfoot.mouseClicked(antartica)){
            removeObjects(getObjects(null));
            setBackground(new GreenfootImage("Antarctica.png"));
            Greenfoot.delay(30);
            addObject(new Picture(new GreenfootImage("pebble-waving.png")),798,110);
            addObject(new Picture(new GreenfootImage("Hello! I've never seen you around.", 30, Color.WHITE, Color.PINK)),480,260);
            Greenfoot.delay(200);
            removeObjects(getObjects(null));
            addObject(new Picture(new GreenfootImage("I don’t usually mess with humans like you, \n"+"but I really need some Critters for a friend’s birthday party…", 30, Color.WHITE, Color.PINK)),480,260);
            Greenfoot.delay(260);
            removeObjects(getObjects(null));
            addObject(new Picture(new GreenfootImage("pebbles-winking.png")),806,116);
            addObject(new Picture(new GreenfootImage("How about let's make a deal? \n"+"I'll test you with 3 trivia questions \n"+"You get at least 2 of them right, then I'll leave you alone! \n"+"if you get them wrong, I'll take your critters!", 30, Color.WHITE, Color.PINK)),480,260);
            Greenfoot.delay(440);
            removeObjects(getObjects(null));
            setBackground(new GreenfootImage("Antarctica q1.png"));
            addObject(q1a,480,210);
            addObject(q1b,480,320);
            addObject(q1c,480,440);
        }
        if(Greenfoot.mouseClicked(q1a)||Greenfoot.mouseClicked(q1c)){
            Title.loseSound.play();
            addObject(new Picture(new GreenfootImage("WRONG! Penguins excrete water by sneezing.", 30, Color.WHITE, Color.PINK)),480,450);
            Greenfoot.delay(160);
            iceQ2();
        }
        else if(Greenfoot.mouseClicked(q1b)){
            Title.winSound.play();
            corrects.add();
            Critters.setCurrency(Critters.getCurrency() + 20);
            addObject(new Picture(new GreenfootImage("CORRECT!", 50, Color.WHITE, Color.PINK)),480,450);
            Greenfoot.delay(150);
            iceQ2();
        }
        if(Greenfoot.mouseClicked(q2c)||Greenfoot.mouseClicked(q2b)){
            Title.loseSound.play();
            addObject(new Picture(new GreenfootImage("WRONG! Penguins shed all feathers through catastrophic molting.", 30, Color.WHITE, Color.PINK)),480,450);
            Greenfoot.delay(160);
            iceQ3();
        }
        else if(Greenfoot.mouseClicked(q2a)){
            Title.winSound.play();
            corrects.add();
            Critters.setCurrency(Critters.getCurrency() + 20);
            addObject(new Picture(new GreenfootImage("CORRECT!", 50, Color.WHITE, Color.PINK)),480,450);
            Greenfoot.delay(150);
            iceQ3();
        }
        if(Greenfoot.mouseClicked(q3a)||Greenfoot.mouseClicked(q3b)){
            Title.loseSound.play();
            addObject(new Picture(new GreenfootImage("WRONG! They are the fastest penguins at 36 km/h.", 30, Color.WHITE, Color.PINK)),480,350);
            Greenfoot.delay(160);
            endGame();
        }
        else if(Greenfoot.mouseClicked(q3c)){
            Title.winSound.play();
            corrects.add();
            Critters.setCurrency(Critters.getCurrency() + 20);
            addObject(new Picture(new GreenfootImage("CORRECT!", 50, Color.WHITE, Color.PINK)),480,450);
            Greenfoot.delay(150);
            endGame();
        }
        Home.checkPause();
    }
    public void iceQ2(){
        removeObjects(getObjects(null));
            setBackground(new GreenfootImage("Antarctica q2.png"));
            addObject(q2a, 480, 210);
            addObject(q2b, 480, 300);
            addObject(q2c, 480, 410);
    }
    public void iceQ3(){
        removeObjects(getObjects(null));
            setBackground(new GreenfootImage("Antarctica q3.png"));
            addObject(q3a, 440, 220);
            addObject(q3b, 440, 295);
            addObject(q3c, 440, 400);
    }
    public void endGame(){
        removeObjects(getObjects(null));
        addObject(new Picture(new GreenfootImage("You got "+corrects.getScore()+" questions correct!", 40, Color.WHITE, Color.PINK)),480,220);
        if(corrects.getScore() <= 1) addObject(new Picture(new GreenfootImage("Oh no, you didn't finish the adventure :( \n"+"Try again?", 40, Color.WHITE, Color.PINK)),480,300);
        else addObject(new Picture(new GreenfootImage("You finished the Antarctica adventure!", 40, Color.WHITE, Color.PINK)),480,300);
        addObject(Home.backToHome,480,450);
    }
}
