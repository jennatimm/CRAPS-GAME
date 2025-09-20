/*
 * TCSS 305
 * Assignment 5
 * Fall 2022
 */

package tests;

import model.Craps;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Simple tests to check the odds for the craps game.
 * Created to use for debugging.
 *
 * @author Jenna Timm
 * @version 1.0
 */
class CrapsTest {

    /** tests to make sure it properly recognizes its the first round */
    @Test
    public void firstRoundStart() {
        Craps c = new Craps();
        assertEquals(0, c.getPoint());
        assertTrue(c.start());
    }

    /** tests to make the point is assigned */
    @Test
    public void firstRoundPointAssignedStart() {
        Craps c = new Craps();
        assertEquals(0, c.getPoint());
        assertTrue(c.start());
        assertNotEquals(0, c.getPoint());
    }

    /** tests to make sure after round one start returns false */
    @Test
    public void otherRoundStart() {
        Craps c = new Craps();
        assertEquals(0, c.getPoint());
        assertTrue(c.start());
        assertNotEquals(0, c.getPoint());
        assertFalse(c.start());
    }

    /** tests to make sure after round one point doesn't get changed */
    @Test
    public void otherRoundPointStart() {
        Craps c = new Craps();
        assertEquals(0, c.getPoint());
        assertTrue(c.start());
        int point = c.getPoint();
        c.start();
        assertEquals(point, c.getPoint());
    }

    /** test to make sure the dice roll correctly */
    @Test
    public void testRoll() {

        boolean seenOne = false;
        boolean seenTwo = false;
        boolean seenThree = false;
        boolean seenFour = false;
        boolean seenFive = false;
        boolean seenSix = false;
        boolean seenOther = false;

        final Craps crap = new Craps();

        for (int count = 0; count < 1000; count++) {
            crap.roll();
            int d = crap.getFirstDice();
            if (d == 1) {
                seenOne = true;
            } else if (d == 2) {
                seenTwo = true;
            } else if (d == 3) {
                seenThree = true;
            } else if (d == 4) { // this should NOT be chosen
                seenFour = true;
            } else if (d == 5) {
                seenFive = true;
            } else if (d == 6) {
                seenSix = true;
            } else // this should NOT be chosen
                seenOther = true;
            }

        assertTrue(seenOne && seenTwo && seenThree && seenFour
        && seenFive && seenSix);

        assertFalse(seenOther);
    }

    /** tests if the sum results is correctly distributed. */
    @org.junit.Test
    @Test
    public void testSumCorrectlyDistributed() {

        int seenTwo = 0;
        int seenThree = 0;
        int seenFour = 0;
        int seenFive = 0;
        int seenSix = 0;
        int seenSeven = 0;
        int seenEight = 0;
        int seenNine = 0;
        int seenTen = 0;
        int seenEleven = 0;
        int seenTwelve = 0;
        int seenOther = 0;

        final Craps crap = new Craps();
        final int max = 1000000;

        for (int count = 0; count < max; count++) {
            crap.roll();
            int d = crap.getSum();

            if (d == 2) {
                seenTwo++;
            } else if (d == 3) {
                seenThree++;
            } else if (d == 4) {
                seenFour++;
            } else if (d == 5) {
                seenFive++;
            } else if (d == 6) {
                seenSix++;
            } else if (d == 7) {
                seenSeven++;
            } else if (d == 8) {
                seenEight++;
            } else if (d == 9) {
                seenNine++;
            } else if (d == 10) {
                seenTen++;
            } else if (d == 11) {
                seenEleven++;
            } else if (d == 12) {
                seenTwelve++;
            } else {
                seenOther++;
            }
        }

        assertEquals(2, (seenTwo * 100 / max));
        assertEquals(5, (seenThree * 100 / max));
        assertEquals(8, (seenFour * 100 / max));
        assertEquals(11, (seenFive * 100 / max));
        assertEquals(13, (seenSix * 100 / max));
        assertEquals(16, (seenSeven * 100 / max));
        assertEquals(13, (seenEight * 100 / max));
        assertEquals(11, (seenNine * 100 / max));
        assertEquals(8, (seenTen * 100 / max));
        assertEquals(5, (seenEleven * 100 / max));
        assertEquals(2, (seenTwelve * 100 / max));
        assertEquals(0, seenOther);
    }

    /**
     * Tests to make sure bank gets set properly.
     * NOTE values passed in are pre-checked to be valid.
     */
    @Test
    public void testSetBank() {
        Craps c = new Craps();
        c.setBank(10);
        assertEquals(10, c.getBank());
    }

    /**
     * Tests to make sure bank gets adjusted properly.
     */
    @Test
    public void testAdjustPositiveBank() {
        Craps c = new Craps();
        c.setBank(10);
        assertEquals(10, c.getBank());
        c.adjustBank(5);
        assertEquals(15, c.getBank());
    }

    /**
     * Tests to make sure bank gets adjusted properly.
     */
    @Test
    public void testAdjustNegativeBank() {
        Craps c = new Craps();
        c.setBank(10);
        assertEquals(10, c.getBank());
        c.adjustBank(-5);
        assertEquals(5, c.getBank());
    }
}
