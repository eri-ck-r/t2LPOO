/**
 *
 * @author Erick Rodrigues de Lemos Riberio
 * @author Luiz Alexandre Espindola Cunha
 */

package t2;

public class Mesh extends Component
{
  String label;
  String material;
  
  public Mesh(GameObject o)
  {
    super(o);
  }

  public Mesh(GameObject o, String label)
  {
    this(o);
    this.label = label;
  }

  public void setMaterial(String newMaterial)
  {
    material = newMaterial;
  }

  public String getMaterial()
  {
    return material;
  }

  public void setLabel(String newLabel)
  {
    label = newLabel;
  }

  public String getLabel()
  {
    return label;
  }

  @Override
  public void displayAttributes(String s)
  {
    System.out.println(s + "      Name: " + label);
    System.out.println(s + "      Material: " + material);
  }

}  // Mesh
