import java.util.Arrays;
import javax.swing.JOptionPane;


public class Hangman
{
    public static void main(String args[])
    {
        //showMenu();
        //StartGame();
        char[] guessWord = {'_', 'a', '_', '_'};
        int numGuesses = 1;
        showProgress(guessWord, numGuesses);
    }
/*
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
        Arrays.fill(guessedWord, '_');

        Boolean isGuessed = false;
        int strikes = 0;
        while(strikes <= 5 || !isGuessed)
        {

        }
    }
*/

    public static int showMenu()
    {
      String strOption = JOptionPane.showInputDialog("Enter 1 to chose a random word\nEnter 2 to chose a word from the user\nEnter 3 to exit game");
      int option = Integer.parseInt(strOption) - 1;
      System.out.println(option);
      return option;
    }
/*
    public static String enterWord()
    {

    }

    public static String getRandomWord()
    {

    }

    public static Boolean TryLetter(char[] guessWord, char guessLetter, String word)
    {

    }
*/


    public static void showProgress(char[] guessWord, int numGuesses)
    {
      if (numGuesses != 1){
        JOptionPane.showMessageDialog(null, new String(guessWord) + "\nYou have " + numGuesses + " guesses left.");
      }else{
        JOptionPane.showMessageDialog(null, new String(guessWord) + "\nYou have " + numGuesses + " guess left.");
      }
    }

}
