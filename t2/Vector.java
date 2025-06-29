/**
 *
 * @author Luiz Alexandre Espindola Cunha
 */

package t2;

import java.util.*;

public final class Vector
  implements Iterable<VectorElementInfo>
{
  private final int n;
  private final double v[];
  
  public Vector(int n)
  {
    this.n = n;
    v = new double[n];
  }

  public int size()
  {
    return this.n;
  }

  public double get(int i)
  {
    return v[i];
  }

  public void set(int i, double s)
  {
    v[i] = s;
  }
  
  public void print()
  {
    for(int i = 0; i < n; i++)
    {
      System.out.printf("%.2f ", v[i]);
    }
    System.out.println();
  }

  @Override
  public Iterator<VectorElementInfo> iterator()
  {
    return new VectorIterator(this);
  }
  
  public class VectorIterator
          implements Iterator<VectorElementInfo>
  {
    private final Vector V;
    private int i;
    
    public VectorIterator(Vector V)
    {
      this.V = V;
      i = 0;
    }
    
    @Override
    public boolean hasNext()
    {
      return i < V.size();
    }
    
    @Override
    public VectorElementInfo next()
    {
      VectorElementInfo info = new VectorElementInfo(i, V.get(i));
      i++;
      return info;
    }
    
  }  // VectorIterator

}  // Vector
