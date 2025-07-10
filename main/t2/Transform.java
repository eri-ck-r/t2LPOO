/**
 *
 * @author Erick Rodrigues de Lemos Riberio
 * @author Luiz Alexandre Espindola Cunha
 */

package t2;
import java.io.Serializable;
public class Transform extends Component implements Serializable
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
        
    @Override
    public void displayAttributes(String s)
    {
        System.out.printf("%s      Position: ", s);
        position.print();
        System.out.printf("%s      Rotation: ", s);
        rotation.print();
        System.out.printf("%s      Scale: %.2f\n", s, scale);
    }
}  // Transform
