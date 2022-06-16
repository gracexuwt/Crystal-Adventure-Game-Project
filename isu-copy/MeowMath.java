import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MeowMath here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MeowMath extends World
{
    // Buttons for player to interact with
    private Button button = new Button(new GreenfootImage("5.png"));
    private Button arrow = new Button(new GreenfootImage("6.png"));
    private Button gummi = new Button(new GreenfootImage("7.png"));
    
    Button q1a = new Button(new GreenfootImage("a) 0 degrees", 30, Color.BLACK, Color.WHITE));
            Button q1b = new Button(new GreenfootImage("b) 40 degrees", 30, Color.BLACK, Color.WHITE));
            Button q1c = new Button(new GreenfootImage("c) 50 degrees", 30, Color.BLACK, Color.WHITE));
            Button q1d = new Button(new GreenfootImage("d) 120 degrees", 30, Color.BLACK, Color.WHITE));
    Button q2a = new Button(new GreenfootImage("a) 49 square inches", 30, Color.BLACK, Color.WHITE));
            Button q2b = new Button(new GreenfootImage("b) 63 square inches", 30, Color.BLACK, Color.WHITE));
            Button q2c = new Button(new GreenfootImage("c) 98 square inches", 30, Color.BLACK, Color.WHITE));
    Button q3a = new Button(new GreenfootImage("a) 31 square centimeters", 30, Color.BLACK, Color.WHITE));
            Button q3b = new Button(new GreenfootImage("b) 17.5 square centimeters", 30, Color.BLACK, Color.WHITE));
            Button q3c = new Button(new GreenfootImage("c) 21.5 square centimeters", 30, Color.BLACK, Color.WHITE));
    Button q4a = new Button(new GreenfootImage("a) 6 cm", 30, Color.BLACK, Color.WHITE));
            Button q4b = new Button(new GreenfootImage("b) 7.3 cm", 30, Color.BLACK, Color.WHITE));
            Button q4c = new Button(new GreenfootImage("c) 8.5 cm", 30, Color.BLACK, Color.WHITE));
            Button q4d = new Button(new GreenfootImage("d) 36 cm", 30, Color.BLACK, Color.WHITE));
    
    Picture p = new Picture(new GreenfootImage("Hello! Welcome to MeowMills \n"+"Here we will do a math quiz \n"+"Good luck!", 20, Color.BLACK, new Color(0,0,0,0)));
    Button b = new Button(new GreenfootImage("START", 20, Color.WHITE, Color.BLACK));
    
    private Counter corrects = new Counter();
    /**
     * Constructor for objects of class MeowMath.
     */
    public MeowMath()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(960, 540, 1); 
        addObject(p, 120,120);
        addObject(b,120,170);
    }
    
    public void act(){
        if(Greenfoot.mouseClicked(b)){
            addObject(button, 220, 420);
            addObject(arrow,480,420);
            addObject(gummi,740,420);
        }
        if(Greenfoot.mouseClicked(arrow)){
            geometryQ1();
        }
        
        if(Greenfoot.mouseClicked(q1a)||Greenfoot.mouseClicked(q1b)||Greenfoot.mouseClicked(q1d)){
            Title.loseSound.play();
            addObject(new Picture(new GreenfootImage("Oh no! You picked the wrong answer. The correct answer is 50 degrees.", 30, Color.WHITE, Color.PINK)),480,350);
            Greenfoot.delay(160);
            geometryQ2();
        }
        else if(Greenfoot.mouseClicked(q1c)){
            Title.winSound.play();
            corrects.add();
            Critters.setCurrency(Critters.getCurrency() + 20);
            addObject(new Picture(new GreenfootImage("Hi, my name is Arrow! Great job, you're doing it RIGHT", 30, Color.WHITE, Color.PINK)),480,350);
            Greenfoot.delay(200);
            geometryQ2();
        }
        if(Greenfoot.mouseClicked(q2b)||Greenfoot.mouseClicked(q2c)){
            Title.loseSound.play();
            addObject(new Picture(new GreenfootImage("Oh no! You picked the wrong answer. The correct answer is 49 square inches.", 30, Color.WHITE, Color.PINK)),480,260);
            Greenfoot.delay(160);
            geometryQ3();
        }
        else if(Greenfoot.mouseClicked(q2a)){
            Title.winSound.play();
            corrects.add();
            Critters.setCurrency(Critters.getCurrency() + 20);
            addObject(new Picture(new GreenfootImage("Meow, you are one smart kitty cat", 30, Color.WHITE, Color.PINK)),480,260);
            Greenfoot.delay(160);
            geometryQ3();
        }
        if(Greenfoot.mouseClicked(q3a)||Greenfoot.mouseClicked(q3c)){
            Title.loseSound.play();
            addObject(new Picture(new GreenfootImage("Oh no! You picked the wrong answer. The correct answer is 17.5 square centimeters.", 30, Color.WHITE, Color.PINK)),480,260);
            Greenfoot.delay(160);
            geometryQ4();
        }
        else if(Greenfoot.mouseClicked(q3b)){
            Title.winSound.play();
            corrects.add();
            Critters.setCurrency(Critters.getCurrency() + 20);
            addObject(new Picture(new GreenfootImage("Impawsible, how did you get that one?!", 30, Color.WHITE, Color.PINK)),480,260);
            Greenfoot.delay(160);
            geometryQ4();
        }
        if(Greenfoot.mouseClicked(q4a)||Greenfoot.mouseClicked(q4b)||Greenfoot.mouseClicked(q4d)){
            Title.loseSound.play();
            addObject(new Picture(new GreenfootImage("Oh no! You picked the wrong answer. The correct answer is 8.5 cm.", 30, Color.WHITE, Color.PINK)),480,260);
            Greenfoot.delay(160);
            endGame();
        }
        else if(Greenfoot.mouseClicked(q4c)){
            Title.winSound.play();
            corrects.add();
            Critters.setCurrency(Critters.getCurrency() + 20);
            addObject(new Picture(new GreenfootImage("YAY you got it!", 30, Color.WHITE, Color.PINK)),480,220);
            Greenfoot.delay(160);
            endGame();
        }
        Home.checkPause();
    }
    
    private void geometryQ1(){
        removeObjects(getObjects(null));
            setBackground(new GreenfootImage("Arrow Q1.png"));
            addObject(q1a, 480, 220);
            addObject(q1b, 480, 250);
            addObject(q1c, 480, 280);
            addObject(q1d, 480, 310);
    } 
    private void geometryQ2(){
        removeObjects(getObjects(null));
            setBackground(new GreenfootImage("Arrow Q2.png"));
            addObject(q2a, 200, 380);
            addObject(q2b, 200, 410);
            addObject(q2c, 200, 440);
    }
    private void geometryQ3(){
        removeObjects(getObjects(null));
            setBackground(new GreenfootImage("Arrow Q3.png"));
            addObject(q3a, 200, 380);
            addObject(q3b, 200, 410);
            addObject(q3c, 200, 440);
    }
       private void geometryQ4(){
        removeObjects(getObjects(null));
            setBackground(new GreenfootImage("Arrow Q4.png"));
            addObject(q4a, 500, 280);
            addObject(q4b, 500, 310);
            addObject(q4c, 500, 340);
            addObject(q4d, 500, 370);
    } 
    
    private void endGame(){
        removeObjects(getObjects(null));
        addObject(new Picture(new GreenfootImage("Congrats! \n"+"You got "+corrects.getScore()+" questions correct!", 40, Color.WHITE, Color.PINK)),480,260);
        addObject(Home.backToHome,480,350);
    }
    }
