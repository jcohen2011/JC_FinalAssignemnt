/** Jacob Cohen - CS 110 - HW5 - Card Class
   
   This test program shows all teh functionality of the card class   
*/
import java.util.*;

public class TestCard
   {
      public static void main(String[]args)
         {  
            //Get testing Varibles
       
            Scanner keyboard = new Scanner(System.in);
            
            System.out.println("Please a Card rank 1 through 13 for the first card.(Ace is low): ");
            int testRankOne = keyboard.nextInt();
            System.out.println("For rank, from 1 to 4, the order is Diamonds, Clubs, Hearts, the Spades.");
            int testSuitOne = keyboard.nextInt();
            
            
            System.out.println("Enter the rank for the second card");
            int testRankTwo = keyboard.nextInt();
            System.out.println("Enter the suit value for the second card");
            int testSuitTwo = keyboard.nextInt();
            
            //Create the Two Card Objects
            
            Card firstCard = new Card(testRankOne, testSuitOne);
            Card secondCard = new Card(testRankTwo, testSuitTwo);
            
            //getSuit test
            
            String TS1 = firstCard.getSuit();
            System.out.println("Using getSuit, your first card's suit is " +TS1);
            String TS2 = secondCard.getSuit();
            System.out.println("Using getSuit, your second card's suit is " +TS2);
            
            //getRank test
            
            int TR1 = firstCard.getRank();
            System.out.println("Using getRank, your first card's rank is " +TR1);
            int TR2 = secondCard.getRank();
            System.out.println("Using getRank, your second card's rank is " +TR2);

            
            //toString test
            
            String CardOneName = firstCard.toString();
            System.out.println("Using toString, the first card is the "+CardOneName);
            String CardTwoName = secondCard.toString();
            System.out.println("Using toString, the second card is the "+CardTwoName);
            
            //equals test
            
            boolean testEquals = firstCard.equals(secondCard);
            System.out.println("Using equals, comparing the two card's rank yields: " +testEquals);
            
            }
            
         }