package euler54.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/*
 *  @author Fesal.Baxhaku
 */
@AllArgsConstructor
public enum CardSuit {
    HEART ('H'),
    DIAMOND ('D'),
    SPADE ('S'),
    CLUB ('C');

    @Getter
    private final char suitChar;
}
