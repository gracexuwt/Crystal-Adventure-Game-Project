import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * The player can spin a jackpot spinner
 * 
 * @author Melanie
 * @version 1
 */
public class Jackpot extends World
{
    private GreenfootImage[][] spinner = new GreenfootImage[3][6];
    
    private GreenfootImage critter = new GreenfootImage("Spinner 1.png");
    private GreenfootImage backpack = new GreenfootImage("Spinner land on backpack.png");
    private GreenfootImage blender = new GreenfootImage("Spinner land on fruit blender.png");
    private GreenfootImage lamp = new GreenfootImage("Spinner land on lamp.png");
    private GreenfootImage rare = new GreenfootImage("Spinner land on RARE.png");
    private GreenfootImage bear = new GreenfootImage("Spinner land on teddy bear.png");
    private GreenfootImage spinning = new GreenfootImage("Spinner 2.png");
        
    private Button spin = new Button(new GreenfootImage("Choose Your Adventure.png"));
    
    public static boolean gainedWin = false;
    /**
     * Constructor for objects of class Jackpot.
     * 
     */
    public Jackpot()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(960, 540, 1);
        
        //Spinning button
        addObject(spin, 790, 160);
        
        //Add Golden tickets Counter
        addObject(Title.currency, 150, 500);
        
        //Add back to title button
        addObject(Home.backToHome, 820, 500);
    }
    
    public void act()
    {
        //When player spins the wheel
        if(Greenfoot.mouseClicked(spin)){
            Critters.setCurrency(Critters.getCurrency()-20);
            Random r = new Random();
            int n = r.nextInt(6);
            //spinning pic
            setBackground(spinning);
            Greenfoot.delay(40);
            Title.cashSound.play();
            if(n==0){
                setBackground(critter);
                Critters.setCurrency(Critters.getCurrency()+10);
                Picture p = new Picture(new GreenfootImage("You won 10 critters!", 30, Color.WHITE, Color.BLACK));
                addObject(p,480,270);
                Greenfoot.delay(150);
                removeObject(p);
            }
            if(n==1){
                setBackground(backpack);
                Critters.setCurrency(Critters.getCurrency()+20);
                Picture p = new Picture(new GreenfootImage("You got a backpack! Go pack up for school!", 30, Color.WHITE, Color.BLACK));
                addObject(p,480,270);
                Greenfoot.delay(150);
                removeObject(p);
            }
            if(n==2){
                setBackground(blender);
                Critters.setCurrency(Critters.getCurrency()+30);
                Picture p = new Picture(new GreenfootImage("You got a fruit blender! Make a smoothie!", 30, Color.WHITE, Color.BLACK));
                addObject(p,480,270);
                Greenfoot.delay(150);
                removeObject(p);
            }
            if(n==3){
                setBackground(lamp);
                Critters.setCurrency(Critters.getCurrency()+30);
                Picture p = new Picture(new GreenfootImage("Woah, a lamp! Time to study with it!", 30, Color.WHITE, Color.BLACK));
                addObject(p,480,270);
                Greenfoot.delay(150);
                removeObject(p);
            }
            if(n==4){
                setBackground(rare);
                Critters.setCurrency(Critters.getCurrency()+150);
                Picture p = new Picture(new GreenfootImage("You won a RARE! +100 Critters!!!", 30, Color.WHITE, Color.BLACK));
                addObject(p,480,270);
                Greenfoot.delay(150);
                removeObject(p);
            }
            if(n==5){
                setBackground(bear);
                Critters.setCurrency(Critters.getCurrency()+40);
                Picture p = new Picture(new GreenfootImage("You got a cute teddy bear for hugs and cuddles!", 30, Color.WHITE, Color.BLACK));
                addObject(p,480,270);
                Greenfoot.delay(150);
                removeObject(p);
            }
        }
        
        Home.checkPause();
    }
}
