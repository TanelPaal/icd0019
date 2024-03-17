package collections.simulator;

import java.util.*;

public class Simulator {
    private double iterations;

    public Simulator(double iterations) {
        this.iterations = iterations;
    }

    public Map<HandType, Double> calculateProbabilities() {
        Map<HandType, Integer> handTypeCounts = new HashMap<>();

        for (int i = 0; i < iterations; i++) {
            List<Card> deck = generateShuffledDeck();
            Hand hand = new Hand();
            for (int j = 0; j < 5; j++) {
                hand.addCard(deck.get(j));
            }
            HandType handType = hand.getHandType();
            handTypeCounts.put(handType, handTypeCounts.getOrDefault(handType, 0) + 1);
        }

        Map<HandType, Double> handTypeProbabilities = new HashMap<>();
        for (HandType handType : handTypeCounts.keySet()) {
            double probability = handTypeCounts.get(handType) / iterations * 100;
            handTypeProbabilities.put(handType, probability);
        }

        return handTypeProbabilities;
    }

    private List<Card> generateShuffledDeck() {
        List<Card> deck = new ArrayList<>();
        for (Card.CardSuit suit : Card.CardSuit.values()) {
            for (Card.CardValue value : Card.CardValue.values()) {
                deck.add(new Card(value, suit));
            }
        }
        Collections.shuffle(deck);
        return deck;
    }

    public double getWinningOdds(Hand player1hand, Hand player2hand) {
        int player1Wins = 0;
        int draws = 0;

        for (int i = 0; i < iterations; i++) {
            List<Card> deck = generateShuffledDeck();
            deck.remove(player1hand.iterator().next());
            deck.remove(player1hand.iterator().next());
            deck.remove(player2hand.iterator().next());
            deck.remove(player2hand.iterator().next());

            Hand communityCards = drawHand(deck, 5);

            Hand player1BestHand = getBestHand(player1hand, communityCards);
            Hand player2BestHand = getBestHand(player2hand, communityCards);

            int comparisonResult = player1BestHand.compareTo(player2BestHand);
            if (comparisonResult > 0) {
                player1Wins++;
            } else if (comparisonResult == 0) {
                draws++;
            }
        }

        if (player1Wins == 0 && draws == 0) {
            return 0.0;
        }

        return player1Wins / (iterations - draws) * 100;
    }

    private Hand drawHand(List<Card> deck, int numCards) {
        Hand hand = new Hand();
        for (int i = 0; i < numCards; i++) {
            hand.addCard(deck.remove(deck.size() - 1));
        }
        return hand;
    }

    private Hand getBestHand(Hand playerHand, Hand communityCards) {
        List<Card> sevenCards = new ArrayList<>();
        playerHand.forEach(sevenCards::add);
        communityCards.forEach(sevenCards::add);

        List<Hand> possibleHands = getPossibleHands(sevenCards);
        return Collections.max(possibleHands);
    }

    private List<Hand> getPossibleHands(List<Card> sevenCards) {
        List<Hand> possibleHands = new ArrayList<>();
        for (int i = 0; i < sevenCards.size(); i++) {
            for (int j = i + 1; j < sevenCards.size(); j++) {
                Hand hand = new Hand();
                for (int k = 0; k < sevenCards.size(); k++) {
                    if (k != i && k != j) {
                        hand.addCard(sevenCards.get(k));
                    }
                }
                possibleHands.add(hand);
            }
        }
        return possibleHands;
    }

}
