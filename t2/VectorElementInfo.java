/**
 *
 * @author Erick Rodrigues de Lemos Riberio
 * @author Luiz Alexandre Espindola Cunha
 */

package t2;

public class VectorElementInfo extends VectorElement
{
  public VectorElementInfo(int i)
  {
    super(i);
  }
  
  public VectorElementInfo(int i, double value)
  {
    super(i, value);
  }
  
  public int getIndex()
  {
    return i;
  }
  
}  // VectorElementInfo