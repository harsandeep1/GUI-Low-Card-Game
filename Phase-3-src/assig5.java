import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Main for Phase 2
public class assig5 
{
   static int NUM_CARDS_PER_HAND = 7;
   static int  NUM_PLAYERS = 2;
   static JLabel[] computerLabels = new JLabel[NUM_CARDS_PER_HAND];
   static JButton[] humanLabels = new JButton[NUM_CARDS_PER_HAND];  
   static JLabel[] playedCardLabels  = new JLabel[NUM_PLAYERS]; 
   static JLabel computer, human, score;
   static int userMove = 1;

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
                 
                  human.setIcon(GUICard.getIcon(LowCardGame.getHand(1).inspectCard(k)));
                  int cpu = duel(LowCardGame.getHand(1).inspectCard(k), LowCardGame.getHand(0));
                  if (userMove == 0){
                     computer.setIcon(GUICard.getIcon(LowCardGame.playCard(0,cpu)));
                  }
                  LowCardGame.playCard(1,k);
                  myCardTable.pn1ComputerHand.removeAll();
                  myCardTable.pn1ComputerHand.revalidate();
                  myCardTable.pn1ComputerHand.repaint();
                  myCardTable.pn1HumanHand.removeAll();
                  myCardTable.pn1HumanHand.revalidate();
                  myCardTable.pn1HumanHand.repaint();
                  for(int j = 0; j < LowCardGame.getHand(1).getNumCards(); j++){
                     humanLabels[j].setIcon(GUICard.getIcon(LowCardGame.getHand(1).inspectCard(j)));
                     myCardTable.pn1ComputerHand.add(computerLabels[j]);
                     myCardTable.pn1HumanHand.add(humanLabels[j]);
                  }
                  if (userMove ==0){
                     Timer timer4 = new Timer(2000, e -> {
                        human.setIcon(GUICard.getBackCardIcon());
                        computer.setIcon(GUICard.getIcon(LowCardGame.playCard(0,0)));
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
         computer = new JLabel("Computer");
         computer.setIcon(GUICard.getBackCardIcon());
         computer.setHorizontalAlignment(JLabel.CENTER);
         computer.setVerticalTextPosition(SwingConstants.BOTTOM);
         computer.setHorizontalTextPosition(SwingConstants.CENTER);
         human = new JLabel("Human");
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
   public static int duel (Card playerCard, Hand cpu){
      //loop through cpu's cards to check if any of the cards are smaller than the player's card
      //if so, "play that card" otherwise return the highest card
      String status = "Player Wins";
      userMove = 1;
      int i = cpu.getNumCards()-1;
      for (; i>=0; i--){
         // check if cpu's card's value is less than player's card's value
         
         if (checkCards(playerCard.getValue(), cpu.inspectCard(i).getValue()) == -1){
               status = "CPU Wins";
               userMove = 0;
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
      score.setText(status);
      System.out.println("CPU CARD: "+ cpu.inspectCard(i).getValue());
      System.out.println("PLAYER CARD " + playerCard.getValue());
      System.out.println("USER MOVE " + userMove);
      return i;
   }

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
