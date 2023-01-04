package euler54.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
 *  @author Fesal.Baxhaku
 */
@Data
@AllArgsConstructor
public class Card implements Comparable<Card> {
    private final CardSuit cardSuit;
    private final CardNumber cardNumber;

    @Override
    public String toString() {
        return cardSuit.toString() + cardNumber.toString();
    }

    @Override
    public int compareTo(Card card) {
        return cardNumber.getValue() - card.cardNumber.getValue();
    }
}
