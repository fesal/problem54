package euler54.controller;

import euler54.model.*;
import euler54.utils.ListUtils;
import euler54.utils.MapList;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
public class GameController {
    private PokerHandController controller;

    /*
     * playBy2Players - will check who will be the winner among players
     * @param players - players playing the game
     * return list of players in case of draw
     */
    public MapList<Integer, PokerHand> playBy2Players(MapList<Integer, Card> playersCards) {
        List<PokerHand> pokerHands = new ArrayList<>();

        for(int i = 0; i < playersCards.size(); i++) {
            List<Card> cards = playersCards.get(i);
            pokerHands.add(controller.handPower(cards));
        }

        return pokerHandsWinner(pokerHands);
    }

    private MapList<Integer, PokerHand> pokerHandsWinner(List<PokerHand> pokerHands) {
        MapList<Integer, PokerHand> winner = new MapList<>();

        for (int i = 1; i < pokerHands.size(); i++) {
            PokerHandType next = pokerHands.get(i).getHandPowerType();
            PokerHandType current = pokerHands.get(i - 1).getHandPowerType();
            if (next.getPower() > current.getPower()) {
                winner.add(i, pokerHands.get(i));
            } else if (next.getPower() < current.getPower()) {
                winner.add(i-1, pokerHands.get(i-1));
            }
            else {
                List<CardNumber> nextCards = pokerHands.get(i).getCardNumbers();
                List<CardNumber> currentCards = pokerHands.get(i - 1).getCardNumbers();
                winner = checkHigherCards(i, pokerHands, nextCards, currentCards);
            }
        }

        return winner;
    }

    private static MapList<Integer, PokerHand> checkHigherCards(int index, List<PokerHand> pokerHands, List<CardNumber> nextCards, List<CardNumber> currentCards) {
        Set<CardNumber> cn = ListUtils.findDuplicates(currentCards);
        Set<CardNumber> cn1 = ListUtils.findDuplicates(nextCards);
        MapList<Integer, PokerHand> winner = new MapList<>();
        CardNumber player1, player2;

        if(cn.size() > 0 && cn1.size() > 0) {
            player1 = ListUtils.findLastElementFromSet(cn);
            player2 = ListUtils.findLastElementFromSet(cn1);

            if(player1.getValue() > player2.getValue() ){
                winner.add(index-1, pokerHands.get(index-1));
            } else if(player1.getValue() < player2.getValue() ){
                winner.add(index, pokerHands.get(index));
            }
        }

        if(winner.size() == 0) { //if players have the same type of card, then check who has the highest card
            nextCards.sort(CardNumber.cardNumberComparator);
            currentCards.sort(CardNumber.cardNumberComparator);
            if (nextCards.get(nextCards.size() - 1).getValue() > currentCards.get(nextCards.size() - 1).getValue()) {
                winner.add(index, pokerHands.get(index));
            } else {
                winner.add(index - 1, pokerHands.get(index - 1));
                winner.add(index, pokerHands.get(index));
            }
        }

        return winner;
    }
}
