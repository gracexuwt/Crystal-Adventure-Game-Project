import java.util.*;
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class is the rock paper scissors game.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RockPaperScissor extends World
{
    // Buttons for player to interact with
    private Button rock = new Button(new GreenfootImage("Rock.png"));
    private Button paper = new Button(new GreenfootImage("Paper.png"));
    private Button scissors = new Button(new GreenfootImage("Scissors.png"));
    // Computer images for rock, paper, scissors
    private Picture computerRock = new Picture(new GreenfootImage("computerRock.png"));
    private Picture computerPaper = new Picture(new GreenfootImage("computerPaper.png"));
    private Picture computerScissors = new Picture(new GreenfootImage("computerScissors.png"));
    
    // Strings to be showed to the player when they win/tie/lose
    private String playerWonRound = "You win this round!";
    private String computerWonRound = "You lost this round";
    private String playerTie = "It's a tie!";
    // Initialize actors for strings above
    private Picture winString = new Picture(new GreenfootImage(playerWonRound, 40, Color.BLACK, new Color(0,0,0,0)));
    private Picture loseString = new Picture(new GreenfootImage(computerWonRound, 40, Color.BLACK, new Color(0,0,0,0)));
    private Picture tieString = new Picture(new GreenfootImage(playerTie, 40, Color.BLACK, new Color(0,0,0,0)));
    
    // Stores the user choice and computer choice for the game
    private String userInput = "";
    private String computerInput;
    
    // Number of wins for the player vs the computer
    private Counter playerWins = new Counter();
    private Counter computerWins = new Counter();
    
    private boolean ticketsAdded = false; // boolean to make sure tickets are only added once
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public RockPaperScissor()
    {    
        super(960, 540, 1); 
        //Add Player interactive buttons
        addObject(rock, 280, 430);
        addObject(paper, 480, 430);
        addObject(scissors, 680, 430);
        //Add Golden tickets Counter
        addObject(Title.currency, 150, 520);
    }
    
    // Gets the computer input (random rock, paper or scissors)
    private String getComputerInput()
    {
        Random r = new Random();
        int n = r.nextInt(3);
        if(n == 0) return "rock";
        if(n == 1) return "paper";
        return "scissors";
    }
    
    // According to computer input, get the corresponding computer image
    private void getComputerImage(String str)
    {
        if(str.equals("rock")) addObject(computerRock, 470, 195);
        else if(str.equals("paper")) addObject(computerPaper,470, 195);
        else if(str.equals("scissors")) addObject(computerScissors, 470, 195);
    }
    // After delay, remove the computer image & string text
    private void removeCompImg()
    {
        removeObject(computerRock);
        removeObject(computerPaper);
        removeObject(computerScissors);
        removeObject(tieString); 
        removeObject(loseString);
        removeObject(winString);
    }
    
    // Get the winner: player or computer or tie
    private String getWinner(String user, String computer)
    {
        if(user.equals("rock")){
            if(computer.equals("paper")) return computerWonRound;
            else if(computer.equals("scissors")) return playerWonRound;
        }
        else if(user.equals("paper") && computer.equals("scissors")){
            return computerWonRound;
        }
        else if(user.equals("scissors") && computer.equals("paper")){
            return playerWonRound;
        }
        else if(computer.equals("rock")){
            if(user.equals("scissors")) return computerWonRound;
            return playerWonRound;
        }
        return playerTie;
    }
    
    // Checks if player won, computer won, or tie. 
    private void checkWin(String str)
    {
        if(str.equals(playerWonRound))
        {
            Title.winSound.play();
            playerWins.add();
            addObject(winString, 480, 300);
        }
        else if(str.equals(computerWonRound))
        {
            Title.loseSound.play();
            computerWins.add();
            addObject(loseString, 480, 300);
        }
        else if(str.equals(playerTie))
        {
            addObject(tieString, 480, 300);
        }
        getComputerImage(computerInput);
        Greenfoot.delay(50); // time for player to see the string
        removeCompImg();
    }
    
    // If the game ends, end screen pops up
    private void gameEndScreen()
    {
        if(playerWins.getScore() >= 5) // player wins
        {
            setBackground(new GreenfootImage("rps-winscreen.png"));
            if(!ticketsAdded)
            {
                Critters.setCurrency(Critters.getCurrency()+30);
            }
            ticketsAdded = true;
        }
        else // computer wins
        {
            setBackground(new GreenfootImage("rps-losescreen.png")); 
            if(!ticketsAdded)
            {
                if(Critters.getCurrency() >= 10)
                {
                    Critters.setCurrency(Critters.getCurrency() -15);
                }
                else
                {
                    Critters.setCurrency(0);
                }
            }
            ticketsAdded = true;
        }
        //remove player interactive buttons
        removeObject(rock);
        removeObject(paper);
        removeObject(scissors);
        
        //Set game as played
        Title.gamesPlayed[1] = true;
    }
    
    public void act()
    {
        //Add player and computer score counter
        addObject(playerWins, 200, 300);
        addObject(computerWins, 760, 300);
        
        // Random computer rock/paper/scissors
        computerInput = getComputerInput();
        
        // Player chooses rock, paper, or scissors
        if(Greenfoot.mouseClicked(rock))
        {
            userInput = "rock";
            String str = getWinner(userInput, computerInput);
            checkWin(str);
        }
        else if(Greenfoot.mouseClicked(paper))
        {
            userInput = "paper";
            String str = getWinner(userInput, computerInput);
            checkWin(str);
        }
        else if(Greenfoot.mouseClicked(scissors))
        {
            userInput = "scissors";
            String str = getWinner(userInput, computerInput);
            checkWin(str);
        }
        // Reset user & computer input
        userInput = "";
        computerInput = "";
        
        //Check if player or computer hits 5 points first, then pop up game end screen
        if(playerWins.getScore() >= 5 || computerWins.getScore() >= 5)
        {
            addObject(Home.backToHome, 480, 383);
            gameEndScreen();
            Home.checkPause();
        }
    }
}
