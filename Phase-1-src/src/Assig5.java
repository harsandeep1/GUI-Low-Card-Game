<<<<<<< HEAD
import javax.swing.*;
import java.awt.*;


public class Assig5
{
   // static for the 57 icons and their corresponding labels
   // normally we would not have a separate label for each card, but
   // if we want to display all at once using labels, we need to.

   static int NUM_CARD_IMAGES = 57; // 52 + 4 jokers + 1 back-of-card image
   static Icon[] icon = new ImageIcon[NUM_CARD_IMAGES];

   static void loadCardIcons()
   {
      // build the file names ("AC.gif", "2C.gif", "3C.gif", "TC.gif", etc.)
      // in a SHORT loop. For each file name, read it in and use it to
      // instantiate each of the 57 Icons in the icon[] array.
      int cardCount = 0;   
      for(int j = 0; j < 4; j++)
      {
         for(int k = 0; k <= 13; k++)
         {
            icon[cardCount++] = new ImageIcon("images/" + turnIntIntoCardValue(k)
                  + turnIntIntoCardSuit(j) + ".gif");
         }      
      }
   }

   // turns 0 - 13 into "A", "2", "3", ... "Q", "K", "X"
   static String turnIntIntoCardValue(int k)
   {
      // an idea for a helper method (do it differently if you wish)
      String value = null;
      String[] index = {"A", "2", "3", "4", "5", "6", "7", "8", "9",
            "T", "J", "Q", "K", "X"};
      if(k >=0 && k <= 13)
      {
         value = index[k];
      }else{
         System.out.println("returning defalut value A");
         return index[0];//returns default value "A".
      }
      return value;
   }

   // turns 0 - 3 into "C", "D", "H", "S"
   static String turnIntIntoCardSuit(int j)
   {
      // an idea for another helper method (do it differently if you wish)
      String suit = null;
      String[] index1 = {"C", "D", "H", "S"};
      if(j >=0 && j <= 3)
      {
         suit = index1[j];
      }else{
         System.out.println("returning defalut suit C");
         return index1[0];//returns default value "A".
      }
      return suit;
   }

   // a simple main to throw all the JLabels out there for the world to see
   public static void main(String[] args)
   {
      int k;

      // prepare the image icon array
      loadCardIcons();

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
      for (k = 0; k < NUM_CARD_IMAGES; k++)
         labels[k] = new JLabel(icon[k]);

      // place your 3 controls into frame
      for (k = 0; k < NUM_CARD_IMAGES; k++)
         frmMyWindow.add(labels[k]);

      // show everything to the user
      frmMyWindow.setVisible(true);
   }
}

=======
import javax.swing.*;
import java.awt.*;


public class Assig5
{
   // static for the 57 icons and their corresponding labels
   // normally we would not have a separate label for each card, but
   // if we want to display all at once using labels, we need to.

   static int NUM_CARD_IMAGES = 57; // 52 + 4 jokers + 1 back-of-card image
   static Icon[] icon = new ImageIcon[NUM_CARD_IMAGES];

   static void loadCardIcons()
   {
      // build the file names ("AC.gif", "2C.gif", "3C.gif", "TC.gif", etc.)
      // in a SHORT loop. For each file name, read it in and use it to
      // instantiate each of the 57 Icons in the icon[] array.
      int cardCount = 0;   
      for(int j = 0; j < 4; j++)
      {
         for(int k = 0; k <= 13; k++)
         {
            icon[cardCount++] = new ImageIcon("images/" + turnIntIntoCardValue(k)
                  + turnIntIntoCardSuit(j) + ".gif");
         }      
      }
      icon[NUM_CARD_IMAGES - 1] = new ImageIcon("images/BK.gif");
   }

   // turns 0 - 13 into "A", "2", "3", ... "Q", "K", "X"
   static String turnIntIntoCardValue(int k)
   {
      // an idea for a helper method (do it differently if you wish)
      String value = null;
      String[] index = {"A", "2", "3", "4", "5", "6", "7", "8", "9",
            "T", "J", "Q", "K", "X"};
      if(k >=0 && k <= 13)
      {
         value = index[k];
      }else{
         return index[0];//returns default value "A".
      }
      return value;
   }

   // turns 0 - 3 into "C", "D", "H", "S"
   static String turnIntIntoCardSuit(int j)
   {
      // an idea for another helper method (do it differently if you wish)
      String suit = null;
      String[] index1 = {"C", "D", "H", "S"};
      if(j >=0 && j <= 3)
      {
         suit = index1[j];
      }else{
         return index1[0];//returns default value "A".
      }
      return suit;
   }

   // a simple main to throw all the JLabels out there for the world to see
   public static void main(String[] args)
   {
      int k;

      // prepare the image icon array
      loadCardIcons();

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
      for (k = 0; k < NUM_CARD_IMAGES; k++)
         labels[k] = new JLabel(icon[k]);

      // place your 3 controls into frame
      for (k = 0; k < NUM_CARD_IMAGES; k++)
         frmMyWindow.add(labels[k]);

      // show everything to the user
      frmMyWindow.setVisible(true);
   }
}

>>>>>>> refs/heads/master
