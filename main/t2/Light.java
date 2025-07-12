/**
 *
 * @author Erick Rodrigues de Lemos Riberio
 * @author Luiz Alexandre Espindola Cunha
 */

package t2;

public class Light extends Component
{
  private static final long serialVersionUID = 2040;
  private LightType type;
  private Color color;
  
  public Light(GameObject o)
  {
    super(o);
    color = Color.white;
    type = LightType.PUNCTUAL;
  }

  public Light(GameObject o, String type)
  {
    super(o);
  }

  public void setType(LightType t)
  {
    type = t;
  }
  
  public void setColor(Color color)
  {
    this.color = color;
  }
  @Override
  public void displayAttributes(String s)
  {
    System.out.printf("%sType: %s\n", s, type.name());
    System.out.printf("%sColor: ", s);
    color.print("");
  }

  public enum LightType
  {
    PUNCTUAL,
    DIRECTIONAL
  }

}  // Light
