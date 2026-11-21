package il.ac.tau.cs.software1.inventory;

/*
 * A simple array-based Inventory (Question 6).
 */
public class NaiveInventory implements Inventory {

	private static final int INITIAL_CAPACITY = 100;

	// TODO: add the fields:
	//       - an array of Collectibles (it may be larger than the number of items actually stored)
	//       - an int that counts how many items are actually stored

	private Collectible[] array_of_Collectibles;
	private int stored;

	public NaiveInventory() {
		array_of_Collectibles = new Collectible[INITIAL_CAPACITY];
		stored = 0;
	}

	@Override
	public void collect(Collectible collectible) {

		if (array_of_Collectibles.length == stored){
			Collectible[] new_array = new Collectible[2*array_of_Collectibles.length];
			for(int i=0 ; i<array_of_Collectibles.length ; i++){
				new_array[i] = array_of_Collectibles[i];
			}
			stored++;
			new_array[array_of_Collectibles.length] = collectible;
			array_of_Collectibles = new_array;
		}
		else{
			array_of_Collectibles[stored] = collectible;
			stored++;
		}
	}

	@Override
	public float getTotalWeight() {
		float sum = 0;
		for (int i = 0; i < stored; i++) {
			sum += array_of_Collectibles[i].getWeight();
		}
		return sum;
	}

	@Override
	public int getCurrentCount() {
		return stored;
	}

	// Returns the array of Collectibles that is stored in the field of this class
	public Collectible[] getCollArr() {
		return array_of_Collectibles;
	}
}
