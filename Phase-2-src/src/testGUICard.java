import java.awt.FlowLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

//Test main for the GUICard class.
//Based upon Phase-1-src/src/Assig5.java
public class testGUICard
{
   // static for the 57 icons and their corresponding labels
   // normally we would not have a separate label for each card, but
   // if we want to display all at once using labels, we need to.

   static int NUM_CARD_IMAGES = 57; // 52 + 4 jokers + 1 back-of-card image
   
   public static void main(String[] args)
   {
      // load card icons
      GUICard cardIcons = new GUICard();
      
      // load deck
      Deck deck = new Deck();

      // establish main frame in which program will run
      JFrame frmMyWindow = new JFrame("Card Room");
      frmMyWindow.setSize(1150, 650);
      frmMyWindow.setLocationRelativeTo(null);
      frmMyWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // set up layout which will control placement of buttons, etc.
      FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 5, 20);
      frmMyWindow.setLayout(layout);

      // prepare the image label array
      JLabel[] labels = new JLabel[NUM_CARD_IMAGES];
      for(int i = 0; i < NUM_CARD_IMAGES - 2; i++)
         labels[i] = new JLabel(cardIcons.getIcon(deck.dealCard()));
      
      //Add card back to label
      labels[NUM_CARD_IMAGES - 1] = new JLabel(cardIcons.getBackCardIcon());
      
      // place cards in frame
      for (JLabel label : labels)
         frmMyWindow.add(label);

      // show everything to the user
      frmMyWindow.setVisible(true);
   }

}
