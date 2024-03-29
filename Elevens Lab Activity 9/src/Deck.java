import java.util.List;
import java.util.ArrayList;

/**
 * The Deck class represents a shuffled deck of cards.
 * It provides several operations including
 *      initialize, shuffle, deal, and check if empty.
 */
public class Deck {

	/**
	 * cards contains all the cards in the deck.
	 */
	//private List<Card> cards;
	private Card[]cards;

	/**
	 * size is the number of not-yet-dealt cards.
	 * Cards are dealt from the top (highest index) down.
	 * The next card to be dealt is at size - 1.
	 */
	private int size;


	/**
	 * Creates a new <code>Deck</code> instance.<BR>
	 * It pairs each element of ranks with each element of suits,
	 * and produces one of the corresponding card.
	 * @param ranks is an array containing all of the card ranks.
	 * @param suits is an array containing all of the card suits.
	 * @param values is an array containing all of the card point values.
	 */
	public Deck(String[] ranks, String[] suits, int[] values) {
		Card[]oldArray = new Card[0];
		for (int i = 0; i < ranks.length; i++ ){
			for (int k = 0; k < suits.length; k++){
				Card newCard = new Card(ranks[i],suits[k],values[i]);
				oldArray = getNewArray(newCard,oldArray);
			}
		}
		cards = oldArray;
		size = cards.length;
			
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
	}
	
	//new array method to add a new card to a deck
	public Card[] getNewArray(Card newCard,Card[]oldArray){
		Card[] newArray = new Card[oldArray.length+1];
		for (int i = 0; i <= newArray.length-2; i++){
			newArray[i] = oldArray[i];
		}
		newArray[newArray.length-1] = newCard;
		return newArray;
		
	}


	/**
	 * Determines if this deck is empty (no undealt cards).
	 * @return true if this deck is empty, false otherwise.
	 */
	public boolean isEmpty() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
		if (cards.length == 0){
			return true;
		}
		return false;
	}

	/**
	 * Accesses the number of undealt cards in this deck.
	 * @return the number of undealt cards in this deck.
	 */
	public int size() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
		return size;
	}

	/**
	 * Randomly permute the given collection of cards
	 * and reset the size to represent the entire deck.
	 */
	public void shuffle() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 4 *** */
		/*for( int k = size - 1; k >= 0; k-- ) {
            int r = (int)(Math.random() * k);
            Card tmp = cards[r];
            cards[r] = cards[k];
            cards[k] = tmp;
        }*/
		Card[] shuffled = new Card[cards.length];
		int k = 0;
		for (int j = 0; j < cards.length/2; j++){
			shuffled[k] = cards[j];
			k = k + 2;
		}
		
		k = 1;
		for (int j = cards.length/2; j < cards.length; j++){
			shuffled[k] = cards[j];
			k = k + 2;
		}
		
		for (int i = 0; i < cards.length; i++){
			cards[i] = shuffled[i];
		}
		
		
		
	}

	/**
	 * Deals a card from this deck.
	 * @return the card just dealt, or null if all the cards have been
	 *         previously dealt.
	 */
	public Card deal() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
		
			if (size == 0){
				return null;
			}
			size--;
			return cards[size];
	}

	/**
	 * Generates and returns a string representation of this deck.
	 * @return a string representation of this deck.
	 */
	@Override
	public String toString() {
		String rtn = "size = " + size + "\nUndealt cards: \n";

		for (int k = size - 1; k >= 0; k--) {
			rtn = rtn + cards[k];
			if (k != 0) {
				rtn = rtn + ", ";
			}
			if ((size - k) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\nDealt cards: \n";
		for (int k = cards.length - 1; k >= size; k--) {
			rtn = rtn + cards[k];
			if (k != size) {
				rtn = rtn + ", ";
			}
			if ((k - cards.length) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\n";
		return rtn;
	}
}
