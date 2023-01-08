package controller;

import data.CardListData;
import data.MapListData;
import euler54.controller.PokerHandController;
import euler54.model.*;
import euler54.utils.MapList;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PokerHandControllerTest {

    @Test
    @Order(1)
    public void testGetTwoPairs() {
        MapList<CardNumber, CardSuit> cardNumberGroup = MapListData.mapListData3();

        PokerHandController phc1 = PokerHandController.builder().build();
        PokerHand ph1 = phc1.getTwoPairs(cardNumberGroup);

        assertEquals(PokerHandType.TWO_PAIR, ph1.getHandPowerType(), "PokerHand type result must have two pairs!");
        assertEquals(5, ph1.getCardNumbers().size());

    }

    @Test
    @Order(2)
    public void testNullOfGetTwoPair() {
        MapList<CardNumber, CardSuit> cardNumberGroup = MapListData.mapListData2();
        PokerHandController phc2 = PokerHandController.builder().build();

        PokerHand ph2 = phc2.getTwoPairs(cardNumberGroup);

        assertNull(ph2, "Method returns PokerHand, while the result must be null!");

        List<Card> cardSet = CardListData.cardListDataSet2();
        cardNumberGroup = phc2.getNumberGroup(cardSet);
        ph2 = phc2.getTwoPairs(cardNumberGroup);

        assertEquals(PokerHandType.TWO_PAIR, ph2.getHandPowerType(), "PokerHand type result must have two pairs!");
        assertEquals(6, ph2.getCardNumbers().size());
    }

}
