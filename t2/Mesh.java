/**
 *
 * @author Erick Rodrigues de Lemos Riberio
 * @author Luiz Alexandre Espindola Cunha
 */

package t2;

public class Mesh extends Component
{
  String name;
  String material;
  
  public Mesh(GameObject o)
  {
    super(o);
  }

  public Mesh(GameObject o, String name)
  {
    this(o);
    this.name = name;
  }

  public void setMaterial(String newMaterial)
  {
    material = newMaterial;
  }

  public String getMaterial()
  {
    return material;
  }

  public void setName(String newName)
  {
    name = newName;
  }

  public String getName()
  {
    return name;
  }

  @Override
  public void displayAttributes(String s)
  {
    System.out.println(s + "      Name: " + name);
    System.out.println(s + "      Material: " + material);
  }

}  // Mesh
