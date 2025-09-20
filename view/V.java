/*
 * TCSS 305
 * Assignment 5
 * Fall 2022
 */

package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;

/**
 * A library that holds static final fileds for the View of the Craps game.
 *
 * @author Jenna Timm
 * @version 1.0
 */
public class V {

    /** A ToolKit to capture screen dimensions. */
    protected static final Toolkit KIT = Toolkit.getDefaultToolkit();

    /** The color for the bank. */
    protected static final Color BANK_COLOR = new Color(110, 141, 110);

    /** A shade of pink hand-picked by Jenna. */
    protected static final Color PINK = new Color(217, 200, 195);

    /** A shade of purple hand-picked by Jenna. */
    protected static final Color PURPLE = new Color(213, 207, 232);

    /** A shade of grey hand-picked by Jenna. */
    protected static final Color GREY = new Color(174, 175, 177);

    /** A shade of blue hand-picked by Jenna. */
    protected static final Color BLUE = new Color(138, 166, 209);

    /** A shade of a lighter blue hand-picked by Jenna. */
    protected static final Color LIGHT_BLUE = new Color(159, 179, 212);

    /** A shade of peach hand-picked by Jenna. */
    protected static final Color PEACHY = new Color(232, 148, 123);

    /** A shade of a light peach hand-picked by Jenna. */
    protected static final Color LIGHT_PEACH = new Color(252, 204, 169);

    /** A shade of minty green hand-picked by Jenna. */
    protected static final Color MINT = new Color(166, 224, 172);

    /** A shade of green hand-picked by Jenna. */
    protected static final Color GREEN = new Color(49, 222, 101);

    /** The Dimension of the screen. */
    protected static final Dimension SCREEN_SIZE = KIT.getScreenSize();

    /** The default button size. */
    protected static final Dimension BUTTON_SIZE = new Dimension(100, 25);

    /** The Titles default font. */
    protected static final Font TITLES_FONT = new Font("Serif", Font.ITALIC,
                                                   50);

    /** The frames Height. */
    protected static final int FRAME_HEIGHT = 533;

    /** The frame width. */
    protected static final int FRAME_WIDTH = 445;

    /** The max amount anyone can put in the bank. */
    protected static final int MAX_BANK = 99999;

    /** The start panels width. */
    protected static final int START_P_WIDTH = 410;

    /** The start panels height. */
    protected static final int START_P_HEIGHT = 450;

    /** The titles placement and size. */
    protected static final Rectangle TITLES_SIZE = new Rectangle(110, 100,
            BUTTON_SIZE.width * 3, BUTTON_SIZE.height * 2);

    /** The Start Panels placement and size. */
    protected static final Rectangle START_PANEL = new Rectangle(10, 10,
            START_P_WIDTH, START_P_HEIGHT);

    /** The Base Frames placement and size. */
    protected static final Rectangle BASE_FRAME_PANEL = new Rectangle(0, 0,
            V.FRAME_WIDTH, V.FRAME_HEIGHT);

    /** The Win Panels placement and size. */
    protected static final Rectangle WIN_PANEL = new Rectangle(10, 10, 260,

                                                            170);

    /** The Roll Panels placement and size. */
    protected static final Rectangle ROLL_PANEL = new Rectangle(10, 190, 260,
                                                           220);

    /** The Roll Inner Panels placement and size. */
    protected static final Rectangle ROLL_IN_PANEL = new Rectangle(10, 10, 100,
                                                              95);

    /** The Roll Grey Panels placement and size. */
    protected static final Rectangle ROLL_GREY_PANEL = new Rectangle(150, 115,
                                                              110, 105);

    /** The Bet Panels placement and size. */
    protected static final Rectangle BET_PANEL = new Rectangle(280, 135, 140,
                                                         275);

    /** The Button Panels placement and size. */
    protected static final Rectangle BUTTON_PANEL = new Rectangle(0, 80, 140,
                                                            195);

    /** The Bank Panels placement and size. */
    protected static final Rectangle BANK_PANEL = new Rectangle(280, 10, 140,
                                                          125);

    /** The Bank Grey Panels placement and size. */
    protected static final Rectangle BANK_GREY_PANEL = new Rectangle(10, 10,
                                                                   120, 120);

    /** The Bank inner Panels placement and size. */
    protected static final Rectangle BANK_IN_PANEL = new Rectangle(10, 10,
                                                            100, 95);

    /** The Set Bank Panels placement and size. */
    protected static final Rectangle SET_BANK_PANEL = new Rectangle(10, 420,
                                                             410, 45);
    /** Information on author and version. */
    protected static final String ABOUT = "AUTHOR:  Jenna Timm \nVERSION: 1.0" +
            "\nWritten with JDK 13";

    /** Tittle for the game. */
    protected static final String TITLE = "C R A P S";

    /** String for the Exit. */
    protected static final String EXIT = "Exit";

    /** String for the reset. */
    protected static final String RESET = "Reset";

    /** Rules for the game of Craps. */
    protected static final String RULES = "\t\tHOW TO PLAY " +
         "\nEvery round the player rolls two dice and the sum is calculated " +
         "\n FIRST ROLL " +
         "\nIf the sum is a 7 or 11 -> player wins!" +
         "\nIf the sum is a 2, 3, or 12 -> House wins!" +
         "\nIf any other number is the sum, that is set as the players point" +
         "\n EVERY OTHER ROLL" +
         "\nIf the sum is a 7 -> house wins!" +
         "\nIf the sum is the same as the players point -> player wins!" +
         "\nIf the sum is any other number, you just continue rolling" +
         "\nBETTING number must be a natural number." +
         " BANK must be set < 99999";

    /** Lists out all the available shortcuts for the game. */
    protected static final String SHORTCUT = "NOTE some buttons have the" +
          " same shortcut\nNOTE no shortcut keys (besides yes) available" +
          " for popups.\n\nMenu shortcuts:\nAtl + g -> Game\nAtl + s -> " +
          "Start\nAtl + r -> Reset\nAtl + e -> Exit\nAlt + h -> Help\nAlt" +
          " + a -> About\nAlt + r -> Rules\nAlt + c -> Shortcut\n\nGame Play" +
          " shortcuts:\nAlt + s -> Start\nAlt + c -> Change Color\nAlt + " +
          "enter -> Set Bank\nAlt + 1 -> add $1 to bet\nAlt + 5 -> add $5" +
          " to bet\nAlt + 0 -> add $10 to bet\nAlt + F5 -> add $50 to bet" +
          "\nAlt + F10 -> add $100 to bet\nAlt + enter -> Submit Bet\nAlt" +
          " + d -> Roll Dice\nAlt + p -> Play Again";

    /** String for the Start. */
    protected static final String START = "Start";
}
