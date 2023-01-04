package euler54.controller;

import euler54.model.*;
import euler54.utils.MapList;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

/*
 *  @author Fesal.Baxhaku
 */
@Data
public class PokerHandController {
    private static final int FOUR_OF_KIND = 4,
                             THREE_OF_KIND = 3,
                             ONE_PAIR = 2;

    public PokerHand handPower(List<Card> cards) {
        List<Card> sortedCards = sortReverseOrder(cards);
        MapList<CardSuit, CardNumber> suitGroup = getSuitGroup(sortedCards);

        PokerHand pokerHand = getRoyalFlush(suitGroup);

        if(pokerHand != null)
            return pokerHand;

        pokerHand = getStraightFlush(suitGroup);

        if(pokerHand != null)
            return pokerHand;

        MapList<CardNumber, CardSuit> cardNumberGroup = getNumberGroup(cards);

        pokerHand = getSameNumber(4, cardNumberGroup, PokerHandType.FOUR_OF_A_KIND);
        if(pokerHand != null)
            return pokerHand;

        pokerHand = getFullHouse(cardNumberGroup);
        if(pokerHand != null)
            return pokerHand;

        pokerHand = getFlush(suitGroup);
        if(pokerHand != null)
            return pokerHand;

        pokerHand = getConsecutiveValues(cardNumberGroup);
        if(pokerHand != null)
            return pokerHand;

        pokerHand = getSameNumber(3, cardNumberGroup, PokerHandType.THREE_OF_A_KIND);
        if(pokerHand != null)
            return pokerHand;

        pokerHand = getTwoPairs(suitGroup);
        if(pokerHand != null)
            return pokerHand;

        pokerHand = getSameNumber(2, cardNumberGroup, PokerHandType.ONE_PAIR);
        if(pokerHand != null)
            return pokerHand;

        List<CardNumber> cardNumbers = getCardNumberList(cardNumberGroup);
        pokerHand = new PokerHand(PokerHandType.HIGH_CARD, cardNumbers);

        return pokerHand;
    }

    protected PokerHand getTwoPairs(MapList<CardSuit, CardNumber> cardNumberGroup) {
        PokerHand pokerHand = null;
        int counter = 0;
        List<CardNumber> cardNumbers = new ArrayList<>();
        for(Map.Entry entry :cardNumberGroup.getMapList().entrySet()) {
            CardSuit c = (CardSuit) entry.getKey();
            List<CardNumber> cardNumberList = cardNumberGroup.get(c);
            if(cardNumberList.size() == 2) {
                counter++;
            }
            cardNumbers.addAll(cardNumberList);
        }

        if(counter == 2) {
            pokerHand = new PokerHand(PokerHandType.TWO_PAIR, cardNumbers);
        }

        return pokerHand;
    }

    protected PokerHand getConsecutiveValues(MapList<CardNumber, CardSuit> cardNumberGroup) {
        List<CardNumber> cardNumbers = getCardNumberList(cardNumberGroup);
        int max = cardNumbers.get(cardNumbers.size()-1).getValue();
        int min = cardNumbers.get(0).getValue();
        PokerHand pokerHand = null;

        if(max - min + 1 == cardNumbers.size()){
            pokerHand = new PokerHand(PokerHandType.STRAIGHT, cardNumbers);
        }

        return pokerHand;
    }

    protected PokerHand getFlush(MapList<CardSuit, CardNumber> list) {
        PokerHand pokerHand = null;
        if(list.getKeys().size() == 1) {
            pokerHand = new PokerHand(PokerHandType.FLUSH, list.getValuesByIndex(0));
        }
        return pokerHand;
    }

    protected PokerHand getFullHouse(MapList<CardNumber, CardSuit> list) {
        List<CardSuit> c1 = list.getValuesByIndex(0);
        List<CardSuit> c2 = list.getValuesByIndex(1);
        int s1 = c1.size();
        int s2 = c2.size();
        PokerHand hand = null;
        if(Math.abs( s1 - s2) == 1 && s1 >= 2 && s2 >= 2) {
            hand = new PokerHand(PokerHandType.FULL_HOUSE, list.getKeys());
        }
        return hand;
    }

    protected PokerHand getRoyalFlush(MapList<CardSuit, CardNumber> list) {
        PokerHand hand = null;
        boolean isRoyal = true;
        if(list.size()==1) {
            List<CardNumber> numbers = list.get(list.getKey());
            for (CardNumber cn: numbers){
                if (cn.getValue() < 10) {
                    isRoyal = false;
                    break;
                }
            }
            if(isRoyal)
                hand = new PokerHand(PokerHandType.ROYAL_FLUSH, numbers);
        }
        return hand;
    }

    /*
     *   getStraightFlush checks whether the player cards are Straight flush
     *   @param MapList - list of cards in the hand of the player
     *
     *   @return PokerHand of type Straight Flush
     */
    protected PokerHand getStraightFlush(MapList<CardSuit, CardNumber> list) {
        PokerHand pokerHand = null;
        List<CardNumber> numbers = list.get(list.getKey());
        numbers.sort(CardNumber.cardNumberComparator);
        int counter = 1;
        boolean isFlush = true;
        for(CardNumber cn: numbers) {
            if((cn.getValue() - numbers.get(counter).getValue()) != 1 && counter > 4) {
                isFlush = false;
            }
            counter++;
        }
        if(isFlush)
            pokerHand = new PokerHand(PokerHandType.STRAIGHT_FLUSH, numbers);

        return pokerHand;
    }

    protected PokerHand getSameNumber(int num, MapList<CardNumber, CardSuit> numberCardGroup, PokerHandType pokerHandType) {
        List<CardNumber> cardNumbers = calculateTheSameNumbers(num, numberCardGroup);
        PokerHand pokerHand = null;

        if(cardNumbers != null)
            pokerHand = new PokerHand(pokerHandType, cardNumbers);

        return pokerHand;
    }

    protected List<CardNumber> calculateTheSameNumbers(int num, MapList<CardNumber, CardSuit> numberCardGroup) {
        List<CardNumber> cardNumbers = new ArrayList<>();
        boolean isTheSame = false;
        for(Map.Entry entry :numberCardGroup.getMapList().entrySet()) {
            CardNumber c = (CardNumber) entry.getKey();
            List<CardSuit> cardSuits = numberCardGroup.get(c);
            if(cardSuits.size() == num) {
                isTheSame = true;
            }
            cardNumbers.add(c);
        }
        return isTheSame ? cardNumbers: null;
    }

    /*
     * Group different suits by the card number if any
     * @param List<Cards> - player hand to be grouped
     *
     * @return grouped card suits by number
     */
    public MapList<CardNumber, CardSuit> getNumberGroup(List<Card> cards) {
        MapList<CardNumber, CardSuit> numberGroup = new MapList<>();
        for (Card card : cards) {
            numberGroup.add(card.getCardNumber(), card.getCardSuit());
        }
        return numberGroup;
    }

    public MapList<CardSuit, CardNumber> getSuitGroup(List<Card> cards) {
        MapList<CardSuit, CardNumber> suitGroup = new MapList<>();
        for (Card card : cards) {
            suitGroup.add(card.getCardSuit(), card.getCardNumber());
        }
        return suitGroup;
    }

    protected List<CardNumber> getCardNumberList(MapList<CardNumber, CardSuit> numberCardGroup) {
        List<CardNumber> cardNumbers = new ArrayList<>();
        for(Map.Entry entry :numberCardGroup.getMapList().entrySet()) {
            CardNumber c = (CardNumber) entry.getKey();
            cardNumbers.add(c);
        }

        cardNumbers.sort(CardNumber.cardNumberComparator);

        return cardNumbers;
    }

    public List<Card> sortReverseOrder(List<Card> cards) {
        return cards.stream()
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.toList());
    }


}
