package main;

import java.util.*;
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

    public static String judgeCardsType(List<Card> cardList) {
        String type = "High Card";
        Map<Card, Integer> map = checkCards(cardList);

        if(map.size() == 4) {
            type = "Pair";
        } else if(map.size() == 3 && maxMapValue(map) == 2){
            type = "Two pair";
        } else if(map.size() == 3 && maxMapValue(map) == 3) {
            type = "Three of a Kind";
        } else if(map.size() == 2 ) {
            type = "Four of a Kind";
        }

        return type;
    }

    private static Map<Card,Integer> checkCards(List<Card> cardList) {
        int count = 1;
        List<Card> cards = cardList.stream().sorted(Comparator.comparing(Card::getNumber)).collect(Collectors.toList());
        Map<Card,Integer> cardMap = new HashMap<Card,Integer>();
        cardMap.put(cards.get(0),count);
        for(int i=1;i<cards.size();i++) {
            if(cards.get(i).getNumber() == cards.get(i-1).getNumber()){
                count ++;
                cardMap.put(cards.get(i),count);
            }else {
                cardMap.put(cards.get(i),1);
            }
        }
        return cardMap;
    }

    private static int maxMapValue(Map<Card,Integer> map) {
        List<Integer> values =new ArrayList<Integer>(map.values());
        Collections.sort(values);
        return values.get(values.size()-1);
    }

}
