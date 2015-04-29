/**
     @author Jacob Cohen - CS 110 - Final assignment
      WarGUI: This class creates and manages the GUI for the War class
              Creates a Wardriver object and connects the .jpgs to the cards
   
*/

//Needed libraries
import java.util.*;
import java.awt.*;         //for gui
import javax.swing.*;
import java.io.*;          //file I/O
import java.awt.event.*;



public class WarGUI extends JFrame
   {
      //Create a 'war game'
      
      private WarDriver game;
      
      //Initialize labels, buttons and card pictures to card objects
     
	   private ImageIcon cardBackImage;
	   private ImageIcon[][] cardImages = new ImageIcon[4][15];
	   private JLabel playerHand;
      private JLabel playerPile;
      private JLabel computerPile;
      private JLabel computerHand;
      private JLabel statusMessage;
      private JPanel topPanel;
      private JPanel bottomPanel;
      private JButton nextStepButton;
      private JCheckBox userInput;
      
      //Make rank/suit parameters
    	private final int RANKS = 15;
   	private final int SUITS = 4;
   	private String rank;     
         
      public WarGui ()
         {
            war = new War()
            cardBackImage = new ImageIcon(ImageIO.read(new File("cardpics/back.jpg")));
            
            for(int i = 0; i < SUITS; i++)
                  {
            				if(i == 0)
            					rank = "s";
            				else if (i == 1) 
            					rank = "h";
            				else if (i == 2)
            					rank ="d";
            				else if (i == 3)
            					rank = "c";
            				String fileName = "cardpics/"+j+rank+".jpg";
            				try
                   {
                       cardImages[i][j] = new ImageIcon(ImageIO.read(new File(fileName)));
                   }
                   catch (IOException ex)
                   {
                       throw new FileNotFoundException("Card image: "+j+rank+".jpg not found.");
                   }
				
			         }
                  
        playerHand = new JLabel(cardBackImage);
        computerHand = new JLabel(cardBackImage);
        // Leave the piles blank for now.
        playerPile = new JLabel();
        computerPile = new JLabel();

        setLayout(new GridLayout(2,1));
        topPanel = new JPanel(new GridLayout(1,4));
        topPanel.add(playerHand);
        topPanel.add(playerPile);
        topPanel.add(computerPile);
        topPanel.add(computerHand);
        bottomPanel = new JPanel(new GridLayout(2,1));
        statusMessage = new JLabel("Welcome to WAR!");
        nextStepButton = new JButton("Begin Game");
        userInput = new JCheckBox("Would you like to play?");
        nextStepButton.addActionListener(new ButtonListener());

        bottomPanel.add(userInput);
        bottomPanel.add(statusMessage);
        bottomPanel.add(nextStepButton);

        this.add(topPanel);
        this.add(bottomPanel);
	}
		   }            
   
   
      //main method
      public static void main(String [] args)
      {
         WarGUI gui = new WarGUI();
      }
      
      
      
   
   
   
   }