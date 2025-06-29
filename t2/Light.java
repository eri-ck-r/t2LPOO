/**
 *
 * @author Erick Rodrigues de Lemos Riberio
 * @author Luiz Alexandre Espindola Cunha
 */

package t2;

public class Light extends Component
{
  private GameConst type;
  private Color color;
  
  public Light(Scene.GameObject o)
  {
    super(o);
  }
  public Light(Scene.GameObject o, String type)
  {
    super(o);
    this.type = new GameConst(type, 1);
  }
  
  public void inspect()
  {
	  this.general_inspect();
	  System.out.printf("Type: %s\n", type.name());
	  System.out.printf("Color: ");
	  color.print("");
  }
  
}  // Light
