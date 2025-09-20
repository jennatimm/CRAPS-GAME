/*
 * TCSS 305
 * Assignment 5
 * Fall 2022
 */

package model;

/**
 * This class holds the logic for the Craps game.
 *
 * @author Jenna Timm
 * @version 1.0
 */
public class Craps {

    /**
     * Current Bank Amount.
     */
    private static int myBank = 0;

    /**
     * Current Stats on how many times the Player won.
     */
    private static int myPlayerWon = 0;

    /**
     * Current Stats on how many times the House won.
     */
    private static int myHouseWon = 0;

    /**
     * Current Bet amount.
     */
    private int myBet;

    /**
     * Results of the first dice rolled.
     */
    private int myFirstDice;

    /**
     * Players point. NOTE when set to 0 only when first round has not occurred.
     */
    private int myPoint;

    /**
     * Results of the second dice rolled.
     */
    private int mySecondDice;

    /**
     * Holds the dum of the two dice.
     */
    private int mySum;

    /**
     * String that holds winner. NOTE when null, no winner has been found.
     */
    private String myWinner;

    /**
     * Constructs a new Crap game to be played.
     */
    public Craps() {
        myPoint = 0;
    }

    /**
     * Rolls the dice and plays whatever round it is based off of
     * if the point has been assigned already.
     *
     * @return true if this is the first round, false otherwise.
     */
    public boolean start() {
        boolean firstRoll = (myPoint == M.NOT_ASSIGNED);
        roll();
        if (firstRoll) {
            firstRound();
        } else {
            otherRounds();
        }
        return firstRoll;
    }

    /**
     * Rolls the dice and sets the fields for the dice and sum.
     */
    public void roll() {
        myFirstDice = M.RANDOM_INT.nextInt(M.MAX_DICE) + 1;
        mySecondDice = M.RANDOM_INT.nextInt(M.MAX_DICE) + 1;
        mySum = myFirstDice + mySecondDice;
    }

    /**
     * Checks for the winner on first round or sets the players point.
     */
    public void firstRound() {
        if (M.P_WIN_FIRST_ROUND.contains(mySum)) {
            setPlayerWon();
        } else if (M.H_WIN_FIRST_ROUND.contains(mySum)) {
            setHouseWon();
        } else {
            myPoint = mySum;
        }
    }

    /**
     * Checks for winner for other rounds.
     */
    public void otherRounds() {
        if (mySum == myPoint) {
            setPlayerWon();
        } else if (mySum == M.H_WIN_OTHER_ROUND) {
            setHouseWon();
        }
    }

    /**
     * Adjusts the bank.
     *
     * @param theAmount the amount the bank needs to be changed by.
     */
    public void adjustBank(final int theAmount) {
        setBank(myBank + theAmount);
    }

    /**
     * Sets that the player won and adjusts bank as needed.
     */
    private void setPlayerWon() {
        adjustBank(myBet * 2);
        myWinner = M.PLAYER_WON;
        myPlayerWon++;
    }

    /**
     * Sets that the House won.
     */
    private void setHouseWon() {
        myWinner = M.HOUSE_WON;
        myHouseWon++;
    }

    /**
     * Getter method for bank amount.
     *
     * @return current bank amount.
     */
    public int getBank() {
        return myBank;
    }

    /**
     * Getter method for first dice.
     *
     * @return number from the first dice.
     */
    public int getFirstDice() {
        return myFirstDice;
    }

    /**
     * getter method for the Houses score.
     *
     * @return the number of times the house has won.
     */
    public int getHouseStat() {
        return myHouseWon;
    }

    /**
     * getter method for the players score.
     *
     * @return the number of times the player has won.
     */
    public int getPlayerStat() {
        return myPlayerWon;
    }

    /**
     * Getter method used in testing to get the players point.
     *
     * @return the players point
     */
    public int getPoint() {
        return myPoint;
    }

    /**
     * Getter method for second dice.
     *
     * @return number from the second dice.
     */
    public int getSecondDice() {
        return mySecondDice;
    }

    /**
     * Getter method for the sum of the dice.
     *
     * @return the sum of the dice.
     */
    public int getSum() {
        return mySum;
    }

    /**
     * Getter Method to receive the winner of this game.
     *
     * @return the String of the winner.
     */
    public String getWinner() {
        return myWinner;
    }

    /**
     * Setter method to set the bank.
     *
     * @param theAmount to set the bank.
     */
    public void setBank(final int theAmount) {
        myBank = theAmount;
    }

    /**
     * Setter method to set the bet.
     *
     * @param theBet  the intended bet
     */
    public void setBet(final int theBet) {
        myBet = theBet;
    }

    /**
     * Resets the Players stats to 0.
     */
    public static void resetPlayerWon() {
        myPlayerWon = 0;
    }

    /**
     * Resets the Houses stats to 0.
     */
    public static void resetHouseWon() {
        myHouseWon = 0;
    }
}
