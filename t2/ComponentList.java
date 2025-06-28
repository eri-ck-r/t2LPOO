/**
 *
 * @author Erick Rodrigues de Lemos Riberio
 * @author Luiz Alexandre Espindola Cunha
 */

package t2;

import java.util.*;

public class ComponentList
{
  private int size;
  private EnumSet<Components> comp_set;
  
  public ComponentList(Scene.GameObject obj)
  {
    //Scene.GameObject.Component component = obj.new Component();
    
    comp_set = EnumSet.of(Components.TRANSFORM);
    
    //comp_set.removeIf(Component c != Components.TRANSFORM);
  }
  
  
  
}  // ComponentList
