/**
 *
 * @author Erick Rodrigues de Lemos Riberio
 * @author Luiz Alexandre Espindola Cunha
 */

package t2;

public class Camera extends Component
{
  private static final long serialVersionUID = 9820;
  private CameraType type;
  private double angle;
  private Point2 planeDist;
  
  public Camera(GameObject o)
  {
    super(o);
    type = CameraType.PARALLEL;
    planeDist = new Point2();
  }

  @Override
  public void displayAttributes(String s)
  {
    System.out.println(s + "Type: " + type.name());
    System.out.println(s + "Angle: " + angle);
    planeDist.print(s + "Distance: ");
  }

  public void setAngle(double x)
  {
    angle = x;
  }

  public double getAngle()
  {
    return angle;
  }

  public void setPlaneDist(double x, double y)
  {
    planeDist = planeDist.move(x - planeDist.x, y - planeDist.y);
  }

  public Point2 getPlaneDist()
  {
    return planeDist;
  }

  public void setType(CameraType t)
  {
    type = t;
  }

  public enum CameraType
  {
    PARALLEL,
    PERSPECTIVE
  }

}  // Camera
