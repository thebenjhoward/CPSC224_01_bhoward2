import java.util.Arrays;
import javax.swing.JOptionPane;

public class Hangman
{
    public static void main(String args[])
    {
        StartGame();
    }

    public static void StartGame()
    {
        switch(showMenu())
        {
            case 0:
            RunGame(getRandomWord());
            break;

            case 1:
            RunGame(enterWord());
            break;

            case 2:
            break;
        }

    }

    public static void RunGame(String word)
    {
        char[] guessedWord = new char[word.Length() * 2];
        Array.fill(guessedWord, '_');

        Boolean isGuessed;
        int strikes;
        while(strikes <= 5 || !isGuessed)
        {

        }
    }

    public static int showMenu()
    {

    }

    public static String enterWord()
    {
        
    }

    public static String getRandomWord()
    {

    }

    public static Boolean TryLetter(char[] guessWord, char guessLetter, String word)
    {
        
    }

    public static void showProgress(char[] guessWord, int numGuesses)
    {

    }



}