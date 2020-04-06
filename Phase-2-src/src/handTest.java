public class handTest {

   public static void main(String[] args) {
      
      // Run for phase 2:
      System.out.println("/* -----------BEGIN PHASE TWO------------------- ");
      
      Hand hand = new Hand();
      
      Card card4 = new Card('A', Card.Suit.HEARTS);
      Card card5 = new Card('3', Card.Suit.CLUBS);
      Card card6 = new Card('T', Card.Suit.SPADES);
      Card card7 = new Card('7', Card.Suit.CLUBS);
      Card card8 = new Card('6', Card.Suit.HEARTS);
      
      hand.takeCard(card4);
      hand.takeCard(card5);
      
      System.out.println("Taking two cards initially...");
      System.out.println(hand);
      
      hand.playCard();
      
      System.out.println("Here is the hand after playing one card: " + hand + "\n");
      
      System.out.println("Testing inspectCard()");
      System.out.println(hand.inspectCard(0)); // Good Card
      System.out.println(hand.inspectCard(33)); // Out of Bounds
      System.out.println(hand.inspectCard(1)); // Null card
      System.out.println("\n");
      
      System.out.println("Now filling the hand with the remaining cards ...\n");
      while(hand.getNumCards() < hand.MAX_CARDS){
          
         hand.takeCard(card6);
         hand.takeCard(card7);
         hand.takeCard(card8);
         hand.takeCard(card4);
         hand.takeCard(card5);
          
      }
      System.out.println("Hand full\nAfter deal");
      System.out.println(hand);
      
      while(hand.getNumCards() > 0){
         System.out.println("Playing " + hand.playCard());
      }
      
      System.out.println("After playing all cards");
      System.out.println(hand);
   
      System.out.println("-------------END PHASE TWO------------------- */\n");
   }

}