import javax.swing.Icon;
import javax.swing.ImageIcon;

public class GUICard
{
   private static Icon[][] iconCards = new ImageIcon[14][4]; // 14 = A thru K + joker
   private static Icon iconBack;
   static boolean iconsLoaded = false;
   
   static String[] suitArray = {"C", "D", "H", "S"};
   static String[] cardValueArray = {"A", "2", "3", "4", "5", "6", "7", "8", "9",
         "T", "J", "Q", "K", "X"};
   
   GUICard()
   {
      if(iconsLoaded == false)
         loadCardIcons();
   }
   
   static private void loadCardIcons()
   {
      // build the file names ("AC.gif", "2C.gif", "3C.gif", "TC.gif", etc.)
      // in a SHORT loop. For each file name, read it in and use it to
      // instantiate each of the 57 Icons in the icon[] array.
      for(int numSuit = 0; numSuit < 4; numSuit++)
      {
         for(int numCardValue = 0; numCardValue <= 13; numCardValue++)
         {
            iconCards[numCardValue][numSuit] = new ImageIcon("images/" + 
                  intToCardValue(numCardValue) + intToSuit(numSuit) + ".gif");
         }      
      }
      
      iconBack = new ImageIcon("images/" + "BK" + ".gif");
      
      iconsLoaded = true;
   }
   
   static public Icon getIcon(Card card)
   {
      int cardValueNum = valueToInt(card.getValue());
      int suitNum = suitToInt(card.getSuit());
      if(cardValueNum == -1 || suitNum == -1)
         return iconBack;
      else
         return iconCards[cardValueNum][suitNum];
   }
   
   static public Icon getBackCardIcon()
   {
      return iconBack;
   }
   
   static private String intToSuit(int numSuit) 
   { 
      return suitArray[numSuit]; 
   };
   
   static private String intToCardValue(int numCardValue) 
   { 
      return cardValueArray[numCardValue];
   };
   
   static private int suitToInt(Card.Suit cardSuit) 
   {
      int suitNum = 0;
      
      for(Card.Suit suit : Card.Suit.values())
      {
         if(cardSuit == suit)
            return suitNum;
         else
            suitNum++;
      }
      
      return -1;
   };
   
   static private int cardValueToInt(char cardValue) 
   {
      int cardValueNum = 0;
      
      for(char value : Card.valuRanks)
      {
         if(cardValue == value)
            return cardValueNum;
         else
            cardValueNum++;
      }
      
      return -1;
   };
}
