/**
   @author Jacob Cohen - CS 110 - Final Assignemnt
   War class - This class contains all the rules and procedures for
   the game itself, including when a 'wars' occur (method), common gaming proceedure
*/
import java.util.Scanner;
import java.util.ArrayList;


public class War
   {
      /*
         Initializes the various card piles needed in the procedures
         to complete operations.
      */
      private ArrayList<Card> faceDown = new ArrayList<Card>();
      private ArrayList<Card> humanWar = new ArrayList<Card>();
      private ArrayList<Card> AI_War = new ArrayList<Card>();
      private ArrayList<Card> humanDeck = new ArrayList<Card>();
      private ArrayList<Card> AI_Deck = new ArrayList<Card>();
      
      //Initialize player objectes, the players operational input, and turns accumulator
      private HumanPlayer human;
      private Player computer;
      private Player AI;
      private String response;
      private int turns = 0;
      
            /**
               @param no input paramaters
               @returns nothing
               This is the primary constructor for the War class, containing the procedure for a single
               game, win conditions, and order of operations for playing.
            */ 
                  
      public War()
         {
            System.out.println("Let's play War!");
            Scanner input = new Scanner(System.in);
            CardDeck deck = new CardDeck();
            boolean winning = false;
            
            for(int i = 0; i < (deck.deckSize()/2) ; i++) //Fill player's deck with main deck
               {
                  humanDeck.add(deck.getDeck().get(i));
               }
             for(int i = deck.deckSize()/2 ; i < deck.deckSize(); i++) //Fill AI deck
               {
                  AI_Deck.add(deck.getDeck().get(i));
               }
               
            //Save the distributed cards to the player's arrayList hands
            
            computer = new Player(AI_Deck); //Creates AI player Hand
            human = new HumanPlayer(humanDeck);// Creates Human player
            
            System.out.print("Take turn? (Y/N): ");
            response = input.nextLine (); //Check for players next turn
            
            while(human.takeTurn(response) != -1 && computer.takeTurn() != -1) //As long as both hands have cards and human wants to play
               {
                  System.out.println("Player card: " + human.getHumanDeck().get(0));
                  System.out.println("Computer card: " + computer.getPlayerDeck().get(0));
                  
                  if(human.getHumanDeck().get(0).getRank() > computer.getPlayerDeck().get(0).getRank()) // If human wins
                     {
                        human.addCard(computer.getPlayerDeck().get(0)); //Add AI card to Human hand
                        human.addCard(human.getHumanDeck().get(0)); // Add Humans card to bottom of humans deck
                        human.removeCard(); //Remove top card of Human hand
                        computer.removeCard(); //Remove top card of AI hand
                        System.out.println("Human wins!");
                     }
                  else if (human.getHumanDeck().get(0).getRank() < computer.getPlayerDeck().get(0).getRank()) //If AI wins
                     {
                        computer.addCard(human.getHumanDeck().get(0)); //Add human card to AI hand
                        computer.addCard(computer.getPlayerDeck().get(0)); //Add Ai card to bottom of AI hand
                        computer.removeCard();  //Remove top card of AI hand
                        human.removeCard();     //Remove top card of human hand
                        System.out.println("AI Wins");
                      }
                   else //if there is a War
                     {
                        boolean win = warGames(human, computer); //boolean equals return of warGames method
                        if(win)
                           {
                              while(!humanWar.isEmpty())
                                 {
                                    human.addCard(humanWar.get(0));//add all Card's to the human
                                    humanWar.remove(0);
                                 }
                               while(!faceDown.isEmpty())
                                 {
                                    human.addCard(faceDown.get(0));
                                    faceDown.remove(0);
                                 }
                            }
                         else
                           {
                              while(!AI_War.isEmpty())
                                 {
                                    computer.addCard(AI_War.get(0)); //add all card's to AI
                                    AI_War.remove(0);
                                 }
                              while(!faceDown.isEmpty())
                                 {
                                    computer.addCard(AI_War.get(0)); //Add face down cards to AI
                                    AI_War.remove(0);
                                 }
                              while(!humanWar.isEmpty())
                                 {
                                    computer.addCard(humanWar.get(0)); //Add face down cards to Human
                                    humanWar.remove(0);
                                 }
                             }
                          }
                       turns++;
                       System.out.print("Take another turn? (Y/N): ");
                       response = input.nextLine();
                }
            System.out.println("That war took: " +turns + " turns to win.");
               if(human.getHumanDeck().size() > computer.getPlayerDeck().size())
                  {
                     System.out.println("Human player wins the War.");
                  }
               else if(human.getHumanDeck().size() < computer.getPlayerDeck().size())
                  {
                     System.out.println("Computer wins the War.");
                  }
               else
                  {
                     System.out.println("No ties during war.");
                  }
         }

            /**
               @param A HumanPlayer and Player, which are the two players playing in the War() constructor
               @returns boolean that declares the winner of a tie breaker, known as a war.
            */          
         
      public boolean warGames(HumanPlayer hum, Player comp)
         {
            boolean victor = false;
            if (hum.getHumanDeck().size() > 1 && comp.getPlayerDeck().size() > 1) //If both players have enough cards for war
               {
                  
                  humanWar.add(hum.getHumanDeck().get(0)); //Place top human card into war stack
                  human.removeCard();
                  AI_War.add(comp.getPlayerDeck().get(0)); //place top AI card into war stack
                  computer.removeCard(); //remove top AI card
                  System.out.println("One face down card."); 
                  faceDown.add(hum.getHumanDeck().get(0)); 
                  human.removeCard();
                  faceDown.add(comp.getPlayerDeck().get(0));
                  computer.removeCard();
                  System.out.println("Player card: " + hum.getHumanDeck().get(0));
                  System.out.println("AI card: " + comp.getPlayerDeck().get(0));
                  humanWar.add(hum.getHumanDeck().get(0));
                  human.removeCard();
                  AI_War.add(comp.getPlayerDeck().get(0));
                  computer.removeCard();
                  
                  if(hum.getHumanDeck().get(0).getRank() == comp.getPlayerDeck().get(0).getRank()) //If players have the same rank
                     {
                        warGames(human, computer); //War again
                     }
                  else if(hum.getHumanDeck().get(0).getRank() > comp.getPlayerDeck().get(0).getRank()) //if Human beats AI
                     {
                        System.out.println("Human Wins!");
                        victor = true;
                     }
                  else  //If AI beats Human
                     {
                        System.out.println("AI Wins!");
                        victor = false;
                     }
                }
              else if(hum.getHumanDeck().size() == 1) //If human doesnt have enough cards to war
               {
                  System.out.println("AI wins. GG WP.");
                  victor = false;
               }
              else if(comp.getPlayerDeck().size() == 1) //if AI doesnt have enough cards to war
               {
                  System.out.println("Human wins. GG WP");
                  victor = true;
               }
              return victor; //Return the winner boolean
              
           }
      }
                  
                  
                  
            