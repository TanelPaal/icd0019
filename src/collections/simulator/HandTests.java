package collections.simulator;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static collections.simulator.Card.CardSuit.*;
import static collections.simulator.Card.CardValue.*;
import static collections.simulator.Helpers.getFlushHand;
import static collections.simulator.Helpers.getHand;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class HandTests {

    @Test
    public void cardsCanBeCompared() {
        assertThat(new Card(A, C).compareTo(new Card(A, S)), is(0));
        assertThat(new Card(A, C).compareTo(new Card(K, S)), is(1));
        assertThat(new Card(K, H).compareTo(new Card(A, H)), is(-1));
    }

    @Test
    public void cardsCanBeSorted() {
        List<Card> cards = Arrays.asList(
                new Card(K, H),
                new Card(Q, H),
                new Card(J, H),
                new Card(S10, S),
                new Card(A, C));

        Collections.sort(cards);

        assertThat(cards.toString(),
                is("[(S10, S), (J, H), (Q, H), (K, H), (A, C)]"));
    }

    @Test
    public void getHandIsHelperMethodForCreatingHandWithTheSpecifiedCards() {
        Hand hand = getHand("AK"); // suits are arbitrary

        assertThat(hand.toString(), is("[(A, D), (K, C)]"));
    }

    @Test
    public void handKnowsWhetherItContainsOnePair() {
        assertThat(getHand("AA").getHandType(),
                is(HandType.ONE_PAIR));

        assertThat(getHand("AK").getHandType(),
                is(not(HandType.ONE_PAIR)));

        assertThat(getHand("AAKK").getHandType(),
                is(not(HandType.ONE_PAIR)));

        assertThat(getHand("AAA").getHandType(),
                is(not(HandType.ONE_PAIR)));

        assertThat(getHand("KKAAA").getHandType(),
                is(not(HandType.ONE_PAIR)));
    }

    @Test
    public void handKnowsWhetherItContainsTwoPairs() {
        assertThat(getHand("AAKK").getHandType(),
                is(HandType.TWO_PAIRS));

        assertThat(getHand("AAKKK").getHandType(),
                is(not(HandType.TWO_PAIRS)));
    }

    @Test
    public void handKnowsWhetherItContainsTrips() {
        assertThat(getHand("AAA").getHandType(),
                is(HandType.TRIPS));

        assertThat(getHand("AAKKK").getHandType(),
                is(not(HandType.TRIPS)));
    }

    @Test
    public void handKnowsWhetherItContainsStraight() {
        assertThat(getHand("A2345").getHandType(),
                is(HandType.STRAIGHT));

        assertThat(getHand("TJQKA").getHandType(),
                is(HandType.STRAIGHT));

        assertThat(getHand("2345").getHandType(),
                is(not(HandType.STRAIGHT)));

        assertThat(getHand("23567").getHandType(),
                is(not(HandType.STRAIGHT)));

        assertThat(getHand("JQKA2").getHandType(),
                is(not(HandType.STRAIGHT)));
    }

    @Test
    public void handKnowsWhetherItContainsFlush() {
        assertThat(getFlushHand("23567").getHandType(),
                is(HandType.FLUSH));

        assertThat(getHand("23456").getHandType(),
                is(not(HandType.FLUSH)));

        assertThat(getFlushHand("23456").getHandType(),
                is(not(HandType.FLUSH)));
    }

    @Test
    public void handKnowsWhetherItContainsFullHouse() {
        assertThat(getFlushHand("AKAAK").getHandType(),
                is(HandType.FULL_HOUSE));

        assertThat(getHand("AAAAK").getHandType(),
                is(not(HandType.FULL_HOUSE)));
    }

    @Test
    public void handKnowsWhetherItContainsFourOfAKind() {
        assertThat(getHand("AAAA").getHandType(),
                is(HandType.FOUR_OF_A_KIND));
    }

    @Test
    public void handKnowsWhetherItContainsStraightFlush() {
        assertThat(getFlushHand("23456").getHandType(),
                is(HandType.STRAIGHT_FLUSH));

        assertThat(getHand("23456").getHandType(),
                is(not(HandType.STRAIGHT_FLUSH)));

        assertThat(getFlushHand("23567").getHandType(),
                is(not(HandType.STRAIGHT_FLUSH)));
    }
}
