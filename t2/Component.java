/**
 *
 * @author Erick Rodrigues de Lemos Riberio
 * @author Luiz Alexandre Espindola Cunha
 */

package t2;

public abstract class Component
{
  private final GameObject o;

  public Component(GameObject o)
  {
    this.o = o;
  }
  
  /**
   * 
   * @return "Transform" or "Mesh" or "Camera" or "Light"
   * 		 depending on where it was invoked
   */
  public String type()
  {
    return this.getClass().getSimpleName();
  }
  
  protected void general_inspect()
  {
    System.out.printf("Component: %s\nFrom object: %s\n",
    		this.type(), o.getName());
  }

}  // Component