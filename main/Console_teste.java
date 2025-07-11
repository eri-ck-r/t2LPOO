/**
 *
 * @author Erick Rodrigues de Lemos Riberio
 * @author Luiz Alexandre Espindola Cunha
 */

 //package main;

 import java.util.*;
 
 import t2.*;
 
 public class Console_teste
 {
     static GameEngine engine;
     static Game currGame;
     static Scene currScene;
     static GameObject currGameObject;
     static Component currComponent;
 
     static Scanner sc = new Scanner(System.in);
 
     static final String[] engine_menu = {
         "Edit game;", 
         "Add game;",
         "Remove game;",
         "Remove all games;",
         "Show games;",
         "Exit."
     };
 
     static final String[] game_menu = {
         "Edit scene;",  // "Obtenção" de uma cena
         "Add scene;",
         "Read scene from file;",
         "Write scene in file;",
         "Remove scene;",
         "Remove all scenes;",
         "Show game;",
         "Return;",
         "Exit."
     }; 
 
     static final String[] scene_menu = {
         "Get name;",
         "Edit name;",
         "Add object;",
         "Remove object;",
         "Remove all objects",
         "Edit object;",
         "Display scene;",
         "Return;",
         "Exit."
     };
 
     static final String[] object_menu = {
         "Get name;",
         "Edit name;",
         "Add child object;",
         "Remove child object;",
         "Remove all child objects",
         "Edit child object;",
         "Edit component;",
         "Add component;",
         "Remove component;",
         "Remove all components;",
         "Display object;",
         "Return;",
         "Exit."
     };
 
     static final String[] component_menu = {
         "Get class;",
         "Inspect;",
         "Return;",
         "Exit."
     };
     
     static private String[] currMenu = engine_menu;
 
     public Console_teste(GameEngine engine)
     {
         Console_teste.engine = engine;
     }
 
     public Console_teste()
     {
         this(new GameEngine());
     }
 
     public void clear_terminal()
     {
         System.out.print("\033[H\033[2J");
         System.out.flush(); // Ensures the output is sent to the console ("terminal") immediately
     }
     
     public void terminal_interface()
     {
         boolean exit = false;
         while(!exit)
         {
             show_menu(currMenu);
             exit = nextMenuSelector();
         }
 
     }
     
     public void show_menu(String[] options)
     {
         System.out.println("-------------- Game Engine --------------");
         for(int j = 0; j < options.length; ++j)
         {
             System.out.printf("%d - %s\n", j+1, options[j]);
         }
         System.out.printf("Choose: ");
     }
 
     private boolean nextMenuSelector()
     {
         int i = sc.nextInt();
         sc.nextLine();
         
         
 
         if(currMenu == engine_menu)
             return engine_menu_options(i);
 
         else if(currMenu == game_menu)
             return game_menu_options(i);
 
         else if(currMenu == scene_menu)
             return scene_menu_options(i);
 
         else if(currMenu == object_menu)
             return object_menu_options(i);
 
         else  // if(currMenu == component_menu)
             return component_menu_options(i);
     }
 
     private boolean engine_menu_options(int i)
     {
         if(i == 1)
         {
             String name = get_input_name();
             System.out.println("! " + name + "!");
             currGame = engine.getGame(name);
             if(currGame != null)
                 currMenu = game_menu;
             else
             {
                 notFound(name);
                 pause();
             }
         }
         else if(i == 2)
         {
             engine.addGame(get_input_name());
         }
         else if(i == 3)
         {
             String name = get_input_name();
             if(engine.removeGame(name))
                 System.out.println("Game successfully removed!");
             else
                 notFound(name);
             pause();
         }
         else if(i == 4)
         {
             engine.clear();
         }
         else if(i == 5)
         {
             engine.display();
         }
         else if(i == 6)
             return true;
         else
         {
             invalid("number");
             pause();
         }
         return false;
     }
 
     private boolean game_menu_options(int i)
     {
         if(i == 1)
         {
             String name = get_input_name();
             currScene = currGame.getScene(name);
             if(currScene != null)
                 currMenu = scene_menu;
             else
             {
                 notFound(name);
                 pause();
             }
         }
         else if(i == 2)
         {
             currGame.addScene(get_input_name());
         }
         else if(i == 3)
         {
             // LER DE ARQUIVO
         }
         else if(i == 4)
         {
             // ESCREVER EM ARQUIVO
         }
         else if(i == 5)
         {
             String name = get_input_name();
             if(currGame.removeScene(name))
                 System.out.println("Scene successfully removed!");  // Refactor later
             else
                 notFound(name);
             pause();
         }
         else if(i == 6)
         {
             currGame.clearScenes();
         }
         else if(i == 7)
         {
             currGame.display();
         }
         else if(i == 8)
         {
             currMenu = engine_menu;
         }
         else if(i == 9)
         {
             return true;
         }
         else
         {
             invalid("number");
             pause();
         }
         return false;
     }
 
     private boolean scene_menu_options(int i)
     {
         
         return false;
     }
 
     private boolean object_menu_options(int i)
     {
         
         return false;
     }
 
     private boolean component_menu_options(int i)
     {
         
         return false;
     }
 
     static public String get_input_name()
     {
         System.out.printf("Type the name: ");
         String s = sc.nextLine();
         System.out.println("$ " + s + " $");
         return s;
     }
 
     static private void pause()
     {
         try
         {
             Thread.sleep(700);
         }
         catch(InterruptedException e)
         {
             System.out.println("Unable to pause. " + e.getMessage());
         }
     }
 
     private void invalid(String s)
     {
         System.out.println("Invalid " + s + "!");
     }
 
     static private void notFound(String s)
     {
         System.out.println(s + " not found!");
     }
 
 
     public enum engine_menu2
     {
         EDIT("Edit name;")
         {
             @Override
             public void execute()
             {
                 String name = get_input_name();
                 System.out.println("! " + name + "!");
                 currGame = engine.getGame(name);
                 if(currGame != null)
                     currMenu = game_menu;
                 else
                 {
                     notFound(name);
                     pause();
                 }
             }
         };
 
 
 
 
         private String option_label;
 
         engine_menu2(String option_label)
         {
             this.option_label = option_label;
         }
 
         public abstract void execute();
     }
 
     static EnumSet currMenu2;
 
 }   // Console_teste
 