import javax.swing.JFrame;
import javax.swing.JPanel;

public class CardTable extends JFrame
{
   static int MAX_CARDS_PER_HAND = 56;
   static int MAX_PLAYERS = 2;
   
   private int numCardsPerHand;
   private int numPlayers;
   
   public JPanel pn1ComputerHand, pn1HumanHand, pn1PlayArea;
   
   CardTable(String title, int numCardsPerHand, int numPlayers)
   {
      this.numCardsPerHand = numCardsPerHand;
      this.numPlayers = numPlayers;
   }
   
   CardTable()
   {
      this("CardTable", MAX_PLAYERS, MAX_CARDS_PER_HAND);
   }
   
   public int getNumCardsPerHand() { return numCardsPerHand; }
   public int getNumPlayers() { return numPlayers; }
}
