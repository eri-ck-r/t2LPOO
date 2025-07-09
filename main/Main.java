/**
 *
 * @author Erick Rodrigues de Lemos Riberio
 * @author Luiz Alexandre Espindola Cunha
 */

package main;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.function.Consumer;

import t2.*;

public class Main
{
  public static void main(String[] args)
  {
    GameEngine e = new GameEngine();
    Console c = new Console(e);
    c.key_listener();
    
    Consumer<Integer> print = (n) -> { System.out.println(n); };
    print.accept(2);
  }
  
  
}  // Main
