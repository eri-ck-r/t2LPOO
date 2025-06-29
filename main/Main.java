/**
 *
 * @author Luiz Alexandre Espindola Cunha
 */

package main;

import t2.*;

public class Main
{
  public static void main(String[] args)
  {
    Scene s = new Scene();
    Scene.GameObject o = s.new GameObject("teste1");
    
    Light t = new Light(o);
    
    t.inspect();
  }
  
  
}  // Main
