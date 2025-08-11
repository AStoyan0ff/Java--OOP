package _01WorkingAbstraction.CardsPower;

public class Card {

    private CardRank rank;
    private CardSuit suit;

    public Card(CardRank rank, CardSuit suit) {

        this.rank = rank;
        this.suit = suit;
    }

    public int getPower() {
        return this.rank.getPower() + this.suit.getPower();
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d",
                this.rank.name(), this.suit.name(), this.getPower());
    }
}
