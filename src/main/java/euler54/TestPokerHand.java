package euler54;

import euler54.controller.GameController;
import euler54.controller.PokerHandController;
import euler54.model.*;
import euler54.utils.FileReaderUtils;
import euler54.utils.MapList;

import java.util.List;

public class TestPokerHand {

    public static void main(String[] args) {

        String filePath = "src/main/resources/";
        String fileName = "p054_poker.txt";
        PokerHandController c = new PokerHandController();
        GameController g = new GameController(c);
        MapList<Integer, Card> mapList = FileReaderUtils.readCardFile(filePath, fileName);

        for(int i = 0; i < mapList.size(); i += 2) {
            MapList<Integer, Card> twoPlayers = new MapList<>();
            twoPlayers.addAll(0, mapList.get(i));
            twoPlayers.addAll(1, mapList.get(i+1));

            MapList<Integer, PokerHand> r = g.playBy2Players(twoPlayers);
            List<PokerHand> winner = r.get(r.getKey());

            System.out.print("Winner is player: " + r.getKey() + " => : " + winner.get(0).getHandPowerType() + " : ");

            for (PokerHand pokerHand : winner) {
                System.out.print(pokerHand.getCardNumbers());
            }
            System.out.println();
        }

    }
}
