/**
 *
 * @author Erick Rodrigues de Lemos Riberio
 * @author Luiz Alexandre Espindola Cunha
 */

package t2;

import java.io.Serializable;

public abstract class Component implements NamedObject, Serializable
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
  @Override
  public final String getName()
  {
    String s = this.getClass().getSimpleName();
    return s;
  }

  public final void display(String s)
  {
    System.out.println(s + "      " + getName());
    s = s + "  ";
    System.out.println(s + "    {");
    System.out.println(s + "      Parent: " + o.getName());
    displayAttributes(s);
    System.out.println(s + "    }");

  }

  public abstract void displayAttributes(String s);

}  // Component