/**
 *
 * @author Erick Rodrigues de Lemos Ribeiro
 * @author Luiz Alexandre Espindola Cunha
 */

package t2;

import java.util.*;
import java.io.*;


public class Console
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
        //"Edit component;",
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

    public Console(GameEngine engine)
    {
        this.engine = engine;
    }

    public Console()
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
            clear_terminal();
            show_menu(currMenu);
            exit = nextMenuSelector();
        }

    }
    
    public void show_menu(String[] options)
    {
        menu_header();
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
            String scene_to_edit = get_input_name();
            Game temp = engine.getGame(scene_to_edit);
            if(temp != null)
            {
                currMenu = game_menu;
                currGame = temp;
            }
            else
            {
                notFound(scene_to_edit);
                pause();
            }
        }
        else if(i == 2)
        {
            engine.addGame(get_input_name());
        }
        else if(i == 3)
        {
            String scene_to_edit = get_input_name();
            if(engine.removeGame(scene_to_edit))
                removed_msg();
            else
                notFound(scene_to_edit);
            pause();
        }
        else if(i == 4)
        {
            engine.clear();
        }
        else if(i == 5)
        {
            engine.display();
            sc.nextLine();
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
        switch(i)
        {
            case 1:
            {
                String scene_to_edit = get_input_name();
                Scene temp = currGame.getScene(scene_to_edit);
                if(temp != null)
                {
                    currMenu = scene_menu;
                    currScene = temp;
                }
                else
                {
                    notFound(scene_to_edit);
                    pause();
                }
                break;
            }
            case 2:
            {
                currGame.addScene(get_input_name());
                break;
            }
            case 3:
            {
                String file_name = get_input_name();
                try(FileInputStream in = new FileInputStream(file_name);
                    ObjectInputStream obj_in = new ObjectInputStream(in))
                {
                    currGame.addScene((Scene)obj_in.readObject());
                }
                catch(Exception e)
                {
                    System.out.println(e.getMessage());
                }
                break;
            }
            case 4:
            {
                String file_name = get_input_name();
                try(FileOutputStream out = new FileOutputStream(file_name);
                ObjectOutputStream obj_out = new ObjectOutputStream(out))
                {
                    String scene_to_write = get_input_name();
                    Scene temp = currGame.getScene(scene_to_write);
                    if(temp != null)
                        obj_out.writeObject(currGame.getScene(scene_to_write));
                    else
                        notFound(scene_to_write);
                }
                catch(Exception e)
                {
                    System.out.println(e.getMessage());
                }
                break;
            }
            case 5:
            {
                String scene_to_edit = get_input_name();
                if(currGame.removeScene(scene_to_edit))
                    removed_msg();
                else
                    notFound(scene_to_edit);
                pause();
                break;
            }
            case 6:
            {
                currGame.clear();
                break;
            }
            case 7:
            {
                currGame.display();
                sc.nextLine();
                break;
            }
            case 8:
            {
                currMenu = engine_menu;
                break;    
            }
            case 9:
            {
                return true;
                   
            }
            default:
            {
                invalid("number");
                pause();
            }
        }
            return false;
    }

    private boolean scene_menu_options(int i)
    {
        switch(i)
        {
            case 1:
            {
                System.out.println(currScene.getName());
                break;
            }
            case 2:
            {
                String new_name = get_input_name();
                currScene.setName(new_name);
                break;
            }
            case 3:
            {
                String new_obj_name = get_input_name();
                currScene.addObject(new_obj_name);
                break;
            }
            case 4:
            {
                String obj_to_remove = get_input_name();
                currScene.removeObject(obj_to_remove);
                break;
            }
            case 5:
            {
                currScene.clear();
                break;
            }
            case 6:
            {
                String obj_to_edit = get_input_name();
                GameObject temp = currScene.getObject(obj_to_edit);
                if(temp != null)
                {
                    currMenu = object_menu;
                    currGameObject = temp;
                }
                else
                {
                    notFound(obj_to_edit);
                    pause();
                }
                break;
            }
            case 7:
            {
                currScene.display("");
                sc.nextLine();
                break;
            }
            case 8:
            {
                currMenu = game_menu;
                break;
            }
            case 9:
            {
                return true;
            }
            default:
            {
                invalid("number");
                pause();
            }
        }
        return false;
    }

    private boolean object_menu_options(int i)
    {
        switch(i)
        {
            case 1:
            {
                System.out.println(currGameObject.getName());

                break;
            }
            case 2:
            {
                String new_name = get_input_name();
                currGameObject.setName(new_name);
                break;
            }
            case 3:
            {
                String new_name = get_input_name();
                currGameObject.addObject(new_name);
                break;
            }
            case 4:
            {
                String objName = get_input_name();
                currGameObject.removeObject(objName);
                break;
            }
            case 5:
            {
                currGameObject.clear();
                break;
            }
            case 6:
            {
                String obj_to_edit = get_input_name();
                GameObject temp = currGameObject.getObject(obj_to_edit);
                if(temp != null)
                {
                    currGameObject = temp;
                }
                else
                {
                    notFound(obj_to_edit);
                    pause();
                }
                break;
            }
            case 7:
            {
                String new_component = get_input_name();
                switch(new_component)
                {
                    case("Mesh"):
                    {
                        currGameObject.addComponent(new Mesh(currGameObject));
                    }
                    case("Light"):
                    {
                        currGameObject.addComponent(new Light(currGameObject));
                    }
                    case("Camera"):
                    {
                        currGameObject.addComponent(new Camera(currGameObject));
                    }
                }

                break;
            }
            case 8:
            {
                currGameObject.removeComponent(get_input_name());
                break;
            }
            case 9:
            {
                currGameObject.removeAllComponents();
                break;
            }
            case 10:
            {
                currGameObject.display("");
                sc.nextLine();
                break;
            }
            case 11:
            {
                currMenu = scene_menu;
                break;
            }
            case 12:
            {
                return true;
            }
            default:
            {
                invalid("number");
                pause();
            }
        }
        return false;
    }

    private boolean component_menu_options(int i)
    {
        switch(i)
        {
            case 1:
            {
                currComponent.getClass();
                break;
            }
            case 2:
            {
                currComponent.displayAttributes("");
                sc.nextLine();
                break;
            }
            case 3:
            {
                currMenu = object_menu;
                break;
            }
            case 4:
            {
                return true;
            }
            default:
            {
                invalid("number");
                pause();
            }
        }
        return false;
    }

    static public String get_input_name()
    {
        System.out.printf("Type the name: ");
        return sc.nextLine();
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

    static private void removed_msg()
    {
        System.out.println("Successfully removed!");
    }

    static private void menu_header()
    {
        System.out.println("-------------- Game Engine --------------");

    }

}   // Console
