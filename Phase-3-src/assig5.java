import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Main for Phase 3
public class assig5 
{
   static int NUM_CARDS_PER_HAND = 7;
   static int  NUM_PLAYERS = 2;
   static JLabel[] computerLabels = new JLabel[NUM_CARDS_PER_HAND];
   static JButton[] humanLabels = new JButton[NUM_CARDS_PER_HAND];  
   static JLabel[] playedCardLabels  = new JLabel[NUM_PLAYERS]; 
   static JLabel computer, human, score;
   static int userMove = 1;
   static int cpuScore =0;
   static int humanScore=0;
   public static void main(String[] args)
   {  
      int numPacksPerDeck = 1;
      int numJokersPerPack = 2;
      int numUnusedCardsPerPack = 0;
      Card[] unusedCardsPerPack = null;
      CardGameFramework LowCardGame = new CardGameFramework( 
            numPacksPerDeck, numJokersPerPack,  
            numUnusedCardsPerPack, unusedCardsPerPack, 
            NUM_PLAYERS, NUM_CARDS_PER_HAND);
      GUICard cardIcons = new GUICard();
      if (LowCardGame.deal()){
         LowCardGame.sortHands();
         CardTable myCardTable 
         = new CardTable("CardTable", NUM_CARDS_PER_HAND, NUM_PLAYERS);
         // establish main frame in which program will run
         myCardTable.setSize(800, 600);
         myCardTable.setLocationRelativeTo(null);
         myCardTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
         // CREATE LABELS ----------------------------------------------------
      //For computer hand and human hand
         for(int i = 0; i < NUM_CARDS_PER_HAND; i++)
         {
            computerLabels[i] = new JLabel(GUICard.getBackCardIcon());
            humanLabels[i] = new JButton(GUICard.getIcon(LowCardGame.getHand(1).inspectCard(i)));
            humanLabels[i].addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent ae) {
                  String action = ae.getActionCommand();
                  int k = Integer.parseInt(action);
                  LowCardGame.getHand(1).inspectCard(k);
                 String status;
                  human.setIcon(GUICard.getIcon(LowCardGame.getHand(1).inspectCard(k)));
                  // if user goes first
                  if (userMove ==1){
                     int cpu = duel(LowCardGame.getHand(1).inspectCard(k), LowCardGame.getHand(0));
                     computer.setIcon(GUICard.getIcon(LowCardGame.playCard(0,cpu)));
                  }
                  //otherwise cpu goes first
                  else {
                     int result = checkCards(LowCardGame.getHand(1).inspectCard(k).getValue(), LowCardGame.playCard(0,0).getValue());
                     if (result == 0){
                        status = "It's a tie!";
                        userMove =1;
                     }
                     else if (result == 1){
                        status = "Player Wins";
                        userMove = 1;
                        humanScore++;
                        human.setText("Human: " + Integer.toString(humanScore));
                     }
                     else {
                        status = "CPU Wins";
                        userMove = 0;
                        cpuScore++;
                       computer.setText("Computer: " + Integer.toString(cpuScore));
                     }
                     score.setText(status);
                  }
                  // plays the card that was clicked on
                  LowCardGame.playCard(1,k);
                  // render the cpu and user hands
                  myCardTable.pn1ComputerHand.removeAll();
                  myCardTable.pn1ComputerHand.revalidate();
                  myCardTable.pn1ComputerHand.repaint();
                  myCardTable.pn1HumanHand.removeAll();
                  myCardTable.pn1HumanHand.revalidate();
                  myCardTable.pn1HumanHand.repaint();
                  //if there's no cards left in your hand the game is over
                  if (LowCardGame.getHand(1).getNumCards() ==0){
                     Timer timer4 = new Timer(2000, e -> {
                        human.setIcon(GUICard.getBackCardIcon());
                        computer.setIcon(GUICard.getBackCardIcon());
                        if (cpuScore<humanScore){
                           score.setText ("<html>Game Over <br> You Won!</html>");
                        }
                        else if (cpuScore>humanScore){
                           score.setText ("<html>Game Over <br> You Lost!</html>");
                        }
                        else {
                           score.setText ("<html>Game Over <br> You Won!</html>");
                        }
                    });
                    timer4.setRepeats(false);
                     timer4.start();
                     return;
                  }
                  // adding the cards to cpu and human hand (visually)
                  for(int j = 0; j < LowCardGame.getHand(1).getNumCards(); j++){
                     humanLabels[j].setIcon(GUICard.getIcon(LowCardGame.getHand(1).inspectCard(j)));
                     myCardTable.pn1ComputerHand.add(computerLabels[j]);
                     myCardTable.pn1HumanHand.add(humanLabels[j]);
                  }
                  // if cpu has first move after winning -- wait 2 seconds before showing it's card
                  if (userMove ==0){
                     Timer timer4 = new Timer(2000, e -> {
                        human.setIcon(GUICard.getBackCardIcon());
                        computer.setIcon(GUICard.getIcon(LowCardGame.getHand(0).inspectCard(0)));
                    });
                    timer4.setRepeats(false);
                     timer4.start();
                  }
                  else {
                     Timer timer4 = new Timer(2000, e -> {
                        human.setIcon(GUICard.getBackCardIcon());
                        computer.setIcon(GUICard.getBackCardIcon());
                    });
                    timer4.setRepeats(false);
                     timer4.start();
                  }
               }
            });
            // humanLabels[i].addActionListener();
            humanLabels[i].setActionCommand(Integer.toString(i));
         }  
          //For play area
         computer = new JLabel("Computer: 0 ");
         computer.setIcon(GUICard.getBackCardIcon());
         computer.setHorizontalAlignment(JLabel.CENTER);
         computer.setVerticalTextPosition(SwingConstants.BOTTOM);
         computer.setHorizontalTextPosition(SwingConstants.CENTER);
         human = new JLabel("Human: 0 ");
         human.setIcon(GUICard.getBackCardIcon());
         human.setHorizontalAlignment(JLabel.CENTER);
         human.setVerticalTextPosition(SwingConstants.BOTTOM);
         human.setHorizontalTextPosition(SwingConstants.CENTER);
         score = new JLabel();
         score.setHorizontalAlignment(JLabel.CENTER);
         score.setText("Play Low Card!");
         
         // ADD LABELS TO PANELS -----------------------------------------
         // First add cards to both players hands
         for(int i = 0; i < NUM_CARDS_PER_HAND; i++)
         {
            myCardTable.pn1ComputerHand.add(computerLabels[i]);
            myCardTable.pn1HumanHand.add(humanLabels[i]);
         }
         //Add jlabels to play area
         myCardTable.pn1PlayArea.add(computer);
         myCardTable.pn1PlayArea.add(score);
         myCardTable.pn1PlayArea.add(human);
         // show everything to the user
         myCardTable.setVisible(true);
      }
   }
   /**
    * 
    * @param playerCard - the player's card
    * @param cpu - the cpu's hand
    * @return an integer (whether or not the user won/cpu win/it's a tie)
    * This method loop through cpu's cards to check if any of the cards are smaller than the player's card
    * if so, "play that card" otherwise return the highest card
    */
   public static int duel (Card playerCard, Hand cpu){
      
      String status = "Player Wins";
      userMove = 1;
      int i = cpu.getNumCards()-1;
      for (; i>=0; i--){
         // check if cpu's card's value is less than player's card's value
         
         if (checkCards(playerCard.getValue(), cpu.inspectCard(i).getValue()) == -1){
               status = "CPU Wins";
               userMove = 0;
               cpuScore++;
               computer.setText("Computer: " + Integer.toString(cpuScore));
               break;
         }
      }
      if (i<0){
         i = 0;
      }
      if (checkCards(playerCard.getValue(), cpu.inspectCard(i).getValue()) == 0){
         status = "It's a tie!";
         userMove =1;
      }
      else if(userMove != 0){
         humanScore++;
         human.setText("Human: " + Integer.toString(humanScore));
      }  
      score.setText(status);
   
      return i;
   }
   /**
    * 
    * @param player - player's card char
    * @param cpu - cpu's card char
    * @return - an integer based on who had the larger card value
    */
   public static int checkCards(char player, char cpu){
      int i = 0;
      int j = 0;
      for (; i<Card.valuRanks.length; i++){
         if (player == Card.valuRanks[i]){
            break;
         }
      }
      for (; j<Card.valuRanks.length; j++){
         if (cpu == Card.valuRanks[j]){
            break;
         }
      }
      // if the two cards are equal
      if (i == j){
         return 0;
      }
      // if the player lost to cpu
      else if (j<i){
         return -1;
      }
      //otherwise player won
      else{
         return 1;
      }
   }
}
