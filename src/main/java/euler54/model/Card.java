package euler54.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;

/*
 *  @author Fesal.Baxhaku
 */
@Data
@AllArgsConstructor
@Builder
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
