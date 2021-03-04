
public class PlantCarrotsButton extends Button {

  public PlantCarrotsButton(String label, float x, float y) {
    super(label, x, y);
    // TODO Auto-generated constructor stub
  }

  @Override
  public void mousePressed() {
    if (isMouseOver()) {
      //System.out.println("Plant Carrots Button Pressed");
      Carrots.plant();
    }
  }

}
