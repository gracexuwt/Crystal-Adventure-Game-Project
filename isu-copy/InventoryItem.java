import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InventoryItem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InventoryItem extends Actor
{
    private GreenfootImage board = new GreenfootImage(388, 94);
    private Color pink = Color.WHITE;
    private Color darkRed = new Color(255, 198, 243);
    private Font fnt1 = new Font(true, false, 25);
    private Font fnt2 = new Font(true, false, 15);
    
    public InventoryItem(GreenfootImage img, String name, int price)
    {
        board.setColor(darkRed);
        board.fill();
        board.setColor(Color.WHITE);
        board.fillRect(5, 5, 84, 84);
        setImage(board);
        img.scale(84, 84 * img.getHeight() / img.getWidth());
        board.drawImage(img, 5, 5);
        board.setColor(pink);
        board.setFont(fnt1);
        board.drawString(name, 100, 40);
        board.setFont(fnt2);
        board.drawString(String.valueOf(price) + " Critters", 100, 75);
    }
}
