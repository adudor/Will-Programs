public class LinkedBox {
    private Box box;
    private LinkedBox next;
    
    LinkedBox(Box box) {
        this.box = box;
        this.next = null;
    }
    
    LinkedBox(Box box, LinkedBox next) {
        this.box = box;
        this.next = next;
    }
    
    public String toString() {
        if (next != null) {
            return box.toString() + "->";
        } else {
            return box.toString() + "-> END";
        }
        
    }
    
    public LinkedBox getNext() {
        return next;
        
    }
    
    public void setNext(LinkedBox next) {
        this.next = next;
        
    }
    
    public Box getBox() {
        return box;
        
    }
    

}