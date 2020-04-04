import javax.swing.JFrame;
import javax.swing.JLabel;

public class testCardTable
{

   public static void main(String[] args)
   {
      // establish main frame in which program will run
      CardTable myCardTable = new CardTable("CardTable", 7, 2);
      myCardTable.setSize(800, 600);
      myCardTable.setLocationRelativeTo(null);
      myCardTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      JLabel card1, card2, computer, human;
      card1 = new JLabel("Card #1");
      card1.setHorizontalAlignment(JLabel.CENTER);
      card2 = new JLabel("Card #2");
      card2.setHorizontalAlignment(JLabel.CENTER);
      computer = new JLabel("Computer");
      computer.setHorizontalAlignment(JLabel.CENTER);
      human = new JLabel("Human");
      human.setHorizontalAlignment(JLabel.CENTER);
      
      myCardTable.pn1PlayArea.add(card1);
      myCardTable.pn1PlayArea.add(card2);
      myCardTable.pn1PlayArea.add(computer);
      myCardTable.pn1PlayArea.add(human);

      // show everything to the user
      myCardTable.setVisible(true);
   }

}
