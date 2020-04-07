import java.awt.*;
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
      // establish main frame in which program will run
      CardTable myCardTable 
         = new CardTable("CardTable", NUM_CARDS_PER_HAND, NUM_PLAYERS);
      myCardTable.setSize(800, 600);
      myCardTable.setLocationRelativeTo(null);
      myCardTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // show everything to the user
      myCardTable.setVisible(true);

      // CREATE LABELS ----------------------------------------------------
      for(int i = 0; i < NUM_CARDS_PER_HAND; i++)
      {
         computerLabels[i] = new JLabel(GUICard.getIcon(new Card(Card.valuRanks[i])));
         humanLabels[i] = new JLabel(GUICard.getIcon(new Card(Card.valuRanks[i])));
      }
      
  
      // ADD LABELS TO PANELS -----------------------------------------
      // First add cards to both players hands
      for(int i = 0; i < NUM_CARDS_PER_HAND; i++)
      {
         myCardTable.pn1ComputerHand.add(computerLabels[i]);
         myCardTable.pn1HumanHand.add(humanLabels[i]);
      }
      
      // and two random cards in the play region (simulating a computer/hum ply)
      JLabel computer, human, score;
      computer = new JLabel("Computer");
      computer.setIcon(GUICard.getIcon(new Card('K')));
      computer.setHorizontalAlignment(JLabel.CENTER);
      computer.setVerticalTextPosition(SwingConstants.BOTTOM);
      computer.setHorizontalTextPosition(SwingConstants.CENTER);
      human = new JLabel("Human");
      human.setIcon(GUICard.getIcon(new Card('2')));
      human.setHorizontalAlignment(JLabel.CENTER);
      human.setVerticalTextPosition(SwingConstants.BOTTOM);
      human.setHorizontalTextPosition(SwingConstants.CENTER);
      score = new JLabel();
      score.setHorizontalAlignment(JLabel.CENTER);
      score.setText("Computer wins!");
      //Add jlabels to play area
      myCardTable.pn1PlayArea.add(computer);
      myCardTable.pn1PlayArea.add(score);
      myCardTable.pn1PlayArea.add(human);

      // show everything to the user
      myCardTable.setVisible(true);
   }
}
