/*
 * TCSS 305
 * Assignment 5
 * Fall 2022
 */

package controller;

import model.Craps;
import view.CrapsGUI;

/**
 * Craps controller used to start the game.
 *
 * @author Jenna Timm
 * @version 1.0
 */
public class CrapsApplication {

    /**
     * Constructs the main GUI frame.
     *
     * @param theArgs Command line arguments (ignored).
     */
    public static void main(String[] theArgs) {
        new CrapsGUI(new Craps());
    }
}


