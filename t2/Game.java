/**
 *
 * @author Erick Rodrigues de Lemos Riberio
 * @author Luiz Alexandre Espindola Cunha
 */

package t2;

import java.util.function.Consumer;

public class Game
{
  private SceneList scenes;
  public String name;

  public Game()
  {
    Scene mainScene = new Scene("Main Scene");  // Every game starts with "main scene"
    scenes = new SceneList();
    scenes.add(mainScene);
  }

  public Game(String name)
  {
    this();
    this.name = name;
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

  public void clear()
  {
    scenes.clear();
  }

  public void forAll(Consumer<Scene> f)
  {
    scenes.forEach(f);
  }

  public void display()
  {
    System.out.println("Game: " + name);
    System.out.println("{");
    forAll(s -> {s.display();});
    System.out.println("}");
  }

}  // Game
