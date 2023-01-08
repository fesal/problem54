package euler54.utils;

import euler54.model.Card;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

@Builder
@Data
public class CardList {

    @Singular("cards")
    private List<Card> cards;
}
