/**
 *
 * @author Erick Rodrigues de Lemos Riberio
 * @author Luiz Alexandre Espindola Cunha
 */

package main;

import t2.*;

public class Main
{
  public static void main(String[] args)
  {
    Scene s = new Scene();
    GameObject o = new GameObject(s, "teste1");
    
    Light t = new Light(o);
    
    
    System.out.println("aaaaaa");
  }
  
  
}  // Main
