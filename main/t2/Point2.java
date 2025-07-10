/**
 *
 * @author Paulo Pagliosa
 * @author Erick Rodrigues de Lemos Riberio
 * @author Luiz Alexandre Espindola Cunha
 */

package t2;

import java.io.Serializable;
public class Point2 implements Serializable
{
  public double x;
  public double y;

  public Point2()
  {
    // do nothing
  }

  public Point2(double x, double y)
  {
    this.x = x;
    this.y = y;
  }

  public Point2(Point2 p)
  {
    x = p.x;
    y = p.y;
  }

  public Point2 move(double dx, double dy)
  {
    x += dx;
    y += dy;
    return this;
  }

  public void print(String name)
  {
    System.out.printf("%s(%.2f,%.2f)\n", name, x, y);
  }

} // Point2

