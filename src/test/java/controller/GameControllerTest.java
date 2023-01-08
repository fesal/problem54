package controller;

import euler54.controller.GameController;
import euler54.controller.PokerHandController;
import euler54.model.*;
import euler54.utils.MapList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameControllerTest {

    @Test
    public void testPlayBy2Players() {
        MapList<Integer, Card> pl = new MapList<>();
        pl.add(0, new Card(CardSuit.SPADE, CardNumber.TWO));
        pl.add(0, new Card(CardSuit.HEART, CardNumber.TWO));
        pl.add(0, new Card(CardSuit.HEART, CardNumber.NINE));
        pl.add(0, new Card(CardSuit.HEART, CardNumber.FOUR));
        pl.add(0, new Card(CardSuit.CLUB, CardNumber.NINE));

        pl.add(1, new Card(CardSuit.SPADE, CardNumber.TWO));
        pl.add(1, new Card(CardSuit.CLUB, CardNumber.NINE));
        pl.add(1, new Card(CardSuit.HEART, CardNumber.NINE));
        pl.add(1, new Card(CardSuit.DIAMOND, CardNumber.NINE));
        pl.add(1, new Card(CardSuit.DIAMOND, CardNumber.TWO));


        PokerHandController phc = new PokerHandController();
        GameController gc = new GameController(phc);

        MapList<Integer, PokerHand> result = gc.playBy2Players(pl);

        Integer key = result.getKey();

        assertEquals(key, 1,"Winner must be player with ID = 1!");
        assertEquals(result.get(key).get(0).getHandPowerType(), PokerHandType.FULL_HOUSE, "PowerHandType must be FULL HOUSE!");
    }

}
