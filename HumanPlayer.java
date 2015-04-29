/**
   @author Jacob Cohen - CS 110 - Final assignment - Human player
   This class defines the player's commands that the game needs to operate. 
   It extends the Player class which defines the parameters of the player
*/
import java.util.Collections;
import java.util.ArrayList;


public class HumanPlayer extends Player
   {
      //Define players hand ArrayList
      private ArrayList<Card> humanPlayer = new ArrayList<Card>();   
            /**
               @param ArrayList<Card} that will be half of a full deck of cards
               @returns nothing, creates the HumanPlayer object.
            */      
      public HumanPlayer(ArrayList<Card> halfDeck)
         {
            super(halfDeck);
            humanPlayer = super.getPlayerDeck();
         }
            /**
               @param String of user input for 'yes or no' to play
               @returns int value that is the Rank of the top card in humanplayer's hand
                Returns -1 if the hand is empty or the player decides not to take a turn.
            */         
      public int takeTurn(String response)
         {
            int thisCard = -1;
            if(response.equalsIgnoreCase("y")) //If cards are the same
               {
                  if(humanPlayer.isEmpty()) //If no cards left in hand
                     {
                        thisCard = -1;
                     }
                   thisCard = humanPlayer.get(0).getRank(); // Check top card value
                }
                else if (response.equalsIgnoreCase("n")) //If cards dont match
                  {
                     thisCard = -1; 
                  }
                  return thisCard;
           }
           
            /**
               @param no input paramaters
               @returns The ArrayList<Card> for the Human's hand of cards
            */      
     public ArrayList<Card> getHumanDeck()
         {
            return humanPlayer;
         }
            /**
               @param A Card object to be added to the player's hand
               @returns a void.
            */ 
      public void addCard(Card card)
         {
            humanPlayer.add(card);
         }

            /**
               @param No input param
               @returns a void
               Removes the card from the top of the ArrayList of humanplayer's hand
            */
                   
       public void removeCard()
         {
            humanPlayer.remove(0);
         }
   }  
            
            
                   