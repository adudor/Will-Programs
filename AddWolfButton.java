
public class AddWolfButton extends Button {

  public AddWolfButton(String label, float x, float y) {
    super(label, x, y);
    // TODO Auto-generated constructor stub
  }

  @Override
  public void mousePressed() {
    if (isMouseOver()) {
      //System.out.println("Add Wolf Button Pressed");
      Button.processing.objects.add(new Wolf());
    }
  }
}
