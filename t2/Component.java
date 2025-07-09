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
  public String getType()
  {
    return this.getClass().getSimpleName();
  }

  public void display(String s)
  {
    System.out.println(s + "      " + getType());
    s = s + "  ";
    System.out.println(s + "    {");
    System.out.println(s + "      Parent: " + o.getName());
    displayAttributes(s);
    System.out.println(s + "    }");

  }

  public abstract void displayAttributes(String s);

}  // Component