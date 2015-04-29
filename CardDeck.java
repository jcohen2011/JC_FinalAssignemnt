/** 
   @author Jacob Cohen - CS 110 - Final Assignment - Deck Class
   Creates an ArrayList of Card objects to make a whole deck. Shuffles the deck and
   implements a getter and a size of the array checker.
   
*/
import java.util.Collections;
import java.util.ArrayList;

public class CardDeck
      {
         //Standard card deck size and card limits
         private final static int MAX_DECK = 52;
         private final int RANKS = 14;
         private final int SUITS = 4;
         
         //Create arraylist to store cards in
         private ArrayList<Card> mainDeck;
         
         
         /**
            @param  No input param
            Creates 52 card deck and then shuffles it
         */
         public CardDeck()
            {
               mainDeck = new ArrayList<Card>();
               
               for( int i = 1; i < SUITS +1; i++)
                  {
                     for(int j = 2; j< RANKS +1 ; j++)
                        {
                           Card nextCard = new Card(j,i);
                           mainDeck.add(nextCard);
                           //System.out.println(nextCard);
                           //System.out.println(mainDeck);
                        }
                   }
                Collections.shuffle(mainDeck); //Shuffle here
            }
            
            /**
               @returns size of the ArrayList that is the Deck as int
            */
            
            public int deckSize()
               {
                  return mainDeck.size();
               }
               
            /**
               @param no input paramaters
               @returns the private ArrayList of the card ArrayList
            */
            public ArrayList<Card> getDeck()
               {
                  return mainDeck;
               }   
       }