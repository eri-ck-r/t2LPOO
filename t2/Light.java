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
  
  public void inspect()
  {
	  this.general_inspect();
	  System.out.printf("Type: %s\n", type.name());
	  System.out.printf("Color: ");
	  color.print("");
  }

  @Override
  public void displayAttributes()
  {
      //TODO
  }

  protected enum LightType
  {
    PUNCTUAL,
    DIRECTIONAL
  }

}  // Light
