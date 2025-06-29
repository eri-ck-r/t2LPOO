/**
 *
 * @author Erick Rodrigues de Lemos Riberio
 * @author Luiz Alexandre Espindola Cunha
 */

package t2;

public class Transform extends Component
{
  private Vector position;
  private Vector rotation;
  private double scale;

  public Transform(GameObject o)
  {
    super(o);
    position = new Vector(3);
    rotation = new Vector(3);
  }

  public void setScale(double s)
  {
      scale = s;
  }

  public void inspect()
  {
	  this.general_inspect();
	  System.out.printf("Position: ");
	  position.print();
	  System.out.printf("Rotation: ");
	  rotation.print();
	  System.out.printf("Scale: %.2f", scale);
  }

  @Override
  public void displayAttributes()
  {
      //TODO
  }
}  // Transform
