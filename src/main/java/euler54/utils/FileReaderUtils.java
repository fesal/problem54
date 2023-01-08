package euler54.utils;

import euler54.model.Card;
import euler54.model.CardNumber;
import euler54.model.CardSuit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderUtils {
    private static int index = 0;
    public static MapList<Integer, Card> readCardFile(String filePath, String fileName) {
        MapList<Integer, Card> playersCards = new MapList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath + fileName));

            String line;
            int counter = 0;
            while ((line = br.readLine()) != null) {
                String[] cards1 = line.split(" ");
                line.split(" ");
                while(counter < 2) {
                    for (int i = 0; i < 5; i++) {
                        char[] chars = cards1[i + counter * 5].toCharArray();
                        Card card = new Card(CardSuit.findByValue(chars[1]), CardNumber.findByValue("" + chars[0]));
                        playersCards.add(index, card);
                    }
                    index ++;
                    counter++;
                }
                counter = 0;
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Cannot read file!");
        }

        return playersCards;
    }

}
