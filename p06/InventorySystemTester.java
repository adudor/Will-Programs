
public class InventorySystemTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(runAllTests());

	}

	public static boolean testLinkedBox() {
		Box cardboard = new Box(Color.YELLOW);
		LinkedBox objBox = new LinkedBox(cardboard);

		if (objBox.getNext() != null) {
			return true;
		} else {
			return false;
		}

		if (objBox.setNext() != null) {
			return true;
		} else {
			return false;
		}

		if (objBox.getBox() != null) {
			return true;
		} else {
			return false;
		}
		return false;

	}
	
	// checks for the correctness of the InventoryList.clear() method
	public static boolean testClear() {
			InventoryList.clear();
			try {
				if(head!=null || tail!=null || size != 0 || blueCount != 0 || brownCount != 0 || yellowCount != 0)
					Return false;
			} catch() {
			return true;
			}
		}

		
	// checks for the correctness of the InventoryList.addYellow(), // InventoryList.addBlue(), and InventoryList.addBrown() methods public static boolean testAddBoxes()
	// checks for the correctness of the InventoryList.removeBox()
	// InventoryList.removeYellow(), and InventoryList.remove Brown() // methods
	public static boolean testRemoveBoxes() {
		LinkedBox objBox = new LinkedBox(cardboard);

		Box yellow1 = new Box(Color.YELLOW);
		Box yellow2 = new Box(Color.YELLOW);
		Box yellow3 = new Box(Color.YELLOW);

		Box blue1 = new Box(Color.BLUE);
		Box blue2 = new Box(Color.BLUE);
		Box blue3 = new Box(Color.BLUE);

		Box brown1 = new Box(Color.BROWN);
		Box brown2 = new Box(Color.BROWN);
		Box brown3 = new Box(Color.BROWN);

		objBox.addYellow(yellow1);
		objBox.addYellow(yellow2);
		objBox.addYellow(yellow3);

		objBox.addBlue(blue1);
		objBox.addBlue(blue2);
		objBox.addBlue(blue3);
		
		objBox.addBrown(brown1);
		objBox.addBrown(brown2);
		objBox.addBrown(brown3);

		objBox.removeBox(3);
		objBox.removeYellow();
		objBox.removeBrown();

		if(objBox.size() != 6) {
			return false;
		} else if(getYellowCount() != 2) {
			return false;
		} else if(getBlueCount() != 2) {
			return false;
		} else if(getBrownCount() != 2) {
			return false;
		}

		return true;
		
	}
	// checks for the correctness of the InventoryList.get() method
	public static boolean testGetBoxes() {
			LinkedBox objBox = new LinkedBox(cardboard);

			Box yellow1 = new Box(Color.YELLOW);
			Box yellow2 = new Box(Color.YELLOW);
			Box yellow3 = new Box(Color.YELLOW);

			Box blue1 = new Box(Color.BLUE);
			Box blue2 = new Box(Color.BLUE);
			Box blue3 = new Box(Color.BLUE);

			Box brown1 = new Box(Color.BROWN);
			Box brown2 = new Box(Color.BROWN);
			Box brown3 = new Box(Color.BROWN);

			objBox.addYellow(yellow1);
			objBox.addYellow(yellow2);
			objBox.addYellow(yellow3);

			objBox.addBlue(blue1);
			objBox.addBlue(blue2);
			objBox.addBlue(blue3);
			
			objBox.addBrown(brown1);
			objBox.addBrown(brown2);
			objBox.addBrown(brown3);

			if(!objBox.get(0).equals(yellow3)) {
				return false;
			}
			
			return true;
		
	}
	// a test suite method to run all your test methods
	public static boolean runAllTests() {
		if(!testLinkedBox()) {
			return false;
		} else if(!testClear()) {
			return false;
		} else if(!testRemoveBoxes()) {
			return false;
		} else if(!testGetBoxes()) {
			return false;
		}
		return true;

		
	}

}
