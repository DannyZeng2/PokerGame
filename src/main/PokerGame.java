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

        if (cardsType == FOUR_OF_KIND ) {
            return compareRepeatCard(cards_1, cards_2, 4);
        }

        if (cardsType == STRAIGHT|| cardsType == HIGHT_CARD) {
            return compareHighCard(cards1, cards2);
        }

        if (cardsType == FLUSH ) {
            return compareSuit(cards_1, cards_2);
        }

        if (cardsType == FUll_HOUSE ) {
           return compareFullHouse(cards_1, cards_2);
        }

        return result;

    }

    private static String compareFullHouse(List<Card> cards_1, List<Card> cards_2) {
        Map<Integer, Integer> map1 = PokerType.checkCards(cards_1);
        Map<Integer, Integer> map2 = PokerType.checkCards(cards_2);
        int threeKind1 = getKey(map1, 3);
        int threeKind2 = getKey(map2, 3);
        int pair1 = getKey(map1, 2);
        int pair2 = getKey(map2, 2);
        if (threeKind1 == threeKind2) {
            return pair1 > pair2 ? "The First Player Win!" : "The Second Player Win!";
        } else {
            return threeKind1 > threeKind2 ? "The First Player Win!" : "The Second Player Win!";
        }
    }

    private static String compareSuit(List<Card> cards_1, List<Card> cards_2) {
        int suit1 = cards_1.get(0).getSuit();
        int suit2 = cards_2.get(0).getSuit();
        if(suit1 == suit2) {
            return compareHighCard(cards_1, cards_2);
        } else {
            return suit1 > suit2 ? "The First Player Win!" : "The Second Player Win!";
        }

    }

    private static String compareRepeatCard(List<Card> cards_1, List<Card> cards_2, int times) {
        Map<Integer, Integer> map1 = PokerType.checkCards(cards_1);
        Map<Integer, Integer> map2 = PokerType.checkCards(cards_2);
        int bigPair1 = getKey(map1, times);
        int bigPair2 = getKey(map2, times);
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

    private static Integer getKey(Map<Integer, Integer> map, int value) {
        List<Integer> pairList = new ArrayList<>();
        for (Integer num : map.keySet()) {
            int count = map.get(num);
            if (value == count) {
                pairList.add(num);
            }
        }

        if (pairList.size() == 1) {
            return pairList.get(0);
        }

        return pairList.get(0) > pairList.get(1) ? pairList.get(0) : pairList.get(1);
    }

}
