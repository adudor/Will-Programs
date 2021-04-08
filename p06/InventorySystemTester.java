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

}