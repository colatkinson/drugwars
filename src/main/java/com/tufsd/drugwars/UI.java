/** 
 * Class to contain all methods relating to user interaction.
 * @author SHCC Interface Team
 * @version 20141024
 */
package com.tufsd.drugwars;
import java.util.Scanner;

public class UI
{
    /**
     * Shows the logo and waits for user input before going to start screen.
     */
     public static void splashscreen()
    {   
        String logo = " ____                    __        __             \n"+
                      "|  _ \\ _ __ _   _  __ _  \\ \\      / /_ _ _ __ ___ \n"+
                      "| | | | '__| | | |/ _` |  \\ \\ /\\ / / _` | '__/ __|\n"+
                      "| |_| | |  | |_| | (_| |   \\ V  V / (_| | |  \\__ \\\n"+
                      "|____/|_|   \\__,_|\\__, |    \\_/\\_/ \\__,_|_|  |___/\n"+
                      "                  |___/                           \n"+
                      "                   ";

        String creds = "From the Sleepy Hollow High School Coding Club!\n"+
                       "Presidents: Colin Atkinson, Katie Brennan\n"+
                       "Advisor: Daniel Larkin\n"+
                       "https://github.com/shhs-coding-club/drugwars\n";

        System.out.println(logo);
        System.out.println(creds);
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Press return to continue...");  
        scanner.nextLine();
        startScreen();
    }
    
    /**
     * A placeholder function for the game main loop.
     */
    public static void dummyFunction()
    {
        System.out.println ("dummyFunction execute");
    }
    
    /**
     * Returns the String value selected in a simple text menu.
     * <p>
     * This method requires user input, so it may take a while to return.
     * 
     * @param   opts  an array of Strings containing menu options
     * @return        a String containing the chosen menu option
     */
    public static String menuGen (String[] opts)
    {
        Scanner menuScanner = new Scanner (System.in);
        int menuChoice;
        
        for (int i = 0; i < opts.length; i++)
        {
            System.out.println((i+1)+". "+opts[i]);
        }
        
        System.out.print("Enter a choice: ");
        
        menuChoice = menuScanner.nextInt();
        
        return opts[menuChoice-1];
    }
    
    /**
     * Asks user whether they want to start a new game or quit.
     */
    public static void startScreen ()
    {
        String[] opts = {"New Game", "Quit"};
        String select = menuGen(opts);
        
        System.out.println (select);
        if (select == "New Game")
        {
            dummyFunction();
        }
        else if (select == "Quit") 
        {
            System.exit(0);
        }
        else
        {
            System.out.println ("Unknown Option");
            System.exit(0);
        }
    }
}
