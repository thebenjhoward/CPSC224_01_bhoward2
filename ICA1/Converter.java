import java.util.Scanner;

public class Converter
{
    public static void main(String[] args)
    {
        Scanner scnr = new Scanner(System.in);
        double inputValue;

        inputValue = getInput(scnr);
        
        boolean quit = false;
        while(!quit)
        {
            switch(selectMenuOption(scnr))
            {
                case 1:
                showKilometers(inputValue);
                break;
                case 2:
                showInches(inputValue);
                break;
                case 3:
                showFeet(inputValue);
                break;
                case 4:
                quit = true;
                System.out.println("\nBye!");
                break;
                default:
                System.out.println("Unknown command");
                break;
            }
        }

        scnr.close();
    }

    public static double getInput(Scanner scnr)
    {
        double value = -1;
        while(value < 0)
        {
            System.out.print("Enter a distance in meters: ");
            value = scnr.nextDouble();
            if(value < 0)
            {
                System.out.println("Please enter a positive value");
            }
        }
        return value;
    }

    public static void showKilometers(double meters)
    {
        System.out.println(meters * 0.001);
    }

    public static void showInches(double meters)
    {
        System.out.println(meters * 39.37);
    }

    public static void showFeet(double meters)
    {
        System.out.println(meters * 3.281);
    }

    public static void menu()
    {
        System.out.println("1. Convert to kilometers");
        System.out.println("2. Convert to inches");
        System.out.println("3. Convert to feet");
        System.out.println("4. Quit the program");
    }

    public static int selectMenuOption(Scanner scnr)
    {
        menu();
        System.out.print("Enter Your Choice: ");
        return scnr.nextInt();
    }
}