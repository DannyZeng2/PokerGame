package main;

import java.util.*;
import java.util.stream.Collectors;
import static main.PokerTypeEnum.*;

public class PokerGame {

    public static String play(List<Card> cards_1, List<Card> cards_2) {
        String result = "";
        List<Card> cards1 = cards_1.stream().sorted(Comparator.comparing(Card::getNumber)).collect(Collectors.toList());
        List<Card> cards2 = cards_2.stream().sorted(Comparator.comparing(Card::getNumber)).collect(Collectors.toList());

        int cardsType;
        int cardsType1 = PokerType.judgeCardsType(cards_1);
        int cardsType2 = PokerType.judgeCardsType(cards_2);

        if (cardsType1 != cardsType2) {
            return PokerType.judgeCardsType(cards1) > cardsType2 ? "The First Player Win!" : "The Second Player Win!";
        } else {
            cardsType = cardsType1;
        }

        if (cardsType == PAIR || cardsType == TWO_PAIR) {
            return compareRepeatCard(cards_1, cards_2, 2);
        }

        if (cardsType == THREE_OF_KIND ) {
            return compareRepeatCard(cards_1, cards_2, 3);
        }

        if (cardsType == STRAIGHT|| cardsType == HIGHT_CARD) {
            return compareHighCard(cards1, cards2);
        }
        return result;

    }

    private static String compareRepeatCard(List<Card> cards_1, List<Card> cards_2, int times) {
        Map<Card, Integer> map1 = PokerType.checkCards(cards_1);
        Map<Card, Integer> map2 = PokerType.checkCards(cards_2);
        int bigPair1 = getKey(map1, times).getNumber();
        int bigPair2 = getKey(map2, times).getNumber();
        if (bigPair1 == bigPair2) {
            return compareHighCard(cards_1, cards_2);
        } else {
            return bigPair1 > bigPair2 ? "The First Player Win!" : "The Second Player Win!";
        }
    }

    private static String compareHighCard(List<Card> cards1, List<Card> cards2) {

        Set<Card> set1 = new HashSet<>(cards1);
        Set<Card> set2 = new HashSet<>(cards2);

        List<Card> list1 = new ArrayList<>(set1);
        List<Card> list2 = new ArrayList<>(set2);

        List<Card> result1 = list1.stream().sorted(Comparator.comparing(Card::getNumber)).collect(Collectors.toList());
        List<Card> result2 = list2.stream().sorted(Comparator.comparing(Card::getNumber)).collect(Collectors.toList());

        int bigNum1 = result1.get(result1.size() - 1).getNumber();
        int bigNum2 = result2.get(result2.size() - 1).getNumber();

        if (bigNum1 == bigNum2) {
            return "Dogfall";
        } else {
            return bigNum1 > bigNum2 ? "The First Player Win!" : "The Second Player Win!";
        }
    }

    private static Card getKey(Map<Card, Integer> map, int value) {
        List<Card> pairList = new ArrayList<>();
        for (Card card : map.keySet()) {
            int count = map.get(card);
            if (value == count) {
                pairList.add(card);
            }
        }

        if (pairList.size() == 1) {
            return pairList.get(0);
        }

        return pairList.get(0).getNumber() > pairList.get(1).getNumber() ? pairList.get(0) : pairList.get(1);
    }

}
