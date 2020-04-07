import java.awt.*;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.*;

//Main for Phase 2
public class assig5
{
   static int NUM_CARDS_PER_HAND = 7;
   static int  NUM_PLAYERS = 2;
   static JLabel[] computerLabels = new JLabel[NUM_CARDS_PER_HAND];
   static JLabel[] humanLabels = new JLabel[NUM_CARDS_PER_HAND];  
   static JLabel[] playedCardLabels  = new JLabel[NUM_PLAYERS]; 
   
   public static void main(String[] args)
   {  
      GUICard cardIcons = new GUICard();
      
      // establish main frame in which program will run
      CardTable myCardTable 
         = new CardTable("CardTable", NUM_CARDS_PER_HAND, NUM_PLAYERS);
      myCardTable.setSize(800, 600);
      myCardTable.setLocationRelativeTo(null);
      myCardTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      // CREATE LABELS ----------------------------------------------------
      //For computer hand and human hand
      for(int i = 0; i < NUM_CARDS_PER_HAND; i++)
      {
         computerLabels[i] = new JLabel(GUICard.getBackCardIcon());
         humanLabels[i] = new JLabel(GUICard.getIcon(randomCardGenerator()));
      }
      
      //For play area
      JLabel computer, human, score;
      computer = new JLabel("Computer");
      computer.setIcon(GUICard.getIcon(new Card('K', Card.Suit.DIAMONDS)));
      computer.setHorizontalAlignment(JLabel.CENTER);
      computer.setVerticalTextPosition(SwingConstants.BOTTOM);
      computer.setHorizontalTextPosition(SwingConstants.CENTER);
      human = new JLabel("Human");
      human.setIcon(GUICard.getIcon(new Card('2', Card.Suit.HEARTS)));
      human.setHorizontalAlignment(JLabel.CENTER);
      human.setVerticalTextPosition(SwingConstants.BOTTOM);
      human.setHorizontalTextPosition(SwingConstants.CENTER);
      score = new JLabel();
      score.setHorizontalAlignment(JLabel.CENTER);
      score.setText("Computer wins!");
      
      // ADD LABELS TO PANELS -----------------------------------------
      // First add cards to both players hands
      for(int i = 0; i < NUM_CARDS_PER_HAND; i++)
      {
         myCardTable.pn1ComputerHand.add(computerLabels[i]);
         myCardTable.pn1HumanHand.add(humanLabels[i]);
      }
      //Add jlabels to play area
      myCardTable.pn1PlayArea.add(computer);
      myCardTable.pn1PlayArea.add(score);
      myCardTable.pn1PlayArea.add(human);
      
      // show everything to the user
      myCardTable.setVisible(true);
   }
   
   public static Card randomCardGenerator()
   {
      Random rand = new Random();
      char cardValue = Card.valuRanks[rand.nextInt(14)];
      Card.Suit cardSuit = Card.Suit.values()[rand.nextInt(4)];
      
      return new Card(cardValue, cardSuit);
   }
}
