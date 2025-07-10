/**
 *
 * @author // Paulo Pagliosa
 */

package t2;

import java.io.Serializable;

public class Color implements Serializable
{
  public int r;
  public int g;
  public int b;

  public Color()
  {
    // do nothing
  }

  public Color(int r, int g, int b)
  {
    this.r = r;
    this.g = g;
    this.b = b;
  }

  public void print(String name)
  {
    System.out.printf("%s(%d,%d,%d)\n", name, r, g, b);
  }

  public static final Color black = new Color();
  public static final Color white = new Color(255, 255, 255);
  public static final Color red = new Color(255, 0, 0);
  public static final Color green = new Color(0, 255, 0);
  public static final Color blue = new Color(0, 0, 255);

} // Color

