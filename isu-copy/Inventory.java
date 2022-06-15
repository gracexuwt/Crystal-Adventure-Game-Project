import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * This is the inventory that stores items the player bought in Shop.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inventory extends World
{
    // Initialize array that contains prices of bought items
    private int[] prices = new int[Shop.boughtItems.size()];
    // Initialize HashMap that contains inventory items
    private HashMap<Integer, InventoryItem> itemImg = new HashMap<Integer, InventoryItem>();
    // Initialize ArrayList for inventory items
    private ArrayList<InventoryItem> items = new ArrayList<InventoryItem>();
    /**
     * Constructor for objects of class Inventory.
     * 
     */
    public Inventory()
    {    
        super(960, 540, 1); 
        
        addObject(Home.backToHome, 840, 80);
        
        // Add inventory items into HashMap
        itemImg.put(Shop.sealP, (new InventoryItem(new GreenfootImage("seal.png"), "Sparky the Seal", Shop.sealP)));
        itemImg.put(Shop.pandaP, (new InventoryItem(new GreenfootImage("panda.png"), "Miko the Red Panda", Shop.pandaP)));
        itemImg.put(Shop.leopardP, (new InventoryItem(new GreenfootImage("leopard.png"), "Trixie the Leopard", Shop.leopardP)));
        itemImg.put(Shop.tortoiseP, (new InventoryItem(new GreenfootImage("tortoise.png"), "Mr.Taco the Tortoise", Shop.tortoiseP)));
        itemImg.put(Shop.otterP, (new InventoryItem(new GreenfootImage("otter.png"), "Ozzie the Otter", Shop.otterP)));
        itemImg.put(Shop.ferretP, (new InventoryItem(new GreenfootImage("ferret.png"), "Robin Hood the Ferret", Shop.ferretP)));

        //Initialize array from Shop
        int x = 0;
        for(int n : Shop.boughtItems){
             prices[x] = n;
             x++;
        }
        
        // Merge sort the array from smallest to largest price
        MergeSort.sort(prices);
        
        // Find all the bought items and show it in the inventory
        for(int n : prices) // add the prices into the ArrayList to keep the correct order
        {
            items.add(itemImg.get(n));
        }
        int place = 0; 
        for(InventoryItem item : items) // shows the pictures onto the World
        {
            int startX = 235;
            if(place < 2){
                addObject(item, startX + place%2 * 482, 190);
            }
            else if (place >= 2 && place < 4){
                addObject(item, startX + place%2 * 482, 325);
            }
            else{
                addObject(item, startX + place%2 * 482, 460);
            }
            place++;
        }
    }
    
    public void act()
    {
        Home.checkPause();
    }
}
