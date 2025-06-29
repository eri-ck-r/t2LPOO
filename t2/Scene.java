/**
 *
 * @author Erick Rodrigues de Lemos Riberio
 * @author Luiz Alexandre Espindola Cunha
 */

package t2;

public class Scene
{
  private String name;
  private GameObjectList root;
  
  public Scene()
  {
    // Quando uma nova cena, S, eh criada, esta conterá
    // tres novos objetos de jogo chamados (1) Cube, (2) Light, e (3) Main Camera.
    // Components: Cube tera Mesh; Light tera Light; Main Camera tera Camera.
    root = new GameObjectList();
    GameObject light = new GameObject("Light");
    light.addComponent(new Light(light));


    //TODO

  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public void addObject(GameObject obj)
  {
    root.add(obj);
  }

  public GameObject getObject(String name)
  {
    return root.getElement(name);
  }

  public boolean removeObject(String name)
  {
    return root.removeElement(name);
  }

  public void clear()
  {
    root.clear();
  }

  public void forEach()
  {
    //TODO
  }

  public void display()
  {
    System.out.println("Scene name: "+name);
    System.out.println(name+"'s objects: ");
    for(GameObject obj : root)
      obj.display();
  }
}  // Scene
