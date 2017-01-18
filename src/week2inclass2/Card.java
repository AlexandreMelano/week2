/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week2inclass2;

/**
 *
 * @author User1
 */
public class Card {
    private String faceName, suit;
    private int faceValue;
    
    public Card(String face, String suit, int value)
    {
        faceName = face; // faceName in pink means its a global variable
        setSuit(suit);
        setValue(value);
    }//end of constructor
    
    // this method will return a sString to represent the Card
    public String toString()
    {
        return faceName + " of " + suit;
    
    }// end of toString
    
    // This method will validate if the suit sis valie i.e hearts, diamonds, spades or clubs
    private void setSuit(String suit)
    {
        if (suit.equalsIgnoreCase("hearts") || suit.equalsIgnoreCase("diamonds") || suit.equalsIgnoreCase("spades") || suit.equalsIgnoreCase("clubs"))
        {
            this.suit = suit;
        
        }
        else 
            throw new IllegalArgumentException ("Suit must be hearts, diamonds, spades, or clubs");
                
    }// end of setSuit
    
    
    // this will validate the input is between 2 - 14 and set the card value
    private void setValue(int value)
    {
        if (value < 2 || value > 14)
            throw new IllegalArgumentException ("Face value must be 2-14");
        else
            faceValue = value;
        
    
    }// end of setValue

    public String getFaceName() {
        return faceName;
    }

    public String getSuit() {
        return suit;
    }

    /**
     *  This method returns face value of the card
     * @return an INT in the range 2-14
     */
    public int getFaceValue() {
        return faceValue;
    }
    
    
    
}// end of Card
