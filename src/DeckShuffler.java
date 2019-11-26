import java.util.Random;

public class DeckShuffler {

    private static final int CARDS_IN_SUIT = 13;
    private static final int SUITS_IN_DECK = 4;
    private static final int CARDS_IN_DECK = CARDS_IN_SUIT * SUITS_IN_DECK;
    private static final String CARD_NAMES[] = {
        "2",
        "3",
        "4",
        "5",
        "6",
        "7",
        "8",
        "9",
        "T",
        "J",
        "Q",
        "K",
        "A",
    };

    private static final String SUIT_NAMES[] = {
            "S",
            "H",
            "D",
            "C"
    };

    private static final Random rand = new Random();

    private static void printCard(int cardNumber) {
        final int suitIndex = cardNumber/CARDS_IN_SUIT;
        final int cardIndex = cardNumber - (suitIndex * CARDS_IN_SUIT);
        System.out.println("(" + cardNumber + "):" + CARD_NAMES[cardIndex] + " of " + SUIT_NAMES[suitIndex]);
    }

    private static int[] shuffleDeck(int[] inputDeck) {
        int[] shuffledDeck = inputDeck.clone();
        for (int currentIndex = 0; currentIndex < CARDS_IN_DECK; currentIndex++) {
            int curCard = shuffledDeck[currentIndex];
            int swapIndex = rand.nextInt(CARDS_IN_DECK);
            int swapCard = shuffledDeck[swapIndex];
            shuffledDeck[currentIndex] = swapCard;
            shuffledDeck[swapIndex] = curCard;
        }
        return shuffledDeck;
    }

    private static int[] initializeDeck() {
        int[] deck = new int[CARDS_IN_DECK];
        for (int i=0; i<CARDS_IN_DECK; i++) {
            deck[i] = i;
        }
        return deck;
    }

    public static void main(String[] args) {
        int[] orderedDeck = initializeDeck();
        int[] shuffledDeck = shuffleDeck(orderedDeck);
        for (int cardNumber : shuffledDeck) {
            printCard(cardNumber);
        }
    }
}




