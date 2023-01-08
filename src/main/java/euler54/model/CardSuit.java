package euler54.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/*
 *  @author Fesal.Baxhaku
 */
public enum CardSuit {
    HEART ('H'),
    DIAMOND ('D'),
    SPADE ('S'),
    CLUB ('C');

    @Getter
    private char suitChar;

    CardSuit(char suitChar) {
        this.suitChar = suitChar;
    }

    public static CardSuit findByValue(final char val){
        CardSuit result = null;
        for (CardSuit suit : values()) {
            if (suit.suitChar == val) {
                result = suit;
                break;
            }
        }
        return result;
    }
}
