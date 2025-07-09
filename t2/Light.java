/**
 *
 * @author Erick Rodrigues de Lemos Riberio
 * @author Luiz Alexandre Espindola Cunha
 */

package t2;

public class Light extends Component
{
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

  @Override
  public void displayAttributes(String s)
  {
    System.out.printf("%s      Type: %s\n", s, type.name());
    System.out.printf("%s      Color: ", s);
    color.print("");
  }

  private enum LightType
  {
    PUNCTUAL,
    DIRECTIONAL
  }

}  // Light
