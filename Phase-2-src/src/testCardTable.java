import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

//Test main for the CardTable class.
public class testCardTable
{

   public static void main(String[] args)
   {
      //Set scores
      int computerScore = 0;
      int humanScore = 0;
      
      // establish main frame in which program will run
      CardTable myCardTable = new CardTable("CardTable", 7, 2);
      myCardTable.setSize(800, 600);
      myCardTable.setLocationRelativeTo(null);
      myCardTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      Icon iconBack = new ImageIcon("images/" + "BK" + ".gif");
      
      //Create Jlabels
      JLabel computer, human, blank;
      computer = new JLabel("Computer");
      computer.setIcon(iconBack);
      computer.setHorizontalAlignment(JLabel.CENTER);
      computer.setVerticalTextPosition(SwingConstants.BOTTOM);
      computer.setHorizontalTextPosition(SwingConstants.CENTER);
      human = new JLabel("Human");
      human.setIcon(iconBack);
      human.setHorizontalAlignment(JLabel.CENTER);
      human.setVerticalTextPosition(SwingConstants.BOTTOM);
      human.setHorizontalTextPosition(SwingConstants.CENTER);
      blank = new JLabel();
      blank.setHorizontalAlignment(JLabel.CENTER);
      blank.setText("Computer: " + computerScore + " | Human: " + humanScore);
      
      //Add jlabels to play area
      myCardTable.pn1PlayArea.add(computer);
      myCardTable.pn1PlayArea.add(blank);
      myCardTable.pn1PlayArea.add(human);

      // show everything to the user
      myCardTable.setVisible(true);
      
      //Pause Program
      try
      {
         Thread.sleep(2000);
      } catch (InterruptedException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      //Display winner
      blank.setText("You win!");
      humanScore++; //Update score
      //Repaint jpanel
      myCardTable.pn1PlayArea.repaint();
      
      //Pause Program
      try
      {
         Thread.sleep(2000);
      } catch (InterruptedException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      //Display score
      blank.setText("Computer: " + computerScore + " | Human: " + humanScore);
      //Repaint jpanel
      myCardTable.pn1PlayArea.repaint();
      
      //Pause Program
      try
      {
         Thread.sleep(2000);
      } catch (InterruptedException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      //Display winner
      blank.setText("Computer wins!");
      computerScore++; //Update score
      //Repaint jpanel
      myCardTable.pn1PlayArea.repaint();
      
      //Pause Program
      try
      {
         Thread.sleep(2000);
      } catch (InterruptedException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      //Display score
      blank.setText("Computer: " + computerScore + " | Human: " + humanScore);
      //Repaint jpanel
      myCardTable.pn1PlayArea.repaint();
   }

}
