
public class AddRabbitButton extends Button {

  public AddRabbitButton(String label, float x, float y) {
    super(label, x, y);
    // TODO Auto-generated constructor stub
  }

  @Override
  public void mousePressed() {
    if (isMouseOver()) {
      //System.out.println("Add Rabbit Button Pressed");
      Button.processing.objects.add(new Rabbit());
    }
  }
}
