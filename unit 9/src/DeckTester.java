/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		String[] rank = {"ace","2","3","4","5","6","7","8","9","10","jack","queen","king"};
		String[] suit = {"spades", "hearts", "diamonds", "clubs"};
		int[] value = {1,2,3,4,5,6,7,8,9,10,11,12,13};
		
		Deck test = new Deck(rank,suit,value);
		test.isEmpty();
		test.size();
		test.deal();
		System.out.println(test);
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
	}
}
