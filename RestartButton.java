
public class RestartButton extends Button {

  public RestartButton(String label, float x, float y) {
    super(label, x, y);
    // TODO Auto-generated constructor stub
  }

  @Override
  public void mousePressed() {
    if (isMouseOver()) {
      //System.out.println("Restart Button Pressed");
      Button.processing.removeAll();
    }
  }
}
