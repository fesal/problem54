package euler54.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/*
 *  @author Fesal.Baxhaku
 */
@AllArgsConstructor
@Data
public class PokerHand {
    private final PokerHandType handPowerType;
    private final List<CardNumber> cardNumbers;
}
