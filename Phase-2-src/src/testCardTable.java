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
      
      //Create Jlabels
      JLabel card1, card2, computer, human;
      card1 = new JLabel("Card #1");
      card1.setHorizontalAlignment(JLabel.CENTER);
      card2 = new JLabel("Card #2");
      card2.setHorizontalAlignment(JLabel.CENTER);
      computer = new JLabel("Computer");
      computer.setHorizontalAlignment(JLabel.CENTER);
      human = new JLabel("Human");
      human.setHorizontalAlignment(JLabel.CENTER);
      
      //Add jlabels to play area
      myCardTable.pn1PlayArea.add(card1);
      myCardTable.pn1PlayArea.add(card2);
      myCardTable.pn1PlayArea.add(computer);
      myCardTable.pn1PlayArea.add(human);

      // show everything to the user
      myCardTable.setVisible(true);
      
      //Pause Program
      try
      {
         Thread.sleep(1000);
      } catch (InterruptedException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      //Reset card1 and card2 labels
      card1.setText("");
      card2.setText("");
      //Repaint jpanel
      myCardTable.pn1PlayArea.repaint();
      
      //Pause Program
      try
      {
         Thread.sleep(1000);
      } catch (InterruptedException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      //Reset card1 and card2 labels
      card1.setText("Card #3");
      card2.setText("Card #4");
      //Repaint jpanel
      myCardTable.pn1PlayArea.repaint();
   }

}
