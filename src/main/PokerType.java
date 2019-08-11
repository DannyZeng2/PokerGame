package main;

import java.util.*;
import java.util.stream.Collectors;

public class PokerType {

    private static final int HIGHT_CARD = 1;
    private static final int PAIR = 2;
    private static final int TWO_PAIR = 3;
    private static final int THREE_OF_KIND = 4;
    private static final int FOUR_OF_KIND = 5;
    private static final int STRAIGHT = 6;

    public static int judgeCardsType(List<Card> cardList) {
        Map<Card, Integer> map = checkCards(cardList);

        if (map.size() == 4) {
            return PAIR;
        } else if (map.size() == 3 && maxMapValue(map) == 2) {
            return TWO_PAIR;
        } else if (map.size() == 3 && maxMapValue(map) == 3) {
            return THREE_OF_KIND;
        } else if (map.size() == 2) {
            return FOUR_OF_KIND;
        } else if (isStraight(cardList)){
            return STRAIGHT;
        }
        return HIGHT_CARD;
    }

    public static Map<Card, Integer> checkCards(List<Card> cardList) {
        int count = 1;
        List<Card> cards = cardList.stream().sorted(Comparator.comparing(Card::getNumber)).collect(Collectors.toList());
        Map<Card, Integer> cardMap = new HashMap<>();
        cardMap.put(cards.get(0), count);
        for (int i = 1; i < cards.size(); i++) {
            if (cards.get(i).getNumber() == cards.get(i - 1).getNumber()) {
                count++;
                cardMap.put(cards.get(i), count);
            } else {
                count = 1;
                cardMap.put(cards.get(i), count);
            }
        }
        return cardMap;
    }

    private static int maxMapValue(Map<Card, Integer> map) {
        List<Integer> values = new ArrayList<>(map.values());
        Collections.sort(values);
        return values.get(values.size() - 1);
    }

    private static boolean isStraight(List<Card> cardList) {
        for(int i=1;i<cardList.size();i++){
            if(cardList.get(i).getNumber() != cardList.get(i-1).getNumber() + 1){
                return false;
            }
        }
        return true;
    }


}
