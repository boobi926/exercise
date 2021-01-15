import javax.smartcardio.Card;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class C {
    public int rank;//牌面值
    public String suit;

    public C(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return String.format("[%s %d]", suit, rank);
    }
}

public class playCard {

    public static final String[] SUITS = {"♥","♠","♦","♣"};

    //1、买牌  52
    public static List<Card> buyDeck() {
        List<Card> deck = new ArrayList<>();
        for (int i = 0; i <  4; i++) {
            for (int j = 1; j <= 13; j++) {
            //    Card card = new Card(j,SUITS[i]);
             //   deck.add(card);
            }
        }
        return deck;
    }

    private static void swap(List<Card> deck,int index,int i) {
        //tmp = [index]
        //[index] = [i]
        //[i] = tmp;
        Card tmp = deck.get(index);
        deck.set(index,deck.get(i));
        deck.set(i,tmp);
    }
    //2、洗牌
    public static void shuffle(List<Card> deck) {
        for (int i = deck.size()-1; i > 0 ; i--) {
            Random random = new Random();
            int index = random.nextInt(i);//[0,i)
            swap(deck,index,i);
        }
    }

    public static void main(String[] args) {
        List<Card> deck = buyDeck();
        System.out.println(deck);
        System.out.println("洗牌：");
        shuffle(deck);
        System.out.println(deck);
        //3个人  轮流   每人揭牌5张

        List< List<Card> > hand = new ArrayList<>();

        List<Card> hands1 = new ArrayList<>();
        List<Card> hands2 = new ArrayList<>();
        List<Card> hands3 = new ArrayList<>();

        hand.add(hands1);
        hand.add(hands2);
        hand.add(hands3);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                Card card = deck.remove(0);
                hand.get(j).add(card);
                /*List<Card> list = hand.get(j);
                list.add(card);*/
            }
        }
        System.out.println("第1个人的牌：");
        System.out.println(hands1);
        System.out.println("第2个人的牌：");
        System.out.println(hands2);
        System.out.println("第3个人的牌：");
        System.out.println(hands3);
        System.out.println("剩下的牌：");
        System.out.println(deck);
    }

}