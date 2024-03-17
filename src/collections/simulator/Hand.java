package collections.simulator;

import java.util.*;

public class Hand implements Iterable<Card>, Comparable<Hand> {

    private List<Card> cards = new ArrayList<>();
    private final Map<Card.CardValue, Integer> valueCount = new HashMap<>();
    private final Map<Card.CardSuit, Integer> suitCount = new HashMap<>();

    public void addCard(Card card) {
        cards.add(card);
        valueCount.put(card.getValue(), valueCount.getOrDefault(card.getValue(), 0) + 1);
        suitCount.put(card.getSuit(), suitCount.getOrDefault(card.getSuit(), 0) + 1);
    }

    @Override
    public String toString() {
        return cards.toString();
    }

    public HandType getHandType() {
        if (isStraightFlush()) {
            return HandType.STRAIGHT_FLUSH;
        } else if (isFourOfAKind()) {
            return HandType.FOUR_OF_A_KIND;
        } else if (isFullHouse()) {
            return HandType.FULL_HOUSE;
        } else if (isFlush()) {
            return HandType.FLUSH;
        } else if (isStraight()) {
            return HandType.STRAIGHT;
        } else if (isThreeOfAKind()) {
            return HandType.TRIPS;
        } else if (isTwoPair()) {
            return HandType.TWO_PAIRS;
        }else if (isOnePair()) {
            return HandType.ONE_PAIR;
        }
        return HandType.HIGH_CARD;
    }

    private boolean isOnePair() {
        return valueCount.values().contains(2);
    }

    private boolean isTwoPair() {
        return Collections.frequency(new ArrayList<>(valueCount.values()), 2) == 2;
    }

    private boolean isThreeOfAKind() {
        return valueCount.values().contains(3);
    }

    private boolean isStraight() {
        if (valueCount.size() != 5) {
            return false;
        }

        List<Card.CardValue> sortedValues = new ArrayList<>(valueCount.keySet());
        sortedValues.sort(Comparator.comparingInt(Card.CardValue::ordinal));

        // Special case: Ace can be the highest card in a straight (10, J, Q, K, A)
        // or the lowest (A, 2, 3, 4, 5). Check for the lower straight with Ace.
        if (sortedValues.get(4) == Card.CardValue.A && sortedValues.get(0) == Card.CardValue.S2
                && sortedValues.get(3).ordinal() - sortedValues.get(0).ordinal() == 3) {
            return true;
        }
        return sortedValues.get(4).ordinal() - sortedValues.get(0).ordinal() == 4;
    }

    private boolean isFlush() {
        return suitCount.values().contains(5);
    }

    private boolean isFullHouse() {
        return isOnePair() && isThreeOfAKind();
    }

    private boolean isFourOfAKind() {
        return valueCount.values().contains(4);
    }

    private boolean isStraightFlush() {
        return isFlush() && isStraight();
    }

    public boolean contains(Card card) {
        return cards.contains(card);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    @Override
    public Iterator<Card> iterator() {
        return cards.iterator();
    }

    @Override
    public int compareTo(Hand other) {
        int handTypeComparison = this.getHandType().compareTo(other.getHandType());
        if (handTypeComparison != 0) {
            return handTypeComparison;
        }

        List<Card> thisCardsSorted = new ArrayList<>(this.cards);
        List<Card> otherCardsSorted = new ArrayList<>(other.cards);

        thisCardsSorted.sort(Comparator.comparing(Card::getValue).reversed());
        otherCardsSorted.sort(Comparator.comparing(Card::getValue).reversed());

        for (int i = 0; i < thisCardsSorted.size(); i++) {
            int cardComparison = thisCardsSorted.get(i).getValue().compareTo(otherCardsSorted.get(i).getValue());
            if (cardComparison != 0) {
                return cardComparison;
            }
        }

        // If the hands have the same values, compare the suits
        for (int i = 0; i < thisCardsSorted.size(); i++) {
            int suitComparison = thisCardsSorted.get(i).getSuit().compareTo(otherCardsSorted.get(i).getSuit());
            if (suitComparison != 0) {
                return suitComparison;
            }
        }

        return 0;
    }

}
