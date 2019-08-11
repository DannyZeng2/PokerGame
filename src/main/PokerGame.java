package main;

import java.util.*;
import java.util.stream.Collectors;

public class PokerGame {

    private static final int HIGHT_CARD = 1;
    private static final int PAIR = 2;
    private static final int TWO_PAIR = 3;
    private static final int THREE_OF_KIND = 4;
    private static final int FOUR_OF_KIND = 5;


    public static String play(List<Card> cards_1, List<Card> cards_2) {
        String result = "";
        List<Card> cards1 = cards_1.stream().sorted(Comparator.comparing(Card::getNumber)).collect(Collectors.toList());
        List<Card> cards2 = cards_2.stream().sorted(Comparator.comparing(Card::getNumber)).collect(Collectors.toList());

        if (judgeCardsType(cards_1) == HIGHT_CARD && judgeCardsType(cards_2) == HIGHT_CARD) {
            int bigNum1 = cards1.get(4).getNumber();
            int bigNum2 = cards2.get(4).getNumber();

            if (bigNum1 == bigNum2) {
                result = "Dogfall";
            } else {
                result = bigNum1 > bigNum2 ? "The First Player Win!" : "The Second Player Win!";
            }
        }

        if (judgeCardsType(cards_1) == PAIR && judgeCardsType(cards_2) == PAIR) {
            Map<Card, Integer> map1 = checkCards(cards_1);
            Map<Card, Integer> map2 = checkCards(cards_2);
            int bigPair1 = getKey(map1,2).getNumber();
            int bigPair2 = getKey(map2,2).getNumber();
            if (bigPair1 == bigPair2) {
                result = "Dogfall";
            }else {
                result = bigPair1 > bigPair2 ? "The First Player Win!" : "The Second Player Win!";
            }

        }

        return result;

    }

    public static int judgeCardsType(List<Card> cardList) {
        int type = HIGHT_CARD;
        Map<Card, Integer> map = checkCards(cardList);

        if (map.size() == 4) {
            type = PAIR;
        } else if (map.size() == 3 && maxMapValue(map) == 2) {
            type = TWO_PAIR;
        } else if (map.size() == 3 && maxMapValue(map) == 3) {
            type = THREE_OF_KIND;
        } else if (map.size() == 2) {
            type = FOUR_OF_KIND;
        }

        return type;
    }

    private static Map<Card, Integer> checkCards(List<Card> cardList) {
        int count = 1;
        List<Card> cards = cardList.stream().sorted(Comparator.comparing(Card::getNumber)).collect(Collectors.toList());
        Map<Card, Integer> cardMap = new HashMap<Card, Integer>();
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
        List<Integer> values = new ArrayList<Integer>(map.values());
        Collections.sort(values);
        return values.get(values.size() - 1);
    }

    private static Card getKey(Map<Card, Integer> map, int value) {
        for (Card card : map.keySet()) {
            int count = map.get(card);
            if (value == count) {
                return card;
            }
        }
        return null;
    }
}
