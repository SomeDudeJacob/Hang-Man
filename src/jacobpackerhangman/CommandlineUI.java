package jacobpackerhangman;

//Project :  <JacobPackerHangMan>
//File    :  <CommandlineUI.java>
//Name    :  <Jacob Packer>
//Date    :  <9-5-2014>
//This is my UI class that manipulates my HangMan Class.

import java.io.InputStreamReader;
import java.util.Scanner;

public class CommandlineUI 
{
    Scanner io;
    Hangman game;
    
    //Below is my constructor that creates my game object.  My constructor will always initialize the 
    //attributes of my class (state).
    public CommandlineUI()
    {  
        String f = "Farm"; 
        game = new Hangman(6, f.toLowerCase());         
        io = new Scanner(new InputStreamReader(System.in));
    }
    
    //This method is called after this class is instantiated, and it starts the HangMan Game.
    public void play()
    {
        char tempChar = '@';
        paintHangMan();
        while(game.getLives() > 0 && game.checkWin() == false)
        {
            System.out.println("Please Enter a Character (char):       " + "Number of Lives Left:" + game.getLives());
            tempChar = io.nextLine().toLowerCase().charAt(0);
            game.guess(tempChar);
            paintHangMan();
            if (game.checkWin() == true)
            {
                System.out.println("Congratulations You Win!");
            }
        }
    }
    
    //The method below is used to paint parts of Hangman to the screen, as the game progresses.
    private void paintHangMan()
    {
        String temp = "";
        char [] tempArray = game.getGuessedCharInArray();
        
        for (int i = 0;i < game.getWordOfQuestion().length(); i++)
        {
            temp = temp + " " + tempArray [i];
        }
        switch (game.getLives()) 
        {
            case 0:  System.out.println(" |--, \n" + " |  O \n" + " | /|\\\n"  + " | / \\\n" + "_|____\n" + temp + "\n You Have Lost" + "\n\n"); 
                     break;
            case 1:  System.out.println(" |--, \n" + " |  O \n" + " | /|\\\n"  + " | /  \n" + "_|____\n" + temp + "\n\n");
                     break;
            case 2:  System.out.println(" |--, \n" + " |  O \n" + " | /|\\\n"  + " |    \n" + "_|____\n" + temp + "\n\n");
                     break;
            case 3:  System.out.println(" |--, \n" + " |  O \n" + " | /|  \n"  + " |    \n" + "_|____\n" + temp + "\n\n");
                     break;
            case 4:  System.out.println(" |--, \n" + " |  O \n" + " |  | \n"  + " |    \n" + "_|____\n" + temp + "\n\n");
                     break;
            case 5:  System.out.println(" |--, \n" + " |  O \n" + " |    \n"  + " |    \n" + "_|____\n" + temp + "\n\n");
                     break;
            case 6:  System.out.println(" |--, \n" + " |    \n" + " |    \n"  + " |    \n" + "_|____\n" + temp + "\n\n");
                     break;
        }
    }
}
