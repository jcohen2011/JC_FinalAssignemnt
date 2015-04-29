/**
   Jacob Cohen - CS 110 - Final assignment - Player class
   Creates the various conditions and operations a player of war needs to play.
*/


import java.util.Collections;
import java.util.ArrayList;

public class Player
   {
   
   //Create ArrayList for the Player's Hand
   
   private ArrayList<Card> AIplayer = new ArrayList<Card>();
             
            /**
               @param ArrayList of Cards, will be half of a deck in War
               @returns Nothing, creates a player's hand object
            */
   
   public Player(ArrayList<Card> halfDeck)
      {
         for(int i = 0; i < halfDeck.size(); i++)
            {
               AIplayer.add(halfDeck.get(i));
            }
       }
       
            /**
               @param no input paramaters
               @returns the private ArrayList of the Ai players arrayList hand
            */ 
               
    public ArrayList<Card> getPlayerDeck()
      {
         return AIplayer;
      }
             
         /**
               @param no input paramaters
               @returns The rank of the top card of the AI player's hand.
                Returns -1 if there are no cards left
         */
     public int takeTurn()
      {
         if(AIplayer.isEmpty())
            {
               int card = -1;
            }
         int TopCard = AIplayer.get(0).getRank();
         return TopCard;
       }
       
            /**
               @param a Card to be added to the bottom of player's hand
               @returns a void.
            */
       
       public void addCard(Card card)
         {
            AIplayer.add(card);
         }
         
            /**
               @param No input parameter.
               @returns a void.
               Method removes the top card of the player's hand.
            */
       public void removeCard()
         {
            AIplayer.remove(0);
         }
       }   
      