package euler54.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/*
 *  @author Fesal.Baxhaku
 */
@AllArgsConstructor
@Data
@Builder
public class PokerHand {
    private final PokerHandType handPowerType;
    private final List<CardNumber> cardNumbers;
}
