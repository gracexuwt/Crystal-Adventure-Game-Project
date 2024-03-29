import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An achievement with a progress bar
 * 
 * @Melanie
 * @version 1
 */
public class Achievement extends Actor
{
    private final int BAR_LENGTH = 285;
    private final int BAR_HEIGHT = 10;
    private int progress;
    private int total;
    private GreenfootImage ach;
    private Color greyedYellow = new Color(219, 202, 215);
    private Color yellow = Color.PINK;
    public Achievement(GreenfootImage theAch, int theProgress, int theTotal)
    {
        progress = theProgress;
        ach = theAch;
        total = theTotal;
    }
    
    //Draws the progress bar
    private GreenfootImage progressBar(int progress, int total)
    {
        double percentReached = progress/(double)total;
        GreenfootImage bar;
        if(percentReached == 0.0){
            bar = new GreenfootImage(1, BAR_HEIGHT);
        }else{
            bar = new GreenfootImage((int) (BAR_LENGTH * percentReached) + 1, BAR_HEIGHT);
        }
            
        bar.setColor(yellow);
        bar.fill();
        return bar;
    }
    
    //Updates the progress
    public void setProgress(int prog)
    {
        progress = prog;
    }
    
    public void act() 
    {
        // Draws the prgress bar
        ach.setColor(greyedYellow);
        ach.fillRect(97, 60, BAR_LENGTH, BAR_HEIGHT);
        ach.drawImage(progressBar(progress, total), 97, 60);
        setImage(ach);
    }    
}
