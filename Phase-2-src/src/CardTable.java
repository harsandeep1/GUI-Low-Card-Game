import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class CardTable extends JFrame
{
   static int MAX_CARDS_PER_HAND = 56;
   static int MAX_PLAYERS = 2;
   
   private int numCardsPerHand;
   private int numPlayers;
   
   public JPanel pn1ComputerHand, pn1HumanHand, pn1PlayArea;
   
   CardTable(String title, int numCardsPerHand, int numPlayers)
   {
      super();
      
      setTitle(title);
      this.numCardsPerHand = numCardsPerHand;
      this.numPlayers = numPlayers;
      
      this.setLayout(new GridLayout(3, 1));
      
      pn1ComputerHand = new JPanel();
      Border ComputerHandBorder = BorderFactory.createTitledBorder("Computer Hand");
      pn1ComputerHand.setBorder(ComputerHandBorder);
      pn1ComputerHand.setLayout(new FlowLayout());
      
      pn1HumanHand = new JPanel();
      Border HumanHandBorder = BorderFactory.createTitledBorder("Human Hand");
      pn1HumanHand.setBorder(HumanHandBorder);
      pn1HumanHand.setLayout(new FlowLayout());
      
      pn1PlayArea = new JPanel();
      Border PlayAreaBorder = BorderFactory.createTitledBorder("Play Area");
      pn1PlayArea.setBorder(PlayAreaBorder);
      pn1PlayArea.setLayout(new GridLayout(2, numPlayers));
      
      this.add(pn1ComputerHand);
      this.add(pn1PlayArea);
      this.add(pn1HumanHand);
   }
   
   CardTable()
   {
      this("CardTable", MAX_PLAYERS, MAX_CARDS_PER_HAND);
   }
   
   public int getNumCardsPerHand() { return numCardsPerHand; }
   public int getNumPlayers() { return numPlayers; }
}
