/**
 *
 * @author Erick Rodrigues de Lemos Riberio
 * @author Luiz Alexandre Espindola Cunha
 */

package t2;

public class ComponentList extends BasicList<Component>
{
  private static final long serialVersionUID = 6442;
  public boolean removeComponent(String type)
  {
    if(type.equals("Transform"))
    {
      System.out.println("Cannot remove Transform");
      return false;
    }
    for(int i = 0 ; i < this.size(); i++)
    {
      if(this.get(i).getName().equals(type))
      {
        this.remove(i);
        return true;
      }
    }
    return false;
  }

  public boolean addComponent(Component newComp)
  {
    for(Component c : this)
    {
      if(c.getName().equals(newComp.getName()))  // Anti-efficient line
      {
        return false;
      }
    }
    add(newComp);
    return true;
  }

  
}  // ComponentList
