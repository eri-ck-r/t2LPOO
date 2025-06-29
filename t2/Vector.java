/**
 *
 * @author Luiz Alexandre Espindola Cunha
 */

package t2;

import java.util.*;

public final class Vector
  implements Iterable<VectorElementInfo>
{
  private final int _n;
  private final double[] _data;
  
  public Vector(int n)
  {
    this._n = n;
    _data = new double[n];
  } // Ctor

  public int size()
  {
    return this._n;
  } // size

  public double get(int i)
  {
    return _data[i];
  } // get

  public void set(int i, double s)
  {
    _data[i] = s;
  } // set

  public void sum(double s)
  {
    for (int i = 0; i < _n; i++)
      _data[i] += s;
  } // scalar sum

  public void mul(double s)
  {
    for(int i = 0; i < _n; i++)
      _data[i] *= s;
  } // scalar mul

  public void sub(double s)
  {
    sum((-1)*s);
  } // scalar sub

  public void sum(Vector v)
  {
    for (int i = 0; i < _n; i++)
      _data[i] += v._data[i];
  } // vector sum

  // É o mesmo código da soma, mas evitei chamar a soma com -v para evitar
  // junção posterior que é mais lento (deve afetar nada a performance, mas vou tentar deixar o mais performante possível
  public void sub(Vector v)
  {
    for (int i = 0; i < _n; i++)
      _data[i] -= v._data[i];
  } // vector sub

  public void print()
  {
    for(double d : _data)
      System.out.printf("%.2f ", d);
    System.out.println();
  } //print

  @Override
  public Iterator<VectorElementInfo> iterator()
  {
    return new VectorIterator(this);
  }
  
  public class VectorIterator
          implements Iterator<VectorElementInfo>
  {
    private final Vector v;
    private int i;
    
    public VectorIterator(Vector v)
    {
      this.v = v;
      i = 0;
    }
    
    @Override
    public boolean hasNext()
    {
      return i < v.size();
    }
    
    @Override
    public VectorElementInfo next()
    {
      VectorElementInfo info = new VectorElementInfo(i, v.get(i));
      i++;
      return info;
    }
    
  }  // VectorIterator

}  // Vector
