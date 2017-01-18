/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week2inclass2;

import java.util.ArrayList;

/**
 *
 * @author User1
 */
public class gameOfWar { // this class consist of the rules for 'war'
    private ArrayList<Card> p1Hand;
    private ArrayList<Card> p2Hand;
    
    public gameOfWar(){
   
        p1Hand = new ArrayList<>();
        p2Hand = new ArrayList<>();
        
        deckOfCards theDeck = new deckOfCards();
        theDeck.shuffle();
        
        dealTheCards(theDeck);
    }// end of GameOfWar
    
// this method will "deal all ofthe cards to the player if card is even p1 gets card, if uneven p2 gets card
    private void dealTheCards(deckOfCards theDeck){
    
    for (int cardNum=0; cardNum < 52; cardNum++)
    {
        if (cardNum % 2 == 0)
            p1Hand.add(theDeck.dealTopCard());
        else
            p2Hand.add(theDeck.dealTopCard());
    }
    
    }// end of dealTheCards
    
    // this method will simulate playing the Game called 'war'
    public void playTheGame(){
        
        while (!p1Hand.isEmpty() && !p2Hand.isEmpty()) // ! means NOT empty %% = and !p2 not empty
        {
            playHand();
        }
        
        if (p1Hand.isEmpty())
            System.out.println("Player 2 is the winner");
        else
            System.out.println("Player 1 is the winner");
    }//end of playTheGame
        
    //this method will simulate playing 1 hand of 'war'
    private void playHand(){
        
        Card p1Card = p1Hand.remove(0); //the remove(0) = remove from position
        Card p2Card = p2Hand.remove(0);
        
        // player 1s card is high then p2 so p1 gets both cards
        if (p1Card.getFaceValue() > p2Card.getFaceValue()){
            
            p1Hand.add(p1Card); 
            p1Hand.add(p2Card);
        }
        
        // player 2s card is higher then p1s
        else if (p2Card.getFaceValue() > p1Card.getFaceValue()){
        
            p2Hand.add(p1Card);
            p2Hand.add(p2Card);
        }
        
        // otherwise its 'war'
        else{
            
            ArrayList<Card> warPile = new ArrayList<>();
            warPile.add(p1Card);
            warPile.add(p2Card);
            playWarHand(warPile); // passes warPile to playWarHand
            
        }
        
    }// end of playHand()
            
    /**
     * This method will simulate playing the 'war' hand
     */
    private void playWarHand(ArrayList<Card> warPile){
        //check if player has enough cards
        if (p1Hand.size() < 3)
        {
            p2Hand.addAll(p1Hand);
            p1Hand.clear();
            p2Hand.addAll(warPile);
        }
        
        // each player puts 2 cards ofthe pile and then preps the 3rd card
        warPile.add(p1Hand.remove(0));
        warPile.add(p1Hand.remove(0));
        warPile.add(p2Hand.remove(0));
        warPile.add(p2Hand.remove(0));
        
        Card p1Card = p1Hand.remove(0);
        Card p2Card = p2Hand.remove(0);
        
        if (p1Card.getFaceValue() > p2Card.getFaceValue())
        {
            p1Hand.addAll(warPile);
            p1Hand.addAll(p1Hand);
            p1Hand.addAll(p2Hand);
            
        }
    }// end of playWarHand
    
    
}// end of class 
