import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Collections.sort;

public class P054 implements Problem {

    public static void main(String args[]) {
        System.out.println(new P054().solve());
    }

    @Override
    public String solve() {
        try {
            Scanner in = new Scanner(new FileReader("data/p054_data.txt"));
            int wins = 0;
            while (in.hasNext()) {
                String line = in.nextLine();
                String[] cards = line.split(" ");
                Card[] firstHand = new Card[5];
                Card[] secondHand = new Card[5];
                for (int card = 0; card < 5; card++) {
                    char value = cards[card].charAt(0);
                    char suit = cards[card].charAt(1);
                    firstHand[card] = new Card(getCardValue(value), getSuit(suit));
                }
                for (int card = 5; card < 10; card++) {
                    char value = cards[card].charAt(0);
                    char suit = cards[card].charAt(1);
                    secondHand[card - 5] = new Card(getCardValue(value), getSuit(suit));
                }

                PokerHand first = new PokerHand(firstHand[0], firstHand[1], firstHand[2], firstHand[3], firstHand[4]);
                PokerHand second = new PokerHand(secondHand[0], secondHand[1], secondHand[2], secondHand[3], secondHand[4]);

                if (first.compareTo(second) > 0) {
                    wins++;
                }
            }
            return Integer.toString(wins);
        } catch (Exception e) {
            return e.toString();
        }
    }

    private int getCardValue(char c) {
        if (c == 'A') {
            return 14;
        } else if (c == 'K') {
            return 13;
        } else if (c == 'Q') {
            return 12;
        } else if (c == 'J') {
            return 11;
        } else if (c == 'T') {
            return 10;
        } else {
            return c - 48;
        }
    }

    private Suit getSuit(char c) {
        if (c == 'C') {
            return Suit.CLUB;
        } else if (c == 'H') {
            return Suit.HEART;
        } else if (c == 'D') {
            return Suit.DIAMOND;
        } else {
            return Suit.SPADE;
        }
    }

    static class PokerHand implements Comparable<PokerHand> {
        List<Card> hand = new ArrayList<>(5);

        PokerHand(Card a, Card b, Card c, Card d, Card e) {
            hand.add(a);
            hand.add(b);
            hand.add(c);
            hand.add(d);
            hand.add(e);
            sort(hand);
        }

        private void printHand() {
            for (Card card : hand) {
                System.out.print(card.getValue() + "" + card.getSuit() + " ");
            }
            System.out.println();
        }

        public int compareTo(PokerHand b) {
            if (this.getBestHand() == b.getBestHand()) {
                List<Card> handA = this.getHand();
                List<Card> handB = b.getHand();
                // We can start from highest card and compare down
                if (this.getBestHand() == HandType.STRAIGHT_FLUSH ||
                        this.getBestHand() == HandType.FLUSH ||
                        this.getBestHand() == HandType.STRAIGHT ||
                        this.getBestHand() == HandType.HIGH_CARD) {
                    return compareKickers(handA, handB);
                }

                if (this.getBestHand() == HandType.QUAD) {
                    int quadIndexA = this.hasQuad();
                    int quadIndexB = b.hasQuad();
                    return handA.get(quadIndexA).compareTo(handB.get(quadIndexB));
                }

                if (this.getBestHand() == HandType.FULL_HOUSE) {
                    int fullHouseIndexA = this.hasFullHouse();
                    int fullHouseIndexB = b.hasFullHouse();
                    return handA.get(fullHouseIndexA).compareTo(handB.get(fullHouseIndexB));
                }

                if (this.getBestHand() == HandType.SET) {
                    int setIndexA = this.hasSet();
                    int setIndexB = b.hasSet();
                    return handA.get(setIndexA).compareTo(handB.get(setIndexB));
                }

                if (this.getBestHand() == HandType.TWO_PAIR) {
                    int pairIndexA = this.hasTwoPair();
                    int pairIndexB = b.hasTwoPair();
                    // If we have the same 2 pair, then we need to compare the smaller pair
                    if (handA.get(pairIndexA).compareTo(handB.get(pairIndexB)) == 0) {
                        int firstPairIndexA = this.hasPair();
                        int firstPairIndexB = b.hasPair();
                        // If we also have the same smaller pair, we need to compare the kicker
                        if (handA.get(firstPairIndexA).compareTo(handB.get(firstPairIndexB)) == 0) {
                            return compareKickers(handA, handB);
                        } else {
                            return handA.get(firstPairIndexA).compareTo(handB.get(firstPairIndexB));
                        }
                    } else {
                        return handA.get(pairIndexA).compareTo(handB.get(pairIndexB));
                    }
                }

                if (this.getBestHand() == HandType.PAIR) {
                    int pairIndexA = this.hasPair();
                    int pairIndexB = b.hasPair();
                    // If we have the same pair, then we need to compare high cards
                    if (handA.get(pairIndexA).compareTo(handB.get(pairIndexB)) == 0) {
                        return compareKickers(handA, handB);
                    } else {
                        return handA.get(pairIndexA).compareTo(handB.get(pairIndexB));
                    }
                }
            }
            return this.getBestHand().compareTo(b.getBestHand());
        }

        int compareKickers(List<Card> handA, List<Card> handB) {
            if (handA.get(4).getValue() != handB.get(4).getValue()) {
                return handA.get(4).compareTo(handB.get(4));
            } else if (handA.get(3).getValue() != handB.get(3).getValue()) {
                return handA.get(3).compareTo(handB.get(3));
            } else if (handA.get(2).getValue() != handB.get(2).getValue()) {
                return handA.get(2).compareTo(handB.get(2));
            } else if (handA.get(1).getValue() != handB.get(1).getValue()) {
                return handA.get(1).compareTo(handB.get(1));
            } else {
                return handA.get(0).compareTo(handB.get(0));
            }
        }

        List<Card> getHand() {
            return hand;
        }

        HandType getBestHand() {
            if (hasStraight() && hasFlush()) {
                return HandType.STRAIGHT_FLUSH;
            } else if (hasQuad() != -1) {
                return HandType.QUAD;
            } else if (hasFullHouse() != -1) {
                return HandType.FULL_HOUSE;
            } else if (hasFlush()) {
                return HandType.FLUSH;
            } else if (hasStraight()) {
                return HandType.STRAIGHT;
            } else if (hasSet() != -1) {
                return HandType.SET;
            } else if (hasTwoPair() != -1) {
                return HandType.TWO_PAIR;
            } else if (hasPair() != -1) {
                return HandType.PAIR;
            } else {
                return HandType.HIGH_CARD;
            }

        }

        private int hasQuad() {
            for (int i = 0; i <= 1; i++) {
                int count = 1;
                for (int j = 1; j < hand.size(); j++) {
                    if (hand.get(i).getValue() == hand.get(j).getValue()) {
                        count++;
                    }
                }
                if (count >= 4) {
                    return i;
                }
            }
            return -1;
        }

        private int hasFullHouse() {
            if (hasSet() != -1 && hasPair() != -1) {
                return hasSet();
            } else {
                return -1;
            }
        }

        private boolean hasFlush() {
            return hand.get(0).getSuit() == hand.get(1).getSuit() &&
                    hand.get(0).getSuit() == hand.get(2).getSuit() &&
                    hand.get(0).getSuit() == hand.get(3).getSuit() &&
                    hand.get(0).getSuit() == hand.get(4).getSuit();
        }

        private boolean hasStraight() {
            return hand.get(0).getValue() + 1 == hand.get(1).getValue() &&
                    hand.get(0).getValue() + 2 == hand.get(2).getValue() &&
                    hand.get(0).getValue() + 3 == hand.get(3).getValue() &&
                    hand.get(0).getValue() + 4 == hand.get(4).getValue();
        }

        private int hasSet() {
            for (int i = 0; i <= 2; i++) {
                int count = 1;
                for (int j = i + 1; j < hand.size(); j++) {
                    if (hand.get(i).getValue() == hand.get(j).getValue()) {
                        count++;
                    }
                }
                if (count == 3) {
                    return i;
                }
            }
            return -1;
        }

        private int hasPair() {
            for (int i = 0; i <= 3; i++) {
                int count = 0;
                for (Card card : hand) {
                    if (hand.get(i).getValue() == card.getValue()) {
                        count++;
                    }
                }
                if (count == 2) {
                    return i;
                }
            }
            return -1;
        }

        private int hasTwoPair() {
            for (int i = 0; i <= 3; i++) {
                int count = 0;
                for (Card card : hand) {
                    if (hand.get(i).getValue() == card.getValue()) {
                        count++;
                    }
                }
                if (count == 2) {
                    return findSecondPair(i);
                }
            }
            return -1;
        }

        private int findSecondPair(int firstPairIndex) {
            if (firstPairIndex > 1) {
                return -1;
            } else {
                for (int i = firstPairIndex + 2; i <= 3; i++) {
                    int count = 1;
                    for (int j = i + 1; j < hand.size(); j++) {
                        if (hand.get(i).getValue() == hand.get(j).getValue()) {
                            count++;
                        }
                    }
                    if (count == 2) {
                        return i;
                    }
                }
            }
            return -1;
        }
    }

    public static class Card implements Comparable<Card> {
        Suit suit;
        int value;

        Card(int value, Suit suit) {
            this.suit = suit;
            this.value = value;
        }

        Suit getSuit() {
            return suit;
        }

        int getValue() {
            return value;
        }

        @Override
        public int compareTo(Card b) {
            return this.getValue() - b.getValue();
        }
    }

    enum HandType {
        HIGH_CARD, PAIR, TWO_PAIR, SET, STRAIGHT, FLUSH, FULL_HOUSE, QUAD, STRAIGHT_FLUSH
    }

    enum Suit {
        CLUB, SPADE, DIAMOND, HEART
    }
}
