package collections.simulator;

import java.util.Objects;

public class Card implements Comparable<Card> {

    public enum CardValue { S2, S3, S4, S5, S6, S7, S8, S9, S10, J, Q, K, A }

    public enum CardSuit { C, D, H, S }

    private final CardValue value;
    private final CardSuit suit;

    public Card(CardValue value, CardSuit suit) {
        this.value = value;
        this.suit = suit;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Card other)) {
            return false;
        }

        return Objects.equals(value, other.value)
                && Objects.equals(suit, other.suit);
    }

    @Override
    public int compareTo(Card other) {
        return this.value.ordinal() - other.value.ordinal();
    }

    public CardValue getValue() {
        return value;
    }

    public CardSuit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return "(%s, %s)".formatted(value, suit);
    }
}
