/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week2inclass2;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author User1
 */
public class deckOfCards{
    
    private ArrayList<Card> deck;
    
    //this constructor is my deck of cards
    public deckOfCards(){
        
        deck = new ArrayList<>();
        String [] suits = {"hearts","spades","clubs","diamonds"};
        String [] faceNames = {"two","three","four","five","six","seven","eight","nine","ten","jack","queen","king","ace"};
        
        
        for (String suit : suits)// loops over suits w Enhanced for loop
        {
            for (int i=0; i < faceNames.length; i++)
            {
                Card newCard = new Card(faceNames[i],suit, i + 2);
                deck.add(newCard);
            }
        
        }
    }// end of constructor


    //this method will return a string representing the deck of cards
    public String toString(){
    
        String deckString = "";
        
        for (Card card : deck)
        {
            deckString += card.toString() + "\n";
        }
     
        return deckString;
    }// end of toString
    
    
    //this method will shuffle the deck of cards
    public void shuffle(){
        
        Collections.shuffle(deck);
    
    }//end of shuffle
    
    // this method will deal top card off the deck
    public Card dealTopCard(){
      
        if (deck.isEmpty())
            return null;
        else return deck.remove(0);
    }
    
     
            
}// end of main

