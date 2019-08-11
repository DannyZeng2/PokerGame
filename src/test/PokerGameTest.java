package test;

import main.Card;
import main.PokerGame;
import main.PokerType;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static main.CardEnum.*;

public class PokerGameTest {

    @Test
    public void should_return_winner_when_compare_big_number() {
        //Given
        List<Card> cards_1 = Arrays.asList(C6, H2, D3, S4, H5);
        List<Card> cards_2 = Arrays.asList(D3, C9, S4, S8, H2);
        //When
        String result = PokerGame.play(cards_1, cards_2);
        //Then
        Assert.assertEquals("The Second Player Win!", result);
    }

    @Test
    public void should_return_winner_when_compare_big_number_include_TJQKA() {
        //Given
        List<Card> cards_1 = Arrays.asList(C6, H11, C10, D13, H5);
        List<Card> cards_2 = Arrays.asList(S12, SAce, S4, S8, H2);
        //When
        String result = PokerGame.play(cards_1, cards_2);
        //Then
        Assert.assertEquals("The Second Player Win!", result);
    }

    @Test
    public void should_return_dogfall_when_both_side_is_equal() {
        //Given
        List<Card> cards_1 = Arrays.asList(C6, H2, D3, S4, H5);
        List<Card> cards_2 = Arrays.asList(C6, H5, D3, H2, S4);
        //When
        String result = PokerGame.play(cards_1, cards_2);
        //Then
        Assert.assertEquals("Dogfall", result);
    }

    @Test
    public void test_card_type() {
        //Given
        List<Card> cards_1 = Arrays.asList(C6, H11, C10, D13, H5);
        List<Card> cards_2 = Arrays.asList(D3, H2, D3, S4, H5);
        List<Card> cards_3 = Arrays.asList(D3, H2, D3, H2, H5);
        List<Card> cards_4 = Arrays.asList(D3, H2, D3, S4, D3);
        List<Card> cards_5 = Arrays.asList(D3, D3, D3, S4, D3);
        //When
        int result_1 = PokerType.judgeCardsType(cards_1);
        int result_2 = PokerType.judgeCardsType(cards_2);
        int result_3 = PokerType.judgeCardsType(cards_3);
        int result_4 = PokerType.judgeCardsType(cards_4);
        //Then
        Assert.assertEquals(1, result_1);
        Assert.assertEquals(2, result_2);
        Assert.assertEquals(3, result_3);
        Assert.assertEquals(4, result_4);
    }

    @Test
    public void should_return_winner_when_the_compare_according_to_pair() {
        //Given
        List<Card> cards_1 = Arrays.asList(D13, H2, D13, S4, H5);
        List<Card> cards_2 = Arrays.asList(C6, H5, D3, C6, S4);

        List<Card> cards_3 = Arrays.asList(H2, H2, D13, S4, H5);
        List<Card> cards_4 = Arrays.asList(C6, H5, D3, C6, S4);

        //When
        String result_1 = PokerGame.play(cards_1, cards_2);
        String result_2 = PokerGame.play(cards_3, cards_4);
        //Then
        Assert.assertEquals("The First Player Win!", result_1);
        Assert.assertEquals("The Second Player Win!", result_2);
    }

    @Test
    public void should_return_dogfall_when_the_compare_according_to_pair() {
        //Given
        List<Card> cards_1 = Arrays.asList(D13, H2, D13, S4, H5);
        List<Card> cards_2 = Arrays.asList(D13, H2, D13, S4, H5);
        //When
        String result = PokerGame.play(cards_1, cards_2);
        //Then
        Assert.assertEquals("Dogfall", result);
    }

    @Test
    public void should_return_winner_when_the_compare_high_card_with_pair() {
        //Given
        List<Card> cards_1 = Arrays.asList(D13, H2, D7, S4, H5);
        List<Card> cards_2 = Arrays.asList(H2, D7, H2, S4, H5);
        //When
        String result = PokerGame.play(cards_1, cards_2);
        //Then
        Assert.assertEquals("The Second Player Win!", result);
    }

    @Test
    public void should_compare_with_high_card_when_the_pair_is_same() {
        //Given
        List<Card> cards_1 = Arrays.asList(D13, H2, D7, H2, H5);
        List<Card> cards_2 = Arrays.asList(H2, D7, H2, S4, H5);

        List<Card> cards_3 = Arrays.asList(S4, H5, D7, H2, H2);
        List<Card> cards_4 = Arrays.asList(H2, SAce, H2, S4, H5);
        //When
        String result_1 = PokerGame.play(cards_1, cards_2);
        String result_2 = PokerGame.play(cards_3, cards_4);
        //Then
        Assert.assertEquals("The First Player Win!", result_1);
        Assert.assertEquals("The Second Player Win!", result_2);
    }

    @Test
    public void should_return_winner_when_the_compare_two_pair_card() {
        //Given
        List<Card> cards_1 = Arrays.asList(H2, H2, H5, S4, H5);
        List<Card> cards_2 = Arrays.asList(H5, D13, D13, S4, H5);

        List<Card> cards_3 = Arrays.asList(SAce, H2, H5, SAce, H5);
        List<Card> cards_4 = Arrays.asList(H2, D13, D13, H5, H5);
        //When
        String result_1 = PokerGame.play(cards_1, cards_2);
        String result_2 = PokerGame.play(cards_3, cards_4);
        //Then
        Assert.assertEquals("The Second Player Win!", result_1);
        Assert.assertEquals("The First Player Win!", result_2);
    }

    @Test
    public void should_return_dogfall_when_the_two_pair_card_is_same() {
        //Given
        List<Card> cards_1 = Arrays.asList(H2, H2, H5, S4, H5);
        List<Card> cards_2 = Arrays.asList(H5, H5, H2, S4, H2);
        //When
        String result_1 = PokerGame.play(cards_1, cards_2);
        //Then
        Assert.assertEquals("Dogfall", result_1);
    }

    @Test
    public void should_compare_with_high_card_when_the_two_pair_card_is_same() {
        //Given
        List<Card> cards_1 = Arrays.asList(H2, H2, H5, S4, H5);
        List<Card> cards_2 = Arrays.asList(H2, H2, H5, D13, H5);
        //When
        String result = PokerGame.play(cards_1, cards_2);
        //Then
        Assert.assertEquals("The Second Player Win!", result);
    }

    @Test
    public void should_return_winner_when_compare_pair_with_two_pair() {
        //Given
        List<Card> cards_1 = Arrays.asList(H2, H2, S4, S4, H5);
        List<Card> cards_2 = Arrays.asList(H2, D13, D13, H5, H11);
        //When
        String result = PokerGame.play(cards_1, cards_2);
        //Then
        Assert.assertEquals("The First Player Win!", result);
    }

    @Test
    public void should_return_winner_when_compare_three_of_kind_with_two_pair() {
        //Given
        List<Card> cards_1 = Arrays.asList(H2, H2, S4, S4, H5);
        List<Card> cards_2 = Arrays.asList(D13, D13, D13, H5, H11);
        //When
        String result = PokerGame.play(cards_1, cards_2);
        //Then
        Assert.assertEquals("The Second Player Win!", result);
    }

    @Test
    public void should_return_winner_when_the_compare_three_of_a_kind_card() {
        //Given
        List<Card> cards_1 = Arrays.asList(H2, H2, H2, S4, H5);
        List<Card> cards_2 = Arrays.asList(H2, D13, D13, D13, H5);

        List<Card> cards_3 = Arrays.asList(SAce, H2, SAce, SAce, H5);
        List<Card> cards_4 = Arrays.asList(D13, SAce, D13, H5, D13);

        //When
        String result_1 = PokerGame.play(cards_1, cards_2);
        String result_2 = PokerGame.play(cards_3, cards_4);
        //Then
        Assert.assertEquals("The Second Player Win!", result_1);
        Assert.assertEquals("The First Player Win!", result_2);
    }

    @Test
    public void should_compare_with_high_card_when_three_of_a_kind_card_is_same() {
        //Given
        List<Card> cards_1 = Arrays.asList(H2, H2, H2, S4, H5);
        List<Card> cards_2 = Arrays.asList(H2, D13, H2, SAce, H2);
        //When
        String result = PokerGame.play(cards_1, cards_2);
        //Then
        Assert.assertEquals("The Second Player Win!", result);
    }

    @Test
    public void should_return_winner_when_the_compare_Straight_card_with_other() {
        //Given
        List<Card> cards_1 = Arrays.asList(H2, D3, S4, H5, C6);
        List<Card> cards_2 = Arrays.asList(H2, D13, D13, D13, H5);
        //When
        String result_1 = PokerGame.play(cards_1, cards_2);
        //Then
        Assert.assertEquals("The First Player Win!", result_1);
    }

    @Test
    public void should_return_winner_when_the_compare_beyween_straight_card() {
        //Given
        List<Card> cards_1 = Arrays.asList(H2, D3, S4, H5, C6);
        List<Card> cards_2 = Arrays.asList(S4, H5, C6, D7, S8);
        //When
        String result_1 = PokerGame.play(cards_1, cards_2);
        //Then
        Assert.assertEquals("The Second Player Win!", result_1);
    }

    @Test
    public void should_return_winner_when_both_side_flush_is_same() {
        //Given
        List<Card> cards_1 = Arrays.asList(H2, H11, H3, H5, H6);
        List<Card> cards_2 = Arrays.asList(H2, H11, H13, H5, H6);
        //When
        String result_1 = PokerGame.play(cards_1, cards_2);
        //Then
        Assert.assertEquals("The Second Player Win!", result_1);
    }

    @Test
    public void should_return_winner_when_both_side_flush_is_different() {
        //Given
        List<Card> cards_1 = Arrays.asList(H2, H11, H3, HAce, H6);
        List<Card> cards_2 = Arrays.asList(S4, S5, S8, S3, S12);
        //When
        String result_1 = PokerGame.play(cards_1, cards_2);
        //Then
        Assert.assertEquals("The Second Player Win!", result_1);
    }
    @Test
    public void should_return_winner_when_both_side_is_full_house() {
        //Given
        List<Card> cards_1 = Arrays.asList(C2, D2, H2, HAce, DAce);
        List<Card> cards_2 = Arrays.asList(HAce, CAce, C12, SAce, S12);

        List<Card> cards_3 = Arrays.asList(D3, S12, C12, C3, D12);
        List<Card> cards_4 = Arrays.asList(C2, S3, H3, D3, S2);
        //When
        String result_1 = PokerGame.play(cards_1, cards_2);
        String result_2 = PokerGame.play(cards_3, cards_4);
        //Then
        Assert.assertEquals("The Second Player Win!", result_1);
        Assert.assertEquals("The First Player Win!", result_2);
    }

    @Test
    public void should_return_winner_when_full_house_compare_to_straight() {
        //Given
        List<Card> cards_1 = Arrays.asList(C2, D2, H2, HAce, DAce);
        List<Card> cards_2 = Arrays.asList(H2, D3, S4, H5, C6);
        //When
        String result_1 = PokerGame.play(cards_1, cards_2);
        //Then
        Assert.assertEquals("The First Player Win!", result_1);
    }

    @Test
    public void should_return_winner_when_full_house_compare_to_flush() {
        //Given
        List<Card> cards_1 = Arrays.asList(C2, D2, H2, HAce, DAce);
        List<Card> cards_2 = Arrays.asList(S4, S5, S8, S3, S12);
        //When
        String result_1 = PokerGame.play(cards_1, cards_2);
        //Then
        Assert.assertEquals("The First Player Win!", result_1);
    }
    @Test
    public void should_return_winner_when_both_side_is_four_of_a_kind() {
        //Given
        List<Card> cards_1 = Arrays.asList(C2, D2, H2, S2, S12);
        List<Card> cards_2 = Arrays.asList(C3, D3, H3, S3, DAce);
        //When
        String result_1 = PokerGame.play(cards_1, cards_2);
        //Then
        Assert.assertEquals("The Second Player Win!", result_1);
    }

}
