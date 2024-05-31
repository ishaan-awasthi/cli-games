public class Card {

    // ATTRIBUTES
    private int value;
    private String name;
    private String suit;


    // CONSTRUCTORS
    public Card(int v, String s, String n){
        value = v;
        name = n;
        suit = s;
    }

    // GETTERS
    public int getValue(){return value;}
    public String getSuit(){return suit;}
    public String getName(){return name;}


    // SETTERS
    public void setValue(int v){value = v;}
    // setValue() is for the purpose of modifying ace cards (1 v 11)
    // additional setters are unnecessary for the game of blackjack
}
