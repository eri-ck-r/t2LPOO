/**
 *
 * @author Erick Rodrigues de Lemos Riberio
 * @author Luiz Alexandre Espindola Cunha
 */

package t2;

import java.util.function.Consumer;

public class Scene implements NamedObject
{
  private String name;
  private GameObjectList root;
  
  public Scene()
  {
    // Quando uma nova cena, S, eh criada, esta conterá
    // tres novos objetos de jogo chamados (1) Cube, (2) Light, e (3) Main Camera.
    // Components: Cube terá Mesh; Light terá Light; Main Camera terá Camera.
    root = new GameObjectList();

    GameObject cube = new GameObject(this, "Cube");
    cube.addComponent(new Mesh(cube));  // Returns a boolean but it doesn't matter in here
    
    GameObject light = new GameObject(this, "Light");
    light.addComponent(new Light(light));

    GameObject main_camera = new GameObject(this, "Main Camera");
    main_camera.addComponent(new Camera(main_camera));

    root.add(cube);
    root.add(light);
    root.add(main_camera);
  }

  public Scene(String name)
  {
    this();
    this.name = name;
  }

  @Override
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

  public void forEach(Consumer<GameObject> f)
  {
    root.forEach(f);
  }
  
  public void display()
  {
    System.out.println("  Scene: " + name);
    System.out.println("  {");
    for(GameObject obj : root)
      obj.display("");
    System.out.println("  }");
  }
  
}  // Scene
