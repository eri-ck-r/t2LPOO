/**
 *
 * @author Erick Rodrigues de Lemos Riberio
 * @author Luiz Alexandre Espindola Cunha
 */

package t2;

import java.util.function.Consumer;

import java.io.Serializable;

public class Game implements NamedObject, Serializable
{
  private static final long serialVersionUID = 6127;
  private BasicList<Scene> scenes;
  public String name;

  public Game()
  {
    scenes = new BasicList<Scene>();
    scenes.add(new Scene("Main Scene"));
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

  public void addScene(String name)
  {
    addScene(new Scene(name));
  }

  public boolean removeScene(String name)
  {
    return scenes.removeElement(name);
  }

  public Scene getScene(String name)
  {
    return scenes.getElement(name);
  }

  public void clearScenes()
  {
    scenes.clear();
  }

  public void setName(String s)
  {
    name = s;
  }

  @Override
  public String getName()
  {
    return name;
  }

  public void forEachScene(Consumer<Scene> f)
  {
    scenes.forEach(f);
  }

  public void display()
  {
    System.out.println("Game: " + name);
    System.out.println("{");

    forEachScene(s -> {s.display("  ");});
    
    System.out.println("}");
  }

}  // Game
