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
    public void should_return_winner_when_the_compare_according_to_pair() {
        //Given
        List<Card> cards_1 = Arrays.asList(THREE_D, TWO_H, THREE_D, FOUR_S, FIVE_H);
        List<Card> cards_2 = Arrays.asList(SIX_C, FIVE_H, THREE_D, SIX_C, FOUR_S);
        //When
        String result = PokerGame.play(cards_1, cards_2);
        //Then
        Assert.assertEquals("The Second Player Win!",result);
    }

}
