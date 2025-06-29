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
  public String getName()
  {
    return this.getClass().getSimpleName();
  }

  public void display()
  {
    System.out.println("Component type: "+ getName());
    System.out.println(getName()+"'s parent: "+o.getName());
  }

  public abstract void displayAttributes();

  protected void general_inspect()
  {
    System.out.printf("Component: %s\nFrom object: %s\n",
    		this.getName(), o.getName());
  }

}  // Component