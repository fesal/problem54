package controller;

import euler54.controller.PokerHandController;
import euler54.model.*;
import euler54.utils.MapList;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PokerHandControllerTest {

    @Test
    @Order(1)
    public void testGetTwoPairs() {
        MapList<CardNumber, CardSuit> cardNumberGroup = new MapList<>();
        cardNumberGroup.add(CardNumber.FIVE, CardSuit.SPADE);
        cardNumberGroup.add(CardNumber.FIVE, CardSuit.CLUB);
        cardNumberGroup.add(CardNumber.TWO, CardSuit.HEART);
        cardNumberGroup.add(CardNumber.TWO, CardSuit.DIAMOND);
        cardNumberGroup.add(CardNumber.FOUR, CardSuit.DIAMOND);

        PokerHandController phc1 = new PokerHandController();
        PokerHand ph1 = phc1.getTwoPairs(cardNumberGroup);

        assertEquals(PokerHandType.TWO_PAIR, ph1.getHandPowerType(), "PokerHand type result must have two pairs!");
        assertEquals(5, ph1.getCardNumbers().size());

    }

    @Test
    @Order(2)
    public void testNullOfGetTwoPair() {
        MapList<CardNumber, CardSuit> cardNumberGroup = new MapList<>();
        List<Card> cardNumbers = new ArrayList<>();
        cardNumbers.add(new Card(CardSuit.SPADE, CardNumber.TWO));
        cardNumbers.add(new Card(CardSuit.HEART, CardNumber.TWO));
        cardNumbers.add(new Card(CardSuit.HEART, CardNumber.NINE));
        cardNumbers.add(new Card(CardSuit.HEART, CardNumber.FOUR));

        PokerHandController phc2 = new PokerHandController();
        cardNumberGroup = phc2.getNumberGroup(cardNumbers);
        PokerHand ph2 = phc2.getTwoPairs(cardNumberGroup);

        assertNull(ph2, "Method returns PokerHand, while the result must be null since method getSuitGroup() must be called first!");

        cardNumbers.add(new Card(CardSuit.DIAMOND, CardNumber.FOUR));
        cardNumbers.add(new Card(CardSuit.DIAMOND, CardNumber.TEN));

        cardNumberGroup = phc2.getNumberGroup(cardNumbers);
        ph2 = phc2.getTwoPairs(cardNumberGroup);

        assertEquals(PokerHandType.TWO_PAIR, ph2.getHandPowerType(), "PokerHand type result must have two pairs!");
        assertEquals(6, ph2.getCardNumbers().size());
    }

}
