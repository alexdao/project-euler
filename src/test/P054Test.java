import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
class P054Test {

    @Test
    void RoyalFlushTest() {
        P054.Card a = new P054.Card(14, P054.Suit.DIAMOND);
        P054.Card b = new P054.Card(13, P054.Suit.DIAMOND);
        P054.Card c = new P054.Card(12, P054.Suit.DIAMOND);
        P054.Card d = new P054.Card(11, P054.Suit.DIAMOND);
        P054.Card e = new P054.Card(10, P054.Suit.DIAMOND);
        P054.PokerHand first = new P054.PokerHand(a, b, c, d, e);

        P054.Card f = new P054.Card(14, P054.Suit.SPADE);
        P054.Card g = new P054.Card(13, P054.Suit.SPADE);
        P054.Card h = new P054.Card(12, P054.Suit.SPADE);
        P054.Card i = new P054.Card(11, P054.Suit.SPADE);
        P054.Card j = new P054.Card(9, P054.Suit.SPADE);
        P054.PokerHand second = new P054.PokerHand(f, g, h, i, j);

        int result = getTestResult(first.compareTo(second));
        assertEquals(1, result);
    }

    @Test
    void StraightFlushTest() {
        P054.Card a = new P054.Card(2, P054.Suit.DIAMOND);
        P054.Card b = new P054.Card(6, P054.Suit.DIAMOND);
        P054.Card c = new P054.Card(3, P054.Suit.DIAMOND);
        P054.Card d = new P054.Card(5, P054.Suit.DIAMOND);
        P054.Card e = new P054.Card(4, P054.Suit.DIAMOND);
        P054.PokerHand first = new P054.PokerHand(a, b, c, d, e);

        P054.Card f = new P054.Card(13, P054.Suit.SPADE);
        P054.Card g = new P054.Card(14, P054.Suit.SPADE);
        P054.Card h = new P054.Card(14, P054.Suit.DIAMOND);
        P054.Card i = new P054.Card(14, P054.Suit.HEART);
        P054.Card j = new P054.Card(14, P054.Suit.CLUB);
        P054.PokerHand second = new P054.PokerHand(f, g, h, i, j);

        int result = getTestResult(first.compareTo(second));
        assertEquals(1, result);
    }

    @Test
    void QuadTest() {
        P054.Card a = new P054.Card(14, P054.Suit.DIAMOND);
        P054.Card b = new P054.Card(14, P054.Suit.SPADE);
        P054.Card c = new P054.Card(14, P054.Suit.DIAMOND);
        P054.Card d = new P054.Card(14, P054.Suit.DIAMOND);
        P054.Card e = new P054.Card(13, P054.Suit.DIAMOND);
        P054.PokerHand first = new P054.PokerHand(a, b, c, d, e);

        P054.Card f = new P054.Card(13, P054.Suit.SPADE);
        P054.Card g = new P054.Card(13, P054.Suit.SPADE);
        P054.Card h = new P054.Card(12, P054.Suit.SPADE);
        P054.Card i = new P054.Card(11, P054.Suit.SPADE);
        P054.Card j = new P054.Card(9, P054.Suit.SPADE);
        P054.PokerHand second = new P054.PokerHand(f, g, h, i, j);

        int result = getTestResult(first.compareTo(second));
        assertEquals(1, result);
    }

    @Test
    void FullHouseTest() {
        P054.Card a = new P054.Card(3, P054.Suit.DIAMOND);
        P054.Card b = new P054.Card(3, P054.Suit.SPADE);
        P054.Card c = new P054.Card(3, P054.Suit.HEART);
        P054.Card d = new P054.Card(2, P054.Suit.SPADE);
        P054.Card e = new P054.Card(2, P054.Suit.DIAMOND);
        P054.PokerHand first = new P054.PokerHand(a, b, c, d, e);

        P054.Card f = new P054.Card(13, P054.Suit.SPADE);
        P054.Card g = new P054.Card(12, P054.Suit.DIAMOND);
        P054.Card h = new P054.Card(11, P054.Suit.SPADE);
        P054.Card i = new P054.Card(10, P054.Suit.SPADE);
        P054.Card j = new P054.Card(9, P054.Suit.SPADE);
        P054.PokerHand second = new P054.PokerHand(f, g, h, i, j);

        int result = getTestResult(first.compareTo(second));
        assertEquals(1, result);
    }

    @Test
    void FullHouseTest2() {
        P054.Card a = new P054.Card(3, P054.Suit.DIAMOND);
        P054.Card b = new P054.Card(3, P054.Suit.SPADE);
        P054.Card c = new P054.Card(3, P054.Suit.HEART);
        P054.Card d = new P054.Card(2, P054.Suit.SPADE);
        P054.Card e = new P054.Card(2, P054.Suit.DIAMOND);
        P054.PokerHand first = new P054.PokerHand(a, b, c, d, e);

        P054.Card f = new P054.Card(4, P054.Suit.SPADE);
        P054.Card g = new P054.Card(4, P054.Suit.DIAMOND);
        P054.Card h = new P054.Card(4, P054.Suit.SPADE);
        P054.Card i = new P054.Card(2, P054.Suit.SPADE);
        P054.Card j = new P054.Card(2, P054.Suit.SPADE);
        P054.PokerHand second = new P054.PokerHand(f, g, h, i, j);

        int result = getTestResult(first.compareTo(second));
        assertEquals(-1, result);
    }

    @Test
    void FullHouseTest3() {
        P054.Card a = new P054.Card(5, P054.Suit.DIAMOND);
        P054.Card b = new P054.Card(5, P054.Suit.SPADE);
        P054.Card c = new P054.Card(5, P054.Suit.HEART);
        P054.Card d = new P054.Card(2, P054.Suit.SPADE);
        P054.Card e = new P054.Card(2, P054.Suit.DIAMOND);
        P054.PokerHand first = new P054.PokerHand(a, b, c, d, e);

        P054.Card f = new P054.Card(4, P054.Suit.SPADE);
        P054.Card g = new P054.Card(4, P054.Suit.DIAMOND);
        P054.Card h = new P054.Card(4, P054.Suit.SPADE);
        P054.Card i = new P054.Card(14, P054.Suit.SPADE);
        P054.Card j = new P054.Card(14, P054.Suit.SPADE);
        P054.PokerHand second = new P054.PokerHand(f, g, h, i, j);

        int result = getTestResult(first.compareTo(second));
        assertEquals(1, result);
    }

    @Test
    void FlushTest() {
        P054.Card a = new P054.Card(5, P054.Suit.DIAMOND);
        P054.Card b = new P054.Card(9, P054.Suit.DIAMOND);
        P054.Card c = new P054.Card(10, P054.Suit.DIAMOND);
        P054.Card d = new P054.Card(2, P054.Suit.DIAMOND);
        P054.Card e = new P054.Card(14, P054.Suit.DIAMOND);
        P054.PokerHand first = new P054.PokerHand(a, b, c, d, e);

        P054.Card f = new P054.Card(13, P054.Suit.SPADE);
        P054.Card g = new P054.Card(12, P054.Suit.DIAMOND);
        P054.Card h = new P054.Card(11, P054.Suit.SPADE);
        P054.Card i = new P054.Card(10, P054.Suit.SPADE);
        P054.Card j = new P054.Card(9, P054.Suit.SPADE);
        P054.PokerHand second = new P054.PokerHand(f, g, h, i, j);

        int result = getTestResult(first.compareTo(second));
        assertEquals(1, result);
    }

    @Test
    void StraightTest() {
        P054.Card a = new P054.Card(2, P054.Suit.DIAMOND);
        P054.Card b = new P054.Card(3, P054.Suit.DIAMOND);
        P054.Card c = new P054.Card(4, P054.Suit.DIAMOND);
        P054.Card d = new P054.Card(5, P054.Suit.DIAMOND);
        P054.Card e = new P054.Card(6, P054.Suit.SPADE);
        P054.PokerHand first = new P054.PokerHand(a, b, c, d, e);

        P054.Card f = new P054.Card(13, P054.Suit.SPADE);
        P054.Card g = new P054.Card(13, P054.Suit.DIAMOND);
        P054.Card h = new P054.Card(12, P054.Suit.SPADE);
        P054.Card i = new P054.Card(12, P054.Suit.DIAMOND);
        P054.Card j = new P054.Card(9, P054.Suit.SPADE);
        P054.PokerHand second = new P054.PokerHand(f, g, h, i, j);

        int result = getTestResult(first.compareTo(second));
        assertEquals(1, result);
    }

    @Test
    void SetTest() {
        P054.Card a = new P054.Card(2, P054.Suit.DIAMOND);
        P054.Card b = new P054.Card(2, P054.Suit.HEART);
        P054.Card c = new P054.Card(2, P054.Suit.DIAMOND);
        P054.Card d = new P054.Card(3, P054.Suit.HEART);
        P054.Card e = new P054.Card(4, P054.Suit.SPADE);
        P054.PokerHand first = new P054.PokerHand(a, b, c, d, e);

        P054.Card f = new P054.Card(13, P054.Suit.SPADE);
        P054.Card g = new P054.Card(13, P054.Suit.DIAMOND);
        P054.Card h = new P054.Card(12, P054.Suit.SPADE);
        P054.Card i = new P054.Card(12, P054.Suit.DIAMOND);
        P054.Card j = new P054.Card(9, P054.Suit.SPADE);
        P054.PokerHand second = new P054.PokerHand(f, g, h, i, j);

        int result = getTestResult(first.compareTo(second));
        assertEquals(1, result);
    }

    @Test
    void SetTest2() {
        P054.Card a = new P054.Card(2, P054.Suit.DIAMOND);
        P054.Card b = new P054.Card(2, P054.Suit.HEART);
        P054.Card c = new P054.Card(2, P054.Suit.DIAMOND);
        P054.Card d = new P054.Card(14, P054.Suit.HEART);
        P054.Card e = new P054.Card(14, P054.Suit.SPADE);
        P054.PokerHand first = new P054.PokerHand(a, b, c, d, e);

        P054.Card f = new P054.Card(3, P054.Suit.SPADE);
        P054.Card g = new P054.Card(3, P054.Suit.DIAMOND);
        P054.Card h = new P054.Card(4, P054.Suit.SPADE);
        P054.Card i = new P054.Card(2, P054.Suit.DIAMOND);
        P054.Card j = new P054.Card(3, P054.Suit.SPADE);
        P054.PokerHand second = new P054.PokerHand(f, g, h, i, j);

        int result = getTestResult(first.compareTo(second));
        assertEquals(-1, result);
    }



    @Test
    void TwoPairTest() {
        P054.Card a = new P054.Card(2, P054.Suit.DIAMOND);
        P054.Card b = new P054.Card(2, P054.Suit.HEART);
        P054.Card c = new P054.Card(3, P054.Suit.DIAMOND);
        P054.Card d = new P054.Card(3, P054.Suit.HEART);
        P054.Card e = new P054.Card(6, P054.Suit.SPADE);
        P054.PokerHand first = new P054.PokerHand(a, b, c, d, e);

        P054.Card f = new P054.Card(13, P054.Suit.SPADE);
        P054.Card g = new P054.Card(13, P054.Suit.DIAMOND);
        P054.Card h = new P054.Card(11, P054.Suit.SPADE);
        P054.Card i = new P054.Card(12, P054.Suit.DIAMOND);
        P054.Card j = new P054.Card(9, P054.Suit.SPADE);
        P054.PokerHand second = new P054.PokerHand(f, g, h, i, j);

        int result = getTestResult(first.compareTo(second));
        assertEquals(1, result);
    }

    @Test
    void PairTest() {
        P054.Card a = new P054.Card(2, P054.Suit.DIAMOND);
        P054.Card b = new P054.Card(2, P054.Suit.HEART);
        P054.Card c = new P054.Card(4, P054.Suit.DIAMOND);
        P054.Card d = new P054.Card(5, P054.Suit.HEART);
        P054.Card e = new P054.Card(6, P054.Suit.SPADE);
        P054.PokerHand first = new P054.PokerHand(a, b, c, d, e);

        P054.Card f = new P054.Card(13, P054.Suit.SPADE);
        P054.Card g = new P054.Card(12, P054.Suit.DIAMOND);
        P054.Card h = new P054.Card(11, P054.Suit.SPADE);
        P054.Card i = new P054.Card(8, P054.Suit.DIAMOND);
        P054.Card j = new P054.Card(9, P054.Suit.SPADE);
        P054.PokerHand second = new P054.PokerHand(f, g, h, i, j);

        int result = getTestResult(first.compareTo(second));
        assertEquals(1, result);
    }

    @Test
    void HighCardTest() {
        P054.Card a = new P054.Card(2, P054.Suit.DIAMOND);
        P054.Card b = new P054.Card(3, P054.Suit.HEART);
        P054.Card c = new P054.Card(4, P054.Suit.DIAMOND);
        P054.Card d = new P054.Card(5, P054.Suit.HEART);
        P054.Card e = new P054.Card(7, P054.Suit.SPADE);
        P054.PokerHand first = new P054.PokerHand(a, b, c, d, e);

        P054.Card f = new P054.Card(13, P054.Suit.SPADE);
        P054.Card g = new P054.Card(10, P054.Suit.DIAMOND);
        P054.Card h = new P054.Card(11, P054.Suit.SPADE);
        P054.Card i = new P054.Card(4, P054.Suit.DIAMOND);
        P054.Card j = new P054.Card(9, P054.Suit.SPADE);
        P054.PokerHand second = new P054.PokerHand(f, g, h, i, j);

        int result = getTestResult(first.compareTo(second));
        assertEquals(-1, result);
    }

    @Test
    void TwoPairKickerTest() {
        P054.Card a = new P054.Card(2, P054.Suit.DIAMOND);
        P054.Card b = new P054.Card(2, P054.Suit.HEART);
        P054.Card c = new P054.Card(3, P054.Suit.DIAMOND);
        P054.Card d = new P054.Card(3, P054.Suit.HEART);
        P054.Card e = new P054.Card(13, P054.Suit.SPADE);
        P054.PokerHand first = new P054.PokerHand(a, b, c, d, e);

        P054.Card f = new P054.Card(2, P054.Suit.SPADE);
        P054.Card g = new P054.Card(2, P054.Suit.DIAMOND);
        P054.Card h = new P054.Card(3, P054.Suit.SPADE);
        P054.Card i = new P054.Card(3, P054.Suit.DIAMOND);
        P054.Card j = new P054.Card(10, P054.Suit.SPADE);
        P054.PokerHand second = new P054.PokerHand(f, g, h, i, j);

        int result = getTestResult(first.compareTo(second));
        assertEquals(1, result);
    }

    @Test
    void PairKickerTest() {
        P054.Card a = new P054.Card(2, P054.Suit.DIAMOND);
        P054.Card b = new P054.Card(2, P054.Suit.HEART);
        P054.Card c = new P054.Card(4, P054.Suit.DIAMOND);
        P054.Card d = new P054.Card(5, P054.Suit.HEART);
        P054.Card e = new P054.Card(13, P054.Suit.SPADE);
        P054.PokerHand first = new P054.PokerHand(a, b, c, d, e);

        P054.Card f = new P054.Card(2, P054.Suit.SPADE);
        P054.Card g = new P054.Card(2, P054.Suit.DIAMOND);
        P054.Card h = new P054.Card(5, P054.Suit.SPADE);
        P054.Card i = new P054.Card(6, P054.Suit.DIAMOND);
        P054.Card j = new P054.Card(10, P054.Suit.SPADE);
        P054.PokerHand second = new P054.PokerHand(f, g, h, i, j);

        int result = getTestResult(first.compareTo(second));
        assertEquals(1, result);
    }

    @Test
    void HighCardKickerTest() {
        P054.Card a = new P054.Card(3, P054.Suit.HEART);
        P054.Card b = new P054.Card(4, P054.Suit.SPADE);
        P054.Card c = new P054.Card(7, P054.Suit.SPADE);
        P054.Card d = new P054.Card(8, P054.Suit.HEART);
        P054.Card e = new P054.Card(9, P054.Suit.SPADE);
        P054.PokerHand first = new P054.PokerHand(a, b, c, d, e);

        P054.Card f = new P054.Card(2, P054.Suit.HEART);
        P054.Card g = new P054.Card(4, P054.Suit.HEART);
        P054.Card h = new P054.Card(6, P054.Suit.CLUB);
        P054.Card i = new P054.Card(8, P054.Suit.SPADE);
        P054.Card j = new P054.Card(9, P054.Suit.HEART);
        P054.PokerHand second = new P054.PokerHand(f, g, h, i, j);

        int result = getTestResult(first.compareTo(second));
        assertEquals(1, result);
    }

    @Test
    void HighCardKickerTest2() {
        P054.Card a = new P054.Card(9, P054.Suit.HEART);
        P054.Card b = new P054.Card(8, P054.Suit.SPADE);
        P054.Card c = new P054.Card(7, P054.Suit.SPADE);
        P054.Card d = new P054.Card(6, P054.Suit.HEART);
        P054.Card e = new P054.Card(2, P054.Suit.SPADE);
        P054.PokerHand first = new P054.PokerHand(a, b, c, d, e);

        P054.Card f = new P054.Card(9, P054.Suit.HEART);
        P054.Card g = new P054.Card(8, P054.Suit.HEART);
        P054.Card h = new P054.Card(7, P054.Suit.CLUB);
        P054.Card i = new P054.Card(6, P054.Suit.SPADE);
        P054.Card j = new P054.Card(3, P054.Suit.HEART);
        P054.PokerHand second = new P054.PokerHand(f, g, h, i, j);

        int result = getTestResult(first.compareTo(second));
        assertEquals(-1, result);
    }

    private int getTestResult(int result) {
        int testResult;
        if (result < 0) {
            testResult = -1;
        } else if (result > 0) {
            testResult = 1;
        }
        else {
            testResult = 0;
        }
        return testResult;
    }
}