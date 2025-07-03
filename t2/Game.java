/**
 *
 * @author Erick Rodrigues de Lemos Riberio
 * @author Luiz Alexandre Espindola Cunha
 */

package t2;

public class Game
{
  private SceneList scenes;

  public Game()
  {
    scenes = new SceneList();

  }

  public void addScene(Scene s)
  {
    scenes.add(s);
  }

  public boolean removeScene(String name)
  {
    return scenes.removeElement(name);
  }

  public Scene getScene(String name)
  {
    return scenes.getElement(name);
  }

  public void forEach()
  {
//Todo

  }
}  // Game
