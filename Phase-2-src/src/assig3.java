//Phase 3 and Phase 4 Test Main
//Used to test the Card, Hand, and Deck classes.
//Author: Kevin Robell
import java.util.Scanner; //For user input.

public class assig3
{
   //Create Scanner Object
   static Scanner in = new Scanner(System.in);
   
   public static void main(String[] args)
   {
      final int DECK_SIZE = 52; //Numbers of cards in a deck
      
      System.out.println("*********************************");
      System.out.println("Phase 3: The Deck Class");
      
      System.out.println("\nDouble Deck Unshuffled:");
      Deck testDeck = new Deck(2); //Initialize double deck
      //Deal through the entire double deck and display on the console
      for(int i = 0; i < (DECK_SIZE * 2); i++)
      {
         System.out.print(testDeck.dealCard() + " / ");
      }
      
      System.out.println("\n\nDouble Deck Shuffled:");
      //Reset to double deck
      testDeck.init(2);
      //Shuffle Deck
      testDeck.shuffle();
      //Deal through the entire double deck and display on the console
      for(int i = 0; i < (DECK_SIZE * 2); i++)
      {
         System.out.print(testDeck.dealCard() + " / ");
      }
      
      System.out.println("\n\nSingle Deck Unshuffled:");
      //Reset to single deck
      testDeck.init(1);
      //Deal through the entire single deck and display on the console
      for(int i = 0; i < DECK_SIZE; i++)
      {
         System.out.print(testDeck.dealCard() + " / ");
      }
      
      System.out.println("\n\nSingle Deck Shuffled:");
      //Reset to single deck
      testDeck.init(1);
      //Shuffle Deck
      testDeck.shuffle();
      //Deal through the entire single deck and display on the console
      for(int i = 0; i < DECK_SIZE; i++)
      {
         System.out.print(testDeck.dealCard() + " / ");
      }
      
      System.out.println("\n\n*********************************");
      System.out.println("Phase 4: The Deck and Hand Classes");
      
      int numHands = -1; //Holds the number of hands of cards
      
      System.out.println("\n---First Deal---");
      
      //Ask user for number of players 1-10
      do
      {
         System.out.print("How many hands (1 - 10)? ");
         //Make sure user has entered an int.
         if(in.hasNextInt() == false)
         {
            in.nextLine(); //Clear garbage input.
            numHands = -1; //Set to junk value.
            continue;
         }
         
         numHands = in.nextInt();
         in.nextLine(); //Clear extraneous input.
      } while(numHands < 1 || numHands > 10);
      
      //Create array to store hand objects
      Hand[] playerHands = new Hand[numHands];
   
      //Initialize hand objects for each player
      for(int i = 0; i < numHands; i++)
      {
         playerHands[i] = new Hand();
      }
      
      //Instantiate new single deck of cards object
      Deck singleDeck = new Deck();
      
      //deal a deck into that many Hand objects until all cards are dealt
      int handIndex = 0; //Index of the hand that gets the next card
      while(singleDeck.getTopCard() >= 0)
      {
         //Deals a card to the next hand
         //The part [handIndex % numHands] cycles through the playerHands array by taking 
         //the modulus of the index by the number of hands
         playerHands[handIndex % numHands].takeCard(singleDeck.dealCard());
         handIndex++;
      }
      
      //display all hands and clear them for next deal
      for(int i = 0; i < playerHands.length; i++)
      {
         //Add one to i to display player numbers starting from 1 instead of 0 like the array.
         System.out.println("Player " + (i+1) + "'s Hand:");
         System.out.println(playerHands[i]);
         playerHands[i].resetHand(); //Clear hand for next deal
      }
      
      System.out.println("\n---Second Deal---");
      
      //Reset deck of cards object with one deck
      singleDeck.init(1);
      //Shuffle the deck
      singleDeck.shuffle();
      
      //deal a deck into that many Hand objects until all cards are dealt
      handIndex = 0; //Index of the hand that gets the next card
      while(singleDeck.getTopCard() >= 0)
      {
         //Deals a card to the next hand
         //The part [handIndex % numHands] cycles through the playerHands array by taking 
         //the modulus of the index by the number of hands
         playerHands[handIndex % numHands].takeCard(singleDeck.dealCard());
         handIndex++;
      }
      
      //display all hands
      for(int i = 0; i < playerHands.length; i++)
      {
         //Add one to i to display player numbers starting from 1 instead of 0 like the array.
         System.out.println("Player " + (i+1) + "'s Hand:");
         System.out.println(playerHands[i]);
      }
      
      //Close Scanner Object
      in.close();
      
      System.exit(0);
   }

}
