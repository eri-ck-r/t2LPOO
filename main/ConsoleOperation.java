/**
 *
 * @author Erick Rodrigues de Lemos Riberio
 * @author Luiz Alexandre Espindola Cunha
 */

package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import main.Console.Menu;

@FunctionalInterface
public interface ConsoleOperation
{
    public void run(Console console);

    final static InputStreamReader keyboard = new InputStreamReader(System.in);
    final static BufferedReader in = new BufferedReader(keyboard);

    public static ConsoleOperation edit = console -> {
        String name = console.ask_name();
        if(console.getMenu() == Menu.GAME)  // if(console.getMenu() == console.game_menu)
        {
            
        }
        
    };

}  // ConsoleOperation
