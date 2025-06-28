/**
 *
 * @author Erick Rodrigues de Lemos Riberio
 * @author Luiz Alexandre Espindola Cunha
 */

package t2;

public abstract class Component
{
  private final Scene.GameObject o;

  public Component(Scene.GameObject o)
  {
    this.o = o;
  }
  
  public Class type()
  {
    return this.o.getClass();
  }
  
  protected void general_inspect()
  {
    System.out.printf("Component: %s\nFrom object: %s\n", this.type(), o.getName());
  }

}  // Component