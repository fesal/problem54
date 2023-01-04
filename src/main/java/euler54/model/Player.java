package euler54.model;

import lombok.Data;

import java.util.List;

/*
 *  @author Fesal.Baxhaku
 */
@Data
public class Player {
    private int number;
    private String username;
    private List<Card> cards;
    private int score; //how many times the player has won the game
}
