package data;

import euler54.model.Card;
import euler54.model.CardNumber;
import euler54.model.CardSuit;
import euler54.utils.CardList;

import java.util.List;

public class CardListData {

    public static List<Card> cardListDataPlayer1() {
            CardList cardList = CardList.builder()
                                        .cards(Card.builder().cardNumber(CardNumber.TWO).cardSuit(CardSuit.SPADE).build())
                                        .cards(Card.builder().cardNumber(CardNumber.TWO).cardSuit(CardSuit.HEART).build())
                                        .cards(Card.builder().cardNumber(CardNumber.NINE).cardSuit(CardSuit.HEART).build())
                                        .cards(Card.builder().cardNumber(CardNumber.FOUR).cardSuit(CardSuit.HEART).build())
                                        .cards(Card.builder().cardNumber(CardNumber.NINE).cardSuit(CardSuit.CLUB).build())
                                        .build();
            return cardList.getCards();
    }

    public static List<Card> cardListDataPlayer2() {
        CardList cardList = CardList.builder()
                .cards(Card.builder().cardNumber(CardNumber.TWO).cardSuit(CardSuit.SPADE).build())
                .cards(Card.builder().cardNumber(CardNumber.NINE).cardSuit(CardSuit.CLUB).build())
                .cards(Card.builder().cardNumber(CardNumber.NINE).cardSuit(CardSuit.HEART).build())
                .cards(Card.builder().cardNumber(CardNumber.NINE).cardSuit(CardSuit.DIAMOND).build())
                .cards(Card.builder().cardNumber(CardNumber.TWO).cardSuit(CardSuit.DIAMOND).build())
                .build();
        return cardList.getCards();
    }

    public static List<Card> cardListDataSet1() {
        CardList cardList = CardList.builder()
                                    .cards(Card.builder().cardNumber(CardNumber.TWO).cardSuit(CardSuit.SPADE).build())
                                    .cards(Card.builder().cardNumber(CardNumber.TWO).cardSuit(CardSuit.HEART).build())
                                    .cards(Card.builder().cardNumber(CardNumber.NINE).cardSuit(CardSuit.HEART).build())
                                    .cards(Card.builder().cardNumber(CardNumber.FOUR).cardSuit(CardSuit.HEART).build())
                                    .build();

        return cardList.getCards();
    }

    public static List<Card> cardListDataSet2() {
        CardList cardList = CardList.builder()
                                    .cards(cardListDataSet1())
                                    .cards(Card.builder().cardNumber(CardNumber.FOUR).cardSuit(CardSuit.DIAMOND).build())
                                    .cards(Card.builder().cardNumber(CardNumber.TEN).cardSuit(CardSuit.DIAMOND).build())
                                    .build();

        return cardList.getCards();
    }

    public static List<Card> cardListDataSet3() {
        CardList cardList = CardList.builder()
                                    .cards(Card.builder().cardNumber(CardNumber.FIVE).cardSuit(CardSuit.SPADE).build())
                                    .cards(Card.builder().cardNumber(CardNumber.FIVE).cardSuit(CardSuit.CLUB).build())
                                    .cards(Card.builder().cardNumber(CardNumber.TWO).cardSuit(CardSuit.HEART).build())
                                    .cards(Card.builder().cardNumber(CardNumber.FOUR).cardSuit(CardSuit.DIAMOND).build())
                                    .cards(Card.builder().cardNumber(CardNumber.TWO).cardSuit(CardSuit.DIAMOND).build())
                                    .build();

        return cardList.getCards();
    }

}
