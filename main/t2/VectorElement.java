/**
 *
 * @author Erick Rodrigues de Lemos Riberio
 * @author Luiz Alexandre Espindola Cunha
 */

package t2;
import java.io.Serializable;
public class VectorElement implements Serializable
{
  protected int i;
  protected double value;
  
  public VectorElement(int i)
  {
    this.i = i;
  }
  
  public VectorElement(int i, double value)
  {
    this.i = i;
    this.value = value;
  }
  
  public double getValue()
  {
    return value;
  }
  
}  // VectorElement
