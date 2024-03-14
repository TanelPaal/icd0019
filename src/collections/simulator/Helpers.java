package collections.simulator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Helpers {

    public static Hand getHand(String cardValues) {
        Map<String, Card.CardValue> map = getCardValueMap();

        Hand hand = new Hand();
        for (String character : cardValues.split("")) {
            Card.CardValue cardValue = map.get(character);
            Card.CardSuit suit = getAvailableSuitFor(cardValue, hand);
            hand.addCard(new Card(cardValue, suit));
        }
        return hand;
    }

    public static Hand getSuitedHand(String cardValues) {
        Map<String, Card.CardValue> map = getCardValueMap();
        Map<String, Card.CardSuit> suitMap = getCardSuitMap();

        Hand hand = new Hand();
        List<String> characters = new ArrayList<>(List.of(cardValues.split("")));

        while (!characters.isEmpty()) {
            String value = characters.remove(0);
            String suit = characters.remove(0);
            hand.addCard(new Card(map.get(value), suitMap.get(suit)));
        }

        return hand;
    }

    public static Hand getFlushHand(String cardValues) {
        Hand hand = new Hand();
        for (Card each : getHand(cardValues)) {
            hand.addCard(new Card(each.getValue(), Card.CardSuit.S));
        }

        return hand;
    }

    private static Card.CardSuit getAvailableSuitFor(Card.CardValue cardValue, Hand hand) {
        if (hand.isEmpty()) {
            return Card.CardSuit.D;
        }

        for (Card.CardSuit suit : Card.CardSuit.values()) {
            if (!hand.contains(new Card(cardValue, suit))) {
                return suit;
            }
        }

        throw new IllegalArgumentException(
                String.format("no suit available for %s in hand %s",
                        cardValue, hand));
    }

    private static Map<String, Card.CardSuit> getCardSuitMap() {
        return Map.of(
                "s", Card.CardSuit.S,
                "h", Card.CardSuit.H,
                "d", Card.CardSuit.D,
                "c", Card.CardSuit.C);
    }

    private static Map<String, Card.CardValue> getCardValueMap() {
        Map<String, Card.CardValue> map = new HashMap<>();

        for (Card.CardValue value : Card.CardValue.values()) {
            int index = value.ordinal();
            map.put(String.valueOf("23456789TJQKA".charAt(index)), value);
        }
        return map;
    }

}
