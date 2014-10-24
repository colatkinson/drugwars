package com.tufsd.drugwars;


/**
 * A class containing information on players.
 * 
 * @author SHCC Game Logic Team
 * @version 20141024
 */
public class Player
{
    // instance variables - replace the example below with your own
    private int y;

    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        //Inv:
        
        int money = 250;
        int ammo = 18;
        int beer = 0;
        int pot = 0;
        int coke = 0;
        int meth = 0;
        int bong = 0;
        int lighter = 0;
        
        //stats
        
        int health = 100; //it's health, what do you think
        int dunkness = 0; //the more you drink, the higher it is
        int highness = 0; //you know what it is
        int stanima = 100; //how long you run
        int tiredness = 10; //get sleep
        
        //Goals

        int days = 31; //days until the loan shark comes
        int bounty = 0; //illigal things = bigger bounty
    }
}
