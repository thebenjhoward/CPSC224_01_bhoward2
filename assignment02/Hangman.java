import java.util.Arrays;
import javax.swing.JOptionPane;
import java.util.Random;

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
        char[] guessedWord = new char[word.length() * 2];
        Arrays.fill(guessedWord, '-');

        Boolean isGuessed = false;
        int strikes = 0;
        while(strikes <= 5 || !isGuessed)
        {

        }
    }

    public static int showMenu()
    {

    }

    public static String enterWord()
    {
        return JOptionPane.showInputDialog("Enter your desired word");
    }

    public static String getRandomWord()
    {
        String[] wordList = { "antidisestablishmentarianism", "no", "bubbles", 
        "sunshine", "help", "happiness", "I am being held against my will",
        "supercalifragilisticexpialidocious", "fear", "anger", "hate", "suffering",
        "pneumonoultramicroscopicsilicovolcanoconiosis", "the quick brown fox jumped "
        + "over the lazy black dog" };

        Random rand = new Random();
        return wordList[rand.nextInt(wordList.length)];
    }

    public static Boolean TryLetter(char[] guessWord, char guessLetter, String word)
    {
        Boolean success = false;
        Boolean alreadyEntered = false;
        for(int i = 0; i < word.length(); i++)
        {
            if(guessWord[i] == '-' && word.charAt(i) == guessLetter)
            {
                success = true;
                guessWord[i] = guessLetter;
            }
            else if(guessWord[i] == guessLetter)
            {
                alreadyEntered = true;
            }
        }

        if(success)
        {
            JOptionPane.showMessageDialog(null, "You guessed a letter!");            
        }
        else if(alreadyEntered)
        {
            JOptionPane.showMessageDialog(null, "You already guessed that letter!");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Sorry, that is incorrect.");
        }
        return success || alreadyentered;
    }

    public static void showProgress(char[] guessWord, int numGuesses)
    {

    }

    public static void addSpaces(char[] guessWord, String word)
    {
        for(int i = 0; i < word.length(); i++)
        {
            if(word.charAt(i) == ' ')
            {
                guessWord[i] = ' ';
            }
        }
    }

}