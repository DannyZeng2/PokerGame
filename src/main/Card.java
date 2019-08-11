package main;

public class Card {

    private String number;
    private String suit;

    public Card(String number, String suit) {
        this.number = formatNumber(number);
        this.suit = formatSuit(suit);
    }

    public int getNumber() {
        return Integer.parseInt(number);
    }

    public String getSuit() {
        return suit;
    }

    private String formatNumber(String number) {
        switch (number) {
            case "T":
                number = "10";
                break;
            case "J":
                number = "11";
                break;
            case "Q":
                number = "12";
                break;
            case "K":
                number = "13";
                break;
            case "A":
                number = "99";
                break;
        }
        return number;
    }

    private String formatSuit(String suit) {
        switch (suit) {
            case "D":
                suit = "1";
                break;
            case "C":
                suit = "2";
                break;
            case "H":
                suit = "3";
                break;
            default:
                suit = "4";
        }
        return suit;
    }
}
