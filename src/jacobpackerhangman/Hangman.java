package jacobpackerhangman;

//Project :  <JacobPackerHangMan>
//File    :  <Hangman.java>
//Name    :  <Jacob Packer>
//Date    :  <9-5-2014>
//This is my UI class that manipulates my HangMan Class.

public class Hangman 
{
    private int lives;
    private String wordOfQuestion;
    private char [] wordDisplayedToUser;
    
    //The method below is my constructor.  It is used to asign all of my attributes, values.
    public Hangman (int livesX, String someWord)
    {
        lives = livesX; 
        wordOfQuestion = someWord;  
        wordDisplayedToUser = wordOfQuestion.toCharArray();
        
        for (int i=0; i < wordOfQuestion.length(); i++)
        {
            wordDisplayedToUser [i] = '_';
        }
    }
    
    //The method below goes through the logic that decides if the guess was correct or not.
    public boolean guess (char c)
    {
        boolean correctGuess = false;
        for (int i=0; i < wordOfQuestion.length(); i++)
        {
            if (c == wordOfQuestion.charAt(i))
            {
                wordDisplayedToUser [i] = c;
                correctGuess = true;
            } 
        }
        
        if (correctGuess)
        {
            return true;
        }
        else
        {
            lives--;
            return false;
        } 
    }
    
    //This Method checks to see if the requirements for victory have been met.
    public boolean checkWin()
    {
        String temp = ""; 
        for (int i=0; i < wordOfQuestion.length(); i++)
        {
            temp = temp + wordDisplayedToUser [i];
        }
        if (temp.equals(wordOfQuestion))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    //Returns the current amount of lives
    public int getLives()
    {
        return lives;
    }
    
    //Returns the unkown word that the user is trying to guess.
    public String getWordOfQuestion()     
    {
       return wordOfQuestion;
    }
    
    //Returns the array of chars that is used for storing the _ and correct guesses of the user. 
    public char[] getGuessedCharInArray()
    {
        return wordDisplayedToUser;
    }
}
