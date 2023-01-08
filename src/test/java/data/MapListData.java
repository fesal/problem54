package data;

import euler54.controller.PokerHandController;
import euler54.model.Card;
import euler54.model.CardNumber;
import euler54.model.CardSuit;
import euler54.utils.MapList;

import java.util.List;

public class MapListData {

    public static MapList<Integer, Card> mapListData() {
        MapList<Integer, Card> players = MapList.<Integer, Card>builder().build();
        players.addAll(0, CardListData.cardListDataPlayer1());
        players.addAll(1, CardListData.cardListDataPlayer2());

        return players;
    }

    public static MapList<CardNumber, CardSuit> mapListData2() {
        PokerHandController phc2 = PokerHandController.builder().build();
        List<Card> cardSet = CardListData.cardListDataSet1();

        return phc2.getNumberGroup(cardSet);
    }

    public static MapList<CardNumber, CardSuit> mapListData3() {
        PokerHandController phc2 = PokerHandController.builder().build();
        List<Card> cardSet = CardListData.cardListDataSet3();

        return phc2.getNumberGroup(cardSet);
    }
}
