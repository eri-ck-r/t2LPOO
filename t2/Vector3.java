/**
 *
 * @author Luiz Alexandre Espindola Cunha
 */

package t2;

import java.util.*;

public final class Vector3
  implements Iterable<VectorElementInfo>
{
  private final int _n;
  private final double[] _data;
  
  public Vector3()
  {
    this._n = 3;
    _data = new double[3];
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

  public Vector3 sum(Vector3 v)
  {
    Vector3 c = new Vector3();
    for (int i = 0; i < _n; i++)
      c._data[i] = _data[i] + v._data[i];
    return c;
  } // vector sum

  // É o mesmo código da soma, mas evitei chamar a soma com -v para evitar
  // junção posterior que é mais lento (deve afetar nada a performance, mas vou tentar deixar o mais performante possível
  public Vector3 sub(Vector3 v)
  {
    Vector3 c = new Vector3();
    for (int i = 0; i < _n; i++)
      _data[i] = _data[i] - v._data[i];
    return c;
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
    private final Vector3 v;
    private int i;
    
    public VectorIterator(Vector3 v)
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
