package test;

import main.Card;
import main.PokerGame;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PokerGameTest {

    private static final Card TWO_H = new Card("2", "H");
    private static final Card THREE_D = new Card("3", "D");
    private static final Card FOUR_S = new Card("4", "S");
    private static final Card FIVE_H = new Card("5", "H");
    private static final Card SIX_C = new Card("6", "C");
    private static final Card SEVEN_D = new Card("7", "D");
    private static final Card EIGHT_S = new Card("8", "S");
    private static final Card NINE_C = new Card("9", "C");
    private static final Card Ten_C = new Card("10", "C");
    private static final Card Jack_H = new Card("J", "H");
    private static final Card Queen_S = new Card("Q", "S");
    private static final Card King_D = new Card("K", "D");
    private static final Card Ace_D = new Card("A", "S");


    @Test
    public void should_return_winner_when_compare_big_number() {
        //Given
        List<Card> cards_1 = Arrays.asList(SIX_C, TWO_H, THREE_D, FOUR_S, FIVE_H);
        List<Card> cards_2 = Arrays.asList(THREE_D, NINE_C, FOUR_S, EIGHT_S, TWO_H);
        //When
        String result = PokerGame.play(cards_1, cards_2);
        //Then
        Assert.assertEquals("The Second Player Win!",result);
    }

    @Test
    public void should_return_winner_when_compare_big_number_include_TJQKA() {
        //Given
        List<Card> cards_1 = Arrays.asList(SIX_C, Jack_H, Ten_C, King_D, FIVE_H);
        List<Card> cards_2 = Arrays.asList(Queen_S, Ace_D, FOUR_S, EIGHT_S, TWO_H);
        //When
        String result = PokerGame.play(cards_1, cards_2);
        //Then
        Assert.assertEquals("The Second Player Win!",result);
    }

    @Test
    public void should_return_dogfall_when_both_side_is_equal() {
        //Given
        List<Card> cards_1 = Arrays.asList(SIX_C, TWO_H, THREE_D, FOUR_S, FIVE_H);
        List<Card> cards_2 = Arrays.asList(SIX_C, FIVE_H, THREE_D, TWO_H, FOUR_S);
        //When
        String result = PokerGame.play(cards_1, cards_2);
        //Then
        Assert.assertEquals("Dogfall",result);
    }

    @Test
    public void test_card_type() {
        //Given
        List<Card> cards_1 = Arrays.asList(SIX_C, Jack_H, Ten_C, King_D, FIVE_H);
        List<Card> cards_2 = Arrays.asList(THREE_D, TWO_H, THREE_D, FOUR_S, FIVE_H);
        List<Card> cards_3 = Arrays.asList(THREE_D, TWO_H, THREE_D, TWO_H, FIVE_H);
        List<Card> cards_4 = Arrays.asList(THREE_D, TWO_H, THREE_D, FOUR_S, THREE_D);
        List<Card> cards_5 = Arrays.asList(THREE_D, THREE_D, THREE_D, FOUR_S, THREE_D);

        //When
        int result_1 = PokerGame.judgeCardsType(cards_1);
        int result_2 = PokerGame.judgeCardsType(cards_2);
        int result_3 = PokerGame.judgeCardsType(cards_3);
        int result_4 = PokerGame.judgeCardsType(cards_4);
        int result_5 = PokerGame.judgeCardsType(cards_5);
        //Then
        Assert.assertEquals(1,result_1);
        Assert.assertEquals(2,result_2);
        Assert.assertEquals(3,result_3);
        Assert.assertEquals(4,result_4);
        Assert.assertEquals(5,result_5);

    }

    @Test
    public void should_return_winner_when_the_compare_according_to_pair() {
        //Given
        List<Card> cards_1 = Arrays.asList(King_D, TWO_H, King_D, FOUR_S, FIVE_H);
        List<Card> cards_2 = Arrays.asList(SIX_C, FIVE_H, THREE_D, SIX_C, FOUR_S);

        List<Card> cards_3 = Arrays.asList(TWO_H, TWO_H, King_D, FOUR_S, FIVE_H);
        List<Card> cards_4 = Arrays.asList(SIX_C, FIVE_H, THREE_D, SIX_C, FOUR_S);

        //When
        String result_1 = PokerGame.play(cards_1, cards_2);
        String result_2 = PokerGame.play(cards_3, cards_4);
        //Then
        Assert.assertEquals("The First Player Win!",result_1);
        Assert.assertEquals("The Second Player Win!",result_2);
    }

    @Test
    public void should_return_dogfall_when_the_compare_according_to_pair() {
        //Given
        List<Card> cards_1 = Arrays.asList(King_D, TWO_H, King_D, FOUR_S, FIVE_H);
        List<Card> cards_2 = Arrays.asList(King_D, TWO_H, King_D, FOUR_S, FIVE_H);
        //When
        String result = PokerGame.play(cards_1, cards_2);
        //Then
        Assert.assertEquals("Dogfall",result);
    }

}
