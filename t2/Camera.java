/**
 *
 * @author Erick Rodrigues de Lemos Riberio
 * @author Luiz Alexandre Espindola Cunha
 */

package t2;

public class Camera extends Component
{
  private CameraType type;
  private double angle;
  private double[] d;
  
  public Camera(GameObject o)
  {
    super(o);
    type = CameraType.PARALLEL;
  }

  @Override
  public void displayAttributes()
  {
    //TODO
  }

  private enum CameraType
  {
    PARALLEL,
    PERSPECTIVE
  }

}  // Camera
