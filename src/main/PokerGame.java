package main;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PokerGame {

    public static String play(List<Card> cards_1, List<Card> cards_2) {

        List<Card> cards1 = cards_1.stream().sorted(Comparator.comparing(Card::getNumber)).collect(Collectors.toList());
        List<Card> cards2 = cards_2.stream().sorted(Comparator.comparing(Card::getNumber)).collect(Collectors.toList());

        int bigNum1 = cards1.get(4).getNumber();
        int bigNum2 = cards2.get(4).getNumber();

        if(bigNum1 == bigNum2) {
            return "Dogfall";
        }
        return bigNum1 > bigNum2 ? "The First Player Win!":"The Second Player Win!";

    }

}
