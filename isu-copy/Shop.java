import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * The shop is where the player can buy items.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shop extends World
{
    // Save a reference to the previous shop world
    public static Shop shop;
    
    // Maps all items in the shop (key) corresponding to a specific price (value)
    public HashMap<ShopItem,Integer> items = new HashMap<ShopItem,Integer>();
    // All items in the shop that are already bought by the player
    public static List<Integer> boughtItems = new ArrayList<Integer>();
        
    //Item Prices
    public static final int sealP = 210;
    public static final int pandaP = 270;
    public static final int ferretP = 250;
    public static final int leopardP = 320;
    public static final int otterP = 250;
    public static final int tortoiseP = 150;
    
    // Add items
    ShopItem seal = new ShopItem(new GreenfootImage("seal.png"), sealP);
    ShopItem panda  = new ShopItem(new GreenfootImage("panda.png"), pandaP);
    ShopItem ferret = new ShopItem(new GreenfootImage("ferret.png"), ferretP);
    ShopItem leopard = new ShopItem(new GreenfootImage("leopard.png"), leopardP);
    ShopItem otter = new ShopItem(new GreenfootImage("otter.png"), otterP);
    ShopItem tortoise = new ShopItem(new GreenfootImage("tortoise.png"), tortoiseP);
        
    //Cheat: makes sure player could only use the cheat once
    boolean cheated = false;
    /**
     * Constructor for objects of class Shop.
     * 
     */
    public Shop()
    {    
        super(960, 540, 1); 
        shop = this; // set reference to this world
 
        // add shop items & prices into HashMap
        items.put(ferret, ferretP);
        items.put(otter, otterP);
        items.put(leopard, leopardP);
        items.put(tortoise, tortoiseP);
        items.put(seal, sealP);
        items.put(panda, pandaP);
        
        //add shop items onto world
        int column = 0;
        for(ShopItem product : items.keySet())
        {
            int startX = getWidth()/2 - 310;
            if(column < 3){
                addObject(product, startX + column%3 * 230, 200);
            }
            else{
                addObject(product, startX + column%3 * 230, 400);
            }
            column++;
        }
    }
    
    public void act()
    {
        addObject(Title.currency, 125, 23); 
        addObject(Home.backToHome, 815, 440);
                
        // If user pressed on any shop item
        if(Greenfoot.mouseClicked(null))
        {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if(mouse == null) return;
            Actor actor = mouse.getActor();
            if(actor != null && actor instanceof ShopItem)
            {
                check((ShopItem)actor);
            }
        }
        checkCheat();
        Home.checkPause();
    }
    
    // This method checks if the player could buy the item
    private void check(ShopItem item)
    {
        int price = items.get(item);
        if(Critters.getCurrency() >= price && !item.bought) //if # of golden tickets is enough for the item & item is not bought
        {
            Title.cashSound.play();
            Critters.setCurrency(Critters.getCurrency()-price); // deduce cost from golden tickets
            boughtItems.add(price); // add the item into list of bought items
            item.soldOut();
        }
    }
    
    //This method allows the player to earn 100 Golden Tickets with the cheat code
    private void checkCheat()
    {
        if(!cheated && Greenfoot.isKeyDown("SPACE")) {
            Critters.setCurrency(Critters.getCurrency() + 100);
            cheated = true;
        }
    }
}
