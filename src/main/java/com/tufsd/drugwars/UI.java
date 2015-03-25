package com.tufsd.drugwars;
import java.util.Scanner;
import java.util.Set;
import java.text.NumberFormat;

/**
 * Drug Wars interface
 * @author Drug Lords Abigail (Team BADASSNESS!!!!!!)
 *
 *
 */
public class UI
{
    /**
     * Shows the Drug Wars logo and waits for the user to press enter.
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
        System.out.print("Press enter to continue...");
        scanner.nextLine();
        startScreen();
    }

    /**
     * Shows the initial text and initializes and runs a new Game.
     */
    public static void initText()
    {
        String name;
        Scanner scan = new Scanner(System.in);
        System.out.println ("You owe $10,000 to a loan shark. You've got 30 days to earn it back by selling drugs. Start now.");
        System.out.print("What is your name? ");
        name = scan.nextLine();
        Game game = new Game(name);
        game.run();
    }

    /**
     * Lets the user decide if they want to start a new game or quit.
     */
    public static void startScreen ()
    {
        String[] opts = {"New Game", "Quit"};
        String select = menuGen(opts);

        System.out.println (select);
        if (select.equals("New Game"))
        {
            initText();
        }
        else if (select.equals("Quit") )
        {
            System.exit(0);
        }
        else
        {
            System.out.println ("Unknown Option");
            System.exit(0);
        }
    }

    /**
     * Generates a menu for users from an array.
     *
     * @param opts an array of Strings containing menu options
     * @return the string value of the selected menu option
     */
    public static String menuGen (String[] opts)
    {
        Scanner menuScanner = new Scanner (System.in);
        int menuChoice;
        System.out.println();
        for (int i = 0; i < opts.length; i++)
        {
            System.out.println((i+1)+". "+opts[i]);
        }

        menuChoice = menuScanner.nextInt();

        return opts[menuChoice-1];
    }

    public static void playerInfo(Player player)
    {
        System.out.println();
        System.out.println("Player Summary");
        System.out.println("\tName: " + player.name);
        System.out.println("\tHealth: " + player.health);
        System.out.println("\tInventory: " + player.inv);
        NumberFormat money = NumberFormat.getCurrencyInstance();

        System.out.println("\tDebt: " + money.format(player.debt));
        System.out.println();
    }
    
    public static void outputInventory (Player player)
    {
        System.out.print("Player Inventory: ");
        for (Drug whatever: player.inv.keySet())
        {
            System.out.print( " " + whatever + " " + player.inv.get(whatever));
        }
    }
    
    public static Location locationMenu()
    {
       String[] new1 = Location.names();
       System.out.println();
       System.out.println("Where to?");
       String val = menuGen(new1);
       return Location.valueOf(val);
    }
    
    public static Drug drugMenu(Player player)
    {
        Set<Drug> myset = player.inv.keySet();
        String[] new1 = new String[myset.size() + 1];
        int i = 0;
        for(Drug drug : myset)
        {
            new1[i] = drug.toString();
            i++;
        }
        new1[myset.size()] = "Cancel";
        System.out.println();
        System.out.println("Which drug would you like to sell?");
        String val = menuGen(new1);
        
        if(!val.equals("Cancel"))
            return Drug.valueOf(val);
        else
            return null;
    }
    
    public static void drugSell(Drug d, Player player)
    {
        if(d != null)
        {
            System.out.print("How many? ");
            System.out.println("(0-" + player.inv.get(d) + ")");
        }
    }
    
    public static void gameMenu(Player player)
    {
        String[] options ={"Location", "BuySell"};
        
        String val = menuGen(options);
        
        if(val.equals("Location"))
        {
            locationMenu();
        }
        else if(val.equals("BuySell"))
        {
            drugMenu(player);
        }
        
    }
  
    
 
}
   
