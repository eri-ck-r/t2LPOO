/**
 *
 * @author Erick Rodrigues de Lemos Riberio
 * @author Luiz Alexandre Espindola Cunha
 */

package main.t2;

public class Scene
{
  private String name;
  private GameObjectList root;
  
  public Scene()
  {
    // Quando uma nova cena, S, eh criada, esta contera
    // tres novos objetos de jogo chamados (1) Cube, (2) Light, e (3) Main Camera.
    
    // Components: Cube tera Mesh; Light tera Light; Main Camera tera Camera.
  }
  
  
  
  public class GameObject
  {
    private String name;
    private GameObject parent;
    private GameObjectList children;
    private ComponentList components;
    
    
    
    public String getName()
    {
      return name;
    }
  }
  
}  // Scene
