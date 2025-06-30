/**
 *
 * @author Erick Rodrigues de Lemos Riberio
 * @author Luiz Alexandre Espindola Cunha
 */

package t2;

public class Transform extends Component
{
  private Vector3 position;
  private Vector3 rotation;
  private double scale;

  public Transform(GameObject o)
  {
    super(o);
    position = new Vector3();
    rotation = new Vector3();
  }

  public double getScale()
  {
      return scale;
  }

  public void setScale(double s)
  {
      scale = s;
  }

  public Vector3 getPosition()
  {
      return position;
  }

  public void setPosition(Vector3 v)
  {
      position = v;
  }

  public Vector3 getRotation()
  {
      return rotation;
  }

  public void setRotation(Vector3 v)
  {
      rotation = v;
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
