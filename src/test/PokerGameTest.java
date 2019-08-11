package test;

import main.Card;
import main.PokerGame;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PokerGameTest {

    private static final Card TWO_H = new Card("2", "H");
    private static final Card THREE_D = new Card("3", "D");
    private static final Card FOUR_S = new Card("4", "S");
    private static final Card FIVE_H = new Card("5", "H");
    private static final Card SIX_C = new Card("6", "C");
    private static final Card SEVEN_D = new Card("7", "D");
    private static final Card EIGHT_S = new Card("8", "S");
    private static final Card NINE_C = new Card("9", "C");
    private static final Card Jack_H = new Card("J", "K");
    private static final Card Queen_S = new Card("Q", "S");


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
    public void should_return_dogfall_when_both_side_is_equal() {
        //Given
        List<Card> cards_1 = Arrays.asList(SIX_C, TWO_H, THREE_D, FOUR_S, FIVE_H);
        List<Card> cards_2 = Arrays.asList(SIX_C, FIVE_H, THREE_D, TWO_H, FOUR_S);
        //When
        String result = PokerGame.play(cards_1, cards_2);
        //Then
        Assert.assertEquals("Dogfall",result);
    }
}
