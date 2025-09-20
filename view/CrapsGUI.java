/*
 * TCSS 305
 * Assignment 5
 * Fall 2022
 */

package view;

import model.Craps;
import model.M;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * The graphical user interface for the interactive Craps game.
 *
 * @author Jenna Timm
 * @version 1.0
 */
public class CrapsGUI extends JFrame {

    /**
     * The color of the frame aka the border of the game layout.
     */
    private static Color myFrameColor = V.GREY;

    /**
     * The color of the panels for the game layout.
     */
    private static Color myPanelColor = V.PINK;

    /**
     * The current craps game being played.
     */
    private Craps myCrap;

    /**
     * Button to increase the bet by $5.
     */
    private JButton myFiveBet;

    /**
     * Button to increase the bet by $10.
     */
    private JButton myTenBet;

    /**
     * Button to increase the bet by $50.
     */
    private JButton myFiftyBet;

    /**
     * Button to increase the bet by $100.
     */
    private JButton myHundredBet;

    /**
     * Button to play again.
     */
    private JButton myPlayAgainButton;

    /**
     * Button to increase the bet by $1.
     */
    private JButton myOneBet;

    /**
     * Button to roll the dice.
     */
    private JButton myRollButton;

    /**
     * Base panel the game is built on.
     */
    private JPanel myBase;

    /**
     * Panel that is in charge of placing the bet.
     */
    private JPanel myBetPanel;

    /**
     * Panel with all the betting increase buttons.
     */
    private JPanel myButtonPanel;

    /**
     * Panel that is in charge of the rolling of the dice.
     */
    private JPanel myRollPanel;

    /**
     * Panel that is in charge of setting the bank.
     */
    private JPanel mySetBankPanel;

    /**
     * Panel that is in charge of starting the game and picking the color.
     */
    private JPanel myStartPanel;

    /**
     * Panel that is in charge of displaying the winners.
     */
    private JPanel myWinPanel;

    /**
     * MenuItem for the start button.
     */
    private JMenuItem myStart;

    /**
     * Displays the bank amount.
     */
    private JTextField myBank;

    /**
     * Displays the rules.
     */
    private JTextArea myRules;

    /**
     * Displays the bet.
     */
    private JTextField myBet;

    /**
     * Displays the first roll.
     */
    private JTextField myFirstRoll;

    /**
     * Displays how many times the house has won.
     */
    private JTextField myHouseWin;

    /**
     * Displays how many times the player has won.
     */
    private JTextField myPlayerWin;

    /**
     * Displays the players point.
     */
    private JTextField myPoint;

    /**
     * Displays the second roll.
     */
    private JTextField mySecondRoll;

    /**
     * Field to insert the bank amount.
     */
    private JTextField mySetBankField;

    /**
     * Displays the total of the two dice.
     */
    private JTextField myTotal;

    /**
     * Constructs a new CrapGUI to display the game being played and to keep
     * score of past games (until the player exits and/or restarts).
     *
     * @param theCrap is the data for the current Craps game being played.
     */
    public CrapsGUI(final Craps theCrap) {

        // set up the Frame
        super();
        myCrap = theCrap;
        setBounds(V.SCREEN_SIZE.width / 2 - V.FRAME_WIDTH / 2,
                V.SCREEN_SIZE.height / 2 - V.FRAME_HEIGHT / 2,
                V.FRAME_WIDTH, V.FRAME_HEIGHT);
        setTitle(V.TITLE);
        getContentPane().setBackground(myFrameColor);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        setUpMenu();
        start();

        setVisible(true);
    }

    /**
     * Sets up the menu on the frame.
     */
    private void setUpMenu() {
        //Set up the menu bar
        JMenuBar menuBar = new JMenuBar();

        //Set uo the menus
        JMenu help = new JMenu("Help");
        JMenu game = new JMenu("Game");
        help.setMnemonic(KeyEvent.VK_H);
        game.setMnemonic(KeyEvent.VK_G);

        //Sets up menu items
        JMenuItem about = createMenuItem("About", KeyEvent.VK_A);
        JMenuItem rules = createMenuItem("Rules", KeyEvent.VK_R);
        JMenuItem shortcut = createMenuItem("Shortcuts Key", KeyEvent.VK_C);
        myStart = createMenuItem(V.START, KeyEvent.VK_S);
        JMenuItem reset = createMenuItem(V.RESET, KeyEvent.VK_R);
        JMenuItem exit = createMenuItem(V.EXIT, KeyEvent.VK_E);

        //adds the listeners
        about.addActionListener(
                theEvent -> JOptionPane.showMessageDialog(null, V.ABOUT));
        rules.addActionListener(
                theEvent -> JOptionPane.showMessageDialog(null, V.RULES));
        shortcut.addActionListener(
                theEvent -> JOptionPane.showMessageDialog(null, V.SHORTCUT));
        myStart.addActionListener(theEvent -> layoutGame());
        reset.addActionListener(theEvent -> resetGame());
        exit.addActionListener(theEvent -> exit());

        //add menusItems -> menus -> menuBar -> frame
        help.add(about);
        help.add(rules);
        help.add(shortcut);
        game.add(myStart);
        game.add(reset);
        game.add(exit);
        menuBar.add(game);
        menuBar.add(help);
        setJMenuBar(menuBar);
    }

    /**
     * Method that checks if the user meant to press exit
     * and exits the game if yes.
     */
    private void exit() {
        if (dropCurrentGame(V.EXIT)) {
            System.exit(0);
        }
    }

    /**
     * Sets up the start screen with rules and color changing option.
     */
    private void start() {
        //Set up Panels
        myStartPanel = createPanel(V.START_PANEL);

        //Set up Title and Rules
        myStartPanel.add(createTitle());
        myRules = new JTextArea(V.RULES);
        myRules.setBounds(10, 260, 390, 180);
        myRules.setBackground(myPanelColor);
        myRules.setEditable(false);

        //Set up Buttons and enable start MenuItem
        JButton startButton = createButton(V.START, KeyEvent.VK_S, 162, 180);
        startButton.addActionListener(thEvent -> layoutGame());
        JButton colorButton = createButton("Change Color", KeyEvent.VK_C,
                                      137, 220, 150);
        colorButton.addActionListener(theEvent -> pickColor());
        myStart.setEnabled(true);

        //add it all up
        myStartPanel.add(myRules);
        myStartPanel.add(colorButton);
        myStartPanel.add(startButton);
        add(myStartPanel);
    }

    /**
     * Creates the base panel for the game and builds the layout on top of it.
     * Also disables the start button.
     */
    private void layoutGame() {
        //create my base panel and remove the start panel
        myBase = createPanel(V.BASE_FRAME_PANEL, myFrameColor);
        remove(myStartPanel);
        repaint();

        //set up game and disable start
        setUpWins();
        setUpRoll();
        setUpBet();
        setUpBank();
        setUpBankAmount();

        add(myBase);
        myStart.setEnabled(false);
    }

    /**
     * Sets up the win panel and adds it to the base.
     */
    private void setUpWins() {
        //set up Win Panel
        JPanel winBase = createPanel(V.WIN_PANEL);
        myWinPanel = createPanel(V.WIN_PANEL);
        myWinPanel.setVisible(false);

        //Set up Fields
        myPlayerWin = createFields(100, 45, false);
        myHouseWin = createFields(100, 80, false);

        //Set up Buttons
        myPlayAgainButton = createButton("Play Again?", KeyEvent.VK_P,
                                    145, 130);
        myPlayAgainButton.addActionListener(theEvent -> newRound());
        myPlayAgainButton.setVisible(false);

        //Add it all up
        myWinPanel.add(createLabels("# of Games won:", 10, 10));
        myWinPanel.add(createLabels("Player:", 50, 45));
        myWinPanel.add(createLabels("House:", 50, 80));
        myWinPanel.add(myPlayerWin);
        myWinPanel.add(myHouseWin);
        myWinPanel.add(myPlayAgainButton);

        myBase.add(myWinPanel);
        myBase.add(winBase);
    }

    /**
     * Sets up the roll panel and adds it to the base.
     */
    private void setUpRoll() {
        //Set up the current roll Panel
        JPanel rollBase = createPanel(V.ROLL_PANEL);
        JPanel inner = createPanel(V.ROLL_IN_PANEL);
        JPanel grey = createPanel(V.ROLL_GREY_PANEL, myFrameColor);
        myRollPanel = createPanel(V.ROLL_PANEL);
        myRollPanel.setVisible(false);

        //Set up TextFields
        myFirstRoll = createFields(90, 50, false);
        myPoint = createFields(10, 50, V.BUTTON_SIZE.width - 20, false);
        mySecondRoll = createFields(90, 80, false);
        myTotal = createFields(90, 110, V.BUTTON_SIZE.width / 2, false);

        //Set up Labels
        inner.add(createLabels("P O I N T", 25, 19));
        myRollPanel.add(createLabels("Current Roll", 100, 20));
        myRollPanel.add(createLabels("DICE 1 :", 30, 50));
        myRollPanel.add(createLabels("DICE 2  :", 30, 80));
        myRollPanel.add(createLabels("Total:", 40, 110));

        //Set up Button and listener
        myRollButton = createButton("Roll Dice", KeyEvent.VK_D, 25, 165);
        myRollButton.addActionListener(theEvent -> roll());

        //Add it all up
        inner.add(myPoint);
        grey.add(inner);
        myRollPanel.add(grey);
        myRollPanel.add(myFirstRoll);
        myRollPanel.add(mySecondRoll);
        myRollPanel.add(myRollButton);
        myRollPanel.add(myTotal);

        myBase.add(myRollPanel);
        myBase.add(rollBase);
    }

    /**
     * Set up bet panel and add it to the base.
     */
    private void setUpBet() {
        //Set up Bet Panel
        JPanel betBase = createPanel(V.BET_PANEL);
        myBetPanel = createPanel(V.BET_PANEL);
        myButtonPanel = createPanel(V.BUTTON_PANEL);
        myBetPanel.setVisible(false);

        //Set up Fields
        myBet = createFields(35, 20, V.BUTTON_SIZE.width - 30, true);
        myBet.setText("0");

        //set up Buttons
        myOneBet = createButton("+ $1.00", KeyEvent.VK_1,
                           30, 0, V.BUTTON_SIZE.width - 20);
        myFiveBet = createButton("+ $5.00", KeyEvent.VK_5,
                            28, 30, V.BUTTON_SIZE.width - 16);
        myTenBet = createButton("+ $10.00", KeyEvent.VK_0,
                           26, 60, V.BUTTON_SIZE.width - 12);
        myFiftyBet = createButton("+ $50.00", KeyEvent.VK_F5,
                             24, 90, V.BUTTON_SIZE.width - 8);
        myHundredBet = createButton("+ $100.00", KeyEvent.VK_F10,
                               22, 120, V.BUTTON_SIZE.width - 4);
        JButton submitBet = createButton("Submit Bet", KeyEvent.VK_ENTER,
                                      20, 150);

        //Add the listeners
        myOneBet.addActionListener(theEvent -> addToBet(1));
        myFiveBet.addActionListener(theEvent -> addToBet(5));
        myTenBet.addActionListener(theEvent -> addToBet(10));
        myFiftyBet.addActionListener(theEvent -> addToBet(50));
        myHundredBet.addActionListener(theEvent -> addToBet(100));
        submitBet.addActionListener(theEvent -> setBet());

        //Add it all up
        myButtonPanel.add(myOneBet);
        myButtonPanel.add(myFiveBet);
        myButtonPanel.add(myTenBet);
        myButtonPanel.add(myFiftyBet);
        myButtonPanel.add(myHundredBet);
        myButtonPanel.add(submitBet);
        myBetPanel.add(myButtonPanel);
        myBetPanel.add(createLabels("Current Bet", 32, 50));
        myBetPanel.add(myBet);

        myBase.add(myBetPanel);
        myBase.add(betBase);
    }

    /**
     * Set up bank panel and add to base.
     */
    private void setUpBank() {
        //set up panels
        JPanel bankPanel = createPanel(V.BANK_PANEL, V.BANK_COLOR);
        JPanel grey = createPanel(V.BANK_GREY_PANEL, myFrameColor);
        JPanel inner = createPanel(V.BANK_IN_PANEL);

        //Set up TextField
        myBank = createFields(10, 50, V.BUTTON_SIZE.width - 20, false);

        //Add it all up
        inner.add(createLabels("B A N K", 28, 20));
        inner.add(myBank);
        grey.add(inner);
        bankPanel.add(grey);
        myBase.add(bankPanel);
    }

    /**
     * Set up the panel that sets my bank and adds it to the base.
     */
    private void setUpBankAmount() {
        //Set up Bet Panel
        JPanel setBankBase = createPanel(V.SET_BANK_PANEL);
        mySetBankPanel = createPanel(V.SET_BANK_PANEL);

        //set up TextFields
        mySetBankField = createFields(210, 10, true);

        //setUpButtons
        JButton setBankButton = createButton("Set Bank-->",
                                               KeyEvent.VK_ENTER, 110, 10);
        setBankButton.addActionListener(theEvent -> setBankView());

        //Add it all up
        mySetBankPanel.add(setBankButton);
        mySetBankPanel.add(mySetBankField);
        myBase.add(mySetBankPanel);
        myBase.add(setBankBase);
    }

    /**
     * Sets the view for the bank.
     */
    private void setBankView() {
        if (validInput(mySetBankField.getText(), V.MAX_BANK)) {
            int amount = Integer.parseInt(mySetBankField.getText());
            myCrap.setBank(amount);
            setTextView(myBank, "$" + amount);
            checkBetButtons();
            mySetBankPanel.setVisible(false);
            myBetPanel.setVisible(true);

        }
        mySetBankField.setText(null);
    }

    /**
     * Rolls the dice and checks for winner.
     * Also sets all the fields as needed.
     */
    private void roll() {
        boolean firstRound = myCrap.start();
        myFirstRoll.setText(String.valueOf(myCrap.getFirstDice()));
        mySecondRoll.setText(String.valueOf(myCrap.getSecondDice()));
        myTotal.setText(String.valueOf(myCrap.getSum()));

        if (myCrap.getWinner() != null) {
            myPoint.setText(myCrap.getWinner());
            checkWinner(myCrap.getWinner());
        } else if (firstRound) {
            myPoint.setText(String.valueOf(myCrap.getSum()));
        }
    }

    /**
     * Checks for winner from the craps game and changes bank based on results.
     * Makes win panel and play button visible. Disables roll button.
     *
     * @param theWinner is a String that represents the winner.
     */
    private void  checkWinner(final String theWinner) {
        if (theWinner.equals(M.PLAYER_WON)) {
            myPlayerWin.setText(String.valueOf(myCrap.getPlayerStat()));
            myBank.setText("$" + myCrap.getBank());
        } else {
            myHouseWin.setText(String.valueOf(myCrap.getHouseStat()));
        }
        myWinPanel.setVisible(true);
        myRollButton.setVisible(false);
        myPlayAgainButton.setVisible(true);
        myBet.setText("0");
    }

    /**
     * Adds to the potential bet amount based off the button being clicked.
     * NOTE It does not officially set the bet.
     *
     * @param theNumber is the amount being added.
     */
    private void addToBet(final int theNumber) {
        String betString = myBet.getText();
        if (validInput(betString, myCrap.getBank()) || betString.equals("0")) {
            int betNumber = Integer.parseInt(betString) + theNumber;
            if (betNumber <= myCrap.getBank()) {
                myBet.setText(String.valueOf(betNumber));
            }
        }
    }

    /**
     * Sets the bet based off of what is in the betTextField IF it is a
     * valid number.
     * NOTE only natural numbers are valid (not including 0).
     */
    private void setBet() {
        String betString = myBet.getText();
        if (validInput(betString, myCrap.getBank())) {
            int betNumber = Integer.parseInt(betString);
            myCrap.setBet(Integer.parseInt(betString));
            myCrap.adjustBank(-betNumber);
            setTextView(myBet, "$" + betNumber);
            setTextView(myBank, "$" + myCrap.getBank());
            myButtonPanel.setVisible(false);
            myRollPanel.setVisible(true);
            myRollButton.setVisible(true);
            myBet.setEditable(false);
        } else {
            myBet.setText("0");
        }
    }

    /**
     * checks if the player meant to press the reset button and then if true,
     * resets the game by throwing away the base panel and creating a new one.
     */
    private void resetGame() {
        if (dropCurrentGame(V.RESET)) {
            Craps.resetHouseWon();
            Craps.resetPlayerWon();
            remove(myBase);
            repaint();
            myCrap = new Craps();
            start();
        }
    }

    /**
     * Erases all information for the current round and starts a new Craps
     * game.
     */
    private void newRound() {
        if (myCrap.getBank() > 0) {
            checkBetButtons();
            myBet.setEditable(true);
            myCrap = new Craps();

            myPoint.setText(null);
            myFirstRoll.setText(null);
            mySecondRoll.setText(null);
            myTotal.setText(null);

            myButtonPanel.setVisible(true);
            myRollPanel.setVisible(false);
            myPlayAgainButton.setVisible(false);
        } else {
            noMoney();
        }
    }

    /**
     * Makes any bet button higher than the current bank amount invisible so
     * the player doesn't think it's a bet option.
     */
    private void checkBetButtons() {
        myHundredBet.setVisible(myCrap.getBank() >= 100);
        myFiftyBet.setVisible(myCrap.getBank() >= 50);
        myTenBet.setVisible(myCrap.getBank() >= 10);
        myFiveBet.setVisible(myCrap.getBank() >= 5);
        myOneBet.setVisible(myCrap.getBank() >= 1);
    }

    /**
     * Gives the player an option to restart the game when they run out of
     * money.
     */
    private void noMoney() {
        String message = "You have no money tho :( Wanna reset?";
        boolean exit;
        int result = JOptionPane.showConfirmDialog(null, message,
                "U Broke", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            resetGame();
        } else {
            exit = (dropCurrentGame(V.EXIT));
            if (exit) {
                System.exit(0);
            } else {
                noMoney();
            }
        }
    }

    /**
     * Checks if the user actually wants to drop the game.
     *
     * @param theCommand is what the user is trying to do.
     * @return true if the user responds yes and false otherwise.
     */
    private boolean dropCurrentGame(final String theCommand) {
        String message = "Are you sure you want to " + theCommand + "?";
        int result = JOptionPane.showConfirmDialog(null, message,
                "W A I T !", JOptionPane.YES_NO_OPTION);
        return result == JOptionPane.YES_OPTION;
    }

    /**
     * Picks the new frame and panel color based off the previous color.
     */
    private void pickColor() {
        if (myPanelColor == V.PEACHY) {
            changeColor(V.GREY, V.PINK);
        } else if (myPanelColor == V.PINK) {
            changeColor(V.BLUE, V.LIGHT_BLUE);
        } else if (myPanelColor == V.LIGHT_BLUE) {
            changeColor(V.GREY, V.PURPLE);
        } else if (myPanelColor == V.PURPLE) {
            changeColor(V.GREEN, V.MINT);
        } else {
            changeColor(V.LIGHT_PEACH, V.PEACHY);
        }
    }

    /**
     * Changes the frame and panel color.
     *
     * @param theFrame is the new color for the frame.
     * @param thePanel is the new color for the panel.
     */
    private void changeColor(final Color theFrame, final Color thePanel) {
        myStartPanel.setBackground(thePanel);
        getContentPane().setBackground(theFrame);
        myRules.setBackground(thePanel);
        myPanelColor = thePanel;
        myFrameColor = theFrame;
    }

    /**
     * Creates a panel then sets the bounds and default color in one call.
     *
     * @param theR Holds the width, height, x and y coordinate.
     * @return the panel all set up.
     */
    private static JPanel createPanel(final Rectangle theR) {
        return createPanel(theR, myPanelColor);
    }

    /**
     * Creates a panel then sets the bounds and color in one call.
     *
     * @param theR Holds the width, height, x and y coordinate.
     * @param theColor is the color for the panel.
     * @return the panel all set up.
     */
    private static JPanel createPanel(final Rectangle theR,
                                      final Color theColor) {
        JPanel current = new JPanel(null);
        current.setBounds(theR);
        current.setBackground(theColor);
        return current;
    }

    /**
     * Creates a button then sets the bounds and keyboard shortcut in one call.
     *
     * @param theTitle the intended title.
     * @param theShortcut the intended shortcut key.
     * @param theX the x-coordinate for the button.
     * @param theY the y-coordinate for the button.
     * @return the button all set up
     */
    private static JButton createButton(final String theTitle,
                                        final int theShortcut,
                                        final int theX, final int theY) {
        return createButton(theTitle, theShortcut, theX, theY,
                            V.BUTTON_SIZE.width);
    }

    /**
     * Creates a button then sets the bounds and keyboard shortcut in one call.
     *
     * @param theTitle the intended title.
     * @param theShortcut the intended shortcut key.
     * @param theX the x-coordinate for the button.
     * @param theY the y-coordinate for the button.
     * @param theWidth the width for the button.
     * @return the button all set up
     */
    private static JButton createButton(final String theTitle,
                                        final int theShortcut, final int theX,
                                        final int theY, final int theWidth) {
        JButton current = new JButton(theTitle);
        current.setMnemonic(theShortcut);
        current.setBounds(theX, theY, theWidth, V.BUTTON_SIZE.height);
        return current;
    }

    /**
     * Creates a textField then sets up it's Horizontal Alignment,
     * bounds and edit ability  in one call.
     *
     * @param theX the x-coordinate for the field.
     * @param theY the y-coordinate for the field.
     * @param theIsEditable is its able to be edited.
     * @return the textField all set up.
     */
    private static JTextField createFields(final int theX, final int theY,
                                           final boolean theIsEditable) {
        return createFields(theX, theY, V.BUTTON_SIZE.width, theIsEditable);
    }

    /**
     * Creates a textField then sets up it's Horizontal Alignment,
     * bounds and edit ability  in one call.
     *
     * @param theX the x-coordinate for the field.
     * @param theY the y-coordinate for the field.
     * @param theWidth the Width for the field.
     * @param theIsEditable is its able to be edited.
     * @return the textField all set up.
     */
    private static JTextField createFields(final int theX, final int theY,
                                           final int theWidth,
                                           final boolean theIsEditable) {
        JTextField current = new JTextField();
        current.setHorizontalAlignment(JTextField.CENTER);
        current.setEditable(theIsEditable);
        current.setBounds(theX, theY, theWidth, V.BUTTON_SIZE.height);
        return current;
    }

    /**
     * Creates the label and sets its bounds in one call.
     *
     * @param theTitle the intended title for the label.
     * @param theX the x-coordinate for the label.
     * @param theY the y-coordinate for the label.
     * @return the label all set up.
     */
    private static JLabel createLabels(final String theTitle,
                                       final int theX, final int theY) {
        JLabel current = new JLabel(theTitle);
        current.setBounds(theX, theY, V.BUTTON_SIZE.width,
                          V.BUTTON_SIZE.height);
        return current;
    }

    /**
     * Creates the menuItem and sets its shortcut in one call.
     *
     * @param theTitle the intended title.
     * @param theShortcut the indented shortcut key.
     * @return the menuItem all set up.
     */
    private static JMenuItem createMenuItem(final String theTitle,
                                            final int theShortcut) {
        JMenuItem current = new JMenuItem(theTitle);
        current.setMnemonic(theShortcut);
        return current;
    }

    /**
     * Creates the Title for the game.
     *
     * @return the finished title.
     */
    private static JLabel createTitle() {
        JLabel current = new JLabel(V.TITLE);
        current.setBounds(V.TITLES_SIZE);
        current.setFont(V.TITLES_FONT);
        return current;
    }

    /**
     * Checks to see if the input is valid.
     * Must be a natural number and less than theMax.
     *
     * @param theIn the number to be checked.
     * @param theMax the max the number can be.
     * @return if the input is valid.
     */
    private static boolean validInput(final String theIn, final int theMax) {
        boolean valid;
        try {
            final int val = Integer.parseInt(theIn);
            valid = val <= theMax && val > 0;
        } catch (final NumberFormatException e) {
            valid = false;
        }
        return valid;
    }

    /**
     * Sets the text and makes the field no editable at the same time.
     *
     * @param theField to be set.
     * @param theAmount the field is to be set too.
     */
    private static void setTextView(final JTextField theField,
                                    final String theAmount) {
        theField.setEditable(false);
        theField.setText(theAmount);
    }
}
