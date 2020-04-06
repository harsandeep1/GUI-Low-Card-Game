//Testing the Card.java class.
public class testCard
{

   public static void main(String[] args)
   {
      Card test1 = new Card();//empty parameters, legal
      Card test2 = new Card('A', Card.Suit.HEARTS);//legal
      Card test3 = new Card('Z', Card.Suit.SPADES);//illegal
      
      //print first iteration of strings
      System.out.println(test1.toString());
      System.out.println(test2.toString());
      System.out.println(test3.toString() + "\n");
      
      test1.set('6', Card.Suit.HEARTS);//legal to legal
      test2.set('B', Card.Suit.DIAMONDS);//legal to illegal
      test3.set('K', Card.Suit.CLUBS);//illegal to legal
      
      //print revised strings
      System.out.println(test1.toString());
      System.out.println(test2.toString());
      System.out.println(test3.toString() + "\n");
   }

}
