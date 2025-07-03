/**
 *
 * @author Erick Rodrigues de Lemos Riberio
 * @author Luiz Alexandre Espindola Cunha
 */

package t2;

public class ComponentList extends BasicList<Component>
{
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

  public boolean addComponent(String type)
  {
    //TODO: don't add if the list already has one of if
    return true;
  }

  
}  // ComponentList
