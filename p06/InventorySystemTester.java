
public class InventorySystemTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
		Box.restartNextInventoryNumber();
		try {
			if (!InventoryList.clear)
		}
		return false;
		
	}
	// checks for the correctness of the InventoryList.addYellow(), // InventoryList.addBlue(), and InventoryList.addBrown() methods public static boolean testAddBoxes()
	// checks for the correctness of the InventoryList.removeBox()
	// InventoryList.removeYellow(), and InventoryList.remove Brown() // methods
	public static boolean testRemoveBoxes() {
		return false;
		
	}
	// checks for the correctness of the InventoryList.get() method
	public static boolean testGetBoxes() {
		return false;
		
	}
	// a test suite method to run all your test methods
	public static boolean runAllTests() {
		return false;
		
	}

}
