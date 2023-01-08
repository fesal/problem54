package euler54.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/*
 *  @author Fesal.Baxhaku
 */
@AllArgsConstructor
public enum PokerHandType {
    HIGH_CARD("High Card", 1),
    ONE_PAIR("One Pair", 2),
    TWO_PAIR("Two Pairs", 3),
    THREE_OF_A_KIND("Three of a Kind", 4),
    STRAIGHT("Straight", 5),
    FLUSH("Flush", 6),
    FULL_HOUSE("Full House", 7),
    FOUR_OF_A_KIND("Four of a Kind", 8),
    STRAIGHT_FLUSH("Straight Flush", 9),
    ROYAL_FLUSH("Royal Flush", 10);

    @Getter
    private final String handName;
    @Getter
    private final int power;
}
