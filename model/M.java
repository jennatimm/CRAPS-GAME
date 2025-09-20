/*
 * TCSS 305
 * Assignment 5
 * Fall 2022
 */

package model;

import java.util.Random;
import java.util.Set;

/**
 * A library that holds static final fileds for the Model of the Craps game.
 *
 * @author Jenna Timm
 * @version 1.0
 */
public class M {

    /** String to indicate player won. To be used in view and model. */
    public static final String PLAYER_WON = "Player WON";

    /** Value for when something hasn't been assigned. */
    protected static final int NOT_ASSIGNED = 0;

    /** int required for the House to win after the first roll. */
    protected static final int H_WIN_OTHER_ROUND = 7;

    /** Max number the dice rolled can be */
    protected static final int MAX_DICE = 6;

    /** Allows for a random int to be pulled. */
    protected static final Random RANDOM_INT = new Random();

    /** String to indicate House won. */
    protected static final String HOUSE_WON = "House WON";

    /** A set of #'s that would result in the House winning first roll. */
    protected static final Set<Integer> H_WIN_FIRST_ROUND = Set.of(2, 3, 12);

    /** A set of #'s that would result in the Player winning first roll. */
    protected static final Set<Integer> P_WIN_FIRST_ROUND = Set.of(7, 11);
}
