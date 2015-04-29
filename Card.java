/** 
   @author Jacob Cohen - CS 110 - Final Assignment - Card Class
   
   This class is for creating cards. It defines cards by rank and suit.
   Card values are constant and cannot be manipulated outside the class because static and final.
   
*/

public class Card {
    private final int rank;
    private final int suit;

    // Kinds of suits
    public final static int DIAMONDS = 1;
    public final static int CLUBS    = 2;
    public final static int HEARTS   = 3;
    public final static int SPADES   = 4;

    // Kinds of ranks
    public final static int ACE   = 1;
    public final static int TWO = 2;
    public final static int THREE = 3;
    public final static int FOUR  = 4;
    public final static int FIVE  = 5;
    public final static int SIX   = 6;
    public final static int SEVEN = 7;
    public final static int EIGHT = 8;
    public final static int NINE  = 9;
    public final static int TEN   = 10;
    public final static int JACK  = 11;
    public final static int QUEEN = 12;
    public final static int KING  = 13;
    

            /**
               @param ints for rank and suit of the card
               @returns nothing, creates the card object
            */ 
    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

            /**
               @param no input paramaters
               @returns the int of the rank for that card
            */ 
    public int getRank() {
        return rank;
    }
    //Returns suit as string from interger input
    String suitName;  //defined outside because didnt work within

            /**
               @param no input paramaters
               @returns String that corresponds to the previously defined suit
            */     
    public String getSuit()
       {
         switch(suit)
            {
               case 1:
                     suitName = "Diamonds";
                     break;
               case 2:
                     suitName = "Clubs";
                     break;
               case 3:
                     suitName = "Hearts";
                     break;
               case 4:
                     suitName = "Spades";
                     break;
              }
         return suitName;     
         }
            /**
               @param int of the rank
               @returns String for the royalty of that card
            */     
    public String getRankName(int rank)
    {
      String rankName = "" + rank;
      switch(rank)
         {
            case 11:
                  rankName = "Jack";
                  break;
            case 12:
                  rankName = "Queen";
                  break;
            case 13:
                  rankName = "King";
                  break;
            case 14:
                  rankName = "Ace";
                  break;
                  
           }
      return rankName;     
      }
            /**
               @param no input paramaters
               @returns String for the full title of a card, including both the rank and suit
            */ 
    public String toString()
     {
        String TS = this.getSuit();
        String cardName = " " + this.getRankName(rank)+ " of " + TS;
        return cardName;
     }
            /**
               @param Card to be comapred to
               @returns boolean to check the rank of the two cards.
            */      
     public boolean equals(Card c)
     {
      boolean comparison;
      if(c.getRank() == rank)
         {
            comparison = true;
         }
      else
         {
            comparison = false;
         }
       return comparison;
      }
    }
  