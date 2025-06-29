/**
 *
 * @author Luiz Alexandre Espindola Cunha
 */

package t2;

public class VectorElement
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
