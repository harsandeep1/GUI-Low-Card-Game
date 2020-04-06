/**
 * @author Jeannie Davis
 * @date 3-23-20
 * testDeck class
 */
import java.util.Scanner;
public class testDeck {
    public static void main(String args[]){
        Deck x = new Deck(2);   // deck that has 2 packs
        Deck y = new Deck();    //deck that has 1 pack
        Scanner myObj = new Scanner(System.in);
        int counter = 0;
        System.out.println("/*-------------------------------------------");
        for  (int i = 0; i<112; i++){   // will loop and deal all cards until deck is empty
            if  (counter== 56){
                System.out.println();
                System.out.println();
            }
            System.out.print(x.dealCard().toString()+" /");
            counter ++;
           
        }
        System.out.println();
        System.out.println();
        x.init(2);                  // resets deck by intializing it to the same 2 packs
        x.shuffle();                //shuffles deck
        int shuffleCounter = 0;
        for  (int i = 0; i<112; i++){   // will loop and deal all cards until deck is empty. Note: this is shuffled
            if  (shuffleCounter== 52){
                System.out.println();
                System.out.println();
            }
            System.out.print(x.dealCard().toString()+" /");
            shuffleCounter ++;
        }
        System.out.println();
        System.out.println();

        System.out.println("/*-------------------------------------------");
        for (int i = 0; i < 56; i++){   //will loop and deal all cards until deck is empty
            System.out.print(y.dealCard().toString()+" /");
        }
        y.init(1);  //resets deck by intializing it to the same pack
        System.out.println();
        System.out.println();
        
        if(y.addCard(new Card()))
           System.out.println("\n\nCan add Ace of Spades to deck.\n");
        else
           System.out.println("\n\nCannot add Ace of Spades to deck.\n");
        
        System.out.println("\n\nRemoving Ace of Spades from the deck.\n");
        y.removeCard(new Card()); //Remove AS from deck
        y.removeCard(new Card()); //Trying and failing to remove it again.
        
        if(y.addCard(new Card()))
           System.out.println("\n\nCan add Ace of Spades to deck.\n");
        else
           System.out.println("\n\nCannot add Ace of Spades to deck.\n");

        y.shuffle();    // shuffles deck
        for (int i = 0; i < 56; i++){   //will loop and deal all cards until deck is empty. Note: this is shuffled
            System.out.print(y.dealCard().toString()+" /");
        }
        
        myObj.close();
    }



}