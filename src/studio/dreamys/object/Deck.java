package studio.dreamys.object;

import studio.dreamys.card.Card;
import studio.dreamys.card.CardSuit;
import studio.dreamys.card.CardValue;
import studio.dreamys.util.DynamicCardArray;

public class Deck {
    private DynamicCardArray cards;

    public Deck() {
        cards = new DynamicCardArray();

        //6 decks
        for (int i = 0; i < 6; i++) {
            //13 cards
            for (int j = 0; j < 13; j++) {
                //4 suits
                for (int k = 0; k < 4; k++) {
                    cards.add(new Card(CardSuit.values()[k], CardValue.values()[j]));
                }
            }
        }

        //shuffle
        for (int i = 0; i < cards.size(); i++) {
            int random = (int) (Math.random() * cards.size());
            Card temp = cards.get(i);
            cards.set(i, cards.get(random));
            cards.set(random, temp);
        }
    }

    public Card draw() {
        Card card = cards.get(0);
        cards.remove(0);
        return card;
    }
}